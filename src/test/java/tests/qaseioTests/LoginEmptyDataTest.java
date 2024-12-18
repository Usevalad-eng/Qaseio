package tests.qaseioTests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginStepsPage;
import tests.base.BaseHeadlessTest;

public class LoginEmptyDataTest extends BaseHeadlessTest {

    LoginStepsPage loginStepsPage = new LoginStepsPage();

    @Test
    @DisplayName("User Should Not Be LoggedIn Using Empty Data")
    void userShouldNotBeLoggedInUsingEmptyData() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        loginStepsPage.openLoginPage();
        loginStepsPage.inputLogin("");
        loginStepsPage.inputPass("");
        loginStepsPage.clickSignin();
        loginStepsPage.getErrorOne();
        loginStepsPage.getErrorTwo();
    }
}
