package pageObjects.Admin;

import commons.AbstractPage;
import commons.PageGeneratorManagerAdmin;
import org.openqa.selenium.WebDriver;
import pageUIs.Admin.LoginPageUI;

public class LoginPO extends AbstractPage {
    WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);

    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);

    }

    public DashboardPO clickToLoginButton(String emailAddress, String password) {
        inputToEmailTextbox(emailAddress);
        inputToPasswordTextbox(password);
        waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManagerAdmin.getDashboardPage(driver);

    }
}
