package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import models.CaseBuilder;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CasePage extends BasePage {

    private final SelenideElement CREATE_CASE_BUTTON = $x("//span[text() = 'Case']");
    private final SelenideElement CASE_NAME_INPUT = $("#title");
    private final SelenideElement SAVE_BUTTON = $x("//span[text() = 'Save']");
    private final SelenideElement CASE_NAME = $x("//div[@class = 'YkyiUm t1vo_q']");
    private final SelenideElement RECEIVE_CASE_NAME = $x("//div[@class = 'YkyiUm t1vo_q']");
    private final SelenideElement CASE_ZERO =
            $x("//small[text() = '0 test cases  |  1 suite  |  No active runs']");

    private final SelenideElement ADD_STEP_BUTTON = $x("//span[text() = ' Add step']");

    //private final SelenideElement STEP_ACTION = $$x("//div[@class = 'ProseMirror toastui-editor-contents']//p").get(3);
    private final SelenideElement STEP_ACTION =$x("//*[@id=\"application-content\"]/div/div[2]/form/div[1]/div[14]/div[1]/div/div/div/div[2]/div/div[1]/div/div/div/div[2]/div/div[2]/div/div/p");

    //private final SelenideElement STEP_RESULT = $$x("//p").get(6);  //$x("//span[text() = 'Expected result']");
    private final SelenideElement STEP_RESULT = $x("//*[@id=\"application-content\"]/div/div[2]/form/div[1]/div[14]/div[1]/div/div/div/div[2]/div/div[3]/div/div/div/div[2]/div/div[2]/div/div/p");
    // //*[@id="application-content"]/div/div[2]/form/div[1]/div[14]/div[1]/div/div/div/div[2]/div/div[3]/div/div/div/div[2]/div/div[2]/div/div/p

    @Step("Create new case")
    public void createNewCase() {
        CREATE_CASE_BUTTON.click();
    }

    @Step("Enter case name: {name}")
    public void inputCaseName(String name) {
        CASE_NAME_INPUT.sendKeys(name);
    }

    @Step("Enter case name: {name}")
    public void inputCaseAll(String name) {
    }

    @Step("Click create case")
    public void createCase() {
        //Selenide.actions().scrollToElement(SAVE_BUTTON);
        SAVE_BUTTON.shouldBe(visible).click();
    }

    @Step("Assert that case {name} created")
    public void assertThatCaseCreated(String name) {
        CASE_NAME.shouldHave(text(name));
    }

    @Step("Receive case name(actual)")
    public String receiveCaseName() {
        return RECEIVE_CASE_NAME.getText();
    }

    @Step("Assert that case {name} is not created")
    public void assertThatCaseCanNotCreated() {
        CASE_ZERO.shouldBe(visible);
    }


    @Step("Add step")
    public void addStep() {
        //Selenide.actions().scrollToElement(ADD_STEP_BUTTON);
        ADD_STEP_BUTTON.shouldBe(visible).click();
    }

    @Step("Add step")
    public void fillStep() {
       //STEP_ACTION.doubleClick().sendKeys("1");
       STEP_ACTION.sendKeys(CaseBuilder.getAllFields().getStepAction());  //todo - to change selector
       //Selenide.actions().scrollToElement(SAVE_BUTTON);
       //STEP_RESULT.click();
       //STEP_RESULT.sendKeys(CaseBuilder.getAllFields().getStepResult());
    }

    @Override
    @Step("Open login Page")
    public void openLoginPage() {
        open("https://app.qase.io/login");
    }

    @Override
    @Step("Is page opened")
    public boolean pageIsOpen(String title) {
        return super.pageIsOpen(title);
    }
}
