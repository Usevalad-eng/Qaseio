package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginStepsPage;
import tests.base.BaseHeadlessTest;
import tests.base.BaseTest;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$x;

public class LoginTest extends BaseTest {

    LoginStepsPage loginStepsPage = new LoginStepsPage();

    public String error1 = "This field is required";
    public String error2 = "This field is required";

    @Test
    public void loginSuccessfulTest(){
        loginStepsPage.openLoginPage();
        loginStepsPage.inputLogin("kubyox@mailto.plus");
        loginStepsPage.inputPass("qaseio122024");
        loginStepsPage.clickSubmit();
        loginStepsPage.successfulLogin();
    }

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

    @Test
    void userShouldNotBeLoggedInUsingEmptyPass() {
        open("/login");
        $("[name=email]").setValue("kubyox@mailto.plus");
        $("[name=password]").setValue("");
        $("span[class=CAunhU]").click();
        String textOfMessageTwo = $$x("//small[@class = 'f75Cb_']").get(0).getText();
        Assertions.assertEquals(error2, textOfMessageTwo, "Error on the page!");
    }

    @Test
    void userShouldNotBeLoggedInUsingEmptyLogin() {
        open("/login");
        $("[name=email]").setValue("");
        $("[name=password]").setValue("qaseio122024");
        $("span[class=CAunhU]").click();
        String textOfMessageOne = $$x("//small[@class = 'f75Cb_']").get(0).getText();
        Assertions.assertEquals(error1, textOfMessageOne, "Error on the page!");
    }
}
