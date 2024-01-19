package com.learning.spring.repository;

import org.springframework.stereotype.Repository;

@Repository
public class DemoRepository {

    public void hello(){
        System.out.println("Hello from repository");
    }
}
