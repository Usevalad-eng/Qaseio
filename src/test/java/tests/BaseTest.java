package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import generators.CaseGenerator;
import generators.ProjectGenerator;
import generators.SuiteGenerator;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.CasePage;
import pages.LoginPage;
import pages.ProjectPage;
import pages.SuitePage;
import steps.LoginSteps;
import steps.ProjectSteps;
import tests.api.pojos.request.cases.CreateCaseRequest;
import tests.api.pojos.request.project.CreateProjectRequest;
import tests.api.pojos.request.suite.CreateSuiteRequest;

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

    public CreateProjectRequest testProject = ProjectGenerator.createProjectApi();
    public CreateProjectRequest testProject2 = CreateProjectRequest.builder().title(fake.name().firstName())
            .code(fake.name().firstName().toUpperCase())
            .description(fake.chuckNorris().fact())
            .access("all")
            .group(fake.name().firstName()).build();
    public CreateProjectRequest testProject3 = new CreateProjectRequest("Demo", "DEMO",
            "Description", "all", "group");
    public CreateSuiteRequest testSuite = SuiteGenerator.createSuiteApi();
    public CreateCaseRequest caseTest = CaseGenerator.createCaseApi();

    public void authorizeInApp(String email, String pwd) {
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
