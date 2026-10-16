package com.own.eosp;

import com.own.eosp.model.Student;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.IOException;
import java.util.Set;

@EnableAsync
@SpringBootApplication
public class EngineeringOnSpringBootApplication {

    public static void main(String[] args) throws IOException {
//		SpringApplication.run(EngineeringOnSpringBootApplication.class, args);
        // turning off the spring application to run and see the validations
        Student student1 = new Student(-1, "Jobaer", 24, 3.4f, "jobaer@gmail.com", "112");
        Student student2 = new Student(-1, "Jobaer", 100, 3.4f, "jobaer#gmail.com", "112");

        try (var validatorFactory = Validation.buildDefaultValidatorFactory()) {
            Validator validation = validatorFactory.getValidator();
            Set<ConstraintViolation<Student>> errors1 = validation.validate(student1);
            System.out.println(errors1.size()); // return error size, for student1 got 1;
            Set<ConstraintViolation<Student>> errors2 = validation.validate(student2);
            System.out.println(errors2.size()); // return error size, for student2 got 0;

            for (ConstraintViolation<Student> error : errors1) {
                System.out.println(error.getPropertyPath().toString() + "-> " + error.getMessage() + "->" + error.getInvalidValue());
            }

            for (ConstraintViolation<Student> error : errors2) {
                System.out.println(error.getPropertyPath().toString() + "-> " + error.getMessage() + "->" + error.getInvalidValue());
            }

//            1
//            3

//            id-> must be greater than 0->-1

//            email-> must be a well-formed email address->jobaer#gmail.com
//            age-> must be between 10 and 50->100
//            id-> must be greater than 0->-1

        }
    }

}

