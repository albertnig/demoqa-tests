package com.simbirsoft.tests.vinogradoff.topic4.one;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class TbankTest {
    @Test
    void testTbank(){
        open("https://www.tbank.ru/");
        $("body").shouldHave(exactText("Открыть вклад")).click();
        $("body").shouldHave(text("Настройте вклад"));
        $$(byText("В юанях")).find(visible).click();
        //$("body").shouldHave(text("Накопительный Альфа‑Счёт"));
    }
}
