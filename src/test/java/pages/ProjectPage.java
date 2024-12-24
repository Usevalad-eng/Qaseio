package pages;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ProjectPage extends BasePage{

    @Override
    @Step("Open Login Page")
    public void openLoginPage() {
        open("https://app.qase.io/login");
    }

    @Step("Project title is visible")
    public void projectPageIsOpened() {
        $("h1[class=uA6zAY]").shouldHave(text("Projects"));
    }

    @Step("Create new project")
    public void createNewProject() {
        $x("//span[text() = 'Create new project']").shouldBe(visible).click();
        //$("#modal-header").shouldHave(text("Create new project"));
    }

    @Step("Enter project name: {name}")
    public void enterProjectName(String name) {
        $("#project-name").sendKeys(name);
    }

    @Step("Click create project")
    public void clickCreateProject() {
        $x("//span[text() = 'Create project']").click();
    }

    @Step("Open Projects page")
    public void openProjectsPage() {
        open("/projects");
    }

    @Step("Assert that project {projName} created")
    public void assertThatProjectCreated(String projName) {
        $(".NFxRR3").shouldHave(text(projName));
    }

    @Step("Find menu")
    public void findMenu() {
        $x("//img[@alt = 'Test Name']").click();
    }

    @Step("Find exit")
    public void findExit() {
        $x("//*[text() = 'Sign out']").click();
    }

    @Step("Assert that exit")
    public void assertThatExit() {
        $(".ilHPl4").shouldBe(exist);
    }

    @Step("Can't create new project error can be seen")
    public void canNotCreateProjectErrorShouldBeVisible() {
        $x("//div[text() = 'The code must be at least 2 characters.']").shouldBe(visible);
    }

    @Attachment(value = "screen", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot() {
        return
                ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public boolean pageIsOpen(String title) {
        return super.pageIsOpen(title);
    }
}
