package com.own.eosp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Component("stu") // giving the bean an another name
public class Student {

    private String name;

    @Autowired
    private Address address;

    @jakarta.annotation.PostConstruct
    public void created() {
        System.out.println(">> Student bean তৈরি হলো (এর ভেতরে address = " + address + ")");
    }
}
