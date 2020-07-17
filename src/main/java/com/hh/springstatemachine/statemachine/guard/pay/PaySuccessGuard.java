package com.hh.springstatemachine.statemachine.guard.pay;

import com.hh.springstatemachine.statemachine.constant.OrderEvents;
import com.hh.springstatemachine.statemachine.constant.OrderStates;
import com.hh.springstatemachine.statemachine.guard.common.BaseOrderGuard;
import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.StateContext;
import org.springframework.stereotype.Component;

/**
 * @author chenguoku
 * @version 1.0.0
 * @ClassName UnderWritingGuard.java
 * @Description 支付成功判断
 * @createTime 2020年07月07日
 */
@Component
@Slf4j
public class PaySuccessGuard extends BaseOrderGuard {

    @Override
    public Boolean doEvaluate(StateContext<OrderStates, OrderEvents> context) {
        log.info("支付成功 guard ...");
        return true;
    }
}
