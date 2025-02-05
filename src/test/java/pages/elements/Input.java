package pages.elements;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class Input {

    private static final String inputLocator = "//input[@placeholder = '%s']";
    public static void setValueInInput(String placeholder, String value){
        $x(format(inputLocator, placeholder)).clear();
        $x(format(inputLocator, placeholder)).setValue(value);
    }

    public static void setValueInInputT(String placeholder, String value){
        $x("//input[@placeholder = '" + placeholder + "']").clear();
        $x("//input[@placeholder = '" + placeholder + "']").setValue(value);
    }
}
