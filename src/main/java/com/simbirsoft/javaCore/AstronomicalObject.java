package com.simbirsoft.javaCore;

public class AstronomicalObject {
    public double weight;
    public double speed;
    public int age;
    public String name;
    public static String space = "universe";

    public AstronomicalObject(double weight, double speed, int age, String name) {
        this.weight = weight;
        this.speed = speed;
        this.age = age;
        this.name = name;
    }

    public void sendRocket(AstronomicalObject object) {
        System.out.println("The rocket flew to " + object.name);
    }

    public static void bigBang() {
        System.out.println("The big bang");
    }

    public int getAge(){
        return age;
    }

}
