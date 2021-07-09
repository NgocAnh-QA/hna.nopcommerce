package pageObjects.User;

import commons.AbstractPage;
import commons.PageGeneratorManagerUser;
import org.openqa.selenium.WebDriver;
import pageUIs.User.LoginPageUI;

public class LoginPO extends AbstractPage {
    WebDriver driver;
    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToEmailTextbox(String email) {
        waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
        sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);

    }

    public HomePagePO clickToLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManagerUser.getHomePage(driver);

    }

    public String getEmptyInvalidDataLoginMessage() {
        waitForElementVisible(driver, LoginPageUI.ERROR_INVALID_EMPTY_MESSAGE);
        return getElementText(driver, LoginPageUI.ERROR_INVALID_EMPTY_MESSAGE);
    }

    public String getAccountLoginMessage() {
        waitForElementVisible(driver, LoginPageUI.ACCOUNT_MESSAGE);
        return getElementText(driver, LoginPageUI.ACCOUNT_MESSAGE);
    }
}
