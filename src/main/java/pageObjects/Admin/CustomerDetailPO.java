package pageObjects.Admin;

import commons.AbstractPage;
import commons.PageGeneratorManagerAdmin;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageUIs.Admin.CustomerDetailPageUI;
import pageUIs.Admin.LoginPageUI;

public class CustomerDetailPO extends AbstractPage {
    WebDriver driver;

    public CustomerDetailPO(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToTextboxByIDAtCustomerDetail(String textboxID, String textValue) {
        waitForElementVisible(driver, CustomerDetailPageUI.DYNAMIC_TEXT_BOX_BY_ID, textboxID);
        sendKeyToElement(driver, textValue, CustomerDetailPageUI.DYNAMIC_TEXT_BOX_BY_ID, textboxID);
    }

    public void clickToRadioButtonByIDAtCustomerDetail(String radioButtonID) {
        waitForElementVisible(driver, CustomerDetailPageUI.DYNAMIC_RADIO_BUTTON_BY_ID, radioButtonID);
        clickToElement(driver, CustomerDetailPageUI.DYNAMIC_RADIO_BUTTON_BY_ID, radioButtonID);
    }

    public void checkToCheckboxByIDAtCustomerDetail(String checkboxID) {
        waitForElementVisible(driver, CustomerDetailPageUI.DYNAMIC_CHECK_BOX_BY_ID, checkboxID);
        checkToCheckBox(driver, CustomerDetailPageUI.DYNAMIC_CHECK_BOX_BY_ID, checkboxID);
    }

    public void inputToTextareaByIDAtCustomerDetail(String textareaID, String textValue) {
        waitForElementVisible(driver, CustomerDetailPageUI.DYNAMIC_TEXT_AREA_BY_ID, textareaID);
        sendKeyToElement(driver, textValue, CustomerDetailPageUI.DYNAMIC_TEXT_AREA_BY_ID, textareaID);
    }

    public void clickToSaveAndContinueEditButton() {
        waitForElementVisible(driver, CustomerDetailPageUI.SAVE_AND_CONTINUE_EDIT_BUTTON);
        clickToElement(driver, CustomerDetailPageUI.SAVE_AND_CONTINUE_EDIT_BUTTON);
    }

    public boolean isAddedSuccessfullyMessageDisplayed() {
        waitForElementVisible(driver, CustomerDetailPageUI.ADDED_SUCCESSFULLY_MESSAGE);
        return isElementDisplayed(driver, CustomerDetailPageUI.ADDED_SUCCESSFULLY_MESSAGE);

    }

    public String getTextboxByIDAtCustomerDetail(String textboxID) {
        waitForElementVisible(driver, CustomerDetailPageUI.DYNAMIC_TEXT_BOX_BY_ID, textboxID);
        return getElementAttribute(driver, CustomerDetailPageUI.DYNAMIC_TEXT_BOX_BY_ID, "value", textboxID);

    }

    public boolean isRadionButtonByIDAtCustomerDetailSelected(String radioButtonID) {
        waitForElementVisible(driver, CustomerDetailPageUI.DYNAMIC_RADIO_BUTTON_BY_ID, radioButtonID);
        return isElementSelected(driver, CustomerDetailPageUI.DYNAMIC_RADIO_BUTTON_BY_ID, radioButtonID);

    }

    public boolean isCheckboxByIDAtCustomerDetailChecked(String checkboxID) {
        waitForElementVisible(driver, CustomerDetailPageUI.DYNAMIC_CHECK_BOX_BY_ID, checkboxID);
        return isElementSelected(driver, CustomerDetailPageUI.DYNAMIC_CHECK_BOX_BY_ID, checkboxID);

    }

    public String getTextAreaByIDAtCustomerDetail(String textareaID) {
        waitForElementVisible(driver, CustomerDetailPageUI.DYNAMIC_TEXT_AREA_BY_ID, textareaID);
        return getElementText(driver, CustomerDetailPageUI.DYNAMIC_TEXT_AREA_BY_ID, textareaID);

    }

    public CustomersPO clickToBackToCustomerListLink() {
        waitForElementClickable(driver, CustomerDetailPageUI.BACK_TO_CUSTOMER_LIST_LINK);
        clickToElement(driver, CustomerDetailPageUI.BACK_TO_CUSTOMER_LIST_LINK);
        waitAjaxLoadingInvisible(driver);
        return PageGeneratorManagerAdmin.getCustomersPage(driver);
    }

    public void inputToCustomerRolesTextboxAtCustomerDetail(String textValue) {
        waitForElementVisible(driver, CustomerDetailPageUI.CLOSE_DEFAULT_VALUE_DROPDOWN);
        clickToElement(driver, CustomerDetailPageUI.CLOSE_DEFAULT_VALUE_DROPDOWN);
        sendKeyToElement(driver, CustomerDetailPageUI.CUSTOMER_ROLES_TEXT_BOX, textValue);
        sendKeyBoardToElement(driver, CustomerDetailPageUI.CUSTOMER_ROLES_TEXT_BOX, Keys.ENTER);
    }

    public boolean isCustomerRolesValueDisplayed(String textValue) {
        waitForElementVisible(driver, CustomerDetailPageUI.DYNAMIC_CUSTOMER_ROLES_SELECTED, textValue);
        return isElementDisplayed(driver, CustomerDetailPageUI.DYNAMIC_CUSTOMER_ROLES_SELECTED, textValue);
    }

    public CustomersPO clickToSaveButton() {
        waitForElementVisible(driver, CustomerDetailPageUI.SAVE_BUTTON);
        clickToElement(driver, CustomerDetailPageUI.SAVE_BUTTON);
        return PageGeneratorManagerAdmin.getCustomersPage(driver);
    }

    public void openPanelByNameText(String panelNameText) {
        if (!isElementUnDisplayed(driver, CustomerDetailPageUI.DYNAMIC_PANEL_NAME_TEXT_CLOSE_ICON, panelNameText)) {
            clickToElement(driver, CustomerDetailPageUI.DYNAMIC_PANEL_NAME_TEXT_CLOSE_ICON, panelNameText);
        }
    }

    public AddressesCustomerPO clickToAddNewAddressButton() {
        waitForElementVisible(driver, CustomerDetailPageUI.ADD_NEW_ADDRESS_BUTTON);
        clickToElement(driver, CustomerDetailPageUI.ADD_NEW_ADDRESS_BUTTON);
        return PageGeneratorManagerAdmin.getAddressesCustomerPage(driver);
    }

    public boolean isAddressDetailsDisplayedAtTable(String firstName, String lastName, String email, String phone, String fax, String company, String address1, String address2, String city, String state, String zipCode, String country) {
        waitForElementVisible(driver, CustomerDetailPageUI.ADDRESS_DETAIL_ON_TABLE_AT_ADDRESSES_PANEL, firstName, lastName, email, phone, fax, company, address1, address2, city, state, zipCode, country);
        System.out.println(">>>>: " + getElement(driver, CustomerDetailPageUI.ADDRESS_DETAIL_ON_TABLE_AT_ADDRESSES_PANEL, firstName, lastName, email, phone, fax, company, address1, address2, city, state, zipCode, country));
        return isElementDisplayed(driver, CustomerDetailPageUI.ADDRESS_DETAIL_ON_TABLE_AT_ADDRESSES_PANEL, firstName, lastName, email, phone, fax, company, address1, address2, city, state, zipCode, country);
    }

    public AddressesCustomerPO clickToEditButtonAtAddressesPanel(String company, String address1, String address2, String city, String state, String zipCode, String country) {
        waitForElementVisible(driver, CustomerDetailPageUI.EDIT_AT_ADDRESS_DETAIL_ON_TABLE, company, address1, address2, city, state, zipCode, country);
        clickToElement(driver, CustomerDetailPageUI.EDIT_AT_ADDRESS_DETAIL_ON_TABLE, company, address1, address2, city, state, zipCode, country);
        return PageGeneratorManagerAdmin.getAddressesCustomerPage(driver);
    }

    public void clickToDeleteButtonAtAddressesPanel(String company, String address1, String address2, String city, String state, String zipCode, String country) {
        waitForElementVisible(driver, CustomerDetailPageUI.DELETE_AT_ADDRESS_DETAIL_ON_TABLE, company, address1, address2, city, state, zipCode, country);
        clickToElement(driver, CustomerDetailPageUI.DELETE_AT_ADDRESS_DETAIL_ON_TABLE, company, address1, address2, city, state, zipCode, country);
    }

    public boolean isNoDataInTableAtAddressesPanel() {
        waitForElementVisible(driver, CustomerDetailPageUI.NO_DATA_IN_TABLE_AT_ADDRESSES_PANEL_MESSAGE);
        return isElementDisplayed(driver, CustomerDetailPageUI.NO_DATA_IN_TABLE_AT_ADDRESSES_PANEL_MESSAGE);

    }
}
