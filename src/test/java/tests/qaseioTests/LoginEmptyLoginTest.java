package tests.qaseioTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.LoginStepsPage;
import tests.base.BaseHeadlessTest;

import static com.codeborne.selenide.Selenide.*;

public class LoginEmptyLoginTest extends BaseHeadlessTest {

    LoginStepsPage loginStepsPage = new LoginStepsPage();

    public String error1 = "This field is required";
    public String error2 = "This field is required";

    @Test
    void userShouldNotBeLoggedInUsingEmptyLogin() {
        loginStepsPage.openLoginPage();
        loginStepsPage.inputLogin("");
        loginStepsPage.inputPass("qaseio122024");
        loginStepsPage.clickSignin();
        /*open("/login");
        $("[name=email]").setValue("");
        $("[name=password]").setValue("qaseio122024");
        $("span[class=CAunhU]").click();*/
        /*String textOfMessageOne = $$x("//small[@class = 'f75Cb_']").get(0).getText();
        Assertions.assertEquals(error1, textOfMessageOne, "Error on the page!");*/
        loginStepsPage.getErrorOne();
    }

    @Test
    @Disabled
    void userShouldNotBeLoggedInUsingEmptyLoginScript() {
        open("/login");
        $("[name=email]").setValue("");
        $("[name=password]").setValue("qaseio122024");
        $("span[class=CAunhU]").click();
        String textOfMessageOne = $$x("//small[@class = 'f75Cb_']").get(0).getText();
        Assertions.assertEquals(error1, textOfMessageOne, "Error on the page!");
    }
}
