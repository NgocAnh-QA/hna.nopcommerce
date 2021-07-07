package pageObjects.User;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.User.CheckoutPageUI;
import pageUIs.User.LoginPageUI;

public class CheckoutPO extends AbstractPage {
    WebDriver driver;
    public CheckoutPO(WebDriver driver) {
        this.driver = driver;
    }

    public void unCheckShipToSameAddress() {
        waitForElementVisible(driver, CheckoutPageUI.SHIP_TO_SAME_ADDRESS_CHECKBOX);
        unCheckToCheckBox(driver, CheckoutPageUI.SHIP_TO_SAME_ADDRESS_CHECKBOX);
    }

    public void inputToTextboxByIdAtBillingAddress(String textboxID, String textValue) {
        waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_TEXT_BOX_BY_ID_AT_BILLING_ADDRESS, textboxID);
        sendKeyToElement(driver, textValue, CheckoutPageUI.DYNAMIC_TEXT_BOX_BY_ID_AT_BILLING_ADDRESS, textboxID);
    }

    public void selectDropdownByIdAtBillingAddress(String selectID, String textValue) {
        waitForElementVisible(driver, CheckoutPageUI.DROPDOWN_BY_ID_AT_BILLING_ADDRESS, selectID);
        selectItemByVisible(driver, textValue, CheckoutPageUI.DROPDOWN_BY_ID_AT_BILLING_ADDRESS, selectID);
    }

    public void clickToContinueButtonAtBillingAddress() {
        waitForElementVisible(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_BILLING_ADDRESS);
        clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_BILLING_ADDRESS);
    }

    public void selectShippingAddressDropdown(String textOption) {
        waitForElementVisible(driver, CheckoutPageUI.SHIPPING_ADDRESS_DROPDOWN);
        selectItemByVisible(driver, textOption, CheckoutPageUI.SHIPPING_ADDRESS_DROPDOWN);
    }

    public void inputToTextboxByIdAtShippingAddress(String textboxID, String textValue) {
        waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_TEXT_BOX_BY_ID_AT_SHIPPING_ADDRESS, textboxID);
        sendKeyToElement(driver, textValue, CheckoutPageUI.DYNAMIC_TEXT_BOX_BY_ID_AT_SHIPPING_ADDRESS, textboxID);
    }

    public void selectByIdAtShippingAddress(String selectID, String textValue) {
        waitForElementVisible(driver, CheckoutPageUI.DROPDOWN_BY_ID_AT_SHIPPING_ADDRESS, selectID);
        selectItemByVisible(driver, textValue, CheckoutPageUI.DROPDOWN_BY_ID_AT_SHIPPING_ADDRESS, selectID);
    }

    public void clickToContinueButtonAtShippingAddress() {
        waitForElementVisible(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_SHIPPING_ADDRESS);
        clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_SHIPPING_ADDRESS);
    }

    public void clickToRadioButtonAtShippingMethod(String textValue) {
        waitForElementVisible(driver, CheckoutPageUI.SHIPPING_METHOD_RADIO_BUTTON, textValue);
        clickToElement(driver, CheckoutPageUI.SHIPPING_METHOD_RADIO_BUTTON, textValue);

    }

    public void clickToContinueButtonAtShippingMethod() {
        waitForElementVisible(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_SHIPPING_METHOD);
        clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_SHIPPING_METHOD);
    }

    public void clickToRadioButtonAtPaymentMethod(String textValue) {
        waitForElementVisible(driver, CheckoutPageUI.PAYMENT_METHOD_RADIO_BUTTON, textValue);
        clickToElement(driver, CheckoutPageUI.PAYMENT_METHOD_RADIO_BUTTON, textValue);
    }

    public void clickToContinueButtonAtPaymentMethod() {
        waitForElementVisible(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_PAYMENT_METHOD);
        clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_PAYMENT_METHOD);
    }

    public boolean isOrderInformationDisplayed() {
        waitForElementVisible(driver, CheckoutPageUI.ORDER_INFORMATION);
        return isElementDisplayed(driver, CheckoutPageUI.ORDER_INFORMATION);
    }

    public void clickToContinueButtonAtOrderInformation() {
        waitForElementVisible(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_ORDER_INFORMATION);
        clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_ORDER_INFORMATION);
    }

    public String getBillingAddressOfConfirmOrderByClass(String nameClass) {
        waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_TEXT_BILLING_ADDRESS_AT_CONFIRM_ORDER, nameClass);
        return getElementText(driver, CheckoutPageUI.DYNAMIC_TEXT_BILLING_ADDRESS_AT_CONFIRM_ORDER, nameClass).trim();

    }

    public String getShippingAddressOfConfirmOrderByClass(String nameClass) {
        waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_TEXT_SHIPPING_ADDRESS_AT_CONFIRM_ORDER, nameClass);
        return getElementText(driver, CheckoutPageUI.DYNAMIC_TEXT_SHIPPING_ADDRESS_AT_CONFIRM_ORDER, nameClass).trim();
    }

    public String getPaymentOfConfirmOrderByClass() {
        waitForElementVisible(driver, CheckoutPageUI.TEXT_PAYMENT_AT_CONFIRM_ORDER);
        return getElementText(driver, CheckoutPageUI.TEXT_PAYMENT_AT_CONFIRM_ORDER).trim();
    }

    public String getShippingOfConfirmOrderByClass() {
        waitForElementVisible(driver, CheckoutPageUI.TEXT_SHIPPING_AT_CONFIRM_ORDER);
        return getElementText(driver, CheckoutPageUI.TEXT_SHIPPING_AT_CONFIRM_ORDER).trim();
    }
}
