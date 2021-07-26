package pageObjects.User;

import commons.AbstractPage;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import pageUIs.User.CustomerInfoPageUI;

public class CustomerInfoPO extends AbstractPage {
    WebDriver driver;
    public CustomerInfoPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click to Save button")
    public void clickToSaveButton() {
        waitForElementClickable(driver, CustomerInfoPageUI.SAVE_BUTTON);
        clickToElement(driver, CustomerInfoPageUI.SAVE_BUTTON);
    }
}
