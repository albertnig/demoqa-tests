package com.simbirsoft.javaCore;

public class Star extends AstronomicalObject {
    public double energy = 3.8;

    public Star(double weight, double speed, int age, String name, double energy) {
        super(weight, speed, age, name);
        this.energy = energy;
    }

    public void allocatedEnergy() {
        System.out.println(energy + " watts of energy is allocated");
    }
}
