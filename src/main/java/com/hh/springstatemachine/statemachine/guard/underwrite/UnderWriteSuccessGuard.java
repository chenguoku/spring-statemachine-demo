package com.hh.springstatemachine.statemachine.guard.underwrite;

import com.hh.springstatemachine.statemachine.constant.OrderEvents;
import com.hh.springstatemachine.statemachine.constant.OrderStates;
import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.guard.Guard;
import org.springframework.stereotype.Component;

/**
 * @author chenguoku
 * @version 1.0.0
 * @ClassName UnderWritingGuard.java
 * @Description 承保成功 guard
 * @createTime 2020年07月06日
 */
@Component
@Slf4j
public class UnderWriteSuccessGuard implements Guard<OrderStates, OrderEvents> {

    @Override
    public boolean evaluate(StateContext<OrderStates, OrderEvents> context) {
        log.info("承保成功 guard ...");

        return true;
    }
}
