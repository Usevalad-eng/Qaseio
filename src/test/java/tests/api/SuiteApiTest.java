package tests.api;

import generators.ProjectGenerator;
import generators.SuiteGenerator;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.api.pojos.request.project.CreateProjectRequest;
import tests.api.pojos.request.suite.CreateSuiteRequest;
import tests.api.pojos.response.project.DeleteProjectResponse;
import tests.api.pojos.response.suite.CreateSuiteResponse;
import tests.api.pojos.response.suite.DeleteSuiteResponse;
import tests.steps.ProjectSteps;
import tests.steps.SuiteSteps;

import static org.assertj.core.api.Assertions.assertThat;

public class SuiteApiTest {

    @Test
    @Step("Suite should be created")
    @DisplayName("Suite should be created")
    void suiteShouldBeCreated() {
        CreateProjectRequest projectApiH = ProjectGenerator.createProjectApiH();
        ProjectSteps.createProject(projectApiH);

        CreateSuiteRequest createSuiteRq = SuiteGenerator.createSuiteApi();
        CreateSuiteResponse createSuiteRs = SuiteSteps.createSuite(createSuiteRq, projectApiH.getCode());

        assertThat(createSuiteRs)
                .isNotNull()
                .extracting(CreateSuiteResponse::isStatus)
                .isEqualTo(true);
    }

    @Test
    @Step("Suite should be deleted")
    @DisplayName("Suite should be deleted")
    void suiteShouldBeDeleted() {
        CreateProjectRequest projectApiH = ProjectGenerator.createProjectApiH();
        ProjectSteps.createProject(projectApiH);

        CreateSuiteRequest createSuiteRq = SuiteGenerator.createSuiteApi();
        SuiteSteps.createSuite(createSuiteRq, projectApiH.getCode());

        DeleteSuiteResponse deleteSuiteResponse = SuiteSteps.deleteSuite(projectApiH.getCode(), "1");
        assertThat(deleteSuiteResponse)
                .extracting(DeleteSuiteResponse::isStatus)
                .isEqualTo(true);
    }

    @Test
    @Step("Suite should not be deleted")
    @DisplayName("Suite should not be deleted")
    void suiteShouldNotBeDeleted() {
        CreateProjectRequest projectApiH = ProjectGenerator.createProjectApiH();
        ProjectSteps.createProject(projectApiH);

        CreateSuiteRequest createSuiteRq = SuiteGenerator.createSuiteApi();
        SuiteSteps.createSuite(createSuiteRq, projectApiH.getCode());

        DeleteSuiteResponse deleteSuiteResponse = SuiteSteps.deleteSuite(projectApiH.getCode(), "2222");
        assertThat(deleteSuiteResponse)
                .extracting(DeleteSuiteResponse::getErrorMessage)
                .isEqualTo("Suite not found");
    }
}
