package pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LoginStepsPage {


    @Step("Open Login Page")
    public void openLoginPage(){
        open("https://app.qase.io/login");
    }

    @Step("Input login {login}")
    public void inputLogin(String login){
        $("[name=email]").sendKeys(login);
    }

    @Step("Input pass: {pass}")
    public void inputPass(String pass){
        $("[name=password]").sendKeys(pass);
    }

    @Step("click submit")
    public void clickSubmit(){
        $("[name=password]").submit();
    }

    @Step("click submit")
    public void clickSignin(){
        $("span[class=CAunhU]").click();
    }

    @Step("successful Login")
    public void successfulLogin(){
        $("h1[class=uA6zAY]").shouldHave(text("Projects"));
    }

    @Step("get error one")
    public void getErrorOne(){
        String textOfMessageOne = $$x("//small[@class = 'f75Cb_']").get(0).getText();
        Assertions.assertEquals("This field is required", textOfMessageOne, "Error on the page!");
    }

    @Step("get error two")
    public void getErrorTwo(){
        String textOfMessageTwo = $$x("//small[@class = 'f75Cb_']").get(0).getText();
        Assertions.assertEquals("This field is required", textOfMessageTwo, "Error on the page!");
    }
}
