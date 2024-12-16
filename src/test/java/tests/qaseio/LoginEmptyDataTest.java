package tests.qaseio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginStepsPage;
import tests.base.BaseTest;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$x;

public class LoginEmptyDataTest extends BaseTest {

    LoginStepsPage loginStepsPage = new LoginStepsPage();

    public String error1 = "This field is required";
    public String error2 = "This field is required";

    @Test
    void userShouldNotBeLoggedInUsingEmptyData() {
        open("/login");
        $("[name=email]").setValue("");
        $("[name=password]").setValue("");
        $("span[class=CAunhU]").click();
        String textOfMessageOne = $$x("//small[@class = 'f75Cb_']").get(0).getText();
        Assertions.assertEquals(error1, textOfMessageOne, "Error on the page!");
        String textOfMessageTwo = $$x("//small[@class = 'f75Cb_']").get(1).getText();
        Assertions.assertEquals(error2, textOfMessageTwo, "Error on the page!");
    }
}
