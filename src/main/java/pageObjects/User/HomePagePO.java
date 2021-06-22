package pageObjects.User;

import pageUIs.User.AbstractPageUI;
import commons.AbstractPage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;

public class HomePagePO extends AbstractPage {
    WebDriver driver;
    public HomePagePO(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterPO clickToRegisterLink() {
        waitForElementClickable(driver, AbstractPageUI.REGISTER_LINK);
        clickToElement(driver, AbstractPageUI.REGISTER_LINK);
        return PageGeneratorManager.getRegisterPage(driver);
    }
}
