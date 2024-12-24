package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ProjectPage;
import tests.base.BaseTest;

public class ProjectTest extends BaseTest {
     ProjectPage projectPage = new ProjectPage();

    @Test
    @Feature("Project")
    @Story("User can create a project")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "test", url = "https://www.test.com")
    @DisplayName("Creation of Project test")
    public void createProjectTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        projectPage.openLoginPage();
        loginSteps.authInApp("kubyox@mailto.plus", "qaseio122024");
        projectPage.projectPageIsOpened();
        projectPage.createNewProject();
        projectPage.enterProjectName("Demo");
        projectPage.clickCreateProject();
        projectPage.openProjectsPage();
        projectPage.assertThatProjectCreated("Demo");
    }

    @Test
    @DisplayName("Creation of Project test")
    public void createProjectWithOneCharacterInTheNameTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        projectPage.openLoginPage();
        loginSteps.authInApp("kubyox@mailto.plus", "qaseio122024");
        projectPage.projectPageIsOpened();
        projectPage.createNewProject();
        projectPage.enterProjectName("D");
        projectPage.clickCreateProject();
        projectPage.canNotCreateProjectErrorShouldBeVisible();
    }

    @Test
    @DisplayName("Creation of Project  and exit from the App test")
    @Severity(SeverityLevel.MINOR)
    public void createProjectAndExitTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        projectPage.openLoginPage();
        loginSteps.authInApp("kubyox@mailto.plus", "qaseio122024");
        projectPage.createNewProject();
        projectPage.enterProjectName("DD");
        projectPage.clickCreateProject();
        projectPage.openProjectsPage();
        projectPage.assertThatProjectCreated("DD");
        projectPage.findMenu();
        projectPage.findExit();
        projectPage.assertThatExit();
    }
}
