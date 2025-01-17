package tests.api;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.LoginRequestPojoModel;
import models.LoginResponsePojoModel;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.*;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specsL.LoginSpecs.loginRequestSpec;
import static specsL.LoginSpecs.loginResponseSpec;


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
    void loginTestB() {
        LoginRequestPojoModel data = new LoginRequestPojoModel();
        data.setEmail("eve.holt@reqres.in");
        data.setPassword("cityslicka");

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
    void loginTestG() {
        LoginRequestPojoModel data = new LoginRequestPojoModel();
        data.setEmail("eve.holt@reqres.in");
        data.setPassword("cityslicka");

        LoginResponsePojoModel response = given()
                .log().uri()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(LoginResponsePojoModel.class);
        assertThat(response.getToken()).isEqualTo("QpwL5tke4Pnpja7X4");
    }

    @Test
    @Disabled
    void loginTestGWSpecs() {
        LoginRequestPojoModel data = new LoginRequestPojoModel();
        data.setEmail("eve.holt@reqres.in");
        data.setPassword("cityslicka");

        LoginResponsePojoModel response = given(loginRequestSpec)
                .body(data)
                .when()
                .post("/login")
                .then()
                .spec(loginResponseSpec)
                .extract().as(LoginResponsePojoModel.class);
        assertThat(response.getToken()).isEqualTo("QpwL5tke4Pnpja7X4");
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

    @Test
    @Disabled
    void addCartTest(){
        String cookieValue = "29687C6076C808CA9A680849350BEF1B499206EEDB28B22451C2A0304FD22F3EE1D4F52CF66B57E9E13EC2788C4EA5626CB66732C9E84F9EF9CF47B06D8CB873FF6B234A0D0B412FF9D1AC3A4843B14F784C71A9769E81038A6E59EECF41A3E8453283C6C217961878FEF469456333F2F416F8EFADC0B037667D4B9E771ABF945DC36BAA0372D519DB2F197FF2FACF39BE9FEC51C6440F1582BD204E357C2B42";
        String body = "product_attribute_72_5_18=53" + "&product_attribute_72_6_19=54" + "&product_attribute_72_3_20=57" +
                "&addtocart_72.EnteredQuontity=4";
        given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .cookie("NOPCOMMERCE.AUTH", cookieValue)
                .body(body)
                .when()
                .post("https://demowebshop.tricentis.com/addproducttocart/details/72/1")
                .then()
                .log().all()
                .statusCode(200)
                .body("success", is(true))
                .body("message", is("The product has been added to your <a href=\"/cart\">shopping cart</a>"));
    }
}
