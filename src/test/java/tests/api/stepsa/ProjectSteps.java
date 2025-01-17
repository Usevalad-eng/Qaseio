package tests.api.stepsa;

import tests.api.pojos.request.project.CreateProjectRequest;
import tests.api.pojos.response.project.CreateProjectResponse;

import static io.restassured.RestAssured.given;
import static tests.api.specs.Specs.REQ_SPEC;
import static tests.api.specs.Specs.RES_SPEC;

public class ProjectSteps {

    public static CreateProjectResponse createProject(CreateProjectRequest projectRq){
        return given()
                .spec(REQ_SPEC)
                .body(projectRq)
                .post("/project")
                .then().spec(RES_SPEC)
                .extract().as(CreateProjectResponse.class);
    }
}
