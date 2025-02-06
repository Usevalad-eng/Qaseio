package tests.api;

import generators.ProjectGenerator;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.api.pojos.request.project.CreateProjectRequest;
import tests.api.pojos.response.project.post.CreateProjectResponse;
import tests.api.pojos.response.project.delete.DeleteProjectResponse;
import tests.api.pojos.response.project.post.Result;
import tests.api.pojos.response.project.get.GetProjResponse;
import tests.api.steps.ProjectSteps;

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
    void projShouldBeCreated(){
        CreateProjectRequest build = CreateProjectRequest.builder()
                .title("title")
                .code("CODE")
                .description("desc")
                .access("all")
                .group("group")
                .build();
        CreateProjectResponse createProjectRs = ProjectSteps.createProject(build);

        assertThat(createProjectRs)
                .isNotNull()
                .extracting(CreateProjectResponse::getResult)
                .extracting(Result::getCode)
                .isEqualTo(build.getCode());
    }

    @Test
    @Step("Project should be created")
    @DisplayName("Project should be created")
    void projectShouldBeCreatedWithStatusTrue(){
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

    @Test
    @Step("Projects should  be displayed")
    @DisplayName("Projects should  be displayed")
    void getProjectList(){
        GetProjResponse getProjResponse = ProjectSteps.getProjects(10, 0);

        assertThat(getProjResponse)
                .extracting(GetProjResponse::isStatus)
                .isEqualTo(true);
    }

    @Test
    @Step("Projects should  be displayed")
    @DisplayName("Projects should  be displayed")
    void getProjectListGetTotal(){
        GetProjResponse getProjResponse = ProjectSteps.getProjects(10, 0);

        assertThat(getProjResponse)
                .extracting(GetProjResponse::getResult)
                .extracting(tests.api.pojos.response.project.get.Result::getTotal)
                .isEqualTo(0);
    }

    @Test
    @Step("Projects should  be displayed")
    @DisplayName("Projects should  be displayed")
    void getProjectListGetTotalWithError(){
        GetProjResponse getProjResponse = ProjectSteps.getProjects(101, 0);  //limit may not be greater than 100.

        assertThat(getProjResponse)
                .extracting(GetProjResponse::getErrorMessage)
                .isEqualTo("Data is invalid.");
    }
}
