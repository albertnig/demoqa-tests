package com.simbirsoft.tests.vasenkoff.topic5.hw.pages;

import com.codeborne.selenide.SelenideElement;
import com.simbirsoft.tests.vasenkoff.topic5.classwork.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderInput = $("label[for='gender-radio-1']"),
            phoneNumberInput = $("#userNumber"),
    //dateOfBirthInput = $("#lastName"),
    subjectsFirstInput = $("#subjectsInput"),
    //subjectsSecondInput = $("#subjectsInput"),
    hobbyInput = $("#hobbiesWrapper"),
            pitureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city");

    public CalendarComponent calendar = new CalendarComponent();

    public void openPage() {
        open("/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public void typeFirstName(String value) {
        firstNameInput.setValue(value);
    }

    public void typeLastName(String value) {
        lastNameInput.setValue(value);
    }

    public void typeUserEmail(String value) {
        userEmailInput.setValue(value);
    }

    public void typeGender(String value) {
        genderInput.setValue(value);
    }

    public void typePhoneNumber(String value) {
        phoneNumberInput.setValue(value);
    }

    public void typeSubjectsFirst(String value) {
        subjectsFirstInput.setValue(value);
    }

    public void typeHobby(String value) {
        hobbyInput.setValue(value);
    }

    public void typePiture(String value) {
        pitureInput.setValue(value);
    }

    public void typeAddress(String value) {
        addressInput.setValue(value);
    }

    public void typeState(String value) {
        stateInput.setValue(value);
    }

    public void typeCity(String value) {
        cityInput.setValue(value);
    }


    public void checkResultsValue(String key, String value) {
        $x("//td[text()='" + key + "']").parent().shouldHave(text(value));
        lastNameInput.setValue(value);
    }
}
