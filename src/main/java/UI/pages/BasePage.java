package UI.pages;

import UI.PageObject;
import org.openqa.selenium.WebDriver;

public abstract class BasePage extends PageObject {

    //locators

    public BasePage(WebDriver driver) {
        super(driver);
    }
}
