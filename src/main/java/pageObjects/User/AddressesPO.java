package pageObjects.User;

import commons.AbstractPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.User.AddressesPageUI;

public class AddressesPO extends AbstractPage {
    WebDriver driver;
    public AddressesPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click to Add new button")
    public void clickToAddNewButton() {
        waitForElementClickable(driver, AddressesPageUI.ADD_NEW_BUTTON);
        clickToElement(driver, AddressesPageUI.ADD_NEW_BUTTON);

    }

    @Step("Click to Save button")
    public void clickToSaveNewButton() {
        waitForElementClickable(driver, AddressesPageUI.SAVE_BUTTON);
        clickToElement(driver, AddressesPageUI.SAVE_BUTTON);
    }
}
