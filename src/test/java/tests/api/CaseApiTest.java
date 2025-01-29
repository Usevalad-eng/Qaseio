package tests.api;

import generators.CaseGenerator;
import generators.ProjectGenerator;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.api.pojos.request.cases.CreateCaseRequest;
import tests.api.pojos.request.project.CreateProjectRequest;
import tests.api.pojos.response.cases.CreateCaseResponse;
import tests.api.pojos.response.cases.DeleteCaseResponse;
import tests.steps.CaseSteps;
import tests.steps.ProjectSteps;

import static org.assertj.core.api.Assertions.assertThat;

public class CaseApiTest {

    @Test
    @Step("Case should be created")
    @DisplayName("Case should be created")
    void caseShouldBeCreated() {
        CreateProjectRequest projectApiH = ProjectGenerator.createProjectApiH();
        ProjectSteps.createProject(projectApiH);

        CreateCaseRequest createCaseRq = CaseGenerator.createCaseApi();
        CreateCaseResponse createCaseRs = CaseSteps.createCase(createCaseRq, projectApiH.getCode());

        assertThat(createCaseRs)
                .isNotNull()
                .extracting(CreateCaseResponse::isStatus)
                .isEqualTo(true);
    }

    @Test
    @Step("Case should be deleted")
    @DisplayName("Case should be deleted")
    void caseShouldBeDeleted(){
        CreateProjectRequest projectApiH = ProjectGenerator.createProjectApiH();
        ProjectSteps.createProject(projectApiH);

        CreateCaseRequest createCaseRq = CaseGenerator.createCaseApi();
        CaseSteps.createCase(createCaseRq, projectApiH.getCode());

        DeleteCaseResponse deleteCaseResponse = CaseSteps.deleteCase(projectApiH.getCode(), "1");
        assertThat(deleteCaseResponse)
                .extracting(DeleteCaseResponse::isStatus)
                .isEqualTo(true);
    }

    @Test
    @Step("Case should not be deleted")
    @DisplayName("Case should not be deleted")
    void caseShouldNotBeDeleted(){
        CreateProjectRequest projectApiH = ProjectGenerator.createProjectApiH();
        ProjectSteps.createProject(projectApiH);

        CreateCaseRequest createCaseRq = CaseGenerator.createCaseApi();
        CaseSteps.createCase(createCaseRq, projectApiH.getCode());

        DeleteCaseResponse deleteCaseResponse = CaseSteps.deleteCase(projectApiH.getCode(), "1111");
        assertThat(deleteCaseResponse)
                .extracting(DeleteCaseResponse::getErrorMessage)
                .isEqualTo("TestCase not found");
    }
}
