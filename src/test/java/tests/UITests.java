package tests;

import UI.factory.PageFactoryManager;
import UI.pages.DashboardPage;
import UI.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.PropertiesHelper;
import utils.WebDriverManager;

import static UI.PageObject.DEFAULT_WAIT_TIME;

public class UITests {

    private WebDriver driver;

    private PageFactoryManager pageFactoryManager;

    private SignInPage signInPage;

    private DashboardPage dashboardPage;

    @BeforeTest
    public void setUp() {
        driver = WebDriverManager.getWebDriver();
        driver.manage().window().maximize();

        pageFactoryManager = new PageFactoryManager(driver);

        driver.get(PropertiesHelper.getProperty("url"));
    }

    @AfterTest
    public void shutDown() {
        driver.close();
    }

    @Test
    public void loginTestUi() {
        signInPage = pageFactoryManager.getSignInPage();
        Assert.assertTrue(signInPage.isEmailFieldDisplayed());
        Assert.assertTrue(signInPage.isPasswordFieldDisplayed());
        Assert.assertTrue(signInPage.isSignInButtonDisplayed());

        signInPage.enterEmail(PropertiesHelper.getProperty("username"));
        signInPage.enterPassword(PropertiesHelper.getProperty("password"));
        signInPage.clickSignInButton();

        dashboardPage = pageFactoryManager.getDashboardPage();
        dashboardPage.waitForPageToLoad();
        Assert.assertTrue(dashboardPage.isOffice365Displayed());
        dashboardPage.clickOffice365();
        Assert.assertTrue(dashboardPage.isPopupConnectorDisplayed());
        dashboardPage.clickPopupConnectorCheckboxes();
        Assert.assertTrue(dashboardPage.isPopupConnectorCreateButtonClickable());
        dashboardPage.clickPopupConnectorCreateButton();

        dashboardPage.waitForTitleToContain("Sign in to your account", DEFAULT_WAIT_TIME);
    }
}
