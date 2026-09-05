package com.own.eosp.model;

import jakarta.annotation.PostConstruct;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
@ToString
@Component
@Conditional(customCondition.class)
public class Address {
//    private int road;
//    private int houseNo;
//    @Value("hello")
    @Autowired
//    @Qualifier("hel")
    private String houseName;
//
    @Bean
    @Primary
    public String house() {
        return "house 54";
    }

    @Bean
//    @Qualifier("hel")
    public String house1() {
        return "house 544";
    }
}


class customCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return true;
    }
}