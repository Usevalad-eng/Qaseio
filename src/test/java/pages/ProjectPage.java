package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import tests.api.pojos.request.project.CreateProjectRequest;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static pages.elements.Button.clickButton;
import static pages.elements.Input.setValueInInputT;

public class ProjectPage extends BasePage {

    private final SelenideElement PROJECT_NAME_INPUT = $("#project-name");
    private final SelenideElement PROJECT_TEXT = $("h1[class=uA6zAY]");
    private final SelenideElement CREATE_NEW_PROJECT_BUTTON = $x("//span[text() = 'Create new project']");
    private final SelenideElement CREATE_PROJECT_BUTTON = $x("//span[text() = 'Create project']");
    private final SelenideElement PROJ_NAME = $(".cx2QU4");
    private final SelenideElement PROJ_ERROR = $x("//div[text()='The code must be at least 2 characters.']");
    private final ElementsCollection DOTS_BUTTON = $$x("//span[@class = 'qc0jO1']");
    private final SelenideElement DELETE_BUTTON = $x("//div[@data-testid = 'remove']");
    private final SelenideElement DELETE_PROJECT_BUTTON = $x("//span[text() = 'Delete project']");
    private final SelenideElement PROJECT_CODE = $x("//h1[@class = 'pOpqJc']");

    @Override
    @Step("Open Login Page")
    public void openLoginPage() {
        open("https://app.qase.io/login");
    }

    @Step("Open Projects page")
    public void openProjectsPage() {
        open("/projects");
    }

    @Step("Click create new project button")
    public void clickCreateNewProjectButton(){
        clickButton("Create new project");
    }

    @Step("Create")
    public void create(CreateProjectRequest project){
        setValueInInputT("For example: Web Application", project.getTitle());
        setValueInInputT("For example: WA", project.getCode());
        clickButton("Create project");
    }

    @Step("Project title is visible")
    public void projectPageIsOpened() {
        PROJECT_TEXT.shouldHave(text("Projects"));
    }

    @Step("Click Create new project button")
    public void createNewProjectButtonToClick() {
        CREATE_NEW_PROJECT_BUTTON.shouldBe(visible).click();
    }

    @Step("Enter project name: {name}")
    public void inputProjectName(String name) {
        PROJECT_NAME_INPUT.sendKeys(name);
    }

    @Step("Click Create project button")
    public void createProjectButtonToClick() {
        CREATE_PROJECT_BUTTON.click();
    }

    @Step("Can't create new project error can be seen")
    public void canNotCreateProjectErrorShouldBeVisible() {
        PROJ_ERROR.shouldBe(visible);
    }

    @Step("Check that project created")
    public void checkThatProjCreated() {
        open("/projects");
        PROJ_NAME.shouldBe(visible);
    }

    @Step("Click on project")
    public void clickOnProject() {
        open("/projects");
        PROJ_NAME.click();
    }

    @Step("Contains project")
    public void assertThatProjContainsProjCode(String projCode) {
        PROJECT_CODE.getText().contains(projCode);
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

    @Override
    public boolean pageIsOpen(String title) {
        return super.pageIsOpen(title);
    }
}
