package com.hh.springstatemachine.statemachine.action.common;

import com.hh.springstatemachine.statemachine.constant.OrderEvents;
import com.hh.springstatemachine.statemachine.constant.OrderStates;
import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

/**
 * @author chenguoku
 * @version 1.0.0
 * @ClassName ErrorAction.java
 * @Description 错误Action
 * @createTime 2020年07月06日
 */
@Component
@Slf4j
public class ErrorAction implements Action<OrderStates, OrderEvents> {
    @Override
    public void execute(StateContext<OrderStates, OrderEvents> context) {
        OrderEvents event = context.getEvent();
        log.error("事件{} 执行异常{}", event.getEvent(), context.getException().getMessage());
    }
}
