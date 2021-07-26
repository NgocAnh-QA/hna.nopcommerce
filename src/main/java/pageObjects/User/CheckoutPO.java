package pageObjects.User;

import commons.AbstractPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.User.CheckoutPageUI;

public class CheckoutPO extends AbstractPage {
    WebDriver driver;

    public CheckoutPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Uncheck ship to same address")
    public void unCheckShipToSameAddress() {
        waitForElementVisible(driver, CheckoutPageUI.SHIP_TO_SAME_ADDRESS_CHECKBOX);
        unCheckToCheckBox(driver, CheckoutPageUI.SHIP_TO_SAME_ADDRESS_CHECKBOX);
    }

    @Step("Input to text box by id: {0} at billing address with value: {1}")
    public void inputToTextBoxByIdAtBillingAddress(String textBoxID, String textValue) {
        waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_TEXT_BOX_BY_ID_AT_BILLING_ADDRESS, textBoxID);
        sendKeyToElement(driver, textValue, CheckoutPageUI.DYNAMIC_TEXT_BOX_BY_ID_AT_BILLING_ADDRESS, textBoxID);
    }

    @Step("Select by id: {0} at billing address with value: {1}")
    public void selectDropdownByIdAtBillingAddress(String selectID, String textValue) {
        waitForElementVisible(driver, CheckoutPageUI.DROPDOWN_BY_ID_AT_BILLING_ADDRESS, selectID);
        selectItemByVisible(driver, textValue, CheckoutPageUI.DROPDOWN_BY_ID_AT_BILLING_ADDRESS, selectID);
    }

    @Step("Click to continue button at billing address")
    public void clickToContinueButtonAtBillingAddress() {
        waitForElementVisible(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_BILLING_ADDRESS);
        clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_BILLING_ADDRESS);
    }

    @Step("Select shipping address dropdown with value: {0}")
    public void selectShippingAddressDropdown(String textOption) {
        waitForElementVisible(driver, CheckoutPageUI.SHIPPING_ADDRESS_DROPDOWN);
        selectItemByVisible(driver, textOption, CheckoutPageUI.SHIPPING_ADDRESS_DROPDOWN);
    }

    @Step("Input to text box by id: {0} at shipping address with value: {1}")
    public void inputToTextBoxByIdAtShippingAddress(String textBoxID, String textValue) {
        waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_TEXT_BOX_BY_ID_AT_SHIPPING_ADDRESS, textBoxID);
        sendKeyToElement(driver, textValue, CheckoutPageUI.DYNAMIC_TEXT_BOX_BY_ID_AT_SHIPPING_ADDRESS, textBoxID);
    }

    @Step("Select by ID: {0} with value: {1}")
    public void selectByIdAtShippingAddress(String selectID, String textValue) {
        waitForElementVisible(driver, CheckoutPageUI.DROPDOWN_BY_ID_AT_SHIPPING_ADDRESS, selectID);
        selectItemByVisible(driver, textValue, CheckoutPageUI.DROPDOWN_BY_ID_AT_SHIPPING_ADDRESS, selectID);
        sleepInSecond(2);
    }

    @Step("Click to continue button at shipping address")
    public void clickToContinueButtonAtShippingAddress() {
        waitForElementVisible(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_SHIPPING_ADDRESS);
        clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_SHIPPING_ADDRESS);
    }

    @Step("Click to radio button: {0} at shipping method")
    public void clickToRadioButtonAtShippingMethod(String textValue) {
        waitForElementVisible(driver, CheckoutPageUI.SHIPPING_METHOD_RADIO_BUTTON, textValue);
        clickToElement(driver, CheckoutPageUI.SHIPPING_METHOD_RADIO_BUTTON, textValue);
    }

    @Step("Click to continue button at shipping method")
    public void clickToContinueButtonAtShippingMethod() {
        waitForElementVisible(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_SHIPPING_METHOD);
        clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_SHIPPING_METHOD);
    }

    @Step("Click to radio button: {0} at payment method")
    public void clickToRadioButtonAtPaymentMethod(String textValue) {
        waitForElementVisible(driver, CheckoutPageUI.PAYMENT_METHOD_RADIO_BUTTON, textValue);
        clickToElement(driver, CheckoutPageUI.PAYMENT_METHOD_RADIO_BUTTON, textValue);
    }

    @Step("Click to continue button at payment method")
    public void clickToContinueButtonAtPaymentMethod() {
        waitForElementVisible(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_PAYMENT_METHOD);
        clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_PAYMENT_METHOD);
    }

    @Step("Verify Order information is displayed")
    public boolean isOrderInformationDisplayed() {
        waitForElementVisible(driver, CheckoutPageUI.ORDER_INFORMATION);
        return isElementDisplayed(driver, CheckoutPageUI.ORDER_INFORMATION);
    }

    @Step("Click to continue button at order information")
    public void clickToContinueButtonAtOrderInformation() {
        waitForElementVisible(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_ORDER_INFORMATION);
        clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_ORDER_INFORMATION);
    }

    @Step("get value of billing address of confirm order")
    public String getBillingAddressOfConfirmOrderByClass(String nameClass) {
        waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_TEXT_BILLING_ADDRESS_AT_CONFIRM_ORDER, nameClass);
        return getElementText(driver, CheckoutPageUI.DYNAMIC_TEXT_BILLING_ADDRESS_AT_CONFIRM_ORDER, nameClass).trim();
    }

    @Step("Get value of shipping address of confirm order")
    public String getShippingAddressOfConfirmOrderByClass(String nameClass) {
        waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_TEXT_SHIPPING_ADDRESS_AT_CONFIRM_ORDER, nameClass);
        return getElementText(driver, CheckoutPageUI.DYNAMIC_TEXT_SHIPPING_ADDRESS_AT_CONFIRM_ORDER, nameClass).trim();
    }

    @Step("Get value of payment of confirm order")
    public String getPaymentOfConfirmOrderByClass() {
        waitForElementVisible(driver, CheckoutPageUI.TEXT_PAYMENT_AT_CONFIRM_ORDER);
        return getElementText(driver, CheckoutPageUI.TEXT_PAYMENT_AT_CONFIRM_ORDER).trim();
    }

    @Step("Get value of Shipping of Confirm order")
    public String getShippingOfConfirmOrderByClass() {
        waitForElementVisible(driver, CheckoutPageUI.TEXT_SHIPPING_AT_CONFIRM_ORDER);
        return getElementText(driver, CheckoutPageUI.TEXT_SHIPPING_AT_CONFIRM_ORDER).trim();
    }

    @Step("Verify product {0} is displayed")
    public boolean isProductNameDisplayedAtRowNumber(String productName) {
        String actualValue = getElementText(driver, CheckoutPageUI.DYNAMIC_PRODUCT_NAME_AT_TABLE_ROW_INDEX);
        return actualValue.equals(productName);
    }

    @Step("Verify Product's info is displayed at row number")
    public boolean isProductInfoDisplayedAtRowNumber(String columnName, String expectedValue) {
        String actualValue = getElementText(driver, CheckoutPageUI.DYNAMIC_PRODUCT_INFO_AT_TABLE_ROW_INDEX, columnName);
        if (columnName.equals("Price") || columnName.equals("Total")){
            actualValue = formatPrice(actualValue);
        }
        return actualValue.equals(expectedValue);
    }

    @Step("get value of sub total")
    public String getSubTotal() {
        waitForElementVisible(driver, CheckoutPageUI.SUB_TOTAL);
        return formatPrice(getElementText(driver, CheckoutPageUI.SUB_TOTAL));
    }

    @Step("Get value of shipping cart")
    public String getShippingCost() {
        waitForElementVisible(driver, CheckoutPageUI.SHIPPING_COST);
        return formatPrice(getElementText(driver, CheckoutPageUI.SHIPPING_COST));
    }

    @Step("Get  value of tax")
    public String getTax() {
        waitForElementVisible(driver, CheckoutPageUI.TAX);
        return formatPrice(getElementText(driver, CheckoutPageUI.TAX));
    }

    @Step("Get  value of total order")
    public String getTotalOrder() {
        waitForElementVisible(driver, CheckoutPageUI.TOTAL_ORDER);
        return formatPrice(getElementText(driver, CheckoutPageUI.TOTAL_ORDER));
    }

    @Step("Click to Confirm button at confirm order")
    public void clickToConfirmButtonAtConfirmOrder() {
        waitForElementVisible(driver, CheckoutPageUI.CONFIRM_BUTTON_AT_CONFIRM_ORDER);
        clickToElement(driver, CheckoutPageUI.CONFIRM_BUTTON_AT_CONFIRM_ORDER);
    }

    @Step("Verify Thank you message is displayed")
    public boolean isThankYouMessageDisplayed() {
        waitForElementVisible(driver, CheckoutPageUI.THANK_YOU_TEXT);
        return isElementDisplayed(driver, CheckoutPageUI.THANK_YOU_TEXT);
    }

    @Step("Verify Order success message is displayed")
    public boolean isOrderSuccessMessageDisplayed() {
        waitForElementVisible(driver, CheckoutPageUI.ORDER_SUCCESS_MESSAGE);
        return isElementDisplayed(driver, CheckoutPageUI.ORDER_SUCCESS_MESSAGE);
    }

    @Step("Verify Order number is displayed")
    public boolean isOrderNumberDisplayed() {
        waitForElementVisible(driver, CheckoutPageUI.ORDER_NUMBER_TEXT);
        return isElementDisplayed(driver, CheckoutPageUI.ORDER_NUMBER_TEXT);
    }

    @Step("Select dropdown by id: {0} with value: {1}")
    public void selectDropdownByIdAtCardPayment(String selectId, String textValue) {
        waitForElementVisible(driver, CheckoutPageUI.CARD_PAYMENT_DROPDOWN, selectId);
        selectItemByVisible(driver, textValue, CheckoutPageUI.CARD_PAYMENT_DROPDOWN, selectId);
    }

    @Step("Input to text box by id: {0} at card payment with value: {1}")
    public void inputToTextBoxByIdAtCardPayment(String textBoxId, String textValue) {
        waitForElementVisible(driver, CheckoutPageUI.CARD_PAYMENT_TEXTBOX, textBoxId);
        sendKeyToElement(driver, textValue, CheckoutPageUI.CARD_PAYMENT_TEXTBOX, textBoxId);
    }

    @Step("Click to Continue button at card payment")
    public void clickToContinueButtonAtCardPayment() {
        waitForElementVisible(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_CARD_PAYMENT);
        clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_CARD_PAYMENT);
    }

    @Step("select Billing address from with value: {0}")
    public void selectBillingAddressFrom(String optionValue) {
        waitForElementVisible(driver, CheckoutPageUI.ADDRESS_FROM_DROPDOWM);
        selectItemByVisible(driver, optionValue, CheckoutPageUI.ADDRESS_FROM_DROPDOWM);
    }

    @Step("Click to Continue button of new address at shipping address")
    public void clickToContinueButtonOfNewAddressAtShippingAddress() {
        waitForElementVisible(driver, CheckoutPageUI.CONTINUE_BUTTON_OF_NEW_ADDRESS_SHIPPING_ADDRESS);
        clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_OF_NEW_ADDRESS_SHIPPING_ADDRESS);
    }
}
