package com.own.eosp.model;

import jakarta.annotation.PostConstruct;
import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class Address {
    private int road;
    private int houseNo;
    private String houseName;

    @PostConstruct
    public void created() {
        System.out.println(">> Address bean তৈরি হলো (IoC container)");
    }
}
