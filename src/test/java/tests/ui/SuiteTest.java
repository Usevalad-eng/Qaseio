package tests.ui;

import generators.ProjectGenerator;
import generators.SuiteGenerator;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.BaseTest;
import tests.api.pojos.request.project.CreateProjectRequest;
import tests.api.pojos.request.suite.CreateSuiteRequest;
import tests.api.steps.ProjectSteps;

import static generators.ProjectGenerator.createProject;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("UI")
public class SuiteTest extends BaseTest {

    @Test
    @Feature("Suite")
    @Story("User can create a suite")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "test", url = "https://app.qase.io")
    @DisplayName("Creation of suite with valid letters and digits as data")
    public void createSuiteRandomTest() {
        loginPage.openLoginPage();
        loginSteps.authInApp(email, password);
        projectPage.openProjectsPage();
        projectPage.projectPageIsOpened();
        projectPage.clickCreateNewProjectButton();
        CreateProjectRequest project = createProject();
        projectPage.createAProject(project);
        projectPage.clickOnProject();
        suitePage.createNewSuite();
        suitePage.inputSuiteName("suite123Test");
        suitePage.createSuite();
        suitePage.assertThatSuiteCreated("suite123Test");
        ProjectGenerator.deleteProjectApi(project.getCode());
    }

    @Test
    @Feature("Suite")
    @Story("User can create a suite")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "test", url = "https://app.qase.io")
    @DisplayName("Creation of suite with valid letters as data")
    public void createSuiteTest() {
        projectPage.openLoginPage();
        loginSteps.authInApp(email, password);
        projectPage.projectPageIsOpened();
        projectPage.createNewProjectButtonToClick();
        projectPage.inputProjectName("Demo");
        projectPage.createProjectButtonToClick();
        suitePage.createNewSuite();
        suitePage.inputSuiteName("suiteTest");
        suitePage.createSuite();
        suitePage.assertThatSuiteCreated("suiteTest");
        ProjectGenerator.deleteProjectApi("DEMO");
    }

    @Test
    @Feature("Suite")
    @Story("User can create a suite")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "test", url = "https://app.qase.io")
    @DisplayName("Creation of suite with valid digits as data")
    public void createSuiteWithDigitsTest() {
        CreateProjectRequest project = createProject();
        ProjectSteps.createProject(project);
        projectPage.openLoginPage();
        loginSteps.authInApp(email, password);
        projectPage.projectPageIsOpened();
        projectPage.clickOnProject();
        suitePage.createNewSuite();
        suitePage.inputSuiteName("12345");
        suitePage.createSuite();
        suitePage.assertThatSuiteCreated("12345");
        ProjectGenerator.deleteProjectApi(project.getCode());
    }

    @Test
    @Feature("Suite")
    @Story("User can create a suite")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "test", url = "https://app.qase.io")
    @DisplayName("Creation of suite with valid random data")
    public void createSuiteWithRandomDataTest() {
        projectPage.openLoginPage();
        loginSteps.authInApp(email, password);
        projectPage.projectPageIsOpened();
        projectPage.createNewProjectButtonToClick();
        CreateProjectRequest testProject = ProjectGenerator.createProject();
        projectPage.inputProjectName(testProject.getTitle());
        projectPage.createProjectButtonToClick();
        suitePage.createNewSuite();
        CreateSuiteRequest testSuite = SuiteGenerator.createSuiteApi();
        String expectedSuiteName = testSuite.getTitle();
        suitePage.inputSuiteName(expectedSuiteName);
        suitePage.createSuite();
        assertEquals(expectedSuiteName, suitePage.receiveSuiteName(), "error!");
        ProjectGenerator.deleteProjectApi(testProject.getTitle().toUpperCase());
    }

    @Test
    @Feature("Suite")
    @Story("User can create a suite")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.MINOR)
    @Link(value = "test", url = "https://app.qase.io")
    @DisplayName("User can not create a suite with not valid data")
    public void cannotCreateSuiteTest() {
        projectPage.openLoginPage();
        loginSteps.authInApp(email, password);
        projectPage.projectPageIsOpened();
        projectPage.createNewProjectButtonToClick();
        projectPage.inputProjectName("Demo");
        projectPage.createProjectButtonToClick();
        suitePage.createNewSuite();
        suitePage.inputSuiteName("");
        suitePage.createSuite();
        suitePage.openSuitePage();
        suitePage.assertThatSuiteNotCreated();
        ProjectGenerator.deleteProjectApi("DEMO");
    }
}
