package tests.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import steps.LoginSteps;

public class BaseTest {

    public LoginSteps loginSteps = new LoginSteps();

    @BeforeAll
    static void screenResolution() {
        Configuration.baseUrl = "https://app.qase.io";
        Configuration.browserSize = "1920x1080";
        //SelenideLogger.addListener("allure", new AllureSelenide());
    }

    /*@BeforeAll
    static void screenResolution() {
        Configuration.baseUrl = "https://app.qase.io";
        Configuration.headless = true;
    }*/

    /*@BeforeAll
    static void screenResolution() {
        Configuration.baseUrl = "https://app.qase.io";
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }*/
}
