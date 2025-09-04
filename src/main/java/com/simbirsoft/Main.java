package com.simbirsoft;

import com.simbirsoft.javaCore.*;

public class Main {
    static Meteorite meteorite = new Meteorite(1.1,16,1,"Asteroid Bennu");
    public static void main(String[] args) {
        Planet planet1 = new Planet(4.8, 6.5, 3, "Venus", 2);
        Planet planet2 = new Planet(5.4, 4.2, 2, "Earth", 3);
        planet1.locationFromSun();

        Star star = new Star(1.9, 2.2, 5, "Sun", 3.8);
        star.allocatedEnergy();
        star.sendRocket(star);

        Satellite satellite = new Satellite(0.5, 7.8, 1, "Moon");
        satellite.refers(planet2);

        System.out.println(AstronomicalObject.getSpace());
        AstronomicalObject.bigBang();

        double venusWeight = planet1.getWeight();
        System.out.println("The mass of Venus " + venusWeight);

        System.out.println("The speed of the planet is up to " + planet1.speed);
        meteorite.crash(planet1);
        System.out.println("The speed of the planet after " + planet1.speed);

        System.out.println("The mass of the planet is up to " + planet2.weight);
        meteorite.checkWeight(planet2);
        System.out.println("The mass of the planet after " + planet2.weight);
    }
}
