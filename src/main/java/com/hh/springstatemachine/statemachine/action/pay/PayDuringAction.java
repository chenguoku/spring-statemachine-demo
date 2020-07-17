package com.hh.springstatemachine.statemachine.action.pay;

import com.hh.springstatemachine.statemachine.constant.OrderEvents;
import com.hh.springstatemachine.statemachine.constant.OrderStates;
import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

/**
 * @author chenguoku
 * @version 1.0.0
 * @ClassName UnderWritingAction.java
 * @Description 核保action
 * @createTime 2020年07月06日
 */
@Component
@Slf4j
public class PayDuringAction implements Action<OrderStates, OrderEvents> {

    @Override
    public void execute(StateContext<OrderStates, OrderEvents> context) {
        log.info("支付中 action...");
    }

}
