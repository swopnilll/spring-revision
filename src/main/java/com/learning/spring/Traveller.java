package com.learning.spring;

public class Traveller {

    Car car = null;

    Bike bike = null;

    Cycle cycle = null;

    public Traveller() {
        this.car = new Car();
        this.bike = new Bike();
        this.cycle = new Cycle();
    }

    public void startJourney(){
        this.car.move();
        this.bike.move();
    }
}
