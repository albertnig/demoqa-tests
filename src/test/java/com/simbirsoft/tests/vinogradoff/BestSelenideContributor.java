package com.simbirsoft.tests.vinogradoff;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class BestSelenideContributor {
    @Test
    void andreiSolntsevShouldBeTheBestContributor() {
        //открыть страничку selenide
        open("https://github.com/selenide/selenide");
        //подвести мышку к первому элементу в области Contributors
        $(".BorderGrid").$(byText("Contributors")).closest("div").$("ul li").hover();
        //проверка в появившемся окне (overlay) текст Andrei Solntsev
        $$(".Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));
    }
}
