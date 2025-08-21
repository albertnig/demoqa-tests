package com.simbirsoft.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {
    @BeforeAll
    static void beforeAll() {
        /*java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        Configuration.browserSize = screenSize.width + "x" + screenSize.height;*/
        Configuration.browser = "chrome";
        Configuration.headless = false; // false для разработки, true для CI
        Configuration.browserSize = "1920x1080"; // фиксированный размер вместо полного экрана
        // ... остальная конфигурация
        Configuration.pageLoadTimeout = 60000;
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest(){
        String permanentAddress = "some street 1";

        open("https://demoqa.com/automation-practice-form");
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
        $("#subjectsInput").setValue("Physics");
        $(".subjects-auto-complete__option").shouldBe(visible).click();
        // Выбор хобби
        $("label[for='hobbies-checkbox-1']").click();
        $("label[for='hobbies-checkbox-2']").click();
        // Загрузка файла
        $("#uploadPicture").uploadFromClasspath("Image.png");
        $("#currentAddress").setValue(permanentAddress);

        // Выбор штата
        $("#state").scrollTo().click();
        $(byText("NCR")).click();
        // Выбор города
        $("#city").click();
        $(byText("Delhi")).click();
        // Отправка формы
        $("#submit").click();
        // Ожидание модального окна
        $("#example-modal-sizes-title-lg").shouldBe(visible, Duration.ofSeconds(10));
        // Проверки результатов
        $(".table-responsive").shouldBe(visible);
        $(".table-responsive tr:nth-child(1) td:nth-child(2)").shouldHave(text("Alex Smith"));
        $(".table-responsive tr:nth-child(2) td:nth-child(2)").shouldHave(text("alex@smith.com"));
        $(".table-responsive tr:nth-child(9) td:nth-child(2)").shouldHave(text("some street 1"));
        $(".table-responsive tr:nth-child(10) td:nth-child(2)").shouldHave(text(permanentAddress));
    }
}
