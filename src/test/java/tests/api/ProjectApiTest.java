package tests.api;

import generators.ProjectGenerator;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.api.pojos.request.project.CreateProjectRequest;
import tests.api.pojos.response.project.CreateProjectResponse;
import tests.api.pojos.response.project.DeleteProjectResponse;
import tests.api.pojos.response.project.Result;
import tests.steps.ProjectSteps;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class ProjectApiTest {

    @Test
    @Step("Project should be created")
    @DisplayName("Project should be created")
    void projectShouldBeCreated(){
        CreateProjectRequest createProjectRq = ProjectGenerator.createProjectApi();
        CreateProjectResponse createProjectRs = ProjectSteps.createProject(createProjectRq);
        assertThat(createProjectRs)
                .isNotNull()
                .extracting(CreateProjectResponse::getResult)
                .extracting(Result::getCode)
                .isEqualTo(createProjectRq.getCode());
    }

    @Test
    @Step("Project should be created")
    @DisplayName("Project should be created")
    void projectShouldBeCreatedTrue(){
        CreateProjectRequest createProjectRq = ProjectGenerator.createProjectApi();
        CreateProjectResponse createProjectRs = ProjectSteps.createProject(createProjectRq);
        assertThat(createProjectRs)
                .isNotNull()
                .extracting(CreateProjectResponse::isStatus)
                .isEqualTo(true);
    }

    @Test
    @Step("Project should be deleted")
    @DisplayName("Project should be deleted")
    void projectShouldBeDeleted(){
        CreateProjectRequest projectToDel = ProjectGenerator.createProjectApi();
        ProjectSteps.createProject(projectToDel);
        DeleteProjectResponse deleteProjectResponse = ProjectSteps.deleteProject(projectToDel.getCode());
        assertThat(deleteProjectResponse)
                .extracting(DeleteProjectResponse::isStatus)
                .isEqualTo(true);
    }

    @Test
    @Step("Project should not be deleted")
    @DisplayName("Project should not be deleted")
    void projectShouldNotBeDeleted(){
        DeleteProjectResponse deleteProjectResponse = ProjectSteps.deleteProject("codeInvalid");
        assertThat(deleteProjectResponse)
                .extracting(DeleteProjectResponse::getErrorMessage)
                .isEqualTo("Project not found");
    }
}
