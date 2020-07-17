package com.hh.springstatemachine.statemachine.config;

import com.hh.springstatemachine.entity.OrderEntity;
import com.hh.springstatemachine.statemachine.constant.OrderEvents;
import com.hh.springstatemachine.statemachine.constant.OrderStates;
import com.hh.springstatemachine.statemachine.constant.StateMachineConstant;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.stereotype.Component;

@Component
public class OrderStateMachinePersist implements StateMachinePersist<OrderStates, OrderEvents, OrderEntity> {

    @Override
    public void write(StateMachineContext<OrderStates, OrderEvents> context, OrderEntity order) throws Exception {
        //这里不做任何持久化工作
    }

    @Override
    public StateMachineContext<OrderStates, OrderEvents> read(OrderEntity order) throws Exception {
        StateMachineContext<OrderStates, OrderEvents> result = new DefaultStateMachineContext<OrderStates, OrderEvents>(
                OrderStates.getOrderStatus(order.getStatus()), null, null, null, null, StateMachineConstant.ORDER_STATE_MACHINE_ID);
        return result;
    }
}