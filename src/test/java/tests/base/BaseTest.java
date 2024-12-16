package tests.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideWait;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    static void screenResolution() {
        Configuration.baseUrl = "https://app.qase.io";
        Configuration.browserSize = "1920x1080";
        //Configuration.timeout = 5000;
    }

    /*@AfterEach
    static void waitMethod(){
        Configuration.timeout = 5000;
    }*/
}
