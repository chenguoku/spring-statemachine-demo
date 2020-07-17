package com.hh.springstatemachine.statemachine.constant;

/**
 * @author chenguoku
 * @version 1.0.0
 * @ClassName OrderStates.java
 * @Description 订单状态
 * @createTime 2020年07月06日
 */
public enum OrderStates {

    // todo 订单状态： 只展示部分
    未处理(0),
    订单创建成功(1),
    核保通过(2),
    承保中(4),
    承保成功(5),
    承保失败(6),
    支付中(10),
    支付失败(11),
    支付成功(12),

    // 中间判断状态
    支付中间判断状态(200),

    ;

    private Integer state;

    OrderStates(Integer state) {
        this.state = state;
    }

    public Integer getState() {
        return state;
    }

    public static OrderStates getOrderStatus(Integer state) {
        for (OrderStates status : OrderStates.values()) {
            if (status.getState() == state) {
                return status;
            }
        }
        return null;
    }
}
