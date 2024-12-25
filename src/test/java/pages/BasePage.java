package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public abstract class BasePage {

    private final String pageTitle = "//div[@id = 'application-content']//h1[text() = '%s']";

    @Step("Open login Page")
    public void openLoginPage(){
        open("/login");
    }

    public boolean pageIsOpen(String title){
        return $(String.format(title, pageTitle)).isDisplayed();
    }
}
