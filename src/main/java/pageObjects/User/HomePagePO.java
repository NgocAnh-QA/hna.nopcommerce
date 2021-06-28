package pageObjects.User;

import pageUIs.User.AbstractPageUI;
import commons.AbstractPage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.User.HomePageUI;

public class HomePagePO extends AbstractPage {
    WebDriver driver;
    public HomePagePO(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPO clickToLoginLink() {
        clickToElement(driver, AbstractPageUI.LOGIN_LINK);
        return PageGeneratorManager.getLoginPage(driver);
    }

    public RegisterPO clickToRegisterLink() {
        waitForElementClickable(driver, AbstractPageUI.REGISTER_LINK);
        clickToElement(driver, AbstractPageUI.REGISTER_LINK);
        return PageGeneratorManager.getRegisterPage(driver);
    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver, AbstractPageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver, AbstractPageUI.MY_ACCOUNT_LINK);
    }
}
