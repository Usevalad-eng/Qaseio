package tests.scriptTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tests.base.BaseHeadlessTest;
import tests.base.BaseSTest;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;

public class STest extends BaseHeadlessTest {
    static Stream<Arguments> qaseioAuthNegativeScenarios() {
        return Stream.of(
                Arguments.of("kubyox@mailto.plus", "", "This field is required"),
                Arguments.of("", "qaseio122024", "This field is required")
        );
    }
    @MethodSource("qaseioAuthNegativeScenarios")
    @ParameterizedTest(name = "Qaseio auth negative tests using JUnit5(empty pass or login)")
    void qaseioAuthNegativeScenarios(String login, String pass, String errorOne) {
        open("/login");
        $("[name=email]").setValue(login);
        $("[name=password]").setValue(pass);
        $("span[class=CAunhU]").click();
        String textOfMessageOne = $$x("//small[@class = 'f75Cb_']").get(0).getText();
        Assertions.assertEquals(errorOne, textOfMessageOne, "Error on the page!");
    }
}
