package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    @Feature("Auth")
    @Story("User can auth to a project")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Auth successful test")
    public void loginSuccessfulAuthTest() {
        loginPage.openLoginPage();
        loginPage.inputLogin("kubyox@mailto.plus");
        loginPage.inputPass("qaseio122024");
        loginPage.clickSubmit();
        loginPage.successfulLogin(); //assertTrue(projectPage.pageIsOpen("Projects"));  //check why it isn't working and delete
    }

    @Test
    @Feature("Auth")
    @Story("User can auth to a project")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("User should not be logged in using empty login and password")
    void userShouldNotBeLoggedInUsingEmptyData() {
        loginPage.openLoginPage();
        loginPage.inputLogin("");
        loginPage.inputPass("");
        loginPage.clickSignInButton();
        assertEquals(2, loginPage.getErrorMessagesCount(), "Something went wrong!");
    }

    @Test
    @Feature("Auth")
    @Story("User can auth to a project")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("User should not be loggedIn using empty login")
    void userShouldNotBeLoggedInUsingEmptyLogin() {
        loginPage.openLoginPage();
        loginPage.inputLogin("");
        loginPage.inputPass("qaseio122024");
        loginPage.clickSignInButton();
        assertEquals("This field is required", loginPage.getErrorMessage(), "Something went wrong!");
    }

    @Test
    @Feature("Auth")
    @Story("User can auth to a project")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("User should not be logged in using empty password")
    void userShouldNotBeLoggedInUsingEmptyPass() {
        loginPage.openLoginPage();
        loginPage.inputLogin("kubyox@mailto.plus");
        loginPage.inputPass("");
        loginPage.clickSignInButton();
        assertEquals("This field is required", loginPage.getErrorMessage(), "Something went wrong!");
    }

    static Stream<Arguments> qaseioAuthNegativeScenarios() {
        return Stream.of(
                Arguments.of("kubyox@mailto.plus", "", "This field is required"),
                Arguments.of("", "qaseio122024", "This field is required")
        );
    }
    @MethodSource("qaseioAuthNegativeScenarios")
    @ParameterizedTest(name = "Qaseio auth negative tests using JUnit5(empty pass or login)")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("User should not be logged in using empty password or login")
    void qaseioAuthNegativeScenarios(String login, String pass, String textOfExpectedMessage) {
        loginPage.openLoginPage();
        loginPage.inputLogin(login);
        loginPage.inputPass(pass);
        loginPage.clickSignInButton();
        String textOfActualMessage = loginPage.getErrorMessagesText();
        assertEquals(textOfExpectedMessage, textOfActualMessage, "Error, something went wrong!");
    }
}
