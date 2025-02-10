package tests.ui;

import generators.ProjectGenerator;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseTest;
import tests.api.pojos.request.project.CreateProjectRequest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectTest extends BaseTest {

    @Test
    @Feature("Project")
    @Story("User can create a project")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "test", url = "https://app.qase.io")
    @DisplayName("Creation of Project with valid data")
    public void createProjTest() {
        authorizeInApp(email, pwd);
        projectPage.openProjectsPage();
        projectPage.clickCreateNewProjectButton();
        CreateProjectRequest projectTwo = ProjectGenerator.createProjectApi();
        projectPage.create(projectTwo);
        projectPage.assertThatProjCreated();
    }

    @Test
    @Feature("Project")
    @Story("User can create a project")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "test", url = "https://app.qase.io")
    @DisplayName("Creation of Project with valid data")
    public void createProjJTest() {
        authorizeInApp("kubyox@mailto.plus", "qaseio122024");
        projectPage.openProjectsPage();
        projectPage.clickCreateNewProjectButton();
        projectPage.createT(ProjectGenerator.createProjectApi());
        projectPage.assertThatProjCreated();
    }

    @Test
    @Feature("Project")
    @Story("User can create a project")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "test", url = "https://app.qase.io")
    @DisplayName("Creation of Project with valid data")
    public void createProjectTest() {
        projectPage.openLoginPage();
        loginSteps.authInApp("kubyox@mailto.plus", "qaseio122024");
        projectPage.projectPageIsOpened();
        projectPage.createNewProject();
        projectPage.inputProjectName("Demo");
        projectPage.createProject();
        projectPage.openProjectsPage();
        projectPage.assertThatProjectCreated("Demo");
        ProjectGenerator.deleteProjectApi("DEMO");
    }

    @Test
    @Feature("Project")
    @Story("User can create/delete a project")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "test", url = "https://app.qase.io")
    @DisplayName("Creation of Project with valid data")
    public void createProjectTestAndDelProj() {
        projectPage.openLoginPage();
        loginSteps.authInApp("kubyox@mailto.plus", "qaseio122024");
        projectPage.projectPageIsOpened();
        projectPage.createNewProject();
        projectPage.inputProjectName("Demo");
        projectPage.createProject();
        projectPage.openProjectsPage();
        projectPage.assertThatProjectCreated("Demo");
        ProjectGenerator.deleteProjectApi("DEMO");
    }

    @Test
    @Feature("Project")
    @Story("User can create a project")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "test", url = "https://app.qase.io")
    @DisplayName("Creation of Project with valid data using Lombok/Faker")
    public void createProjectTestUsingBuilder() {
        projectPage.openLoginPage();
        loginSteps.authInApp("kubyox@mailto.plus", "qaseio122024");
        projectPage.projectPageIsOpened();
        projectSteps.createProject(ProjectGenerator.createProjectApi());
        projectPage.openProjectsPage();
        projectPage.assertThatProjCreated();
    }

    /*@Test
    @Feature("Project")
    @Story("User can create a project")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "test", url = "https://app.qase.io")
    @DisplayName("Creation of Project with valid data using Lombok/Faker")
    public void createProjectTestUsingTestBuilder() {
        projectPage.openLoginPage();
        loginSteps.authInApp("kubyox@mailto.plus", "qaseio122024");
        projectPage.projectPageIsOpened();
        projectSteps.createProject(testProject2);
        projectPage.openProjectsPage();
        projectPage.assertThatProjCreated();
    }*/

