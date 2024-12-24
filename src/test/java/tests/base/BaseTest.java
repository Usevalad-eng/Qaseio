package tests.base;

import com.codeborne.selenide.Configuration;
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
}
