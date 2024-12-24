package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import tests.base.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTest {
     LoginPage loginPage = new LoginPage();
     //ProjectPage projectPage = new ProjectPage();

    @Test
    @DisplayName("Auth successful test")
    public void loginSuccessfulAuthTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        loginPage.openLoginPage();
        loginPage.inputLogin("kubyox@mailto.plus");
        loginPage.inputPass("qaseio122024");
        loginPage.clickSubmit();
        loginPage.successfulLogin();
        //assertTrue(projectPage.pageIsOpen("Project"));
    }

    @Test
    @DisplayName("User should not be logged in using empty data")
    void userShouldNotBeLoggedInUsingEmptyData() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        loginPage.openLoginPage();
        loginPage.inputLogin("");
        loginPage.inputPass("");
        loginPage.clickSignInButton();
        assertEquals(2, loginPage.getErrorMessagesCount(), "Something went wrong!");
    }

    @Test
    @DisplayName("User should not be loggedIn using empty login")
    void userShouldNotBeLoggedInUsingEmptyLogin() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        loginPage.openLoginPage();
        loginPage.inputLogin("");
        loginPage.inputPass("qaseio122024");
        loginPage.clickSignInButton();
        assertEquals("This field is required", loginPage.getErrorMessage(), "Something went wrong!");
    }

    @Test
    @DisplayName("User should not be logged in using empty Password")
    void userShouldNotBeLoggedInUsingEmptyPass() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        loginPage.openLoginPage();
        loginPage.inputLogin("kubyox@mailto.plus");
        loginPage.inputPass("");
        loginPage.clickSignInButton();
        assertEquals("This field is required", loginPage.getErrorMessage(), "Something went wrong!");
    }
}
