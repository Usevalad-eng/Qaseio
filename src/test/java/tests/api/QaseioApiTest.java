package tests.api;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class QaseioApiTest {

    public String token = "8712b8dd5d9089dac78e3e50b649233346b7f122015027677ef032f5b55fc9e8";

    @Test
    @Step("Get projects")
    @DisplayName("Get projects")
    public void qaseioGetProj() {
        given()
                .header("Token", token)
                .log().uri()
                .when()
                .get("https://api.qase.io/v1/project")
                .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }

    @Test
    @Step("Create project 'Demo'")
    @DisplayName("Create project 'Demo'")
    public void qaseioCreateProj() {

        String data = "{ \"title\": \"MEMO\", \"code\": \"MEMO\" }";

        given()
                .header("Token", token)
                .log().uri()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("https://api.qase.io/v1/project")
                .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }

    @Test
    @Step("Delete project 'Demo'")
    @DisplayName("Delete project 'Demo', project with code 'DEMO' should be created before this method runs")
    public void qaseioDelProj() {
        given()
                .header("Token", token)
                .log().uri()
                .when()
                .delete("https://api.qase.io/v1/project/" + "DEMO")
                .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }
}


