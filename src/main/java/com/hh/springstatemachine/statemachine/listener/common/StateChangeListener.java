package com.hh.springstatemachine.statemachine.listener.common;

import com.hh.springstatemachine.statemachine.constant.OrderEvents;
import com.hh.springstatemachine.statemachine.constant.OrderStates;
import com.hh.springstatemachine.statemachine.constant.StateMachineConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.annotation.OnStateChanged;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.statemachine.config.EnableWithStateMachine;

/**
 * @author chenguoku
 * @version 1.0.0
 * @ClassName StateChangeAction.java
 * @Description 持久化订单 子状态
 * @createTime 2020年07月06日
 */
@WithStateMachine(id = StateMachineConstant.ORDER_STATE_MACHINE_ID)
@EnableWithStateMachine
@Slf4j
public class StateChangeListener {

    @OnStateChanged
    public void anyStateChange(StateContext<OrderStates, OrderEvents> stateContext) {
        OrderStates orderStates = stateContext.getTarget().getId();
        log.info("Change Action ...." + orderStates);

        // 1.修改并记录子状态变更

        // 2.修改父状态

    }

}
