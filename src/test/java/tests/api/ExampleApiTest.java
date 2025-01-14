package tests.api;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
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
                .statusCode(HttpStatus.SC_OK)
        .body("count", is(6172))
        .body("country.country_id[0]", is("NG"));
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
                .statusCode(HttpStatus.SC_OK)
                .body("total", is(20));
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
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }

    @Test
    @Disabled
    void loginCheckTest() {
        given()
                .log().uri()
                .contentType(ContentType.JSON)
                .formParam("email", "eve.holt@reqres.in")
                .formParam("password", "cityslicka")
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }

    @Test
    @Disabled
    void checkResponseTest() {
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
                .statusCode(422)
                .body("error", is("Missing 'name' parameter"));
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
                .statusCode(HttpStatus.SC_OK)
                .body("total", is(20));
    }

    @Test
    @Disabled
    void loginPostTest() {
        String data = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }";

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

    /*@BeforeAll
    static void configureBaseUrl(){
        RestAssured.baseURI = "https://demowebshop.tricentis.com";
        String authCookie = given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("Email", "kubyox@mailto.plus")
                .formParam("Password", "kubyox")
                .when()
                .post("https://demowebshop.tricentis.com/login")
                .then()
                .statusCode(302)
                .extract()
                .cookie("NOPCOMMERCE.AUTH");
        open("https://demowebshop.tricentis.com/Themes/DefaultClean/Content/images/logo.png");
        WebDriverRunner.getWebDriver().manage().addCookie(new Cookie("NOPCOMMERCE.AUTH", authCookie));
    }*/

    @Test
    @Disabled
    void testDemowebshop(){
        open("https://demowebshop.tricentis.com/login");
        //Selenide.refresh();
        //String data = "{ \"email\": \"kubyox@mailto.plus\", \"password\": \"kubyox\" }";
        $("#Email").setValue("kubyox@mailto.plus");
        $("#Password").setValue("kubyox").pressEnter();
        $(".account").shouldHave(Condition.text("kubyox@mailto.plus"));
    }

    @Test
    @Disabled
    void loginWithCookie(){
        String authCookie = given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("Email", "kubyox@mailto.plus")
                .formParam("Password", "kubyox")
                .when()
                .post("https://demowebshop.tricentis.com/login")
                .then()
                .statusCode(302)
                .extract()
                .cookie("NOPCOMMERCE.AUTH");
        open("https://demowebshop.tricentis.com/Themes/DefaultClean/Content/images/logo.png");
        WebDriverRunner.getWebDriver().manage().addCookie(new Cookie("NOPCOMMERCE.AUTH", authCookie));
        open("https://demowebshop.tricentis.com");
        $(".account").shouldHave(Condition.text("kubyox@mailto.plus"));
    }
}
