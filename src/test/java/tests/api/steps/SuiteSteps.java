package tests.api.steps;

import tests.api.pojos.request.suite.CreateSuiteRequest;
import tests.api.pojos.response.suite.CreateSuiteResponse;
import tests.api.pojos.response.suite.DeleteSuiteResponse;

import static io.restassured.RestAssured.given;

import static tests.api.specs.Specs.REQ_SPEC;
import static tests.api.specs.Specs.RES_SPEC;

public class SuiteSteps {

    public static String path = "/suite/";

    public static CreateSuiteResponse createSuite(CreateSuiteRequest suiteRq, String codeOfProject){
        return given()
                .spec(REQ_SPEC)
                .body(suiteRq)
                .post(path + codeOfProject)
                .then().spec(RES_SPEC)
                .extract().as(CreateSuiteResponse.class);
    }

    public static DeleteSuiteResponse deleteSuite(String codeOfProject, String id){
        return given()
                .spec(REQ_SPEC)
                .delete(path + codeOfProject + "/" + id)
                .then().spec(RES_SPEC)
                .extract().as(DeleteSuiteResponse.class);
    }
}
