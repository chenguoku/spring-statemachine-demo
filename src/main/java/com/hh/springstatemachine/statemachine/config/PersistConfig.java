package com.hh.springstatemachine.statemachine.config;

import com.hh.springstatemachine.entity.OrderEntity;
import com.hh.springstatemachine.statemachine.constant.OrderEvents;
import com.hh.springstatemachine.statemachine.constant.OrderStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.persist.StateMachinePersister;

@Configuration
public class PersistConfig {

    @Autowired
    private OrderStateMachinePersist orderStateMachinePersist;

    @Bean(name = "orderPersister")
    public StateMachinePersister<OrderStates, OrderEvents, OrderEntity> orderPersister() {
        return new DefaultStateMachinePersister<OrderStates, OrderEvents, OrderEntity>(orderStateMachinePersist);
    }
}