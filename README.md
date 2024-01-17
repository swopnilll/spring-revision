# Annotation Based Configuration

In this article, we'll delve into the steps for annotation-based configuration in Spring. This approach simplifies the process of creating and managing Spring beans using annotations. Let's break down the steps:

### Annotate a class with @Component:
Use @Component annotation on a class to signal Spring IoC Container to automatically create a Spring bean for that class.
For instance, annotate classes like Car, Bike, Cycle, or any class you want to be managed by Spring.

### Use @ComponentScan to specify the package:
Explicitly tell Spring IoC Container to scan a particular package for classes annotated with @Component.
Apply @ComponentScan annotation and specify the package name where the 

### Use @Autowired to inject Spring beans:
After creating Spring beans, inject dependencies automatically using @Autowired annotation.
For example, if a class has a dependency on another class, annotate the field or constructor with @Autowired.


### Use @Qualifier to avoid ambiguity:

If there are multiple beans of the same type, use @Qualifier in conjunction with @Autowired to specify which bean to inject.
It avoids confusion for Spring IoC Container when injecting dependencies.

### Create Spring IoC Container and retrieve beans:

To test the annotation-based configuration, create a Spring container using ApplicationContext.
Retrieve Spring beans from the container using the getBean method.

These steps harness the power of annotations to instruct Spring IoC Container for automatic bean creation and management. Unlike Java-based configuration, there's no need to manually create objects; Spring Container takes care of it.


### Spring Beans
```java
package com.learning.spring;

@Component
public class Bike implements Vehicle {
    public void move(){
        System.out.println("Bike is moving");
    }
}

@Component
public class Car implements Vehicle {

    public void move(){
        System.out.println("Car is moving");
    }
}

@Component
public class Traveller {
    private  Vehicle vehicle;

    @Autowired
    public Traveller(@Qualifier("bike") Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void startJourney(){
        this.vehicle.move();
    }
}
```

### App Config Class
```java

@ComponentScan(basePackages = "com.learning.spring")
@Configuration
public class AppConfig {

}
```

### Client (Main App)
```java
public class Client {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        Car car =  applicationContext.getBean(Car.class);
        car.move();

        Bike bike = applicationContext.getBean(Bike.class);
        bike.move();

        Traveller traveller = applicationContext.getBean(Traveller.class);
        traveller.startJourney();

    }
}
```
        


