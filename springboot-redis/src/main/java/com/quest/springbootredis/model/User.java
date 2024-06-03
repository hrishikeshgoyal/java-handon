package com.quest.springbootredis.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Long Id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;

}
