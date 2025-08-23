package com.simbirsoft.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {
    @BeforeAll
    static void beforeAll() {
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        Configuration.browserSize = screenSize.width + "x" + screenSize.height;
        Configuration.pageLoadTimeout = 60000;
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        String permanentAddress = "some street 1";

        open("/automation-practice-form");
        // Заполнение основных полей
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Smith");
        $("#userEmail").setValue("alex@smith.com");
        // Выбор пола
        $("label[for='gender-radio-1']").click();

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
        $("#currentAddress").setValue(permanentAddress);
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
                text("Alex Smith"),
                text("alex@smith.com"),
                text("Male"),
                text("8800200600"),
                text("11 August,1992"),
                text("Maths, Physics"),
                text("Sports, Reading"),
                text("Image.png"),
                text("some street 1"),
                text("NCR Delhi")
        );

        // Закрытие модального окна
        $("#closeLargeModal").click();
        $(".modal-content").should(disappear);
    }
}
