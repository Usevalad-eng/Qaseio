package tests.base;

import com.codeborne.selenide.Configuration;

public class BaseSelenoidConfigTest {
    public static void configure() {
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = "chrome";
        //Configuration.browserVersion = "latest";
        Configuration.browserSize = "1920x1080";
        //Configuration.timeout = 10000;
    }
}