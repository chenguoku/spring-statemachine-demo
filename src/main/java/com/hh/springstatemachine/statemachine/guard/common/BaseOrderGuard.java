package com.hh.springstatemachine.statemachine.guard.common;

import com.hh.springstatemachine.statemachine.constant.OrderEvents;
import com.hh.springstatemachine.statemachine.constant.OrderStates;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.guard.Guard;

/**
 * @author chenguoku
 * @version 1.0.0
 * @ClassName BaseOrderGuard.java
 * @Description 订单状态基础guard
 * @createTime 2020年07月14日
 */
public abstract class BaseOrderGuard implements Guard<OrderStates, OrderEvents> {
    @Override
    public boolean evaluate(StateContext<OrderStates, OrderEvents> context) {
        return doEvaluate(context);
    }

    public abstract Boolean doEvaluate(StateContext<OrderStates, OrderEvents> context);
}
