package UI.pages;

import UI.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DashboardPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(DashboardPage.class);

    private final By dashboard = By.className("uS6W6__cardBodyWrapper--uS6W6");

    private final By office365 = By.className("B_3lU__cardContent--B_3lU");

    private final By popupConnector = By.className("l5xWJ__prepareStep--l5xWJ");

    private final By popupConnectorCheckboxes = By.className("x_Jss__checkbox--x_Jss");

    private final By popupConnectorCreateButton = By.className("TtGHT__primary--TtGHT");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void waitForPageToLoad() {
        waitForElementToBeClickable(dashboard, PageObject.DEFAULT_WAIT_TIME);
    }

    public boolean isOffice365Displayed() {
        return getDriver().findElement(office365).isDisplayed();
    }

    public boolean isPopupConnectorDisplayed() {
        return getDriver().findElement(popupConnector).isDisplayed();
    }

    public boolean isPopupConnectorCreateButtonClickable() {
        return getDriver().findElement(popupConnector).isEnabled();
    }

    public void clickOffice365() {
        getDriver().findElement(office365).click();

        log.info("Click Office 365 Connector");
    }

    public void clickPopupConnectorCheckboxes() {
        List<WebElement> elements = getDriver().findElements(popupConnectorCheckboxes);
        elements.forEach(element -> {
            WebElement checkbox = element.findElement(By.tagName("input"));
            while (!checkbox.isSelected()) {
                waitForElementToBeClickable(element, DEFAULT_WAIT_TIME);
                getActions().moveToElement(element).click().build().perform();
            }
        });

        log.info("Click Popup Connector Checkboxes");
    }

    public void clickPopupConnectorCreateButton() {
        WebElement element = getDriver().findElement(popupConnectorCreateButton);
        getActions().moveToElement(element).click().build().perform();

        log.info("Click Popup Connector Create Button");
    }
}
