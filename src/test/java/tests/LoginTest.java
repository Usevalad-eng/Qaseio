package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProjectPage;
import tests.base.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {
     LoginPage loginPage = new LoginPage();
     ProjectPage projectPage = new ProjectPage();

    @Test
    @DisplayName("Auth successful Test")
    //@Disabled
    public void loginSuccessfulAuthTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        loginPage.openLoginPage();
        loginPage.inputLogin("kubyox@mailto.plus");
        loginPage.inputPass("qaseio122024");
        loginPage.clickSubmit();
        loginPage.successfulLogin();
        //projectPage.pageIsOpen("Project");
        //projectPage.projectPageIsOpened();
        //assertTrue(projectPage.pageIsOpen("Project"));
        //Selenide.closeWebDriver();
    }

    @Test
    @DisplayName("User Should Not Be LoggedIn Using Empty Data")
    void userShouldNotBeLoggedInUsingEmptyData() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        loginPage.openLoginPage();
        loginPage.inputLogin("");
        loginPage.inputPass("");
        loginPage.clickSignin();
        //loginPage.getErrorOne();
        //loginPage.getErrorTwo();
        assertEquals(2, loginPage.getErrorMessagesCount(), "Error!");
    }

    @Test
    @DisplayName("User Should Not Be LoggedIn Using Empty Login")
    void userShouldNotBeLoggedInUsingEmptyLogin() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        loginPage.openLoginPage();
        loginPage.inputLogin("");
        loginPage.inputPass("qaseio122024");
        loginPage.clickSignin();
        //loginPage.getErrorOne();
        assertEquals("This field is required", loginPage.getErrorMessage(), "Something went wrong!");
    }

    @Test
    @DisplayName("User Should Not Be LoggedIn Using Empty Pass")
    void userShouldNotBeLoggedInUsingEmptyPass() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        loginPage.openLoginPage();
        loginPage.inputLogin("kubyox@mailto.plus");
        loginPage.inputPass("");
        loginPage.clickSignin();
        //loginPage.getErrorTwo();
        assertEquals("This field is required", loginPage.getErrorMessage(), "Something went wrong!");
    }
}