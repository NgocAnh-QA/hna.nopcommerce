package pageObjects.User;

import PageUIs.User.RegisterPageUI;
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
        waitForElementVisible(driver, RegisterPageUI.MANDANTORY_FIELD_ERROR_MESSAGE, textField);
        return isElementDisplayed(driver, RegisterPageUI.MANDANTORY_FIELD_ERROR_MESSAGE, textField);
    }


    public String getValidationErrorMessage() {
        waitForElementVisible(driver, RegisterPageUI.VALIDATION_ERROR_MESSAGE);
        return getElementText(driver, RegisterPageUI.VALIDATION_ERROR_MESSAGE);
    }
}
