package com.own.eosp.model;

import com.own.eosp.annotation.BdPhoneNumber;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Positive
    private int id;
    @NotBlank
    private String name;
    @Range(min = 10, max = 50)
    private int age;
    @Positive
    private float cgpa;
    @Email
    private String email;
    //    @Pattern() use korte pari = rπegex or we can build a custom constraint annotation ex: @BdPhoneNumber
    //    @Pattern(regexp = "(\\+88)?01[3-9]\\d{8}", message = "Number format is not valid for Bangladesh")
    @BdPhoneNumber
    private String phone;
}
