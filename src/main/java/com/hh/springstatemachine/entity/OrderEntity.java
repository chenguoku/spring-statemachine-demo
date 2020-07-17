package com.hh.springstatemachine.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单实体类
 *
 * @author hh2016
 * @date 2020-06-28
 */
@Data
public class OrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 名称
     */
    private String name;
    /**
     * 是否删除
     */
    private Integer isDel;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

}
