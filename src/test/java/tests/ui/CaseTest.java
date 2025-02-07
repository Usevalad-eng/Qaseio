package tests.ui;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

public class CaseTest extends BaseTest {

    @Test
    @Feature("Case")
    @Story("User can create a case")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "test", url = "https://app.qase.io")
    @DisplayName("Creation of a case with valid data")
    public void createCaseTest() {
        projectPage.openLoginPage();
        loginSteps.authInApp("kubyox@mailto.plus", "qaseio122024");
        projectPage.projectPageIsOpened();
        projectPage.createNewProject();
        projectPage.inputProjectName("Demo");
        projectPage.createProject();
        suitePage.createNewSuite();
        suitePage.inputSuiteName("suiteTest");
        suitePage.createSuite();
        casePage.createNewCase();
        casePage.inputCaseName("caseTest");
        casePage.createCase();
        casePage.assertThatCaseCreated("caseTest");
    }

    @Test
    //@Disabled
    @Feature("Case")
    @Story("User can create a case")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "test", url = "https://app.qase.io")
    @DisplayName("Creation of a case with valid data")
    public void createCaseTestTest() {
        projectPage.openLoginPage();
        loginSteps.authInApp("kubyox@mailto.plus", "qaseio122024");
        projectPage.projectPageIsOpened();
        projectPage.createNewProject();
        projectPage.inputProjectName("Demo");
        projectPage.createProject();
        suitePage.createNewSuite();
        suitePage.inputSuiteName("suiteTest");
        suitePage.createSuite();
        casePage.createNewCase();
        casePage.inputCaseName("caseTest");
        casePage.addStep();
        casePage.fillSteps();
        casePage.createCase();
        casePage.assertThatCaseCreated("caseTest");
    }

    @Test
    @Feature("Case")
    @Story("User can create a case")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "test", url = "https://app.qase.io")
    @DisplayName("Creation of a case with valid data plus description, steps and other fields")
    public void createCaseWithStepsTest() {
        projectPage.openLoginPage();
        loginSteps.authInApp("kubyox@mailto.plus", "qaseio122024");
        projectPage.projectPageIsOpened();
        projectPage.createNewProject();
        projectPage.inputProjectName("Demo");
        projectPage.createProject();
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
    }

    @Test
    @Feature("Case")
    @Story("User can create a case")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "test", url = "https://app.qase.io")
    @DisplayName("Creation of case with valid data(using Faker to get random project with random data)")
    public void createCaseTestTTest() {
        projectPage.openLoginPage();
        loginSteps.authInApp("kubyox@mailto.plus", "qaseio122024");
        projectPage.projectPageIsOpened();
        projectPage.createNewProject();
        projectPage.inputProjectName(testProject.getTitle());
        projectPage.createProject();
        suitePage.createNewSuite();
        String expectedSuiteName = testSuite.getTitle();
        suitePage.inputSuiteName(expectedSuiteName);
        suitePage.createSuite();
        casePage.createNewCase();
        String expectedCaseName = caseTest.getTitle();
        casePage.inputCaseName(expectedCaseName);
        casePage.createCase();
        Assertions.assertEquals(expectedCaseName, casePage.receiveCaseName(), "error!");
    }

    @Test
    @Feature("Case")
    @Story("User can not create a case")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.MINOR)
    @Link(value = "test", url = "https://app.qase.io")
    @DisplayName("Creation of a case with not valid data")
    public void notCreateCaseTest() {
        projectPage.openLoginPage();
        loginSteps.authInApp("kubyox@mailto.plus", "qaseio122024");
        projectPage.projectPageIsOpened();
        projectPage.createNewProject();
        projectPage.inputProjectName("Demo");
        projectPage.createProject();
        suitePage.createNewSuite();
        suitePage.inputSuiteName("suiteTest");
        suitePage.createSuite();
        casePage.createNewCase();
        casePage.inputCaseName("");
        projectPage.openProjectsPage();
        casePage.assertThatCaseCanNotCreated();
    }
}
