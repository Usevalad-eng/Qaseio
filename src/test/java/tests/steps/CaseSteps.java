package tests.steps;

import tests.api.pojos.request.cases.CreateCaseRequest;
import tests.api.pojos.request.suite.CreateSuiteRequest;
import tests.api.pojos.response.cases.CreateCaseResponse;
import tests.api.pojos.response.cases.DeleteCaseResponse;
import tests.api.pojos.response.suite.CreateSuiteResponse;
import tests.api.pojos.response.suite.DeleteSuiteResponse;

import static io.restassured.RestAssured.given;
import static tests.api.specs.Specs.REQ_SPEC;
import static tests.api.specs.Specs.RES_SPEC;

public class CaseSteps {

    public static String path = "/case/";

    public static CreateCaseResponse createCase(CreateCaseRequest caseRq, String code){
        return given()
                .spec(REQ_SPEC)
                .body(caseRq)
                .post(path + code)
                .then().spec(RES_SPEC)
                .extract().as(CreateCaseResponse.class);
    }

    public static DeleteCaseResponse deleteCase(String code, String id){
        return given()
                .spec(REQ_SPEC)
                .delete(path + code + "/" + id)
                .then().spec(RES_SPEC)
                .extract().as(DeleteCaseResponse.class);
    }
}
