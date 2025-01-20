package tests.steps;

import tests.api.pojos.request.project.CreateProjectRequest;
import tests.api.pojos.response.project.CreateProjectResponse;
import tests.api.pojos.response.project.DeleteProjectResponse;

import static io.restassured.RestAssured.given;
import static tests.api.specs.Specs.REQ_SPEC;
import static tests.api.specs.Specs.RES_SPEC;

public class ProjectSteps {

    public static String path = "/project";

    public static CreateProjectResponse createProject(CreateProjectRequest projectRq){
        return given()
                .spec(REQ_SPEC)
                .body(projectRq)
                .post("/project")
                .then().spec(RES_SPEC)
                .extract().as(CreateProjectResponse.class);
    }

    public static DeleteProjectResponse deleteProject(String code){
        return given()
                .spec(REQ_SPEC)
                .delete(path + "/" + code)
                .then().spec(RES_SPEC)
                .extract().as(DeleteProjectResponse.class);
    }
}
