package com.simbirsoft.tests.vasenkoff.topic5.PageObject;

import com.simbirsoft.tests.vasenkoff.topic5.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.simbirsoft.tests.vasenkoff.topic5.PageObject.TestData.firstName;
import static com.simbirsoft.tests.vasenkoff.topic5.PageObject.TestData.lastName;

public class PracticeFormWithPageObjectTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        String permanentAddress = "some street 1";

        registrationPage.openPage();
        registrationPage.typeFirstName(firstName)
                        .typeLastName(lastName);
        // Заполнение основных полей
        $("#userEmail").setValue("alex@smith.com");
        // Выбор пола
        $("label[for='gender-radio-1']").click();
        // Заполнение номера телефона
        $("#userNumber").setValue("8800200600");
        // Заполнение даты рождения
        registrationPage.calendar.setDate("28", "July", "2005");
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

        registrationPage.checkResultsValue("Student Name", firstName + " " + lastName);

        /*$(".table-responsive").shouldHave(
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
        );*/
        // Закрытие модального окна
        $("#closeLargeModal").click();
        $(".modal-content").should(disappear);
    }
}