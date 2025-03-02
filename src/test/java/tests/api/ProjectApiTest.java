package tests.api;

import generators.ProjectGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.api.pojos.request.project.CreateProjectRequest;
import tests.api.pojos.response.project.delete.DeleteProjectResponse;
import tests.api.pojos.response.project.get.GetProjResponse;
import tests.api.pojos.response.project.post.CreateProjectResponse;
import tests.api.pojos.response.project.post.Result;
import tests.api.steps.ProjectSteps;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("Api")
public class ProjectApiTest {

    @Test
    @DisplayName("Project with valid random data should be created")
    void projectShouldBeCreated(){
        CreateProjectRequest createProjectRq = ProjectGenerator.createProject();
        CreateProjectResponse createProjectRs = ProjectSteps.createProject(createProjectRq);

        assertThat(createProjectRs)
                .isNotNull()
                .extracting(CreateProjectResponse::getResult)
                .extracting(Result::getCode)
                .isEqualTo(createProjectRq.getCode());

        ProjectGenerator.deleteProjectApi(createProjectRq.getCode());
    }

    @Test
    @DisplayName("Project with valid not random data should be created")
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

        ProjectGenerator.deleteProjectApi(build.getCode());
    }

    @Test
    @DisplayName("Project should be created, checking only creating")
    void projectShouldBeCreatedWithStatusTrue(){
        CreateProjectRequest createProjectRq = ProjectGenerator.createProject();
        CreateProjectResponse createProjectRs = ProjectSteps.createProject(createProjectRq);

        assertThat(createProjectRs)
                .isNotNull()
                .extracting(CreateProjectResponse::isStatus)
                .isEqualTo(true);

        ProjectGenerator.deleteProjectApi(createProjectRq.getCode());
    }

    @Test
    @DisplayName("Project should be deleted")
    void projectShouldBeDeleted(){
        CreateProjectRequest projectToDel = ProjectGenerator.createProject();
        ProjectSteps.createProject(projectToDel);
        DeleteProjectResponse deleteProjectResponse = ProjectSteps.deleteProject(projectToDel.getCode());

        assertThat(deleteProjectResponse)
                .extracting(DeleteProjectResponse::isStatus)
                .isEqualTo(true);
    }

    @Test
    @DisplayName("Project should not be deleted")
    void projectShouldNotBeDeleted(){
        DeleteProjectResponse deleteProjectResponse = ProjectSteps.deleteProject("codeInvalid");

        assertThat(deleteProjectResponse)
                .extracting(DeleteProjectResponse::getErrorMessage)
                .isEqualTo("Project not found");
    }

    @Test
    @DisplayName("Projects should  be displayed as a json data only")
    void getProjectList(){
        GetProjResponse getProjResponse = ProjectSteps.getProjects(10, 0);

        assertThat(getProjResponse)
                .extracting(GetProjResponse::isStatus)
                .isEqualTo(true);
    }

    @Test
    @DisplayName("Projects should  be displayed with errors when limit  greater than 100")
    void getProjectListTotalWithErrorMessage(){
        GetProjResponse getProjResponse = ProjectSteps.getProjects(101, 0);

        assertThat(getProjResponse)
                .extracting(GetProjResponse::getErrorMessage)
                .isEqualTo("Data is invalid.");
    }
}