//    @Test
//    @Feature("Project")
//    @Story("User can create a project")
//    @Owner("Vsevolod")
//    @Severity(SeverityLevel.NORMAL)
//    @Link(value = "test", url = "https://app.qase.io")
//    @DisplayName("Creation of Project with valid data using Constructor/Faker")
//    public void createProjectTestUsingBuilderTwo() {
//        projectPage.openLoginPage();
//        loginSteps.authInApp("kubyox@mailto.plus", "qaseio122024");
//        projectPage.projectPageIsOpened();
//        projectSteps.createProject(testProject3);
//        projectPage.openProjectsPage();
//        projectPage.assertThatProjCreated();
//    }

    @Test
    @Feature("Project")
    @Story("User can create a project")
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
        projectPage.inputProjectName(fakeName);
        projectPage.createProject();
        projectPage.openProjectsPage();
        String actualProjName = projectPage.receiveProjectName();
        assertAll(
                () -> assertEquals(fakeName, actualProjName, "Error, something went wrong!"),
                () -> projectPage.assertThatProjCreated()
        );
    }

    @Test
    @Feature("Project")
    @Story("User can't create a project")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "test", url = "https://app.qase.io")
    @DisplayName("Creation of a Project with only one character is unavailable")
    public void createProjectWithOneCharacterInTheNameTest() {
        projectPage.openLoginPage();
        loginSteps.authInApp("kubyox@mailto.plus", "qaseio122024");
        projectPage.projectPageIsOpened();
        projectPage.createNewProject();
        projectPage.inputProjectName("D");
        projectPage.createProject();
        projectPage.canNotCreateProjectErrorShouldBeVisible();
    }

    @Test
    @DisplayName("Creation of Project  and exit from the App")
    @Feature("Project")
    @Story("User can create a project")
    @Owner("Vsevolod")
    @Link(value = "test", url = "https://app.qase.io")
    @Severity(SeverityLevel.NORMAL)
    public void createProjectAndExitTest() {
        projectPage.openLoginPage();
        loginSteps.authInApp("kubyox@mailto.plus", "qaseio122024");
        projectPage.createNewProject();
        projectPage.inputProjectName("Dee");
        projectPage.createProject();
        projectPage.openProjectsPage();
        projectPage.assertThatProjectCreated("Dee");
        projectPage.findMenu();
        projectPage.findExit();
        projectPage.assertThatExit();
    }

    @Test
    @DisplayName("Deletion of the Project")
    @Feature("Project")
    @Story("User can delete a project")
    @Owner("Vsevolod")
    @Link(value = "test", url = "https://app.qase.io")
    @Severity(SeverityLevel.NORMAL)
    public void createProjectAndDel() {
        projectPage.openLoginPage();
        loginSteps.authInApp("kubyox@mailto.plus", "qaseio122024");
        projectPage.createNewProject();
        projectPage.inputProjectName("Dee");
        projectPage.createProject();
        projectPage.openProjectsPage();
        projectPage.findDots();
        projectPage.deleteButton();
        projectPage.deleteProject();
        projectPage.assertThatProjDeleted();
    }

    @Test
    @DisplayName("Deletion of the Project")
    @Feature("Project")
    @Story("User can delete a project")
    @Owner("Vsevolod")
    @Link(value = "test", url = "https://app.qase.io")
    @Severity(SeverityLevel.NORMAL)
    public void createProjAndDeleteTest() {
        ProjectGenerator.createProjApi();
        projectPage.openLoginPage();
        loginSteps.authInApp("kubyox@mailto.plus", "qaseio122024");
        projectPage.openProjectsPage();
        projectPage.findDots();
        projectPage.deleteButton();
        projectPage.deleteProject();
        projectPage.assertThatProjDeleted();
    }

    @Test
    @DisplayName("Deletion of the Project")
    @Feature("Project")
    @Story("User can delete a project")
    @Owner("Vsevolod")
    @Link(value = "test", url = "https://app.qase.io")
    @Severity(SeverityLevel.NORMAL)
    public void createProjADeleteTest() {
        CreateProjectRequest projectR = ProjectGenerator.createProjectApi();
        ProjectGenerator.getProjectCreated(projectR);
        ProjectGenerator.deleteProjectApi(projectR.getCode());
        authorizeInApp("kubyox@mailto.plus", "qaseio122024");
        projectPage.assertThatProjDeleted();
    }
}
