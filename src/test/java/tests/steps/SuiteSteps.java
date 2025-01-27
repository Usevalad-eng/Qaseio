package tests.steps;

import tests.api.pojos.request.suite.CreateSuiteRequest;
import tests.api.pojos.response.suite.CreateSuiteResponse;

import static io.restassured.RestAssured.given;

import static tests.api.specs.Specs.REQ_SPEC;
import static tests.api.specs.Specs.RES_SPEC;

public class SuiteSteps {

    public static String path = "/suite/";

    public static CreateSuiteResponse createSuite(CreateSuiteRequest suiteRq, String code){
        return given()
                .spec(REQ_SPEC)
                .body(suiteRq)
                .post(path + code)
                .then().spec(RES_SPEC)
                .extract().as(CreateSuiteResponse.class);
    }
}
