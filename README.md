# Vehicle Journey Application

This repository contains a simple Java application for a traveler starting a journey with various vehicles. However, it's important to note that the current implementation exhibits tight coupling, which may hinder flexibility, maintainability, and testability.

## Problem:

The `Traveller` class is directly dependent on specific implementations of the `Car` and `Bike` classes, resulting in tight coupling.

## Why is it a concern?

1. **Direct Dependency:**
    - The `Traveller` class directly references concrete classes (`Car` and `Bike`), making it susceptible to changes in their implementations.

2. **Limited Flexibility:**
    - Adding a new type of vehicle requires modifying the `Traveller` class, reducing flexibility and making the code harder to maintain.

3. **Difficulty in Unit Testing:**
    - Unit testing becomes challenging due to dependencies on specific implementations, potentially affecting the testability of the `Traveller` class.

4. **Difficulty in Code Reusability:**
    - The `Traveller` class is tightly bound to specific vehicle implementations, limiting its reusability in different contexts.

## Solution:

To address these issues and promote loose coupling, consider introducing an interface or abstract class for the vehicles. This allows the `Traveller` class to depend on abstractions rather than concrete implementations, enhancing flexibility and maintainability.

```java
// Example interface for vehicles
public interface Moveable {
    void move();
}

// Updated Car and Bike classes implementing Moveable
// ...

// Updated Traveller class
public class Traveller {

    Moveable movable = null;

    public Traveller(Movable movable) {
        this.movable = movable;
    }

    public void startJourney(){
        this.movable.move();
    }
}
