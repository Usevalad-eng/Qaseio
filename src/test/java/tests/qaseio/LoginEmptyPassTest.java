package tests.qaseio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginStepsPage;
import tests.base.BaseTest;

import static com.codeborne.selenide.Selenide.*;

public class LoginEmptyPassTest extends BaseTest {

    LoginStepsPage loginStepsPage = new LoginStepsPage();

    public String error1 = "This field is required";
    public String error2 = "This field is required";

    @Test
    void userShouldNotBeLoggedInUsingEmptyPass() {
        open("/login");
        $("[name=email]").setValue("kubyox@mailto.plus");
        $("[name=password]").setValue("");
        $("span[class=CAunhU]").click();
        String textOfMessageTwo = $$x("//small[@class = 'f75Cb_']").get(0).getText();
        Assertions.assertEquals(error2, textOfMessageTwo, "Error on the page!");
    }
}
