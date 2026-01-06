package com.simbirsoft.tests.vasenkoff.topic5.classwork.PageObject;

import com.codeborne.selenide.SelenideElement;
import com.simbirsoft.tests.vasenkoff.topic5.classwork.pages.Gender;
import com.simbirsoft.tests.vasenkoff.topic5.classwork.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.simbirsoft.tests.vasenkoff.topic5.classwork.PageObject.TestData.*;

public class PracticeFormWithPageObjectTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(email)
                .typeGender(Gender.FEMALE)
                .typePhoneNumber(phoneNumber);

        registrationPage.calendar.setDate("28", "July", "2005");

        registrationPage
                .addSubject("Math")
                .addSubjectWithEnter("Physics")
                .addHobby("Sports")
                .addHobby("Reading")
                .uploadPicture(pictureFileName)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submitAndWaitForModal();

        // Проверка что таблица содержит все данные
        registrationPage.resultsModal
                .checkTitle("Thanks for submitting the form")
                .checkResultsValue("Student Name", firstName + " " + lastName)
                .checkResultsValue("Student Email", email)
                .checkResultsValue("Gender", "Female")
                .checkResultsValue("Mobile", phoneNumber)
                .checkResultsValue("Date of Birth", "28 July,2005")
                .checkResultsValue("Subjects", "Maths, Physics")
                .checkResultsValue("Hobbies", "Sports, Reading")
                .checkResultsValue("Picture", pictureFileName)
                .checkResultsValue("Address", currentAddress)
                .checkResultsValue("State and City", state + " " + city)
                .close();
        // Закрытие модального окна
        $("#submit").scrollTo().click();
        $(".modal-content").should(disappear);
    }
}