package com.learning.spring.controller;

import com.learning.spring.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DemoController {
    DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    public void hello(){
        System.out.println("Hello from controller");
        demoService.hello();
    }
}
