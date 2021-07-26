package pageObjects.User;

import commons.AbstractPage;
import commons.PageGeneratorManagerUser;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.User.OrderInformationPageUI;

public class OrderInformationPO extends AbstractPage {
    WebDriver driver;

    public OrderInformationPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Get value of Order number")
    public String getOrderNumber() {
        waitForElementVisible(driver, OrderInformationPageUI.ORDER_NUMBER_TEXT);
        String orderNumber = getElementText(driver, OrderInformationPageUI.ORDER_NUMBER_TEXT);
        return orderNumber.substring(orderNumber.lastIndexOf("#") + 1);
    }

    @Step("Get value of Order status")
    public String getOrderStatus() {
        waitForElementVisible(driver, OrderInformationPageUI.ORDER_STATUS_TEXT);
        String orderStatus = getElementText(driver, OrderInformationPageUI.ORDER_STATUS_TEXT);
        return orderStatus.substring(orderStatus.lastIndexOf(" ") + 1);

    }

    @Step("Get value of Order total")
    public String getOrderTotal() {
        waitForElementVisible(driver, OrderInformationPageUI.ORDER_TOTAL_TEXT);
        String orderTotal = getElementText(driver, OrderInformationPageUI.ORDER_TOTAL_TEXT);
        return formatPrice(orderTotal);
    }

    @Step("Get value of Shipping address of confirm order by class: {0}")
    public String getShippingAddressOfConfirmOrderByClass(String nameClass) {
        waitForElementVisible(driver, OrderInformationPageUI.DYNAMIC_TEXT_SHIPPING_ADDRESS_AT_CONFIRM_ORDER, nameClass);
        return getElementText(driver, OrderInformationPageUI.DYNAMIC_TEXT_SHIPPING_ADDRESS_AT_CONFIRM_ORDER, nameClass).trim();
    }

    @Step("Get value of billing address of confirm order by class: {0}")
    public String getBillingAddressOfConfirmOrderByClass(String nameClass) {
        waitForElementVisible(driver, OrderInformationPageUI.DYNAMIC_TEXT_BILLING_ADDRESS_AT_CONFIRM_ORDER, nameClass);
        return getElementText(driver, OrderInformationPageUI.DYNAMIC_TEXT_BILLING_ADDRESS_AT_CONFIRM_ORDER, nameClass).trim();
    }

    @Step("Get value of Payment method")
    public String getPaymentMethod() {
        waitForElementVisible(driver, OrderInformationPageUI.PAYMENT_METHOD_TEXT);
        return getElementText(driver, OrderInformationPageUI.PAYMENT_METHOD_TEXT).trim();
    }

    @Step("Get value of Payment status")
    public String getPaymentStatus() {
        waitForElementVisible(driver, OrderInformationPageUI.PAYMENT_STATUS_TEXT);
        return getElementText(driver, OrderInformationPageUI.PAYMENT_STATUS_TEXT).trim();
    }

    @Step("Get value of Shipping method")
    public String getShippingMethod() {
        waitForElementVisible(driver, OrderInformationPageUI.SHIPPING_METHOD_TEXT);
        return getElementText(driver, OrderInformationPageUI.SHIPPING_METHOD_TEXT).trim();
    }

    @Step("Get value of Shipping status")
    public String getShippingStatus() {
        waitForElementVisible(driver, OrderInformationPageUI.SHIPPING_STATUS_TEXT);
        return getElementText(driver, OrderInformationPageUI.SHIPPING_STATUS_TEXT).trim();
    }

    @Step("Verify product {0} is displayed at row number")
    public boolean isProductNameDisplayedAtRowNumber(String productName) {
        String actualValue = getElementText(driver, OrderInformationPageUI.DYNAMIC_PRODUCT_NAME_AT_TABLE_ROW_INDEX);
        return actualValue.equals(productName);
    }

    @Step("Verify Product info is displayed")
    public boolean isProductInfoDisplayedAtRowNumber(String columnName, String expectedValue) {
        String actualValue = getElementText(driver, OrderInformationPageUI.DYNAMIC_PRODUCT_INFO_AT_TABLE_ROW_INDEX, columnName);
        if (columnName.equals("Price") || columnName.equals("Total")){
            actualValue = formatPrice(actualValue);
        }
        return actualValue.equals(expectedValue);
    }

    @Step("Get value of Sub total")
    public String getSubTotal() {
        waitForElementVisible(driver, OrderInformationPageUI.SUB_TOTAL);
        return formatPrice(getElementText(driver, OrderInformationPageUI.SUB_TOTAL));
    }

    @Step("Get value of Shipping cost")
    public String getShippingCost() {
        waitForElementVisible(driver, OrderInformationPageUI.SHIPPING_COST);
        return formatPrice(getElementText(driver, OrderInformationPageUI.SHIPPING_COST));
    }

    @Step("Get value of Tax")
    public String getTax() {
        waitForElementVisible(driver, OrderInformationPageUI.TAX);
        return formatPrice(getElementText(driver, OrderInformationPageUI.TAX));
    }

    @Step("Get value of Total order")
    public String getTotalOrder() {
        waitForElementVisible(driver, OrderInformationPageUI.TOTAL_ORDER);
        return formatPrice(getElementText(driver, OrderInformationPageUI.TOTAL_ORDER));
    }

    @Step("Get value of Gift wrapping")
    public String getGiftWrapping() {
        waitForElementVisible(driver, OrderInformationPageUI.GIFT_WRAPPING_TEXT);
        String giftOption = getElementText(driver, OrderInformationPageUI.GIFT_WRAPPING_TEXT).trim();
        return giftOption.substring(giftOption.lastIndexOf(" ") + 1);
    }

    @Step("Click to Re Order button")
    public CartPO clickToReOrderButton() {
        waitForElementVisible(driver, OrderInformationPageUI.RE_ORDER_BUTTON);
        clickToElement(driver, OrderInformationPageUI.RE_ORDER_BUTTON);
        return PageGeneratorManagerUser.getCartPage(driver);
    }
}
