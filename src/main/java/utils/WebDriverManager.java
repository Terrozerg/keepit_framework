package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {

    private static WebDriver webdriver;

    //TODO add different browser support if needed
    private static WebDriver getDriverInstance() {
        if (webdriver == null) {
            webdriver = new ChromeDriver();
        }

        return webdriver;
    }

    public static WebDriver getWebDriver() {
        return getDriverInstance();
    }
}
