package com.hh.springstatemachine.controller;

import com.hh.springstatemachine.entity.OrderEntity;
import com.hh.springstatemachine.statemachine.config.OrderStateMachine;
import com.hh.springstatemachine.statemachine.constant.OrderEvents;
import com.hh.springstatemachine.statemachine.constant.OrderStates;
import com.hh.springstatemachine.statemachine.entity.StateMachineSendResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenguoku
 * @version 1.0.0
 * @ClassName TestController.java
 * @Description 测试Controller
 * @createTime 2020年07月08日
 */
@RestController
public class TestController {

    @Autowired
    private OrderStateMachine orderStateMachine;

    @RequestMapping("test/one")
    public String testOne() {

        Map<String, Object> attachMap = new HashMap<>();
        attachMap.put("1", "1");
        StateMachineSendResult stateMachineSendResult = orderStateMachine.modifyOrderStatus(OrderEvents.创建订单事件, null, attachMap);
        return stateMachineSendResult.toString();
    }

    @RequestMapping("test/two")
    public String testTwo() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(9999L);
        orderEntity.setStatus(OrderStates.核保通过.getState());
        Map<String, Object> attachMap = new HashMap<>();
        attachMap.put("1", "1");
        StateMachineSendResult stateMachineSendResult = orderStateMachine.modifyOrderStatus(OrderEvents.支付事件, orderEntity, attachMap);
        return stateMachineSendResult.toString();
    }


}
