package tests.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ExampleApiTest {

    @Test
    @Disabled
    void count() {
        given()
                .log().all()
                .when()
                .get("https://api.nationalize.io/?name=nathaniel")
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
        //.body("count", is(6172))
        //.body("country.country_id[0]", is("NG"));
    }

    @Test
    @Disabled
    void checkTotal() {
        given()
                .when()
                .get("https://selenoid.autotests.cloud/status")
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
        //.body("total", is(20));
    }

    @Test
    @Disabled
    void loginTest() {
        String data = "{ \"email\": \"eve.holt@reqres.in\", \"password\":\"cityslicka\" }";
        given()
                .log().uri()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200);
        //.body("token", is("QpwL5tke4Pnpja7X4"));
    }

    @Test
    @Disabled
    void check() {
        String expectedResponse = "{\n" +
                "  \"count\": 6172,\n" +
                "  \"name\": \"nathaniel\",\n" +
                "  \"country\": [\n" +
                "    {\n" +
                "      \"country_id\": \"NG\",\n" +
                "      \"probability\": 0.176324535127189\n" +
                "    },\n" +
                "    {\n" +
                "      \"country_id\": \"GH\",\n" +
                "      \"probability\": 0.0830436129701313\n" +
                "    },\n" +
                "    {\n" +
                "      \"country_id\": \"NE\",\n" +
                "      \"probability\": 0.0716461588044484\n" +
                "    },\n" +
                "    {\n" +
                "      \"country_id\": \"US\",\n" +
                "      \"probability\": 0.0320193196984244\n" +
                "    },\n" +
                "    {\n" +
                "      \"country_id\": \"ID\",\n" +
                "      \"probability\": 0.0263754042540012\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        Response actualResponse = given()
                .log().uri()
                .when()
                .get("https://api.nationalize.io/?name=nathaniel")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().response();

        assertEquals(expectedResponse, actualResponse.asString(), "error!");
    }

    @Test
    @Disabled
    void checkResponse() {
        Integer expectedCount = 6172;

        Integer actualCount = given()
                .log().uri()
                .when()
                .get("https://api.nationalize.io/?name=nathaniel")
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().path("count");

        assertEquals(expectedCount, actualCount, "Error!");
    }

    @Test
    @Disabled
    void checkContent() {
        given()
                .log().uri()
                .when()
                .get("https://api.nationalize.io/?namee=nathaniel")
                .then()
                .log().status()
                .log().body()
                .statusCode(422);
        //.body("error", is("Missing 'name' parameter"));
    }

    @Test
    @Disabled
    void checkName() {
        given()
                .log().all()
                .when()
                .get("https://api.nationalize.io/?name=nathaniel")
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
        //.body("total", is(20));
    }

    @Test
    @Disabled
    void loginPostTest() {
        String data = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }";

        /*String data = "{\n" +
                "\"email\":\"eve.holt@reqres.in\",\n" +
                "\"password\":\"cityslicka\"\n" +
                "}";*/

        String validatableResponse = given()
                .log().uri()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().path("token");
        //.body("token", is("QpwL5tke4Pnpja7X4"));

        assertEquals("QpwL5tke4Pnpja7X4", validatableResponse, "Error!");
    }
}
