package tests.api;

import com.google.common.base.Supplier;
import generators.ProjectGenerator;
import generators.SuiteGenerator;
import org.junit.jupiter.api.Test;
import tests.api.pojos.request.project.CreateProjectRequest;
import tests.api.pojos.request.suite.CreateSuiteRequest;
import tests.api.pojos.response.project.CreateProjectResponse;
import tests.api.pojos.response.project.Result;
import tests.api.pojos.response.suite.CreateSuiteResponse;
import tests.steps.ProjectSteps;
import tests.steps.SuiteSteps;

import static org.assertj.core.api.Assertions.assertThat;

public class SuiteApiTest {

    @Test
    void suiteShouldBeCreated(){
        //todo - create Project with code = DDD;
        CreateSuiteRequest createSuiteRq = SuiteGenerator.createSuiteApi();
        CreateSuiteResponse createSuiteRs = SuiteSteps.createSuite(createSuiteRq, "DDD");
        assertThat(createSuiteRs)
                .isNotNull()
                .extracting(CreateSuiteResponse::isStatus)
                .isEqualTo(true);
    }
}
