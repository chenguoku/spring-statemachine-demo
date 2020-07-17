package com.hh.springstatemachine.statemachine.entity;

import com.hh.springstatemachine.statemachine.constant.OrderStates;
import lombok.Data;

import java.util.Map;

/**
 * @author chenguoku
 * @version 1.0.0
 * @ClassName StateMachineSendResult.java
 * @Description 状态机发送结果
 * @createTime 2020年07月06日
 */
@Data
public class StateMachineSendResult {
    /**
     * 发送结果
     */
    private Boolean result;

    /**
     * 发送之后的状态
     */
    private OrderStates orderStates;

    /**
     * 附加属性
     */
    private Map<Object, Object> attachMap;

    public StateMachineSendResult() {
    }

    public StateMachineSendResult(Boolean result, OrderStates orderStates, Map<Object, Object> attachMap) {
        this.result = result;
        this.orderStates = orderStates;
        this.attachMap = attachMap;
    }

}
