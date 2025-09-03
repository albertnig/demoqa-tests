package com.simbirsoft.javaCore;

public class Satellite extends AstronomicalObject {

    public Satellite(double weight, double speed, int age, String name) {
        super(weight, speed, age, name);
    }

    public void refers(Planet planet) {
        System.out.println(this.name + " refers to the " + planet.name);
    }
}
