package pageObjects.User;

import commons.AbstractPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.User.ChangePasswordPageUI;

public class ChangePasswordPO extends AbstractPage {
    WebDriver driver;
    public ChangePasswordPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click to Save Change button")
    public void clickToSaveChange() {
        waitForElementClickable(driver, ChangePasswordPageUI.SAVE_BUTTON);
        clickToElement(driver, ChangePasswordPageUI.SAVE_BUTTON);
    }

    @Step("Get result message")
    public String getResultMessage() {
        waitForElementVisible(driver, ChangePasswordPageUI.RESULT_MESSAGE);
        return  getElementText(driver, ChangePasswordPageUI.RESULT_MESSAGE);
    }
}
