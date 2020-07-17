package com.hh.springstatemachine.statemachine.constant;

/**
 * @author chenguoku
 * @version 1.0.0
 * @ClassName OrderEvents.java
 * @Description 订单事件
 * @createTime 2020年07月06日
 */
public enum OrderEvents {
    // todo 只展示部分
    //订单初始化
    创建订单事件("create_order"),

    // 承保，
    支付事件("pay"),
    承保事件("underwrite"),

    ;

    private String event;

    OrderEvents(String event) {
        this.event = event;
    }

    public String getEvent() {
        return event;
    }

    public static OrderEvents getOrderEvent(String event) {
        for (OrderEvents e : OrderEvents.values()) {
            if (e.getEvent().equals(event)) {
                return e;
            }
        }
        return null;
    }
}
