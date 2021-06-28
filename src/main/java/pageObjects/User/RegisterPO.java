package pageObjects.User;

import pageUIs.User.RegisterPageUI;
import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

public class RegisterPO extends AbstractPage {
    WebDriver driver;

    public RegisterPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }

    public boolean isMandantoryFieldErrorDisplayed(String textField) {
        waitForElementVisible(driver, RegisterPageUI.MANDATORY_FIELD_ERROR_MESSAGE, textField);
        return isElementDisplayed(driver, RegisterPageUI.MANDATORY_FIELD_ERROR_MESSAGE, textField);
    }


    public String getValidationErrorMessage() {
        waitForElementVisible(driver, RegisterPageUI.VALIDATION_ERROR_MESSAGE);
        return getElementText(driver, RegisterPageUI.VALIDATION_ERROR_MESSAGE);
    }

    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }


    public String getEmailExistsErrorMessage() {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_EXISTS_ERROR_MESSAGE);
        return getElementText(driver, RegisterPageUI.EMAIL_EXISTS_ERROR_MESSAGE);
    }

    public String getValidationPasswordMessage() {
        waitForElementVisible(driver, RegisterPageUI.VALIDATION_ERROR_MESSAGE);
        return concatTextInElement(driver, RegisterPageUI.PASSWORD_ERROR1_MESSAGE, RegisterPageUI.PASSWORD_ERROR2_MESSAGE);
    }

    public String concatTextInElement(WebDriver driver, String locator1, String locator2){
        return getElementText(driver, locator1).trim() + " " + getElementText(driver, locator2).trim();

    }
}
