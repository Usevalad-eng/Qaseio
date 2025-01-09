package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CaseTest extends BaseTest{
    @Test
    //@Disabled
    @Feature("Case")
    @Story("User can create a case")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "test", url = "https://app.qase.io")
    @DisplayName("Creation of a case with valid data")
    public void createProjectTest() {
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
}
