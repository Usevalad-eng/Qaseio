package tests.base;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseSTest {
    @BeforeAll
    static void screenResolution() {
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "109.0";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 5000;
    }
}
