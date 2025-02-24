package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.Project;
import config.User;
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

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    protected String email = User.config.email(); //protected String email = "kubyox@mailto.plus";
    protected String password = User.config.password(); //protected String password = "qaseio122024";
    public LoginSteps loginSteps = new LoginSteps();
    public ProjectSteps projectSteps = new ProjectSteps();
    public LoginPage loginPage = new LoginPage();
    public ProjectPage projectPage = new ProjectPage();
    public SuitePage suitePage = new SuitePage();
    public CasePage casePage = new CasePage();

    public void authorizeInApp(String email, String pwd) {
        open("https://app.qase.io/login");
        $("[name=email]").setValue(email);
        $("[name=password]").setValue(pwd).submit();
    }

    @BeforeAll
    static void screenResolution() {
        Configuration.baseUrl = Project.config.baseUrl();       //Configuration.baseUrl = "https://app.qase.io";
        Configuration.browserSize = "1920x1080";
        //Configuration.headless = true;
    }

    @BeforeEach
    void setUp() {
        Configuration.timeout = Project.config.timeout();   //Configuration.timeout = 7000;
        Configuration.pollingInterval = 400;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }
}
