package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ProjectPage;

public class ProjectTest extends BaseTest {

    @Test
    @Feature("Project")
    @Story("User can create a project")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "test", url = "https://www.test.com")
    @DisplayName("Creation of Project with valid data")
    public void createProjectTest() {
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
    @Feature("Project")
    @Story("User can create a project")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "test", url = "https://www.test.com")
    @DisplayName("Creation of a Project with only one character")
    public void createProjectWithOneCharacterInTheNameTest() {
        projectPage.openLoginPage();
        loginSteps.authInApp("kubyox@mailto.plus", "qaseio122024");
        projectPage.projectPageIsOpened();
        projectPage.createNewProject();
        projectPage.enterProjectName("D");
        projectPage.clickCreateProject();
        projectPage.canNotCreateProjectErrorShouldBeVisible();
    }

    @Test
    @Disabled
    @DisplayName("Creation of Project  and exit from the App")
    @Feature("Project")
    @Story("User can create a project")
    @Owner("Vsevolod")
    @Link(value = "test", url = "https://www.test.com")
    @Severity(SeverityLevel.MINOR)
    public void createProjectAndExitTest() {
        projectPage.openLoginPage();
        loginSteps.authInApp("kubyox@mailto.plus", "qaseio122024");
        projectPage.createNewProject();
        projectPage.enterProjectName("Dee");
        projectPage.clickCreateProject();
        projectPage.openProjectsPage();
        projectPage.assertThatProjectCreated("Dee");
        projectPage.findMenu();
        projectPage.findExit();
        projectPage.assertThatExit();
    }
}
