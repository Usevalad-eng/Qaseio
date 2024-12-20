package tests.selenoidTests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import tests.base.BaseSelenoidTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Selenoid2Test extends BaseSelenoidTest {

    @Test
    @Disabled
    public void userShouldBeLoggedInUsingValidData() {
        open("https://app.qase.io/login");
        $("[name=email]").setValue("kubyox@mailto.plus");
        $("[name=password]").setValue("qaseio122024");
        $("span[class=CAunhU]").click();
        $("h1[class=uA6zAY]").shouldHave(text("Projects"));
    }

    @Test
    @Disabled
    void searchTest() {
        open("https://www.google.com");
        $("[name=q]").setValue("Selenoid").pressEnter();
        $("h3").shouldBe(Condition.visible);
    }
}
