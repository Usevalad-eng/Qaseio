package tests;

import io.qameta.allure.*;
import models.Project;
import models.ProjectBuilder;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProjectTest extends BaseTest {
    //Project proj = ProjectBuilder.get();
    //Project proj1 = Project.builder().projectName("Demo").projectCode("Demo").build();

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
        projectPage.getProjectName("Demo");
        projectPage.clickCreateProject();
        projectPage.openProjectsPage();
        projectPage.assertThatProjectCreated("Demo");
    }

    @Test
    @Disabled
    @Feature("Project")
    @Story("User can create a project")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.MINOR)
    @Link(value = "test", url = "https://www.test.com")
    @DisplayName("Creation of Project with valid data and using Lombok")
    public void createProjectTestUsingBuilder() {
        projectPage.openLoginPage();
        loginSteps.authInApp("kubyox@mailto.plus", "qaseio122024");
        projectPage.projectPageIsOpened();
        //projectSteps.createProjectWithBuilder(proj);  //todo add lombok
        projectPage.openProjectsPage();
        projectPage.assertThatProjectCreated("Demo");
    }

    @Test
    @Disabled
    @Feature("Project")
    @Story("User can create a project")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.MINOR)
    @Link(value = "test", url = "https://www.test.com")
    @DisplayName("Creation of Project with valid data using Faker")
    public void createProjectTestWithFaker() {
        projectPage.openLoginPage();
        loginSteps.authInApp("kubyox@mailto.plus", "qaseio122024");
        projectPage.projectPageIsOpened();
        projectPage.createNewProject();
        projectPage.getProjectName(fake.name().firstName());
        projectPage.clickCreateProject();
        projectPage.openProjectsPage();
        projectPage.assertThatProjCreated();
    }

    @Test
    @Feature("Project")
    @Story("User can't create a project")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.MINOR)
    @Link(value = "test", url = "https://www.test.com")
    @DisplayName("Creation of a Project with only one character is unavailable")
    public void createProjectWithOneCharacterInTheNameTest() {
        projectPage.openLoginPage();
        loginSteps.authInApp("kubyox@mailto.plus", "qaseio122024");
        projectPage.projectPageIsOpened();
        projectPage.createNewProject();
        projectPage.getProjectName("D");
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
        projectPage.getProjectName("Dee");
        projectPage.clickCreateProject();
        projectPage.openProjectsPage();
        projectPage.assertThatProjectCreated("Dee");
        projectPage.findMenu();
        projectPage.findExit();
        projectPage.assertThatExit();
    }
}
