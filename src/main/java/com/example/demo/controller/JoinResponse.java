package com.example.demo.controller;


import lombok.Data;

@Data
public class JoinResponse {

    private String name;

    private int age;

    public JoinResponse(String name, int age) {
        this.name = name;
        this.age = age;
    }


}
