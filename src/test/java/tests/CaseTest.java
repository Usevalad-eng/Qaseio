package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaseTest extends BaseTest{
    @Test
    //@Disabled
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
        projectPage.CreateProject();
        //projectPage.openProjectsPage();
        //projectPage.assertThatProjectCreated("Demo");
        suitePage.createNewSuite();
        suitePage.getSuiteName("suiteTest");
        suitePage.createSuite();
        //suitePage.assertThatSuiteCreated("suiteTest");
        casePage.createNewCase();
        casePage.getCaseName("caseTest");
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
    public void createCaseTestT() {
        projectPage.openLoginPage();
        loginSteps.authInApp("kubyox@mailto.plus", "qaseio122024");
        projectPage.projectPageIsOpened();
        projectPage.createNewProject();
        projectPage.getProjectName(projectFakerTest.getProjName());
        projectPage.CreateProject();
        //projectPage.openProjectsPage();
        //projectPage.assertThatProjectCreated("Demo");
        suitePage.createNewSuite();
        String expectedSuiteName = suiteFakerTest.getSuiteName();
        suitePage.getSuiteName(expectedSuiteName);
        suitePage.createSuite();
        //suitePage.assertThatSuiteCreated("suiteTest");
        //assertEquals(expectedSuiteName, suitePage.receiveSuiteName(), "error!");
        casePage.createNewCase();
        String expectedCaseName = caseFakerTest.getCaseName();
        casePage.getCaseName(expectedCaseName);
        casePage.createCase();
        //casePage.assertThatCaseCreated("caseTest");
        Assertions.assertEquals(expectedCaseName, casePage.receiveCaseName(), "error!");
    }
}
