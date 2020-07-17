package com.hh.springstatemachine.statemachine.annotation;

import com.hh.springstatemachine.statemachine.constant.OrderStates;
import org.springframework.statemachine.annotation.OnTransition;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author chenguoku
 * @version 1.0.0
 * @ClassName StatesOnTransition.java
 * @Description 注解
 * @createTime 2020年06月29日
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@OnTransition
public @interface StatesOnTransition {
    OrderStates[] source() default {};

    OrderStates[] target() default {};
}
