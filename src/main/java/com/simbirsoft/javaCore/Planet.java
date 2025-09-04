package com.simbirsoft.javaCore;

public class Planet extends AstronomicalObject {
    public int number;

    public Planet(double weight, double speed, int age, String name, int number) {
        super(weight, speed, age, name);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void locationFromSun(){
        System.out.println(name + " " + number + " planet from the sun");
    }
}
