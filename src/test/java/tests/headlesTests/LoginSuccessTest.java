package tests.headlesTests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import tests.base.BaseTest;

public class LoginSuccessTest extends BaseTest {

    LoginPage loginStepsPage = new LoginPage();

    @Test
    @DisplayName("Auth successful Test")
    @Disabled
    public void loginSuccessfulAuthTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        loginStepsPage.openLoginPage();
        loginStepsPage.inputLogin("kubyox@mailto.plus");
        loginStepsPage.inputPass("qaseio122024");
        loginStepsPage.clickSubmit();
        loginStepsPage.successfulLogin();
    }
}
