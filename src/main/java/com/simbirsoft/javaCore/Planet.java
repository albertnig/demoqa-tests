package com.simbirsoft.javaCore;

public class Planet extends AstronomicalObject implements PresenceOfResources {

    public NameOfPlanet planetName;
    public int number;
    public String structure;

    String[] planetsStructure = {"earth group", "gas giants", "ice giants"};

    public Planet(double weight, double speed, int age, NameOfPlanet planetName, int number, int index) {
        super(weight, speed, age, planetName.name());
        this.planetName = planetName;
        this.number = number;
        this.structure = planetsStructure[index];
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Planet name = " + name;
    }

    public void locationFromSun() {
        System.out.println(name + " is " + number + " planet from the sun");
    }

    public Planet distanceByStructure() {
        if (this.structure.equals("earth group")) {
            System.out.println(this.name + " is close to the sun");
        } else if (this.structure.equals("gas giants")) {
            System.out.println(this.name + " is far to the sun");
        } else {
            System.out.println(this.name + " is very far from the sun");
        }
        return this;
    }

    @Override
    public void lookingForPeople() {
        if (planetName.equals(NameOfPlanet.EARTH)) {
            System.out.println("There are people on planet " + planetName);
        } else {
            System.out.println("There are no people on planet " + planetName);
        }
    }

    @Override
    public void lookingForWater() {
        if (planetName.equals(NameOfPlanet.EARTH) || planetName.equals(NameOfPlanet.MARS)) {
            System.out.println("There is water on planet " + planetName);
        } else {
            System.out.println("There is no water on planet " + planetName);
        }
    }
}
