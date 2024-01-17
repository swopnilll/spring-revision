## Introduction

When we create an object using new keyword, the object is store in heap memory of JVM.

The Idea of using Spring container is to allow the spring container to create and manage object for us.

For that, first of all, we need to provide an information in a configuration file to create and manage Spring beans. 
This is called configuration metadata.

Spring provides different ways to configure the spring beans. 
1. XML-based configuration.
2. Annotation based configuration.
3. Java based configuration

Most of the developer prefer a mix of Java based and annotation based configuration.

## Steps of Java Based Configuration 

1. Create a configuration class with @Configuration annotation.
2. Create a method and annotate it with @Bean annotation.
3. Create Spring IoC container (Application Context) and Retrieve Spring bean from Spring IoC Container.

# Java-Based Configuration in Spring

## Introduction:

In this section, we'll delve into understanding the Spring container with Java-based configuration. Before exploring the Spring container, it's crucial to grasp the steps involved in creating a Java-based configuration in a Spring application.

## Java-Based Configuration Steps:

### 1. Create a Configuration Class:

- Create a configuration class annotated with `@Configuration`. This class will serve as the basis for configuring Spring beans.

```java
   @Configuration
   public class AppConfig {
       // Configuration details go here
   }
```
Whenever we annotate a class with @Configuration annotation, then the class becomes a java based configuration class.

And within the configuration class, we can configure one or more spring beans using @Bean annotation.



### 2. Define Spring Beans:
To define Spring beans within the configuration class, create methods annotated with @Bean. Each method returns an object of a specific class, and Spring container manages these objects.

```java
@Configuration
public class AppConfig {
    @Bean
    public Car car() {
        return new Car();
    }

    @Bean
    public Bike bike() {
        return new Bike();
    }
}

```
In the above example, the car() method returns a new instance of the Car class, and the bike() method returns a new instance of the Bike class.

@Bean Annotation tells spring container that this method returns an instance of car class and spring IoC container have to manage the instance of car class.


### 3. Inject Dependencies Manually:
In Java-based configuration, dependencies need to be injected manually. For example, if the Traveler class depends on the Bike class, inject the Bike object manually.
```java
@Configuration
public class AppConfig {
    @Bean
    public Car car() {
        return new Car();
    }

    @Bean
    public Bike bike() {
        return new Bike();
    }

    @Bean
    public Traveler traveler() {
        return new Traveler(bike());
    }
}
```
The Traveler class is created with a manually injected dependency of the Bike class.

## Create Spring IoC Container and Retrieve Bean 

```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {
        // Creating the Spring container using AnnotationConfigApplicationContext
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieving Spring beans from the container
        Vehicle car = context.getBean(Car.class);
        Vehicle bike = context.getBean(Bike.class);
        Traveller traveller = context.getBean(Traveller.class);

        // Invoking methods on the retrieved beans
        car.move();
        bike.move();
        traveller.startJourney();
    }
}
```

In this client class, we create an AnnotationConfigApplicationContext and pass our AppConfig class to it. We then retrieve the Spring beans (Car, Bike, and Traveller) from the container using the getBean method.

Finally, we invoke the move method on the Car and Bike beans and the startJourney method on the Traveller bean.


## Summary
This example demonstrates how to configure Spring beans using Java-based configuration and how to use the Spring container to manage these beans. By injecting dependencies through the container, we achieve loose coupling and enable Spring to handle the object lifecycle. This approach enhances flexibility, modularity, and testability in our application.


## Understanding How Spring IOC Container Works

### Overview
Consider an application with multiple Java classes, denoted as Class1, Class2, Class3, and so forth. Instead of manually creating objects for these classes, we want the Spring container to take control of the object creation and management process.

To achieve this, we provide information in a configuration file to the Spring container. The configuration file can be in various formats, including XML-based configuration, annotation-based configuration, or Java-based configuration.

Here's how the process unfolds:

1. Configuration File: We create a configuration file that specifies which Spring beans the container should create. This file contains details about the beans and their dependencies.
2. Spring IOC Container: The Spring IOC container reads the configuration file, extracting information on which beans to create and how to manage their lifecycle.
3. Bean Creation and Lifecycle Management: Based on the configuration, the container creates Spring beans and manages their lifecycle, handling aspects such as initialization, usage, and destruction.
4. Dependency Injection: If there are dependencies between beans, the container uses dependency injection to inject the required dependencies into the corresponding beans.
5. Application Ready: Once the container has created and configured all the necessary beans, and injected dependencies, the application becomes fully configured and ready to use.

## Conclusion
Understanding how the Spring IOC container works is crucial for efficiently leveraging the benefits of inversion of control. By providing configuration details, developers allow the container to handle object creation, lifecycle management, and dependency injection, promoting a modular and maintainable application design. In the next sections, we will explore the specifics of using annotation-based configuration in a Spring application.
