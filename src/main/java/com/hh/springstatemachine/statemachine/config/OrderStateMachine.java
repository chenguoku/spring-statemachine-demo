package com.hh.springstatemachine.statemachine.config;

import com.hh.springstatemachine.entity.OrderEntity;
import com.hh.springstatemachine.statemachine.constant.OrderEvents;
import com.hh.springstatemachine.statemachine.constant.OrderStates;
import com.hh.springstatemachine.statemachine.entity.StateMachineSendResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenguoku
 * @version 1.0.0
 * @ClassName OrderStateMachineServiceImpl.java
 * @Description 订单状态机的实现类
 * @createTime 2020年07月06日
 */
@Service
@Slf4j
public class OrderStateMachine {

    @Autowired
    private OrderStateMachineBuilder orderStateMachineBuilder;

    @Resource(name = "orderPersister")
    private StateMachinePersister<OrderStates, OrderEvents, OrderEntity> persister;


    /**
     * 修改订单状态
     *
     * @param: event        事件
     * @param: order        订单
     * @param: attachMap    附加属性
     * @return: 修改结果
     * @author: chenguoku
     * @date: 2020-7-6
     */
    public StateMachineSendResult modifyOrderStatus(OrderEvents event, OrderEntity order, Map<String, Object> attachMap) {
        StateMachineSendResult sendResult = null;
        Map<Object, Object> extendedState = new HashMap<>();
        Boolean sendEventResult = true;
        StateMachine<OrderStates, OrderEvents> stateMachine = null;

        // todo 可以加个分布式锁
        try {
            // 构建状态机
            stateMachine = orderStateMachineBuilder.build();
            extendedState = stateMachine.getExtendedState().getVariables();

            if (attachMap != null) {
                for (Map.Entry<String, Object> entry : attachMap.entrySet()) {
                    extendedState.put(entry.getKey(), entry.getValue());
                }
            }

            OrderStates sendBeforeStatus = null;

            if (order == null) {
                stateMachine.start();
            } else {
                persister.restore(stateMachine, order);
                sendBeforeStatus = stateMachine.getState().getId();
            }

            // 发送执行事件
            sendEventResult = stateMachine.sendEvent(event);

            // 发送结果处理
            OrderStates sendAfterStatus = stateMachine.getState().getId();
            log.info("状态机发送之后状态:{}", sendAfterStatus.getState());

            if (!sendEventResult) {
                sendResult = new StateMachineSendResult(false, sendAfterStatus, extendedState);
            } else {
                sendResult = (sendBeforeStatus == sendAfterStatus) ? new StateMachineSendResult(false, sendAfterStatus, extendedState)
                        : new StateMachineSendResult(true, sendAfterStatus, extendedState);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("订单状态机异常:{}", e.getMessage());
        }

        return sendResult;
    }
}
