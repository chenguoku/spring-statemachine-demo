package com.hh.springstatemachine.statemachine.action.create;

import com.hh.springstatemachine.statemachine.action.common.BaseOrderAction;
import com.hh.springstatemachine.statemachine.constant.OrderEvents;
import com.hh.springstatemachine.statemachine.constant.OrderStates;
import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.StateContext;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author chenguoku
 * @version 1.0.0
 * @ClassName CreateOrderAction.java
 * @Description 创建订单action
 * @createTime 2020年07月13日
 */
@Component
@Slf4j
public class CreateOrderAction extends BaseOrderAction {

    @Override
    public void doExecute(StateContext<OrderStates, OrderEvents> context) {
        log.info("创建订单action...");
        Map<Object, Object> variables = context.getExtendedState().getVariables();
        variables.put("orderNo", "123");
//        throw new RuntimeException("手抛");
    }
}
