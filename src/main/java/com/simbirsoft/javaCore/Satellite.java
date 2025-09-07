package com.simbirsoft.javaCore;

import java.util.ArrayList;
import java.util.List;

public class Satellite extends AstronomicalObject {
    List<String> typeSatellite = new ArrayList<>();

    public Satellite(double weight, double speed, int age, String name) {
        super(weight, speed, age, name);
    }

    public boolean initializeSatelliteTypes() {
        typeSatellite.add("Regular satellites");
        typeSatellite.add("Irregular satellites");
        typeSatellite.add("Trojan satellites");
        typeSatellite.add("Horseshoe orbits");
        typeSatellite.add("Quasi-satellites");
        return true;
    }

    public void refers(Planet planet) {
        System.out.println(this.name + " refers to the " + planet.name);
    }
}
