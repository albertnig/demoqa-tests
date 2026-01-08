package com.simbirsoft.tests.vasenkoff.topic5.classwork.PageObject;

import com.github.javafaker.Faker;

public class TestData {

    static Faker faker = new Faker();
    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            phoneNumber = "8800200600",
            currentAddress = faker.address().fullAddress(),
            state = "NCR",
            city = "Delhi",
            pictureFileName = "Image.png";

    public static String[] subjects = {"Math", "Physics"};
    public static String[] hobbies = {"Sports", "Reading"};
}
