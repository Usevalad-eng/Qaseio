package tests;

import io.qameta.allure.*;
import models.Project;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectTest extends BaseTest {

    @Test
    @Feature("Project")
    @Story("1 User can create a project")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "test", url = "https://app.qase.io")
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
    @Story("1.1 User can create a project")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "test", url = "https://app.qase.io")
    @DisplayName("Creation of Project with valid data")
    public void createProjectTestAndDelProj() {
        projectPage.openLoginPage();
        loginSteps.authInApp("kubyox@mailto.plus", "qaseio122024");
        projectPage.projectPageIsOpened();
        projectPage.createNewProject();
        projectPage.getProjectName("Demo");
        projectPage.clickCreateProject();
        projectPage.openProjectsPage();
        projectPage.assertThatProjectCreated("Demo");
        projectPage.delProj();
    }

    @Test
    @Disabled
    @Feature("Project")
    @Story("2 User can create a project")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "test", url = "https://app.qase.io")
    @DisplayName("Creation of Project with valid data using Lombok/Constructor/Faker")
    public void createProjectTestUsingBuilder() {
        projectPage.openLoginPage();
        loginSteps.authInApp("kubyox@mailto.plus", "qaseio122024");
        projectPage.projectPageIsOpened();
        //projectSteps.createProject(proj);  //todo -add lombok
        projectSteps.createProject(projectFakerTest);
        projectPage.openProjectsPage();
        projectPage.assertThatProjCreated();
    }

    @Test
    @Disabled
    @Feature("Project")
    @Story("3 User can create a project")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "test", url = "https://app.qase.io")
    @DisplayName("Creation of Project with valid data using Constructor/Faker")
    public void createProjectTestWithFaker() {
        projectPage.openLoginPage();
        loginSteps.authInApp("kubyox@mailto.plus", "qaseio122024");
        projectPage.projectPageIsOpened();
        projectPage.createNewProject();
        String fakeName = fake.name().firstName();
        projectPage.getProjectName(fakeName);
        projectPage.clickCreateProject();
        projectPage.openProjectsPage();
        String actualProjName = projectPage.receiveProjectName();
        assertAll(
                () -> assertEquals(fakeName, actualProjName, "Error, something went wrong!"),
                () -> projectPage.assertThatProjCreated()
        );
        //assertEquals(fakeName, actualProjName, "Error, something went wrong!");
    }

    @Test
    @Feature("Project")
    @Story("4 User can't create a project")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "test", url = "https://app.qase.io")
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
    @Story("5 User can create a project")
    @Owner("Vsevolod")
    @Link(value = "test", url = "https://app.qase.io")
    @Severity(SeverityLevel.NORMAL)
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
