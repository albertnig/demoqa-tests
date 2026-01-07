package com.simbirsoft.tests.vasenkoff.topic5.classwork.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Visible;
import com.simbirsoft.tests.vasenkoff.topic5.classwork.pages.components.CalendarComponent;
import com.simbirsoft.tests.vasenkoff.topic5.classwork.pages.components.ResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final String FORM_TITLE = "Student Registration Form";
    private final SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            phoneNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitButton = $("#submit"),
            stateCityWrapper = $("#stateCity-wrapper");

    public CalendarComponent calendar = new CalendarComponent();
    public ResultsModal resultsModal = new ResultsModal();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage typeGender(Gender gender) {
        genderWrapper.$(byText(gender.getDisplayName())).click();
        return this;
    }

    public RegistrationPage typePhoneNumber(String value) {
        phoneNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage addSubject(String subject) {
        subjectsInput.setValue(subject);
        $(".subjects-auto-complete__option").shouldBe(new Visible()).click();
        return this;
    }

    public RegistrationPage addSubjectWithEnter(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage addHobby(String hobby) {
        hobbiesWrapper.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String fileName) {
        uploadPictureInput.uploadFromClasspath(fileName);
        return this;
    }

    public RegistrationPage setCurrentAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    public RegistrationPage setState(String state) {
        stateInput.scrollTo().click();
        stateCityWrapper.$(byText(state)).click();
        return this;
    }

    public RegistrationPage setCity(String city) {
        cityInput.click();
        stateCityWrapper.$(byText(city)).click();
        return this;
    }

    public RegistrationPage submitAndWaitForModal() {
        submitButton.click();
        resultsModal.waitForAppear();
        return this;
    }
}
