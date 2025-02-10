package tests.ui;

import generators.ProjectGenerator;
import generators.SuiteGenerator;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseTest;
import tests.api.pojos.request.project.CreateProjectRequest;
import tests.api.pojos.request.suite.CreateSuiteRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuiteTest extends BaseTest {

    @Test
    @Feature("Suite")
    @Story("User can create a suite")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "test", url = "https://app.qase.io")
    @DisplayName("Creation of suite with valid data")
    public void createSuiteTest() {
        projectPage.openLoginPage();
        loginSteps.authInApp("kubyox@mailto.plus", "qaseio122024");
        projectPage.projectPageIsOpened();
        projectPage.createNewProject();
        projectPage.inputProjectName("Demo");
        projectPage.createProject();
        suitePage.createNewSuite();
        suitePage.inputSuiteName("suiteTest");
        suitePage.createSuite();
        suitePage.assertThatSuiteCreated("suiteTest");
    }

    @Test
    @Feature("Suite")
    @Story("User can create a suite")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "test", url = "https://app.qase.io")
    @DisplayName("Creation of suite with valid data(using Faker to get random project with random data)")
    public void createSuiteTestTest() {
        projectPage.openLoginPage();
        loginSteps.authInApp("kubyox@mailto.plus", "qaseio122024");
        projectPage.projectPageIsOpened();
        projectPage.createNewProject();
        CreateProjectRequest testProject = ProjectGenerator.createProjectApi();
        projectPage.inputProjectName(testProject.getTitle());
        projectPage.createProject();
        suitePage.createNewSuite();
        CreateSuiteRequest testSuite = SuiteGenerator.createSuiteApi();
        String expectedSuiteName = testSuite.getTitle();
        suitePage.inputSuiteName(expectedSuiteName);
        suitePage.createSuite();
        assertEquals(expectedSuiteName, suitePage.receiveSuiteName(), "error!");
    }

    @Test
    @Feature("Suite")
    @Story("User can create a suite")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.MINOR)
    @Link(value = "test", url = "https://app.qase.io")
    @DisplayName("Creation of suite with valid data")
    public void cannotCreateSuiteTest() {
        projectPage.openLoginPage();
        loginSteps.authInApp("kubyox@mailto.plus", "qaseio122024");
        projectPage.projectPageIsOpened();
        projectPage.createNewProject();
        projectPage.inputProjectName("Demo");
        projectPage.createProject();
        suitePage.createNewSuite();
        suitePage.inputSuiteName("");
        suitePage.createSuite();
        suitePage.openSuitePage();
        suitePage.assertThatSuiteNotCreated();
    }
}
