package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage {

    private final SelenideElement LOGIN_INPUT = $("[name=email]");   //$x("//input[@name='email']");
    private final SelenideElement PASS_INPUT = $("[name=password]");    //$x("//input[@name='password']");
    private final SelenideElement SIGN_IN_BUTTON = $("span[class=CAunhU]");
    private final ElementsCollection ERROR_MESSAGE = $$x("//small[@class = 'f75Cb_']");
    private final SelenideElement PROJECTS_TEXT = $("h1[class=uA6zAY]");

    @Override
    @Step("Open login Page")
    public void openLoginPage() {
        open("/login");
    }

    @Step("Input login {login}")
    public void inputLogin(String login) {
        LOGIN_INPUT.setValue(login);  //LOGIN_INPUT.sendKeys(login);
    }

    @Step("Input pass: {pass}")
    public void inputPass(String pass) {
        PASS_INPUT.setValue(pass);  //PASS_INPUT.sendKeys(pass);
    }

    @Step("Submit")
    public void submit() {
        PASS_INPUT.submit();
    }

    @Step("Click sign in button")
    public void clickSignInButton() {
        SIGN_IN_BUTTON.click();
    }

    @Step("Successful login")
    public void successfulLogin() {
        PROJECTS_TEXT.shouldHave(text("Projects"));
    }

    @Step("Get error message count")
    public Integer getErrorMessagesCount() {
        return ERROR_MESSAGE.size();
    }

    @Step("Get error message")
    public String getErrorMessagesText() {
        return ERROR_MESSAGE.get(0).getText();
    }

    @Override
    public boolean pageIsOpen(String title) {
        return super.pageIsOpen(title);
    }
}
