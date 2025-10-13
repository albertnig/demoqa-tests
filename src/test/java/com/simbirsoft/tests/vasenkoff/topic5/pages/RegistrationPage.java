package com.simbirsoft.tests.vasenkoff.topic5.pages;

import com.codeborne.selenide.SelenideElement;
import com.simbirsoft.tests.vasenkoff.topic5.components.CalendarComponent;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName");

    public CalendarComponent calendar = new CalendarComponent();


    public void openPage() {
        open("/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public void typeLastName(String value) {
        lastNameInput.setValue(value);
    }

    public void checkResultsValue(String key, String value) {
        $x("//td[text()='" + key + "']").parent().shouldHave(text(value));
        lastNameInput.setValue(value);
    }
}
