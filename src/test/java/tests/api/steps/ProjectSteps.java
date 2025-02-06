package tests.api.steps;

import tests.api.pojos.request.project.CreateProjectRequest;
import tests.api.pojos.response.project.post.CreateProjectResponse;
import tests.api.pojos.response.project.delete.DeleteProjectResponse;
import tests.api.pojos.response.project.get.GetProjResponse;

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

    public static DeleteProjectResponse deleteProject(String codeOfProject){
        return given()
                .spec(REQ_SPEC)
                .delete(path + "/" + codeOfProject)
                .then().spec(RES_SPEC)
                .extract().as(DeleteProjectResponse.class);
    }

    public static GetProjResponse getProjects(int limit, int offset){
        return given()
                .spec(REQ_SPEC)
                .queryParam("limit", limit)
                .queryParam("offset", offset)
                .get(path)
                .then().spec(RES_SPEC)
                .extract().as(GetProjResponse.class);
    }
}
