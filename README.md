
## Understanding @Qualifier and @Primary

### Overview:
In this tutorial, we explore the use of several annotations in the Spring Framework, focusing on the challenges posed by ambiguity in bean injection and how to address them using @Qualifier and @Primary annotations.

## Introduction to Annotations:
#### @Component: 
Marks a class as a Spring component, allowing it to be automatically detected and registered as a bean in the Spring IoC container. 

#### @Autowired: 
Autowired dependencies between beans, injecting them automatically by type. 

#### @Qualifier: 
Resolves ambiguity when there are multiple beans of the same type by specifying the bean name to be injected. 

#### @ComponentScan
Scans specified packages for components to register in the Spring IoC container.

## Addressing Ambiguity with @Qualifier:
#### Problem Statement:

- Multiple implementations of the Vehicle interface (e.g., Car, Bike, Cycle).
- Constructor injection in the Driver class leads to ambiguity for the Spring IoC container.

#### Solution:

- Introduces the use of @Qualifier annotation to specify which bean to inject.
- Demonstrates providing the bean name (e.g., @Qualifier("cycle")) to resolve ambiguity.

## Introduction to @Primary Annotation:

Qualifier effectively resolves ambiguity, an alternative solution using @Primary annotation can also be employed


```java
@Component
@Primary
public class Car implements Vehicle {

    public void move(){
        System.out.println("Car is moving");
    }
}
```

```java
@Component
public class Traveller {
    private  Vehicle vehicle;

    @Autowired
    public Traveller(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void startJourney(){
    this.vehicle.move();
    }
}
```

## Use Cases for @Primary Annotation:

#### Scenario:
Multiple beans of the same type in different environments (e.g., data sources).

#### Use Case:
In a Spring application, it's common to have different configurations for various environments, such as using different databases for local development, testing, and production. The @Primary annotation can be leveraged to handle these scenarios effectively.


