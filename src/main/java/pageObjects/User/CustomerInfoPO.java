package pageObjects.User;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.User.AbstractPageUI;
import pageUIs.User.CustomerInfoPageUI;

public class CustomerInfoPO extends AbstractPage {
    WebDriver driver;
    public CustomerInfoPO(WebDriver driver) {
        this.driver = driver;
    }


    public void clickToSaveButton() {
        waitForElementClickable(driver, CustomerInfoPageUI.SAVE_BUTTON);
        clickToElement(driver, CustomerInfoPageUI.SAVE_BUTTON);
    }
}
