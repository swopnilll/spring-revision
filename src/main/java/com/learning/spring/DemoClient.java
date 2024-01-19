package com.learning.spring;

import com.learning.spring.controller.DemoController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoClient {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        applicationContext.getBean(DemoController.class).hello();
    }
}
