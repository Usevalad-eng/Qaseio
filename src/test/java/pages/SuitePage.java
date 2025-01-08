package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SuitePage extends BasePage{

    private final SelenideElement CREATE_SUITE_BUTTON = $x("//span[text() = 'Suite']");
    private final SelenideElement SUITE_NAME_INPUT = $("#title");
    private final SelenideElement CREATE_BUTTON = $x("//span[text() = 'Create']");
    private final SelenideElement SUITE_NAME = $("h3[class = 'IeCpCv']");

    @Step("Create new suite")
    public void createNewSuite() {
        CREATE_SUITE_BUTTON.shouldBe(visible).click();
    }

    @Step("Enter suite name: {name}")
    public void getSuiteName(String name) {
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
