package com.own.eosp.validator;

import com.own.eosp.annotation.BdPhoneNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BdPhoneNumberValidator implements ConstraintValidator<BdPhoneNumber, String> {
    int max, min;
    @Override
    public void initialize(BdPhoneNumber constraintAnnotation) {
        this.max = constraintAnnotation.max();
        this.min = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext constraintValidatorContext) {
        log.info("validating bd phone number: {}", phone);
        return phone.matches("(\\+88)?01[3-9]\\d{8}");
    }
}
