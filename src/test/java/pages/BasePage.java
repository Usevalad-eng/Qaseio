package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    private final String pageTitle = "//div[@id = 'application-content']//h1[text() = '%s']";

    public boolean pageIsOpen(String title){
        return $(String.format(pageTitle, title)).isDisplayed();
    }
}
