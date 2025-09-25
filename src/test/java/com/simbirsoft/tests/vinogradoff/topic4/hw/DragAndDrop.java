package com.simbirsoft.tests.vinogradoff.topic4.hw;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {
    @Test
    void shouldActionDragAndDrop() {
        //arrange
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //assert (Проверяем исходное состояние)
        $("#column-a header").shouldHave(text("A"));
        $("#column-b header").shouldHave(text("B"));
        //act
        actions()
                .clickAndHold($("#column-a"))
                .moveToElement($("#column-b"))
                .release()
                .perform();
        //sleep(10);
        //assert (Проверяем, что содержимое поменялось местами)
        $("#column-a header").shouldHave(text("B"));
        $("#column-b header").shouldHave(text("A"));
        sleep(5000);
    }

    /*@Test
    void shouldActionDragAndDrop2() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        // act
        $("#column-a").dragAndDropTo($("#column-b"));
        // assert
        $("#column-a header").shouldHave(text("B"));
        $("#column-b header").shouldHave(text("A"));
    }*/
}