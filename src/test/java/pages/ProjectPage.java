package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Data;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.restassured.RestAssured.given;

@Data
public class ProjectPage extends BasePage {

    private final SelenideElement PROJECT_NAME_INPUT = $("#project-name");
    private final SelenideElement PROJECT_CODE_INPUT = $("#project-code");
    private final SelenideElement PROJECT_TEXT = $("h1[class=uA6zAY]");
    private final SelenideElement CREATE_NEW_PROJECT_BUTTON = $x("//span[text() = 'Create new project']");
    private final SelenideElement CREATE_PROJECT_BUTTON = $x("//span[text() = 'Create project']");
    private final SelenideElement RECEIVE_PROJECT_NAME = $("a[class = cx2QU4]");
    private final SelenideElement PROJECT_NAME = $(".NFxRR3");
    private final SelenideElement MENU_BUTTON = $x("//img[@alt = 'Test Name']");
    private final SelenideElement SIGN_OUT_BUTTON = $x("//*[text() = 'Sign out']");
    private final SelenideElement QASE_LOGO = $(".ilHPl4");
    private final SelenideElement PROJ_NAME = $(".cx2QU4");
    private final SelenideElement PROJ_ERROR = $x("//div[text()='The code must be at least 2 characters.']");
    private final ElementsCollection DOTS_BUTTON = $$x("//span[@class = 'qc0jO1']");
    private final SelenideElement DELETE_BUTTON = $x("//div[@data-testid = 'remove']");
    private final SelenideElement DELETE_PROJECT_BUTTON = $x("//span[text() = 'Delete project']");
    private final SelenideElement PROJECT_INPUT = $x("//label[text() = 'Project name']/../..//input");

    @Override
    @Step("Open Login Page")
    public void openLoginPage() {
        open("https://app.qase.io/login");
    }

    @Step("Project title is visible")
    public void projectPageIsOpened() {
        PROJECT_TEXT.shouldHave(text("Projects"));
    }

    @Step("Create new project")
    public void createNewProject() {
        CREATE_NEW_PROJECT_BUTTON.shouldBe(visible).click();
    }

    @Step("Enter project name: {name}")
    public void inputProjectName(String name) {
        PROJECT_NAME_INPUT.sendKeys(name);
    }

    @Step("Enter project code: {code}")
    public void inputProjectCode(String code) {
        PROJECT_CODE_INPUT.sendKeys(code);
    }

    @Step("Receive project name(actual)")
    public String receiveProjectName() {
        open("/projects");
        return RECEIVE_PROJECT_NAME.getText();
    }

    @Step("Receive proj name(expected)")
    public String receiveProjName() {
        return PROJECT_CODE_INPUT.getText();
    }

    @Step("Click create project")
    public void createProject() {
        CREATE_PROJECT_BUTTON.click();
    }

    @Step("Open Projects page")
    public void openProjectsPage() {
        open("/projects");
    }

    @Step("Assert that project {projName} created")
    public void assertThatProjectCreated(String projName) {
        PROJECT_NAME.shouldHave(text(projName));
    }

    @Step("Find menu")
    public void findMenu() {
        MENU_BUTTON.click();
    }

    @Step("Find exit")
    public void findExit() {
        SIGN_OUT_BUTTON.click();
    }

    @Step("Assert that exit")
    public void assertThatExit() {
        QASE_LOGO.shouldBe(exist);
    }

    @Step("Can't create new project error can be seen")
    public void canNotCreateProjectErrorShouldBeVisible() {
        PROJ_ERROR.shouldBe(visible);
    }

    @Step("Assert that project deleted")
    public void assertThatProjCreated() {
        open("/projects");
        PROJ_NAME.shouldBe(visible);
    }

    @Step("Assert project name")
    public void assertProjectName(String text) {
        open("/projects");
        PROJECT_CODE_INPUT.shouldHave(text(text));
    }

    @Step("Find and click Dots")
    public void findDots() {
        DOTS_BUTTON.get(5).click();
    }

    @Step("Click Delete button")
    public void deleteButton() {
        DELETE_BUTTON.shouldBe(visible).click();
    }

    @Step("Click Delete project button")
    public void deleteProject() {
        DELETE_PROJECT_BUTTON.shouldBe(visible).click();
    }

    @Step("Assert that project deleted")
    public void assertThatProjDeleted() {
        open("/projects");
        PROJ_NAME.shouldBe(not(visible));
    }

    /*@Step("Del project 'Demo'")
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
    }*/

    @Override
    public boolean pageIsOpen(String title) {
        return super.pageIsOpen(title);
    }
}
