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

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    public static Faker fake = new Faker();
    public LoginSteps loginSteps = new LoginSteps();
    public ProjectSteps projectSteps = new ProjectSteps();
    public LoginPage loginPage = new LoginPage();
    public ProjectPage projectPage = new ProjectPage();
    public SuitePage suitePage = new SuitePage();
    public CasePage casePage = new CasePage();
    public QaseioApiTest qaseioApiTest = new QaseioApiTest();
    public Project proj = ProjectBuilder.get();
    public Project proj2 = ProjectBuilder.getTwo();
    public Project proj1 = Project.builder().projectName("Demo").projectCode("Demo").build();
    public Project projTest = new Project(fake.code().asin(), fake.name().firstName());
    public Suite suite = SuiteBuilder.get();
    public Suite suiteSuite = new Suite(fake.name().firstName());
    public Case caseName = new Case(fake.name().firstName(), "action", "result");
    public Case caseCase = CaseBuilder.get();

    public void authorizeInApp(String email, String pwd){
        open("https://app.qase.io/login");
        $("[name=email]").setValue(email);
        $("[name=password]").setValue(pwd).submit();
    }

    @BeforeAll
    static void screenResolution() {
        Configuration.baseUrl = "https://app.qase.io";
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    void setUp() {
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 200;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
        Configuration.timeout = 3000;
    }
}
