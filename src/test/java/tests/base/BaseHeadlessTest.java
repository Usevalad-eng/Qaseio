package tests.base;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseHeadlessTest {
    @BeforeAll
    static void screenResolution() {
        Configuration.baseUrl = "https://app.qase.io";
        Configuration.headless = true;
    }
}
