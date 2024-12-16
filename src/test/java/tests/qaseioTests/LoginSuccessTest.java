package tests.qaseioTests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.LoginStepsPage;
import tests.base.BaseTest;

public class LoginSuccessTest extends BaseTest {

    LoginStepsPage loginStepsPage = new LoginStepsPage();

    public String error1 = "This field is required";
    public String error2 = "This field is required";

    @Test
    @Disabled
    public void loginSuccessfulTest(){
        loginStepsPage.openLoginPage();
        loginStepsPage.inputLogin("kubyox@mailto.plus");
        loginStepsPage.inputPass("qaseio122024");
        loginStepsPage.clickSubmit();
        loginStepsPage.successfulLogin();
    }

    /*@Test
    @Disabled
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
    @Disabled
    void userShouldNotBeLoggedInUsingEmptyPass() {
        open("/login");
        $("[name=email]").setValue("kubyox@mailto.plus");
        $("[name=password]").setValue("");
        $("span[class=CAunhU]").click();
        String textOfMessageTwo = $$x("//small[@class = 'f75Cb_']").get(0).getText();
        Assertions.assertEquals(error2, textOfMessageTwo, "Error on the page!");
    }

    @Test
    @Disabled
    void userShouldNotBeLoggedInUsingEmptyLogin() {
        open("/login");
        $("[name=email]").setValue("");
        $("[name=password]").setValue("qaseio122024");
        $("span[class=CAunhU]").click();
        String textOfMessageOne = $$x("//small[@class = 'f75Cb_']").get(0).getText();
        Assertions.assertEquals(error1, textOfMessageOne, "Error on the page!");
    }*/
}
