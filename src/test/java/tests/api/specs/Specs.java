package tests.api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;

public class Specs {

    public static String token = System.getProperty("token", "8712b8dd5d9089dac78e3e50b649233346b7f122015027677ef032f5b55fc9e8");

    public static final RequestSpecification REQ_SPEC = with()
            .baseUri("https://api.qase.io")
            .basePath("/v1")
            .log().uri()
            .contentType(ContentType.JSON)
            .header("Token", token);  //.header("Token", "8712b8dd5d9089dac78e3e50b649233346b7f122015027677ef032f5b55fc9e8");

    public static final ResponseSpecification RES_SPEC = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .build();
}
