package UI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SignInPage extends BasePage{

    private static final Logger log = LoggerFactory.getLogger(SignInPage.class);

    private final By email = By.name("email");

    private final By password = By.name("password");

    private final By signInButton = By.className("TtGHT__primary--TtGHT");

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public boolean isEmailFieldDisplayed() {
        return getDriver().findElement(email).isDisplayed();
    }

    public boolean isPasswordFieldDisplayed() {
        return getDriver().findElement(password).isDisplayed();
    }

    public boolean isSignInButtonDisplayed() {
        return getDriver().findElement(signInButton).isDisplayed();
    }

    public void enterEmail(String emailString) {
        WebElement emailElem = getDriver().findElement(email);
        emailElem.clear();
        emailElem.sendKeys(emailString);

        log.info("Enter Email: {}", emailString);
    }

    public void enterPassword(String passwordString) {
        WebElement passwordElem = getDriver().findElement(password);
        passwordElem.clear();
        passwordElem.sendKeys(passwordString);

        log.info("Enter Password: {}", passwordString);
    }

    public void clickSignInButton() {
        getDriver().findElement(signInButton).click();

        log.info("Click Sign In Button");
    }
}
