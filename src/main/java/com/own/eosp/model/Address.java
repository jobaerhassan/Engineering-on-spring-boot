package com.own.eosp.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
    private int road;
    private int houseNo;
    private String houseName;
}
