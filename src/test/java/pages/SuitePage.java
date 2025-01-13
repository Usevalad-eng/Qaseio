package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SuitePage extends BasePage {

    private final SelenideElement CREATE_SUITE_BUTTON = $x("//span[text() = 'Suite']");
    private final SelenideElement SUITE_NAME_INPUT = $("#title");
    private final SelenideElement CREATE_BUTTON = $x("//span[text() = 'Create']");
    private final SelenideElement SUITE_NAME = $("h3[class = 'IeCpCv']");
    private final SelenideElement RECEIVE_SUITE_NAME = $x("//a[@class = 'ZofjAx z7H5tt']");

    @Step("Create new suite")
    public void createNewSuite() {
        CREATE_SUITE_BUTTON.shouldBe(visible).click();
    }

    @Step("Enter suite name: {name}")
    public void inputSuiteName(String name) {
        SUITE_NAME_INPUT.sendKeys(name);
    }

    @Step("Click create suite")
    public void createSuite() {
        CREATE_BUTTON.click();
    }

    @Step("Assert that suite {name} created")
    public void assertThatSuiteCreated(String name) {
        SUITE_NAME.shouldHave(text(name));
    }

    @Step("Receive suite name(actual)")
    public String receiveSuiteName() {
        return RECEIVE_SUITE_NAME.getText();
    }

    @Step("Open suite Page")
    public void openSuitePage() {
        open("https://app.qase.io/project/DEMO");
    }

    @Step("Assert that suite {name} not created")
    public void assertThatSuiteNotCreated() {
        SUITE_NAME.shouldNotBe(visible);
    }

    @Override
    @Step("Open login page")
    public void openLoginPage() {
        open("https://app.qase.io/login");
    }

    @Override
    @Step("Is page opened")
    public boolean pageIsOpen(String title) {
        return super.pageIsOpen(title);
    }
}
