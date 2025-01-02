package asserts;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class AssertEquals {

    public static void assertText(SelenideElement element, String text){
        element.shouldHave(Condition.text(text));
    }
}
