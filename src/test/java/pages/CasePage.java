package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

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
        /*CASE_NAME_INPUT.sendKeys(name);*/
    }

    @Step("Click create case")
    public void createCase() {
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
