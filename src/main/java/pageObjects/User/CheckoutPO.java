package pageObjects.User;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.User.CheckoutPageUI;

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
        sleepInSecond(2);
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

    public boolean isProductNameDisplayedAtRowNumber(String productName) {
        String actualValue = getElementText(driver, CheckoutPageUI.DYNAMIC_PRODUCT_NAME_AT_TABLE_ROW_INDEX);
        return actualValue.equals(productName);

    }

    public boolean isProductInfoDisplayedAtRowNumber(String columnName, String expectedValue) {
        String actualValue = getElementText(driver, CheckoutPageUI.DYNAMIC_PRODUCT_INFO_AT_TABLE_ROW_INDEX, columnName);
        if (columnName.equals("Price") || columnName.equals("Total")){
            actualValue = formatPrice(actualValue);
        }
        return actualValue.equals(expectedValue);

    }

    public String getSubTotal() {
        waitForElementVisible(driver, CheckoutPageUI.SUB_TOTAL);
        return formatPrice(getElementText(driver, CheckoutPageUI.SUB_TOTAL));
    }

    public String getShippingCost() {
        waitForElementVisible(driver, CheckoutPageUI.SHIPPING_COST);
        return formatPrice(getElementText(driver, CheckoutPageUI.SHIPPING_COST));
    }

    public String getTax() {
        waitForElementVisible(driver, CheckoutPageUI.TAX);
        return formatPrice(getElementText(driver, CheckoutPageUI.TAX));
    }

    public String getTotalOrder() {
        waitForElementVisible(driver, CheckoutPageUI.TOTAL_ORDER);
        return formatPrice(getElementText(driver, CheckoutPageUI.TOTAL_ORDER));
    }

    public void clickToConfirmButtonAtConfirmOrder() {
        waitForElementVisible(driver, CheckoutPageUI.CONFIRM_BUTTON_AT_CONFIRM_ORDER);
        clickToElement(driver, CheckoutPageUI.CONFIRM_BUTTON_AT_CONFIRM_ORDER);
    }

    public boolean isThankYouMessageDisplayed() {
        waitForElementVisible(driver, CheckoutPageUI.THANK_YOU_TEXT);
        return isElementDisplayed(driver, CheckoutPageUI.THANK_YOU_TEXT);
    }

    public boolean isOrderSuccessMessageDisplayed() {
        waitForElementVisible(driver, CheckoutPageUI.ORDER_SUCCESS_MESSAGE);
        return isElementDisplayed(driver, CheckoutPageUI.ORDER_SUCCESS_MESSAGE);
    }


    public boolean isOrderNumberisplayed() {
        waitForElementVisible(driver, CheckoutPageUI.ORDER_NUMBER_TEXT);
        return isElementDisplayed(driver, CheckoutPageUI.ORDER_NUMBER_TEXT);
    }


    public void selectDropdownByIdAtCardPayment(String selectId, String textValue) {
        waitForElementVisible(driver, CheckoutPageUI.CARD_PAYMENT_DROPDOWN, selectId);
        selectItemByVisible(driver, textValue, CheckoutPageUI.CARD_PAYMENT_DROPDOWN, selectId);
    }

    public void inputToTextboxByIdAtCardPayment(String textboxId, String textValue) {
        waitForElementVisible(driver, CheckoutPageUI.CARD_PAYMENT_TEXTBOX, textboxId);
        sendKeyToElement(driver, textValue, CheckoutPageUI.CARD_PAYMENT_TEXTBOX, textboxId);
    }

    public void clickToContinueButtonAtCardPayment() {
        waitForElementVisible(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_CARD_PAYMENT);
        clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_CARD_PAYMENT);

    }

    public void selectBillingAddressFrom(String optionValue) {
        waitForElementVisible(driver, CheckoutPageUI.ADDRESS_FROM_DROPDOWM);
        selectItemByVisible(driver, optionValue, CheckoutPageUI.ADDRESS_FROM_DROPDOWM);
    }

    public void clickToContinueButtonOfNewAddressAtShippingAddress() {
        waitForElementVisible(driver, CheckoutPageUI.CONTINUE_BUTTON_OF_NEW_ADDRESS_SHIPPING_ADDRESS);
        clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_OF_NEW_ADDRESS_SHIPPING_ADDRESS);
    }
}
