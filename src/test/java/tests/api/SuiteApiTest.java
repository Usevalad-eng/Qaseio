package tests.api;

import generators.ProjectGenerator;
import generators.SuiteGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.api.pojos.request.project.CreateProjectRequest;
import tests.api.pojos.request.suite.CreateSuiteRequest;
import tests.api.pojos.response.suite.CreateSuiteResponse;
import tests.api.pojos.response.suite.DeleteSuiteResponse;
import tests.api.steps.ProjectSteps;
import tests.api.steps.SuiteSteps;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("Api")
public class SuiteApiTest {

    @Test
    @DisplayName("Suite should be created")
    void suiteShouldBeCreated() {
        CreateProjectRequest projectApi = ProjectGenerator.createProjectApiUI();
        ProjectSteps.createProject(projectApi);

        CreateSuiteRequest createSuiteRq = SuiteGenerator.createSuiteApi();
        CreateSuiteResponse createSuiteRs = SuiteSteps.createSuite(createSuiteRq, projectApi.getCode());

        assertThat(createSuiteRs)
                .isNotNull()
                .extracting(CreateSuiteResponse::isStatus)
                .isEqualTo(true);

        ProjectGenerator.deleteProjectApi(projectApi.getCode());
    }

    @Test
    @DisplayName("Suite should be deleted")
    void suiteShouldBeDeleted() {
        CreateProjectRequest projectApi = ProjectGenerator.createProjectApiUI();
        ProjectSteps.createProject(projectApi);

        CreateSuiteRequest createSuiteRq = SuiteGenerator.createSuiteApi();
        SuiteSteps.createSuite(createSuiteRq, projectApi.getCode());

        DeleteSuiteResponse deleteSuiteResponse = SuiteSteps.deleteSuite(projectApi.getCode(), "1");
        assertThat(deleteSuiteResponse)
                .extracting(DeleteSuiteResponse::isStatus)
                .isEqualTo(true);

        ProjectGenerator.deleteProjectApi(projectApi.getCode());
    }

    @Test
    @DisplayName("Suite should not be deleted")
    void suiteShouldNotBeDeleted() {
        CreateProjectRequest projectApi = ProjectGenerator.createProjectApiUI();
        ProjectSteps.createProject(projectApi);

        CreateSuiteRequest createSuiteRq = SuiteGenerator.createSuiteApi();
        SuiteSteps.createSuite(createSuiteRq, projectApi.getCode());

        DeleteSuiteResponse deleteSuiteResponse = SuiteSteps.deleteSuite(projectApi.getCode(), "2222");
        assertThat(deleteSuiteResponse)
                .extracting(DeleteSuiteResponse::getErrorMessage)
                .isEqualTo("Suite not found");

        ProjectGenerator.deleteProjectApi(projectApi.getCode());
    }
}
