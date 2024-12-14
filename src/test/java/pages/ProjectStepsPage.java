package pages;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ProjectStepsPage {

    @Step("Open Login Page")
    public void openLoginPage() {
        open("/login");
    }

    @Step("Input login {login}")
    public void inputLogin(String login) {
        $("[name=email]").sendKeys(login);
    }

    @Step("Input pass: {pass}")
    public void inputPass(String pass) {
        $("[name=password]").sendKeys(pass);
    }

    @Step("submit")
    public void clickSubmit() {
        $("[name=password]").submit();
    }

    @Step("create new project")
    public void createNewProject() {
        $x("//span[text() = 'Create new project']").shouldBe(visible).click();
        $("#modal-header").shouldHave(text("Create new project"));
    }

    @Step("enter project name: {name}")
    public void enterProjectName(String name) {
        $("#project-name").sendKeys(name);
    }

    @Step("click create project")
    public void clickCreateProject() {
        $x("//span[text() = 'Create project']").click();
    }

    @Step("open Projects page")
    public void openProjectsPage() {
        open("/projects");
    }

    @Step("assert that project {projName} created")
    public void assertThatProjectCreated(String projName) {
        $(".NFxRR3").shouldHave(text(projName));
    }

    @Attachment(value = "screen", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot() {
        return
                ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}