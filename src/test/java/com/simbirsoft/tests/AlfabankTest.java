package com.simbirsoft.tests;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AlfabankTest {
    @Test
    void testAlfa(){
        open("https://alfabank.ru/");
        $(byText("Стать клиентом")).click();
        $("body").shouldHave(text("Выберите продукт и станьте клиентом"));
        $$(byText("Накопления")).find(visible).click();
        $("body").shouldHave(text("Накопительный Альфа‑Счёт"));
    }
}
