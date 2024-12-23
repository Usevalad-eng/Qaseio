package tests.headlesTests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import tests.base.BaseHeadlessTest;

public class LoginEmptyLoginTest extends BaseHeadlessTest {

    LoginPage loginStepsPage = new LoginPage();

    @Test
    @DisplayName("User Should Not Be LoggedIn Using Empty Login")
    void userShouldNotBeLoggedInUsingEmptyLogin() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        loginStepsPage.openLoginPage();
        loginStepsPage.inputLogin("");
        loginStepsPage.inputPass("qaseio122024");
        loginStepsPage.clickSignin();
        loginStepsPage.getErrorOne();
    }
}
