package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import models.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.CasePage;
import pages.LoginPage;
import pages.ProjectPage;
import pages.SuitePage;
import steps.LoginSteps;
import steps.ProjectSteps;
import tests.api.QaseioApiTest;

public class BaseTest {

    static Faker fake = new Faker();
    public LoginSteps loginSteps = new LoginSteps();
    public ProjectSteps projectSteps = new ProjectSteps();
    LoginPage loginPage = new LoginPage();
    ProjectPage projectPage = new ProjectPage();
    SuitePage suitePage = new SuitePage();
    CasePage casePage = new CasePage();
    QaseioApiTest qaseioApiTest = new QaseioApiTest();

    Project proj = ProjectBuilder.get();
    Project proj1 = Project.builder().projectName("Demo").projectCode("Demo").build();

    Project projTest = new Project(fake.code().asin(), fake.name().firstName());
    Suite suite = SuiteBuilder.get();
    Suite suiteSuite = new Suite(fake.name().firstName());
    Case caseName = new Case(fake.name().firstName());
    Case caseCase = CaseBuilder.get();


    @BeforeAll
    static void screenResolution() {
        Configuration.baseUrl = "https://app.qase.io";
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    void setUp() {
        Configuration.timeout = 5000;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
        Configuration.timeout = 3000;
    }
}
