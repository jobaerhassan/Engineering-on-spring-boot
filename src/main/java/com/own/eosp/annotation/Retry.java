package com.own.eosp.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Retry {
    Class<? extends Throwable> exceptions() default RuntimeException.class;
    int retryTimes() default 1;
    long intervalTimes() default 3000;
}
