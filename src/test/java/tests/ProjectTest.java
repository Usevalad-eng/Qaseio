package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import java.time.LocalDateTime;
import java.util.Date;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ProjectTest extends BaseTest {

    @Test
    public void createProjectTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("/login");
        $("[name=email]").sendKeys("kubyox@mailto.plus");
        $("[name=password]").sendKeys("qaseio122024");
        $("[name=password]").submit();
        $x("//span[text() = 'Create new project']").shouldBe(visible).click();
        $("#modal-header").shouldHave(text("Create new project"));
        $("#project-name").sendKeys("Demo");
        //$("#project-code").sendKeys("Demo");
        $x("//span[text() = 'Create project']").click();
        open("/projects");
        $(".NFxRR3").shouldBe(exist);  //del
        $(".NFxRR3").shouldHave(text("Demo"));  //ok
        $$x("//a[@class = 'cx2QU4']").get(0).shouldHave(text("Demo"));  //del
    }
}
