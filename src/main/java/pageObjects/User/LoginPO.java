package pageObjects.User;

import commons.AbstractPage;
import commons.PageGeneratorManagerUser;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.User.LoginPageUI;

public class LoginPO extends AbstractPage {
    WebDriver driver;
    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Input to Email text box with value: {0}")
    public void inputToEmailTextBox(String email) {
        waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
        sendKeyToElement(driver, LoginPageUI.EMAIL_TEXT_BOX, email);
    }

    @Step("Input to Password text box with value: {0}")
    public void inputToPasswordTextBox(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXT_BOX);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXT_BOX, password);
    }

    @Step("Click to Login button")
    public HomePagePO clickToLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManagerUser.getHomePage(driver);

    }
    @Step("Get error empty/invalid data login message")
    public String getEmptyInvalidDataLoginMessage() {
        waitForElementVisible(driver, LoginPageUI.ERROR_INVALID_EMPTY_MESSAGE);
        return getElementText(driver, LoginPageUI.ERROR_INVALID_EMPTY_MESSAGE);
    }

    @Step("Get error validate account message")
    public String getAccountLoginMessage() {
        waitForElementVisible(driver, LoginPageUI.ACCOUNT_MESSAGE);
        return getElementText(driver, LoginPageUI.ACCOUNT_MESSAGE);
    }
}
