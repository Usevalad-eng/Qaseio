package pages.elements;

import static com.codeborne.selenide.Selenide.$x;

public class Input {

    public static String inputLocator = "//label[text()='%s']/../..//input";

    public static void setValueInInput(String label, String value){
        $x(String.format(inputLocator, label)).setValue(value);
    }

    public static void setValueInInputT(String placeholder, String value){
        $x("//input[@placeholder = '" + placeholder + "']").clear();
        $x("//input[@placeholder = '" + placeholder + "']").setValue(value);
    }
}
