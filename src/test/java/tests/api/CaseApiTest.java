package tests.api;

import generators.CaseGenerator;
import generators.ProjectGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.api.pojos.request.cases.CreateCaseRequest;
import tests.api.pojos.request.project.CreateProjectRequest;
import tests.api.pojos.response.cases.CreateCaseResponse;
import tests.api.pojos.response.cases.DeleteCaseResponse;
import tests.api.steps.CaseSteps;
import tests.api.steps.ProjectSteps;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("Api")
public class CaseApiTest {

    @Test
    @DisplayName("Case should be created")
    void caseShouldBeCreated() {
        CreateProjectRequest projectApi = ProjectGenerator.createProjectApi();
        ProjectSteps.createProject(projectApi);

        CreateCaseRequest createCaseRq = CaseGenerator.createCaseApi();
        CreateCaseResponse createCaseRs = CaseSteps.createCase(createCaseRq, projectApi.getCode());

        assertThat(createCaseRs)
                .isNotNull()
                .extracting(CreateCaseResponse::isStatus)
                .isEqualTo(true);

        ProjectGenerator.deleteProjectApi(projectApi.getCode());
    }

    @Test
    @DisplayName("Case should be deleted")
    void caseShouldBeDeleted(){
        CreateProjectRequest projectApi = ProjectGenerator.createProjectApi();
        ProjectSteps.createProject(projectApi);

        CreateCaseRequest createCaseRq = CaseGenerator.createCaseApi();
        CaseSteps.createCase(createCaseRq, projectApi.getCode());

        DeleteCaseResponse deleteCaseResponse = CaseSteps.deleteCase(projectApi.getCode(), "1");
        assertThat(deleteCaseResponse)
                .extracting(DeleteCaseResponse::isStatus)
                .isEqualTo(true);

        ProjectGenerator.deleteProjectApi(projectApi.getCode());
    }

    @Test
    @DisplayName("Case should not be deleted")
    void caseShouldNotBeDeleted(){
        CreateProjectRequest projectApi = ProjectGenerator.createProjectApi();
        ProjectSteps.createProject(projectApi);

        CreateCaseRequest createCaseRq = CaseGenerator.createCaseApi();
        CaseSteps.createCase(createCaseRq, projectApi.getCode());

        DeleteCaseResponse deleteCaseResponse = CaseSteps.deleteCase(projectApi.getCode(), "1111");
        assertThat(deleteCaseResponse)
                .extracting(DeleteCaseResponse::getErrorMessage)
                .isEqualTo("TestCase not found");

        ProjectGenerator.deleteProjectApi(projectApi.getCode());
    }
}
