package com.learning.spring;

public class Client {
    public static void main(String[] args) {

        Vehicle car = new Car();
//        Vehicle bike = new Bike();
//        Vehicle cycle = new Cycle();

        Traveller traveller = new Traveller(car);
//        Traveller traveller = new Traveller(bike);
//        Traveller traveller = new Traveller(cycle);
        traveller.startJourney();

    }
}
