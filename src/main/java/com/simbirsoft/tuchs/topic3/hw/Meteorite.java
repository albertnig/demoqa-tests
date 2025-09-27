package com.simbirsoft.tuchs.topic3.hw;

public class Meteorite extends AstronomicalObject {

    String[] countdown = {"five", "four", "three", "two", "one"};

    public Meteorite(double weight, double speed, int age, String name) {
        super(weight, speed, age, name);
    }

    public void crash(Planet planet) {
        for (int i = 0; i < countdown.length; i++) {
            System.out.println(countdown[i]);
        }
        planet.setSpeed(planet.getSpeed() - 1);
    }

    public void checkWeight(Planet planet) {
        if (planet.weight <= 5) {
            System.out.println("There is no planet anymore");
            planet.weight -= planet.weight;
        } else {
            System.out.println("The planet is rocking");
            planet.weight -= 1;
        }
    }

}
