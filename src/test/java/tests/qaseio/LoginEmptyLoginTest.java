package tests.qaseio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginStepsPage;
import tests.base.BaseHeadlessTest;
import tests.base.BaseTest;

import static com.codeborne.selenide.Selenide.*;

public class LoginEmptyLoginTest extends BaseHeadlessTest {

    LoginStepsPage loginStepsPage = new LoginStepsPage();

    public String error1 = "This field is required";
    public String error2 = "This field is required";

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
