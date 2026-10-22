package com.own.eosp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.IOException;

@EnableAsync
@SpringBootApplication
public class EngineeringOnSpringBootApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(EngineeringOnSpringBootApplication.class, args);
//
//        Student student1 = new Student(-1, "Jobaer", 24, 3.4f, "jobaer@gmail.com", "112");
//        Student student2 = new Student(-1, "Jobaer", 100, 3.4f, "jobaer#gmail.com", "112");
//
//        try (var validatorFactory = Validation.buildDefaultValidatorFactory()) {
//            Validator validation = validatorFactory.getValidator();
//            Set<ConstraintViolation<Student>> errors1 = validation.validate(student1);
//            System.out.println(errors1.size()); // return error size, for student1 got 1;
//            Set<ConstraintViolation<Student>> errors2 = validation.validate(student2);
//            System.out.println(errors2.size()); // return error size, for student2 got 0;
//
//            for (ConstraintViolation<Student> error : errors1) {
//                System.out.println(error.getPropertyPath().toString() + "-> " + error.getMessage() + "->" + error.getInvalidValue());
//            }
//
//            for (ConstraintViolation<Student> error : errors2) {
//                System.out.println(error.getPropertyPath().toString() + "-> " + error.getMessage() + "->" + error.getInvalidValue());
//            }
//

    }
}



