package tests.ui;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tests.BaseTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("UI")
public class LoginTest extends BaseTest {

    @Test
    @Feature("Auth")
    @Story("User can authorize to the application")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Auth successful test")
    public void loginSuccessfulAuthTest() {
        loginPage.openLoginPage();
        loginPage.inputLogin(email);
        loginPage.inputPass(password);
        loginPage.clickSubmit();
        loginPage.successfulLogin();
    }

    @Test
    @Feature("Auth")
    @Story("User can  authorize to the application")
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

    static Stream<Arguments> qaseioAuthNegativeScenarios() {
        return Stream.of(
                Arguments.of("kubyox@mailto.plus", "", "This field is required"),
                Arguments.of("", "qaseio122024", "This field is required")
        );
    }

    @MethodSource("qaseioAuthNegativeScenarios")
    @ParameterizedTest(name = "Qaseio auth negative tests using JUnit5(empty pass or login)")
    @Severity(SeverityLevel.NORMAL)
    @Story("User can  authorize to the application")
    @Owner("Vsevolod")
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
