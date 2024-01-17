package com.learning.spring;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle {
    public void move(){
        System.out.println("Bike is moving");
    }
}
