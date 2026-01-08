package com.simbirsoft.tests.vasenkoff.topic5.classwork.pages.components;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Visible;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ResultsModal {
    private final SelenideElement
            modalTitle = $("#example-modal-sizes-title-lg"),
            modalContent = $(".modal-content"),
            table = $(".table-responsive"),
            closeButton = $("#closeLargeModal");

    public ResultsModal waitForAppear() {
        modalTitle.shouldBe(new Visible(), Duration.ofSeconds(15));
        modalContent.shouldBe(visible);
        table.shouldBe(visible);
        return this;
    }

    public ResultsModal checkTitle(String expectedTitle) {
        modalTitle.shouldHave(text(expectedTitle));
        return this;
    }

    public ResultsModal checkResultsValue(String key, String value) {
        $x("//td[text()='" + key + "']").parent().shouldHave(text(value));
        return this;
    }

    public ResultsModal checkResultsContainsText(String... texts) {
        for (String text : texts) {
            table.shouldHave(text(text));
        }
        return this;
    }

    public void close() {
        closeButton.click();
        modalContent.should(disappear);
    }
}
