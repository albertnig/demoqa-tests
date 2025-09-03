package com.simbirsoft;

import com.simbirsoft.javaCore.*;

public class Main {
    static Meteorite meteorite = new Meteorite();
    public static void main(String[] args) {
        Planet planet1 = new Planet(4.8, 6.5, 3, "Venus", 2);
        Planet planet2 = new Planet(5.4, 4.2, 2, "Earth", 3);
        planet1.locationFromSun();

        Star star = new Star(1.9, 2.2, 5, "Sun", 3.8);
        star.allocatedEnergy();
        star.sendRocket(star);

        Satellite satellite = new Satellite(0.5, 7.8, 1, "Moon");
        satellite.refers(planet2);

        System.out.println(AstronomicalObject.space);
        AstronomicalObject.bigBang();

        int earthAge = planet2.getAge();
        System.out.println(earthAge);

        System.out.println(planet1.speed);
        meteorite.crash(planet1);
        System.out.println(planet1.speed);
    }
}
