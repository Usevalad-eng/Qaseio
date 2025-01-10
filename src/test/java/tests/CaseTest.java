package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaseTest extends BaseTest{
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
        projectPage.getProjectName("Demo");
        projectPage.createProject();
        suitePage.createNewSuite();
        suitePage.getSuiteName("suiteTest");
        suitePage.createSuite();
        casePage.createNewCase();
        casePage.getCaseName("caseTest");
        casePage.createCase();
        casePage.assertThatCaseCreated("caseTest");
    }

    @Test
    @Disabled
    @Feature("Case")
    @Story("User can create a case")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "test", url = "https://app.qase.io")
    @DisplayName("Creation of case with valid data(using Faker to get random project with random data)")
    public void createCaseTestT() {
        projectPage.openLoginPage();
        loginSteps.authInApp("kubyox@mailto.plus", "qaseio122024");
        projectPage.projectPageIsOpened();
        projectPage.createNewProject();
        projectPage.getProjectName(projectFakerTest.getProjName());
        projectPage.createProject();
        suitePage.createNewSuite();
        String expectedSuiteName = suiteFakerTest.getSuiteName();
        suitePage.getSuiteName(expectedSuiteName);
        suitePage.createSuite();
        casePage.createNewCase();
        String expectedCaseName = caseFakerTest.getCaseName();
        casePage.getCaseName(expectedCaseName);
        casePage.createCase();
        Assertions.assertEquals(expectedCaseName, casePage.receiveCaseName(), "error!");
    }

    @Test
    @Disabled
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
        projectPage.getProjectName("Demo");
        projectPage.createProject();
        suitePage.createNewSuite();
        suitePage.getSuiteName("suiteTest");
        suitePage.createSuite();
        casePage.createNewCase();
        casePage.getCaseName("");
        projectPage.openProjectsPage();
        casePage.assertThatCaseCanNotCreated();
    }
}
