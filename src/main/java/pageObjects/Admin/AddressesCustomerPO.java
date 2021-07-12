package pageObjects.Admin;

import commons.AbstractPage;
import commons.PageGeneratorManagerAdmin;
import org.openqa.selenium.WebDriver;
import pageUIs.Admin.AddressesCustomerPageUI;
import pageUIs.Admin.LoginPageUI;

public class AddressesCustomerPO extends AbstractPage {
    WebDriver driver;

    public AddressesCustomerPO(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToTextboxByIDAtAddressPage(String textBoxID, String textValue) {
        waitForElementVisible(driver, AddressesCustomerPageUI.DYNAMIC_TEXT_BOX_BY_ID, textBoxID);
        sendKeyToElement(driver,textValue, AddressesCustomerPageUI.DYNAMIC_TEXT_BOX_BY_ID,textBoxID);
    }

    public void selectDropdownByIDAtAddressPage(String dropdownID, String textValue) {
        waitForElementVisible(driver, AddressesCustomerPageUI.DYNAMIC_DROPDOWN_BY_ID, dropdownID);
        selectItemByVisible(driver, textValue, AddressesCustomerPageUI.DYNAMIC_DROPDOWN_BY_ID, dropdownID);

    }

    public void clickToSaveButton() {
        waitForElementVisible(driver, AddressesCustomerPageUI.SAVE_BUTTON);
        clickToElement(driver, AddressesCustomerPageUI.SAVE_BUTTON);

    }

    public boolean isAddSuccessMessageDisplayed() {
        waitForElementVisible(driver, AddressesCustomerPageUI.ADD_SUCCESS_MESSAGE);
        return isElementDisplayed(driver, AddressesCustomerPageUI.ADD_SUCCESS_MESSAGE);

    }

    public String getAttributeTextboxByIDAtAddressPage(String textBoxID) {
        waitForElementVisible(driver, AddressesCustomerPageUI.DYNAMIC_TEXT_BOX_BY_ID, textBoxID);
        return getElementAttribute(driver, AddressesCustomerPageUI.DYNAMIC_TEXT_BOX_BY_ID, "value", textBoxID);

    }

    public String getFirstSelectedInDropdownByID(String dropdownID) {
        waitForElementVisible(driver, AddressesCustomerPageUI.DYNAMIC_DROPDOWN_BY_ID, dropdownID);
        return getFirstSelectedTextInDropdown(driver, AddressesCustomerPageUI.DYNAMIC_DROPDOWN_BY_ID, dropdownID);

    }

    public CustomerDetailPO clickToBackToCustomerDetailsLink() {
        waitForElementClickable(driver, AddressesCustomerPageUI.BACK_TO_CUSTOMER_DETAIL_LINK);
        clickToElement(driver, AddressesCustomerPageUI.BACK_TO_CUSTOMER_DETAIL_LINK);
        return PageGeneratorManagerAdmin.getCustomerDetailPage(driver);

    }
}
