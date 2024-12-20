package tests.selenoidTests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Selenoid3Test {

    @BeforeAll
    public static void setUp() {
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = "chrome";
    }

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
    public void userCanSearch() {
        open("https://www.google.com");
        $("[name='q']").setValue("Selenide").pressEnter();
        $$("#search .g").shouldHave(sizeGreaterThan(1));
    }

    @Test
    @Disabled
    void test() {
        Assertions.assertTrue(true);
    }
}
