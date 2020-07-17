package com.hh.springstatemachine.statemachine.action.common;

import com.hh.springstatemachine.statemachine.constant.OrderEvents;
import com.hh.springstatemachine.statemachine.constant.OrderStates;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;

/**
 * @author chenguoku
 * @version 1.0.0
 * @ClassName BaseOrderAction.java
 * @Description 状态机的基础Action
 * @createTime 2020年07月14日
 */
public abstract class BaseOrderAction implements Action<OrderStates, OrderEvents> {

    @Override
    public void execute(StateContext<OrderStates, OrderEvents> context) {
        doExecute(context);
    }

    public abstract void doExecute(StateContext<OrderStates, OrderEvents> context);

}
