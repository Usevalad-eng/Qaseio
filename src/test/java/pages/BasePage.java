package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public abstract class BasePage {

    @Step("Open login Page")
    public void openLoginPage(){
        open("/login");
    }

    @Step("Is page opened")
    public boolean pageIsOpen(String title){
        String pageTitle = "//div[@id = 'application-content']//h1[text() = '%s']";
        return $x(String.format(pageTitle, title)).isDisplayed();
    }
}
