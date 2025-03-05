package UI.factory;

import UI.pages.DashboardPage;
import UI.pages.SignInPage;
import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public SignInPage getSignInPage(){
        return new SignInPage(driver);
    }

    public DashboardPage getDashboardPage() {
        return new DashboardPage(driver);
    }
}
