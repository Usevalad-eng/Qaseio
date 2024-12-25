package tests.api;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class QaseioApiTest {

    @Test
    void qaseio(){
        given()
                .header("Token", "8712b8dd5d9089dac78e3e50b649233346b7f122015027677ef032f5b55fc9e8")
                .log().uri()
                .when()
                .get("https://api.qase.io/v1/project")
                .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }
}