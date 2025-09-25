package com.simbirsoft.tests.vinogradoff.topic4.two;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideSearch {
    @Test
    void shouldFindSelenideRepositoryPage() {
        //открыть страницу github.com
        open("https://github.com/");
        // кликнуть на поле поиска чтобы активировать его
        $(".search-input").click();
        // ввести в поле ввода selenide и нажать Enter
        $("input[id='query-builder-test']").setValue("selenide").pressEnter();
        // нажать на линк от первого результата поиска
        // Найти ссылку с текстом "selenide/selenide" и кликнуть
        $("a[href*='/selenide/selenide']").click();
        //check: в заголовке встречается selenide/selenide
        $("div.f3.text-normal").shouldHave(text("selenide"));
    }
}
