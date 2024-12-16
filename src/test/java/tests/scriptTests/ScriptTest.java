package tests.scriptTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tests.base.BaseHeadlessTest;
import tests.base.BaseTest;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class ScriptTest extends BaseTest {

    public String error1 = "This field is required";
    public String error2 = "This field is required";

    @Test
    @Disabled
    public void userShouldBeLoggedInUsingValidData() {
        open("/login");
        $("[name=email]").setValue("kubyox@mailto.plus");
        $("[name=password]").setValue("qaseio122024");
        $("span[class=CAunhU]").click();
        $("h1[class=uA6zAY]").shouldHave(text("Projects"));
        Configuration.timeout = 5000;
    }

    @Test
    @Disabled
    void userShouldNotBeLoggedInUsingEmptyData() {
        open("/login");
        $("[name=email]").setValue("");
        $("[name=password]").setValue("");
        $("span[class=CAunhU]").click();
        String textOfMessageOne = $$x("//small[@class = 'f75Cb_']").get(0).getText();
        Assertions.assertEquals(error1, textOfMessageOne, "Error on the page!");
        String textOfMessageTwo = $$x("//small[@class = 'f75Cb_']").get(1).getText();
        Assertions.assertEquals(error2, textOfMessageTwo, "Error on the page!");
        Configuration.timeout = 5000;
    }

    @Test
    @Disabled
    void userShouldNotBeLoggedInUsingEmptyPass() {
        open("/login");
        $("[name=email]").setValue("kubyox@mailto.plus");
        $("[name=password]").setValue("");
        $("span[class=CAunhU]").click();
        String textOfMessageTwo = $$x("//small[@class = 'f75Cb_']").get(0).getText();
        Assertions.assertEquals(error2, textOfMessageTwo, "Error on the page!");
        Configuration.timeout = 5000;
    }

    @Test
    @Disabled
    void userShouldNotBeLoggedInUsingEmptyLogin() {
        open("/login");
        $("[name=email]").setValue("");
        $("[name=password]").setValue("qaseio122024");
        $("span[class=CAunhU]").click();
        String textOfMessageOne = $$x("//small[@class = 'f75Cb_']").get(0).getText();
        Assertions.assertEquals(error1, textOfMessageOne, "Error on the page!");
        Configuration.timeout = 5000;
    }

    static Stream<Arguments> qaseioAuthNegativeScenarios() {
        return Stream.of(
                Arguments.of("kubyox@mailto.plus", "", "This field is required"),
                Arguments.of("", "qaseio122024", "This field is required")
        );
    }
    @MethodSource("qaseioAuthNegativeScenarios")
    @ParameterizedTest(name = "Qaseio auth negative tests using JUnit5(empty pass or login)")
    @Disabled
    void qaseioAuthNegativeScenarios(String login, String pass, String errorOne) {
        open("/login");
        $("[name=email]").setValue(login);
        $("[name=password]").setValue(pass);
        $("span[class=CAunhU]").click();
        String textOfMessageOne = $$x("//small[@class = 'f75Cb_']").get(0).getText();
        Assertions.assertEquals(errorOne, textOfMessageOne, "Error on the page!");
        Configuration.timeout = 5000;
    }

    @Test
    @Disabled
    public void createProjectScriptTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("/login");
        $("[name=email]").sendKeys("kubyox@mailto.plus");
        $("[name=password]").sendKeys("qaseio122024");
        $("[name=password]").submit();
        $x("//span[text() = 'Create new project']").shouldBe(visible).click();
        $("#modal-header").shouldHave(text("Create new project"));
        $("#project-name").sendKeys("Demo");
        $x("//span[text() = 'Create project']").click();
        open("/projects");
        $(".NFxRR3").shouldBe(exist);
        $(".NFxRR3").shouldHave(text("Demo"));
        $$x("//a[@class = 'cx2QU4']").get(0).shouldHave(text("Demo"));
        Configuration.timeout = 5000;
    }

    @Test
    @Disabled
    public void createProjectStepsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("open login page", new Allure.ThrowableRunnableVoid() {
            @Override
            public void run() throws Throwable {
                open("/login");
            }
        });
        step("authorization", () -> {
            $("[name=email]").sendKeys("kubyox@mailto.plus");
            $("[name=password]").sendKeys("qaseio122024");
            $("[name=password]").submit();
        });
        step("create new project", () -> {
            $x("//span[text() = 'Create new project']").shouldBe(visible).click();
            $("#modal-header").shouldHave(text("Create new project"));
        });
        step("enter project name", () -> $("#project-name").sendKeys("Demo"));
        step("click create project", () -> {
            $x("//span[text() = 'Create project']").click();
        });
        step("open Projects page", () -> {
            open("/projects");
        });
        step("assert that project created", () -> {
            $(".NFxRR3").shouldBe(exist);
            $(".NFxRR3").shouldHave(text("Demo"));
            $$x("//a[@class = 'cx2QU4']").get(0).shouldHave(text("Demo"));
        });
        Configuration.timeout = 5000;
    }
}
