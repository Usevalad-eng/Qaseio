package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.LoginPage;
import pages.ProjectPage;
import steps.LoginSteps;
import steps.ProjectSteps;

public class BaseTest {

    static Faker fake = new Faker();
    public LoginSteps loginSteps = new LoginSteps();
    public ProjectSteps projectSteps = new ProjectSteps();
    LoginPage loginPage = new LoginPage();
    ProjectPage projectPage = new ProjectPage();

    @BeforeAll
    static void screenResolution() {
        Configuration.baseUrl = "https://app.qase.io";
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    void setUp(){
        Configuration.timeout = 5000;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void tearDown(){
        Selenide.closeWebDriver();
        Configuration.timeout = 3000;
    }
}
