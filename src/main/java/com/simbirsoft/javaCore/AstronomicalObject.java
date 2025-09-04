package com.simbirsoft.javaCore;

public class AstronomicalObject {
    public double weight;
    public double speed;
    public int age;
    public String name;
    private static String space = "universe";

    public AstronomicalObject(double weight, double speed, int age, String name) {
        this.weight = weight;
        this.speed = speed;
        this.age = age;
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getSpace() {
        return space;
    }

    public static void setSpace(String space) {
        AstronomicalObject.space = space;
    }

    public void sendRocket(AstronomicalObject object) {
        System.out.println("The rocket flew to " + object.name);
    }

    public static void bigBang() {
        System.out.println("The big bang");
    }

    public double getWeight(){
        return weight;
    }

}
