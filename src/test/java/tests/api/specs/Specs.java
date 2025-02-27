package tests.api.specs;

import config.ConfigReader;
import helpers.CustomAllureListener;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;

public class Specs {


    public static final RequestSpecification REQ_SPEC = with()
            .baseUri(ConfigReader.apiConfig.baseUri())
            .basePath(ConfigReader.apiConfig.basePath())
            .filter(CustomAllureListener.withCustomTemplates())
            .log().uri()
            .contentType(ContentType.JSON)
            .header("Token", ConfigReader.apiConfig.token());

    public static final ResponseSpecification RES_SPEC = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .build();
}
