package com.hh.springstatemachine.statemachine.transition;

import com.hh.springstatemachine.statemachine.annotation.StatesOnTransition;
import com.hh.springstatemachine.statemachine.constant.OrderEvents;
import com.hh.springstatemachine.statemachine.constant.OrderStates;
import com.hh.springstatemachine.statemachine.constant.StateMachineConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.statemachine.config.EnableWithStateMachine;

/**
 * @author chenguoku
 * @version 1.0.0
 * @ClassName OrderTransition.java
 * @Description 订单状态转换
 * @createTime 2020年07月08日
 */
@WithStateMachine(id = StateMachineConstant.ORDER_STATE_MACHINE_ID)
@EnableWithStateMachine
@Slf4j
public class OrderTransition {

    @StatesOnTransition(target = OrderStates.支付成功)
    public void payTransition(StateContext<OrderStates, OrderEvents> context) {
        log.info("支付成功 transition ...");
    }

}
