package com.hh.springstatemachine.statemachine.config;


import com.hh.springstatemachine.statemachine.action.common.ErrorAction;
import com.hh.springstatemachine.statemachine.action.create.CreateOrderAction;
import com.hh.springstatemachine.statemachine.action.pay.*;
import com.hh.springstatemachine.statemachine.action.underwrite.UnderWriteAction;
import com.hh.springstatemachine.statemachine.action.underwrite.UnderWriteErrorAction;
import com.hh.springstatemachine.statemachine.constant.OrderEvents;
import com.hh.springstatemachine.statemachine.constant.OrderStates;
import com.hh.springstatemachine.statemachine.constant.StateMachineConstant;
import com.hh.springstatemachine.statemachine.guard.pay.PayDuringGuard;
import com.hh.springstatemachine.statemachine.guard.pay.PaySuccessGuard;
import com.hh.springstatemachine.statemachine.guard.underwrite.UnderWriteSuccessGuard;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.stereotype.Component;

import java.util.EnumSet;

/**
 * 订单状态机构建器
 */
@Component
@Slf4j
public class OrderStateMachineBuilder {

    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private ErrorAction errorAction;

    @Autowired
    private PayAction payAction;

    @Autowired
    private PaySuccessGuard paySuccessGuard;

    @Autowired
    private UnderWriteAction underWriteAction;

    @Autowired
    private UnderWriteSuccessGuard underWriteSuccessGuard;

    @Autowired
    private PayErrorAction payErrorAction;

    @Autowired
    private UnderWriteErrorAction underWriteErrorAction;

    @Autowired
    private PayDuringGuard payDuringGuard;

    @Autowired
    private PaySuccessAction paySuccessAction;

    @Autowired
    private PayDuringAction payDuringAction;

    @Autowired
    private PayFailAction payFailAction;

    @Autowired
    private PaySuccessJumpAction paySuccessJumpAction;

    @Autowired
    private CreateOrderAction createOrderAction;

    /**
     * 构建状态机
     *
     * @return
     * @throws Exception
     */
    public StateMachine<OrderStates, OrderEvents> build() throws Exception {
        StateMachineBuilder.Builder<OrderStates, OrderEvents> builder = StateMachineBuilder.builder();

        log.info("构建订单状态机");

        builder.configureConfiguration()
                .withConfiguration()
                .machineId(StateMachineConstant.ORDER_STATE_MACHINE_ID)
                .beanFactory(beanFactory);

        builder.configureStates()
                .withStates()
                .initial(OrderStates.未处理)
                .choice(OrderStates.承保中)
                .choice(OrderStates.支付中间判断状态)
                .states(EnumSet.allOf(OrderStates.class));

        builder.configureTransitions()
                //创建订单
                .withExternal().source(OrderStates.未处理).target(OrderStates.订单创建成功).event(OrderEvents.创建订单事件)
                .action(createOrderAction, errorAction)

                //核保通过 -> 支付中间判断状态
                //            支付中间判断状态 -> 支付成功
                //            支付中间判断状态 -> 支付中
                //            支付中间判断状态 -> 支付失败
                .and()
                .withExternal().source(OrderStates.核保通过).target(OrderStates.支付中间判断状态).event(OrderEvents.支付事件)
                .action(payAction, payErrorAction)
                .and()
                .withChoice().source(OrderStates.支付中间判断状态)
                .first(OrderStates.支付成功, paySuccessGuard, paySuccessAction)
                .then(OrderStates.支付中, payDuringGuard, payDuringAction)
                .last(OrderStates.支付失败, payFailAction)
                .and()
                .withInternal().source(OrderStates.支付成功).action(paySuccessJumpAction)

                //支付成功 -> 承保中
                //            承保中 -> 承保成功
                //            承保中 -> 承保失败
                .and()
                .withExternal()
                .source(OrderStates.支付成功).target(OrderStates.承保中).event(OrderEvents.承保事件).action(underWriteAction, underWriteErrorAction)
                .and()
                .withChoice().source(OrderStates.承保中)
                .first(OrderStates.承保成功, underWriteSuccessGuard)
                .last(OrderStates.承保失败)

        ;

        return builder.build();
    }
}