package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuiteTest extends BaseTest{

    @Test
    @Disabled
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
        projectPage.getProjectName("Demo");
        projectPage.createProject();
        suitePage.createNewSuite();
        suitePage.getSuiteName("suiteTest");
        suitePage.createSuite();
        suitePage.assertThatSuiteCreated("suiteTest");
    }

    @Test
    @Disabled
    @Feature("Suite")
    @Story("User can create a suite")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "test", url = "https://app.qase.io")
    @DisplayName("Creation of suite with valid data(using Faker to get random project with random data)")
    public void createSuiteTestT() {
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
        assertEquals(expectedSuiteName, suitePage.receiveSuiteName(), "error!");
    }

    @Test
    @Disabled
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
        projectPage.getProjectName("Demo");
        projectPage.createProject();
        suitePage.createNewSuite();
        suitePage.getSuiteName("");
        suitePage.createSuite();
        suitePage.openSuitePage();
        suitePage.assertThatSuiteNotCreated();
    }
}
