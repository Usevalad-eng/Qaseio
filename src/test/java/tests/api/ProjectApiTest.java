package tests.api;

import generators.ProjectGenerator;
import org.junit.jupiter.api.Test;
import tests.api.pojos.request.project.CreateProjectRequest;
import tests.api.pojos.response.project.CreateProjectResponse;
import tests.api.pojos.response.project.Result;
import tests.steps.ProjectSteps;

import static org.assertj.core.api.Assertions.assertThat;

public class ProjectApiTest {

    @Test
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
    void projectShouldBeCreatedTrue(){
        CreateProjectRequest createProjectRq = ProjectGenerator.createProjectApi();
        CreateProjectResponse createProjectRs = ProjectSteps.createProject(createProjectRq);
        assertThat(createProjectRs)
                .isNotNull()
                .extracting(CreateProjectResponse::isStatus)
                .isEqualTo(true);
    }
}
