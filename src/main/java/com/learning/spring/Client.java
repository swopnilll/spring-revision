package com.learning.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {

        // Creating Spring IoC Container
        // Read the configuration class
        // Create and manage the spring beans
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve spring bean from Spring IoC container.
       Car car =  applicationContext.getBean(Car.class);
       car.move();

       Bike bike = applicationContext.getBean(Bike.class);
       bike.move();

       Traveller traveller = applicationContext.getBean(Traveller.class);
       traveller.startJourney();

    }
}
