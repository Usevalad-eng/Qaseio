package tests.ui;

import generators.ProjectGenerator;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.BaseTest;
import tests.api.pojos.request.project.CreateProjectRequest;

@Tag("UI")
public class ProjectTest extends BaseTest {

    @Test
    @Feature("Project")
    @Story("User can create a project")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "test", url = "https://app.qase.io")
    @DisplayName("Creation of Project with valid data")
    public void createProjectTest() {
        authorizeInApp(email, password);
        projectPage.openProjectsPage();
        projectPage.clickCreateNewProjectButton();
        CreateProjectRequest project = ProjectGenerator.createProjectApi();
        projectPage.create(project);
        projectPage.assertThatProjCreated();
        ProjectGenerator.deleteProjectApi(project.getCode());
    }

    @Test
    @Feature("Project")
    @Story("User can create a project")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "test", url = "https://app.qase.io")
    @DisplayName("Creation of Project with valid data using random data")
    public void createProjectWithRandomDataTest() {
        projectPage.openLoginPage();
        loginSteps.authInApp(email, password);
        projectPage.projectPageIsOpened();
        CreateProjectRequest projectApi = ProjectGenerator.createProjectApi();
        projectSteps.createProject(projectApi);
        projectPage.openProjectsPage();
        projectPage.assertThatProjCreated();
        ProjectGenerator.deleteProjectApi(projectApi.getTitle().toUpperCase());
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
        loginSteps.authInApp(email, password);
        projectPage.projectPageIsOpened();
        projectPage.createNewProject();
        projectPage.inputProjectName("D");
        projectPage.createProject();
        projectPage.canNotCreateProjectErrorShouldBeVisible();
    }

    @Test
    @DisplayName("Deletion of the Project")
    @Feature("Project")
    @Story("User can delete the project")
    @Owner("Vsevolod")
    @Link(value = "test", url = "https://app.qase.io")
    @Severity(SeverityLevel.NORMAL)
    public void DeleteProjectTest() {
        ProjectGenerator.createProjApi();
        projectPage.openLoginPage();
        loginSteps.authInApp(email, password);
        projectPage.openProjectsPage();
        projectPage.findDots();
        projectPage.deleteButton();
        projectPage.deleteProject();
        projectPage.assertThatProjDeleted();
    }

    @Test
    @DisplayName("Deletion of the Project")
    @Feature("Project")
    @Story("User can crete and delete the project")
    @Owner("Vsevolod")
    @Link(value = "test", url = "https://app.qase.io")
    @Severity(SeverityLevel.NORMAL)
    public void createProjectAndDeleteTest() {
        CreateProjectRequest projectR = ProjectGenerator.createProjectApi();
        ProjectGenerator.getProjectCreated(projectR);
        ProjectGenerator.deleteProjectApi(projectR.getCode());
        authorizeInApp(email, password);
        projectPage.assertThatProjDeleted();
    }
}
