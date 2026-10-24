package com.own.eosp.annotation;

import com.own.eosp.validator.BdPhoneNumberValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BdPhoneNumberValidator.class) // kon class ta ei annotation wala field ta k validate korbe
public @interface BdPhoneNumber {
    String message() default "Number format is not valid for Bangladesh";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int max() default Integer.MAX_VALUE;

    int min() default Integer.MIN_VALUE;
}
