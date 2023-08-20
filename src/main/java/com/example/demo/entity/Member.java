package com.example.demo.entity;


import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer age;


    public Member(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
