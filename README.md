# Vehicle Journey Application

This repository contains a simple Java application for a traveler starting a journey with various vehicles. The design has been improved to address the issue of tight coupling.

## Problem:

The initial implementation had tight coupling, where the `Traveller` class was directly dependent on specific implementations of the `Car`, `Bike`, and `Cycle` classes.

## Solution:

To address tight coupling, a `Vehicle` interface has been introduced:

```java
public interface Vehicle {
    void move();
}
``` 

## Explanation:

Using the Vehicle interface in this scenario helps to address the problem of tight coupling by introducing an abstraction that allows the Traveller class to depend on an interface rather than specific implementations (such as Car, Bike, or Cycle). Here's how this resolves the tight coupling issue:

## 1. Abstraction

The Vehicle interface defines a contract with a single method, move(). This abstraction allows any class that implements the Vehicle interface to be considered a valid vehicle without exposing the internal details of how it moves.

```java
public interface Vehicle {
    void move();
}
```

## 2. Loose Coupling

The Traveller class now depends on the Vehicle interface, rather than specific vehicle implementations. This promotes loose coupling because the Traveller class doesn't need to know the specific classes like Car, Bike, or Cycle; it only cares that the provided object adheres to the Vehicle interface.

```Java
public class Traveller {
    Vehicle vehicle = null;

    public Traveller(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void startJourney(){
        this.vehicle.move();
    }
}

```

## 3. Flexibility and Extensibility

With this approach, you can easily introduce new types of vehicles by implementing the Vehicle interface. Adding a new vehicle type doesn't require modifying the Traveller class, promoting flexibility and extensibility.

```java
public class Bike implements Vehicle {
    @Override
    public void move() {
        System.out.println("Bike is moving");
    }
}

```

## 4. Client Code Independence:

In the client code (e.g., Client class), you can create instances of different vehicle types (Car, Bike, Cycle) and pass them to the Traveller class. The client code is no longer tightly bound to specific vehicle implementations, making it more independent and adaptable.

```java
public class Client {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle bike = new Bike();
        Vehicle cycle = new Cycle();

        Traveller traveller = new Traveller(car);
        traveller.startJourney();
    }
}
```

## Conclusion

Overall, using interfaces in this manner promotes a more modular, maintainable, and extensible design, adhering to the principles of object-oriented programming such as abstraction and encapsulation.

## Interface and Abstract Class


In the provided example, you can use either an interface or an abstract class to achieve the goal of reducing tight coupling. Both interfaces and abstract classes offer a way to define a common contract for classes to adhere to, but there are some differences between the two.

# Interface vs Abstract Class Comparison

| Feature                 | Interface                                      | Abstract Class                                |
|-------------------------|------------------------------------------------|-----------------------------------------------|
| **Definition**          | Defines a contract without any implementation. | Can have both abstract and concrete methods.  |
| **Multiple Inheritance**| A class can implement multiple interfaces.      | A class can extend only one abstract class.   |
| **Fields**              | Can only have constants (public static final). | Can have instance variables (fields).         |
| **Constructors**        | Cannot have constructors.                       | Can have constructors.                        |
| **Access Modifiers**    | All methods are implicitly public.              | Methods can have various access modifiers.    |
| **Default Methods**     | Can include default methods with implementation.| Can include methods with implementation.      |
| **Use Case**            | Suitable for defining a contract for unrelated classes. | Suitable for sharing implementation among related classes. |
| **Example**             | `public interface Vehicle { void move(); }`    | `public abstract class Vehicle { abstract void move(); void stop() { System.out.println("Vehicle has stopped"); } }` |

Choose between an interface and an abstract class based on the specific requirements of your design. If you need to provide a common implementation or share state among related classes, an abstract class might be more appropriate. If you want to define a contract for unrelated classes or support multiple inheritances, an interface might be a better choice.

