package pageObjects.User;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.User.AddressesPageUI;
import pageUIs.User.LoginPageUI;

public class AddressesPO extends AbstractPage {
    WebDriver driver;
    public AddressesPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToAddNewButton() {
        waitForElementClickable(driver, AddressesPageUI.ADD_NEW_BUTTON);
        clickToElement(driver, AddressesPageUI.ADD_NEW_BUTTON);

    }

    public void clickToSaveNewButton() {
        waitForElementClickable(driver, AddressesPageUI.SAVE_BUTTON);
        clickToElement(driver, AddressesPageUI.SAVE_BUTTON);
    }
}
