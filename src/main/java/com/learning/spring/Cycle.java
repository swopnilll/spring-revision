package com.learning.spring;

import org.springframework.stereotype.Component;

@Component
public class Cycle implements Vehicle {

    public void move(){
        System.out.println("Cycle is moving");
    }
}
