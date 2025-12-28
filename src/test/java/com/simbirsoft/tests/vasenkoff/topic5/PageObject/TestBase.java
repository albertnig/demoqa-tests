package com.simbirsoft.tests.vasenkoff.topic5.PageObject;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class
TestBase {
    @BeforeAll
    static void beforeAll() {
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        Configuration.browserSize = screenSize.width + "x" + screenSize.height;
        Configuration.pageLoadTimeout = 60000;
        //Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
    }
}
