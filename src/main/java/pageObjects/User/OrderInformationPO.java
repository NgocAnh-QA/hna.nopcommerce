package pageObjects.User;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.User.CheckoutPageUI;
import pageUIs.User.LoginPageUI;
import pageUIs.User.OrderInformationPageUI;

public class OrderInformationPO extends AbstractPage {
    WebDriver driver;

    public OrderInformationPO(WebDriver driver) {
        this.driver = driver;
    }


    public String getOrderNumber() {
        waitForElementVisible(driver, OrderInformationPageUI.ORDER_NUMBER_TEXT);
        String orderNumber = getElementText(driver, OrderInformationPageUI.ORDER_NUMBER_TEXT);
        return orderNumber.substring(orderNumber.lastIndexOf("#") + 1);
    }

    public String getOrderStatus() {
        waitForElementVisible(driver, OrderInformationPageUI.ORDER_STATUS_TEXT);
        String orderStatus = getElementText(driver, OrderInformationPageUI.ORDER_STATUS_TEXT);
        return orderStatus.substring(orderStatus.lastIndexOf(" ") + 1);

    }

    public String getOrderTotal() {
        waitForElementVisible(driver, OrderInformationPageUI.ORDER_TOTAL_TEXT);
        String orderTotal = getElementText(driver, OrderInformationPageUI.ORDER_TOTAL_TEXT);
        return formatPrice(orderTotal);
    }

    public String getShippingAddressOfConfirmOrderByClass(String nameClass) {
        waitForElementVisible(driver, OrderInformationPageUI.DYNAMIC_TEXT_SHIPPING_ADDRESS_AT_CONFIRM_ORDER, nameClass);
        return getElementText(driver, OrderInformationPageUI.DYNAMIC_TEXT_SHIPPING_ADDRESS_AT_CONFIRM_ORDER, nameClass).trim();
    }

    public String getBillingAddressOfConfirmOrderByClass(String nameClass) {
        waitForElementVisible(driver, OrderInformationPageUI.DYNAMIC_TEXT_BILLING_ADDRESS_AT_CONFIRM_ORDER, nameClass);
        return getElementText(driver, OrderInformationPageUI.DYNAMIC_TEXT_BILLING_ADDRESS_AT_CONFIRM_ORDER, nameClass).trim();

    }

    public String getPaymentMethod() {
        waitForElementVisible(driver, OrderInformationPageUI.PAYMENT_METHOD_TEXT);
        return getElementText(driver, OrderInformationPageUI.PAYMENT_METHOD_TEXT).trim();

    }

    public String getPaymentStatus() {
        waitForElementVisible(driver, OrderInformationPageUI.PAYMENT_STATUS_TEXT);
        return getElementText(driver, OrderInformationPageUI.PAYMENT_STATUS_TEXT).trim();
    }

    public String getShippingMethod() {
        waitForElementVisible(driver, OrderInformationPageUI.SHIPPING_METHOD_TEXT);
        return getElementText(driver, OrderInformationPageUI.SHIPPING_METHOD_TEXT).trim();
    }

    public String getShippingStatus() {
        waitForElementVisible(driver, OrderInformationPageUI.SHIPPING_STATUS_TEXT);
        return getElementText(driver, OrderInformationPageUI.SHIPPING_STATUS_TEXT).trim();
    }


    public boolean isProductNameDisplayedAtRowNumber(String productName) {
        String actualValue = getElementText(driver, OrderInformationPageUI.DYNAMIC_PRODUCT_NAME_AT_TABLE_ROW_INDEX);
        return actualValue.equals(productName);

    }

    public boolean isProductInfoDisplayedAtRowNumber(String columnName, String expectedValue) {
        String actualValue = getElementText(driver, OrderInformationPageUI.DYNAMIC_PRODUCT_INFO_AT_TABLE_ROW_INDEX, columnName);
        if (columnName.equals("Price") || columnName.equals("Total")){
            actualValue = formatPrice(actualValue);
        }
        System.out.println(actualValue);
        return actualValue.equals(expectedValue);

    }

    public String getSubTotal() {
        waitForElementVisible(driver, OrderInformationPageUI.SUB_TOTAL);
        return formatPrice(getElementText(driver, OrderInformationPageUI.SUB_TOTAL));
    }

    public String getShippingCost() {
        waitForElementVisible(driver, OrderInformationPageUI.SHIPPING_COST);
        return formatPrice(getElementText(driver, OrderInformationPageUI.SHIPPING_COST));
    }

    public String getTax() {
        waitForElementVisible(driver, OrderInformationPageUI.TAX);
        return formatPrice(getElementText(driver, OrderInformationPageUI.TAX));
    }

    public String getTotalOrder() {
        waitForElementVisible(driver, OrderInformationPageUI.TOTAL_ORDER);
        return formatPrice(getElementText(driver, OrderInformationPageUI.TOTAL_ORDER));
    }

    public String getGiftWrapping() {
        waitForElementVisible(driver, OrderInformationPageUI.GIFT_WRAPPING_TEXT);
        String giftOption = getElementText(driver, OrderInformationPageUI.GIFT_WRAPPING_TEXT).trim();
        return giftOption.substring(giftOption.lastIndexOf(" ") + 1);
    }

    public CartPO clickToReOrderButton() {
        waitForElementVisible(driver, OrderInformationPageUI.RE_ORDER_BUTTON);
        clickToElement(driver, OrderInformationPageUI.RE_ORDER_BUTTON);
        return PageGeneratorManager.getCartPage(driver);
    }
}
