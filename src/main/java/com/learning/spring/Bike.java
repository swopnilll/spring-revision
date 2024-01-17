package com.learning.spring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Bike implements Vehicle {
    public void move(){
        System.out.println("Bike is moving");
    }
}
