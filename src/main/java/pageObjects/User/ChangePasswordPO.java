package pageObjects.User;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.User.AbstractPageUI;
import pageUIs.User.ChangePasswordPageUI;

public class ChangePasswordPO extends AbstractPage {
    WebDriver driver;
    public ChangePasswordPO(WebDriver driver) {
        this.driver = driver;
    }


    public void clickToSaveChange() {
        waitForElementClickable(driver, ChangePasswordPageUI.SAVE_BUTTON);
        clickToElement(driver, ChangePasswordPageUI.SAVE_BUTTON);
    }

    public String getResultMessage() {
        waitForElementVisible(driver, ChangePasswordPageUI.RESULT_MESSAGE);
        return  getElementText(driver, ChangePasswordPageUI.RESULT_MESSAGE);
    }
}
