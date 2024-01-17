package com.learning.spring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle {

    public void move(){
        System.out.println("Car is moving");
    }
}
