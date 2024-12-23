package tests.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    static void screenResolution() {
        Configuration.baseUrl = "https://app.qase.io";
        Configuration.browserSize = "1920x1080";
    }

    /*@AfterAll
    static void exit(){
        Selenide.closeWindow();
        //Selenide.clearBrowserCookies();
    }*/
}
