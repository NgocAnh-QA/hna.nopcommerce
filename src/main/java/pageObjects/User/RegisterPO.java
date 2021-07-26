package pageObjects.User;

import io.qameta.allure.Step;
import pageUIs.User.RegisterPageUI;
import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

public class RegisterPO extends AbstractPage {
    WebDriver driver;

    public RegisterPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click to register button")
    public void clickToRegisterButton() {
        waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }

    @Step("Verify error mandatory field: {0} is displayed")
    public boolean isMandatoryFieldErrorDisplayed(String textField) {
        waitForElementVisible(driver, RegisterPageUI.MANDATORY_FIELD_ERROR_MESSAGE, textField);
        return isElementDisplayed(driver, RegisterPageUI.MANDATORY_FIELD_ERROR_MESSAGE, textField);
    }

    @Step("Get validation error message")
    public String getValidationErrorMessage() {
        waitForElementVisible(driver, RegisterPageUI.VALIDATION_ERROR_MESSAGE);
        return getElementText(driver, RegisterPageUI.VALIDATION_ERROR_MESSAGE);
    }

    @Step("Get register success message")
    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    @Step("Get email exists error message")
    public String getEmailExistsErrorMessage() {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_EXISTS_ERROR_MESSAGE);
        return getElementText(driver, RegisterPageUI.EMAIL_EXISTS_ERROR_MESSAGE);
    }

    @Step("Get validation password message")
    public String getValidationPasswordMessage() {
        waitForElementVisible(driver, RegisterPageUI.VALIDATION_ERROR_MESSAGE);
        return concatTextInElement(driver, RegisterPageUI.PASSWORD_ERROR1_MESSAGE, RegisterPageUI.PASSWORD_ERROR2_MESSAGE);
    }

    public String concatTextInElement(WebDriver driver, String locator1, String locator2){
        return getElementText(driver, locator1).trim() + " " + getElementText(driver, locator2).trim();

    }
}
