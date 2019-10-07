package com.example.netobserver.annotation;

import com.example.netobserver.type.NetType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NetWork {

    NetType netType() default NetType.AUTO; //默认属性值
}
