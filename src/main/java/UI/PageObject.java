package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public abstract class PageObject {

    private WebDriver driver;

    private Actions actions;

    public static final int DEFAULT_WAIT_TIME = 10;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Actions getActions() {
        return actions;
    }

    public void waitForPageToLoad(int timeOut) {
        new WebDriverWait(driver, Duration.ofSeconds(timeOut))
                .until(webDriver -> Objects.equals(((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState"), "complete"));
    }

    public void waitForElementToBeClickable(By element, int timeOut) {
        new WebDriverWait(driver, Duration.ofSeconds(timeOut)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeClickable(WebElement element, int timeOut) {
        new WebDriverWait(driver, Duration.ofSeconds(timeOut)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToDisappear(By element, int timeOut) {
        new WebDriverWait(driver, Duration.ofSeconds(timeOut)).until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public void waitForTitleToContain(String title, int timeOut) {
        new WebDriverWait(driver, Duration.ofSeconds(timeOut)).until(ExpectedConditions.titleContains(title));
    }

    public void waitForAjaxToComplete(int timeOut) {
        new WebDriverWait(driver, Duration.of(timeOut, ChronoUnit.SECONDS))
                .until(webDriver -> Objects.requireNonNull(((JavascriptExecutor) webDriver)
                        .executeScript("return window.jQuery != undefined && jQuery.active == 0;")));
    }
}
