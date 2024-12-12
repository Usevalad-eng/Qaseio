package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tests.base.BaseTest;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LoginScriptTest extends BaseTest {
    public String error1 = "This field is required";
    public String error2 = "This field is required";

    @Test
    public void userShouldBeLoggedInUsingValidData() {
        open("/login");
        $("[name=email]").setValue("kubyox@mailto.plus");
        $("[name=password]").setValue("qaseio122024");
        $("span[class=CAunhU]").click();
        $("h1[class=uA6zAY]").shouldHave(text("Projects"));
    }

    @Test
    void userShouldBeLoggedInUsingEmptyData() {
        open("/login");
        $("[name=email]").setValue("");
        $("[name=password]").setValue("");
        $("span[class=CAunhU]").click();
        String textOfMessageOne = $$x("//small[@class = 'f75Cb_']").get(0).getText();
        Assertions.assertEquals(error1, textOfMessageOne, "Error on the page!");
        String textOfMessageTwo = $$x("//small[@class = 'f75Cb_']").get(1).getText();
        Assertions.assertEquals(error2, textOfMessageTwo, "Error on the page!");
    }

    @Test
    void qaseioAuthTwouserShouldBeLoggedInUsingEmptyPass() {
        open("/login");
        $("[name=email]").setValue("kubyox@mailto.plus");
        $("[name=password]").setValue("");
        $("span[class=CAunhU]").click();
        String textOfMessageTwo = $$x("//small[@class = 'f75Cb_']").get(0).getText();
        Assertions.assertEquals(error2, textOfMessageTwo, "Error on the page!");
    }

    @Test
    void qaseioAuthThreeuserShouldBeLoggedInUsingEmptyLogin() {
        open("/login");
        $("[name=email]").setValue("");
        $("[name=password]").setValue("qaseio122024");
        $("span[class=CAunhU]").click();
        String textOfMessageOne = $$x("//small[@class = 'f75Cb_']").get(0).getText();
        Assertions.assertEquals(error1, textOfMessageOne, "Error on the page!");
    }

    static Stream<Arguments> qaseioAuthNegativeScenarios() {
        return Stream.of(
                //Arguments.of("", "", "This field is required", "This field is required"),
                Arguments.of("kubyox@mailto.plus", "", "This field is required", "This field is required"),
                Arguments.of("", "qaseio122024", "This field is required", "This field is required")
                //Arguments.of("some_email@email.ru", "pwd", "This field is required", "This field is required")
        );
    }
    @MethodSource("qaseioAuthNegativeScenarios")
    @ParameterizedTest(name = "Qaseio auth negative test using JUnit5")
    void qaseioAuthNegativeScenarios(String login, String pass, String errorOne, String errorTwo) {
        open("/login");
        $("[name=email]").setValue(login);
        $("[name=password]").setValue(pass);
        $("span[class=CAunhU]").click();
        String textOfMessageOne = $$x("//small[@class = 'f75Cb_']").get(0).getText();
        Assertions.assertEquals(errorOne, textOfMessageOne, "Error on the page!");
        //String textOfMessageTwo = $$x("//small[@class = 'f75Cb_']").get(1).getText();
        //Assertions.assertEquals(errorTwo, textOfMessageTwo, "Error on the page!");
    }
}
