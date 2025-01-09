package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuiteTest extends BaseTest{

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
        projectPage.getProjectName("Demo");
        projectPage.CreateProject();
        //projectPage.openProjectsPage();
        //projectPage.assertThatProjectCreated("Demo");
        suitePage.createNewSuite();
        suitePage.getSuiteName("suiteTest");
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
    public void createSuiteTestT() {
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
        projectPage.getProjectName("Demo");
        projectPage.CreateProject();
        //projectPage.openProjectsPage();
        //projectPage.assertThatProjectCreated("Demo");
        suitePage.createNewSuite();
        suitePage.getSuiteName("");
        suitePage.createSuite();
        //suitePage.assertThatSuiteCreated("suiteTest");
        //reload
        //assert that not created
        suitePage.openSuitePage();
        suitePage.assertThatSuiteNotCreated();
    }
}
