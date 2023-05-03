package com.nhnacademy.edu.jdbc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author : marco@nhnacademy.com
 * @Date : 05/04/2023
 */

@Target(value = {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
    enum Method{
        POST,GET
    }
    String value();
    Method method() default Method.GET;
}
