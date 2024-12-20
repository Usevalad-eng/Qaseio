package tests.scriptTests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

public class ScriptTrueTest extends BaseTest {

    @Test
    @Disabled
    void test(){
        Assertions.assertTrue(true);
    }
}
