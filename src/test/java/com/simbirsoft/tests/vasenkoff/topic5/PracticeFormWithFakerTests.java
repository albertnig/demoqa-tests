package com.simbirsoft.tests.vasenkoff.topic5;

import com.github.javafaker.Faker;
import com.simbirsoft.tests.vasenkoff.topic5.PageObject.TestBase;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormWithFakerTests extends TestBase {

    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            currentAddress = faker.lebowski().quote();

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        // Заполнение основных полей
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        // Выбор пола
        $("label[for='gender-radio-1']").click();
        // Заполнение номера телефона
        $("#userNumber").setValue("8800200600");
        // Заполнение даты рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1992");
        $(".react-datepicker__day--011:not(.react-datepicker__day--outside-month)").click();
        // Добавление первого предмета
        $("#subjectsInput").setValue("Math");
        $(".subjects-auto-complete__option").shouldBe(visible).click();
        // Добавление второго предмета
        $("#subjectsInput").setValue("Physics").pressEnter();
        // Выбор хобби
        $("label[for='hobbies-checkbox-1']").click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        // Загрузка файла
        $("#uploadPicture").uploadFromClasspath("Image.png");
        $("#currentAddress").setValue(currentAddress);
        // Выбор штата
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        // Выбор города
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        // Отправка формы
        $("#submit").click();
        // Ожидание модального окна
        $("#example-modal-sizes-title-lg").shouldBe(visible, Duration.ofSeconds(15));
        $(".modal-content").shouldBe(visible);
        $(".table-responsive").shouldBe(visible);
        // Проверка заголовка
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        // Проверка что таблица содержит все данные
        $(".table-responsive").shouldHave(
                text(firstName + " " + lastName),
                text(userEmail),
                text("Male"),
                text("8800200600"),
                text("11 August,1992"),
                text("Maths, Physics"),
                text("Sports, Reading"),
                text("Image.png"),
                text(currentAddress),
                text("NCR Delhi")
        );
        // Закрытие модального окна
        $("#closeLargeModal").click();
        $(".modal-content").should(disappear);
    }
}