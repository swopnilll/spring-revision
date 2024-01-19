package com.learning.spring.service;

import com.learning.spring.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    DemoRepository demoRepository;

    @Autowired
    public DemoService(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
    }

    public void hello(){
        System.out.println("Hello from service");
        this.demoRepository.hello();
    }
}
