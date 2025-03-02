package tests.ui;

import generators.CaseGenerator;
import generators.ProjectGenerator;
import generators.SuiteGenerator;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.BaseTest;
import tests.api.pojos.request.cases.CreateCaseRequest;
import tests.api.pojos.request.project.CreateProjectRequest;
import tests.api.pojos.request.suite.CreateSuiteRequest;

@Tag("UI")
public class CaseTest extends BaseTest {

    @Test
    @Feature("Case")
    @Story("User can create a case")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "test", url = "https://app.qase.io")
    @DisplayName("Creation of an empty case with valid data")
    public void createCaseTest() {
        projectPage.openLoginPage();
        loginSteps.authInApp(email, password);
        projectPage.projectPageIsOpened();
        projectPage.createNewProjectButtonToClick();
        projectPage.inputProjectName("Demo");
        projectPage.createProjectButtonToClick();
        suitePage.createNewSuite();
        suitePage.inputSuiteName("suiteTest");
        suitePage.createSuite();
        casePage.createNewCase();
        casePage.inputCaseName("caseTest");
        casePage.createCase();
        casePage.assertThatCaseCreated("caseTest");
        ProjectGenerator.deleteProjectApi("DEMO");
    }

    @Test
    @Feature("Case")
    @Story("User can create a case")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "test", url = "https://app.qase.io")
    @DisplayName("Creation of a case with valid data")
    public void createCaseWithStepsTest() {
        projectPage.openLoginPage();
        loginSteps.authInApp(email, password);
        projectPage.projectPageIsOpened();
        projectPage.createNewProjectButtonToClick();
        projectPage.inputProjectName("Demo");
        projectPage.createProjectButtonToClick();
        suitePage.createNewSuite();
        suitePage.inputSuiteName("suiteTest");
        suitePage.createSuite();
        casePage.createNewCase();
        casePage.inputCaseName("caseTest");
        casePage.addStep();
        casePage.fillStep();
        casePage.createCase();
        casePage.assertThatCaseCreated("caseTest");
        ProjectGenerator.deleteProjectApi("DEMO");
    }

    @Test
    @Feature("Case")
    @Story("User can create a case")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "test", url = "https://app.qase.io")
    @DisplayName("Creation of a case with valid data plus filling: description, steps and other fields")
    public void createCaseWithFieldsTest() {
        projectPage.openLoginPage();
        loginSteps.authInApp(email, password);
        projectPage.projectPageIsOpened();
        projectPage.createNewProjectButtonToClick();
        projectPage.inputProjectName("Demo");
        projectPage.createProjectButtonToClick();
        suitePage.createNewSuite();
        suitePage.inputSuiteName("suiteTest");
        suitePage.createSuite();
        casePage.createNewCase();
        casePage.inputCaseName("caseTest");
        casePage.fillStatus();
        casePage.fillDescription();
        casePage.fillSuite("suiteTest");
        casePage.fillSeverity("Major");
        casePage.fillPriority("High");
        casePage.fillType("Functional");
        casePage.fillLayer("E2E");
        casePage.fillIsFlaky("Yes");
        casePage.fillBehavior("Positive");
        casePage.fillAutomationStatus("Automated");
        casePage.addStep();
        casePage.fillStep();
        casePage.createCase();
        casePage.assertThatCaseCreated("caseTest");
        ProjectGenerator.deleteProjectApi("DEMO");
    }

    @Test
    @Feature("Case")
    @Story("User can create a case")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "test", url = "https://app.qase.io")
    @DisplayName("Creation of case with valid random data")
    public void createCaseWithRandomDataTest() {
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
        casePage.createNewCase();
        CreateCaseRequest caseTest = CaseGenerator.createCaseApi();
        String expectedCaseName = caseTest.getTitle();
        casePage.inputCaseName(expectedCaseName);
        casePage.createCase();
        Assertions.assertEquals(expectedCaseName, casePage.receiveCaseName(), "error!");
        ProjectGenerator.deleteProjectApi(testProject.getTitle().toUpperCase());
    }

    @Test
    @Feature("Case")
    @Story("User can not create a case")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.MINOR)
    @Link(value = "test", url = "https://app.qase.io")
    @DisplayName("User can not create of a case with not valid data")
    public void canNotCreateCaseTest() {
        projectPage.openLoginPage();
        loginSteps.authInApp(email, password);
        projectPage.projectPageIsOpened();
        projectPage.createNewProjectButtonToClick();
        projectPage.inputProjectName("Demo");
        projectPage.createProjectButtonToClick();
        suitePage.createNewSuite();
        suitePage.inputSuiteName("suiteTest");
        suitePage.createSuite();
        casePage.createNewCase();
        casePage.inputCaseName("");
        projectPage.openProjectsPage();
        casePage.assertThatCaseCanNotCreated();
        ProjectGenerator.deleteProjectApi("DEMO");
    }
}
