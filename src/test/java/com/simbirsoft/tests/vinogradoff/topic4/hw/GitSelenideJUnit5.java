package com.simbirsoft.tests.vinogradoff.topic4.hw;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class GitSelenideJUnit5 {
    @Test
    void shouldFindJUnit5() {
        //arrange
        open("https://github.com/selenide/selenide");
        //act
        $("#wiki-tab").click();
        //assert
        $(".markdown-body").shouldHave(text("Welcome to the selenide wiki!"));
        //act
        $("a[href$='/selenide/selenide/wiki/SoftAssertions']").click();
        //assert
        $$("li").findBy(text("JUnit5 extension -"))
                .$("code")
                .shouldHave(text("SoftAssertsExtension"));
    }
}
