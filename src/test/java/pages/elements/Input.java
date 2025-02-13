package pages.elements;

import static com.codeborne.selenide.Selenide.$x;

public class Input {

    public static void setValueInInputT(String placeholder, String value){
        $x("//input[@placeholder = '" + placeholder + "']").clear();
        $x("//input[@placeholder = '" + placeholder + "']").setValue(value);
    }
}
