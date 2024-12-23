package tests.headlesTests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import tests.base.BaseHeadlessTest;

public class LoginEmptyPassTest extends BaseHeadlessTest {

    LoginPage loginStepsPage = new LoginPage();

    @Test
    @DisplayName("User Should Not Be LoggedIn Using Empty Pass")
    void userShouldNotBeLoggedInUsingEmptyPass() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        loginStepsPage.openLoginPage();
        loginStepsPage.inputLogin("kubyox@mailto.plus");
        loginStepsPage.inputPass("");
        loginStepsPage.clickSignin();
        loginStepsPage.getErrorTwo();
    }
}
