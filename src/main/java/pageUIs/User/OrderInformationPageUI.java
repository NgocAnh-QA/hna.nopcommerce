package pageUIs.User;

public class OrderInformationPageUI {
    public static final String ORDER_NUMBER_TEXT = "//div[@class='order-number']/strong";
    public static final String ORDER_STATUS_TEXT = "//li[@class='order-status']";
    public static final String ORDER_TOTAL_TEXT = "//li[@class='order-total']/strong";

    public static final String DYNAMIC_TEXT_BILLING_ADDRESS_AT_CONFIRM_ORDER = "//div[@class='billing-info']//ul[@class='info-list']//li[@class='%s']";
    public static final String DYNAMIC_TEXT_SHIPPING_ADDRESS_AT_CONFIRM_ORDER = "//div[@class='shipping-info']//ul[@class='info-list']//li[@class='%s']";

    public static final String PAYMENT_METHOD_TEXT = "//li[@class='payment-method']/span[last()]";
    public static final String PAYMENT_STATUS_TEXT = "//li[@class='payment-method-status']/span[last()]";
    public static final String SHIPPING_METHOD_TEXT = "//li[@class='shipping-method']/span[last()]";
    public static final String SHIPPING_STATUS_TEXT = "//li[@class='shipping-status']/span[last()]";

    public static final String DYNAMIC_PRODUCT_NAME_AT_TABLE_ROW_INDEX = "//table[@class='data-table']//tbody/tr//a";
    public static final String DYNAMIC_PRODUCT_INFO_AT_TABLE_ROW_INDEX = "//table[@class='data-table']//tbody/tr//label[contains(.,'%s')]/following-sibling::span";

    public static final String SUB_TOTAL = "//label[text()='Sub-Total:']/parent::td/following-sibling::td/span";
    public static final String SHIPPING_COST = "//label[text()='Shipping:']/parent::td/following-sibling::td/span";
    public static final String TAX = "//label[text()='Tax:']/parent::td/following-sibling::td/span";
    public static final String TOTAL_ORDER = "//label[text()='Order Total:']/parent::td/following-sibling::td/span";

    public static final String GIFT_WRAPPING_TEXT = "//div[@class='selected-checkout-attributes']";
    public static final String RE_ORDER_BUTTON = "//button[text()='Re-order']";
}
