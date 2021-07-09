package pageObjects.User;

import pageUIs.User.AbstractPageUI;
import commons.AbstractPage;
import commons.PageGeneratorManagerUser;
import org.openqa.selenium.WebDriver;

public class HomePagePO extends AbstractPage {
    WebDriver driver;
    public HomePagePO(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPO clickToLoginLink() {
        clickToElement(driver, AbstractPageUI.LOGIN_LINK);
        return PageGeneratorManagerUser.getLoginPage(driver);
    }

    public RegisterPO clickToRegisterLink() {
        waitForElementClickable(driver, AbstractPageUI.REGISTER_LINK);
        clickToElement(driver, AbstractPageUI.REGISTER_LINK);
        return PageGeneratorManagerUser.getRegisterPage(driver);
    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver, AbstractPageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver, AbstractPageUI.MY_ACCOUNT_LINK);
    }
}
