package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Data;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.restassured.RestAssured.given;

//@Data
public class ProjectPage extends BasePage {

    private final SelenideElement PROJECT_NAME_INPUT = $("#project-name");
    private final SelenideElement PROJECT_CODE_INPUT = $("#project-code");

    private final SelenideElement PROJECT_INPUT = $x("//label[text() = 'Project name']/../..//input");

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
    public void getProjectName(String name) {
        PROJECT_NAME_INPUT.sendKeys(name);
    }

    @Step("Enter project code: {code}")
    public void getProjectCode(String code) {
        PROJECT_CODE_INPUT.sendKeys(code);
    }

    @Step("Receive project name(actual)")
    public String receiveProjectName() {
        open("/projects");
        return $("a[class = cx2QU4]").getText();
    }

    @Step("Receive proj name(expected)")
    public String receiveProjName() {
        return PROJECT_CODE_INPUT.getText();
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

    @Step("Find exit")
    public void assertThatProjCreated() {
        open("/projects");
        $(".cx2QU4").shouldBe(visible);
    }

    @Step("Assert project name")
    public void assertProjectName(String text) {
        open("/projects");
        PROJECT_CODE_INPUT.shouldHave(text(text));
    }

    /*@Attachment(value = "screen", type = "image/png", fileExtension = "png")
public byte[] attachScreenshot() {
    return
            ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
}*/

    @Step("Del project 'Demo'")
    public void delProj() {
        given()
                .header("Token", "8712b8dd5d9089dac78e3e50b649233346b7f122015027677ef032f5b55fc9e8")
                .log().uri()
                .when()
                .delete("https://api.qase.io/v1/project/DEMO")
                .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }

    @Override
    public boolean pageIsOpen(String title) {
        return super.pageIsOpen(title);
    }
}
