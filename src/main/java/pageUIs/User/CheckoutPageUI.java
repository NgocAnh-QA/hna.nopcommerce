package pageUIs.User;

public class CheckoutPageUI {
    public static final String CONTINUE_BUTTON_AT_BILLING_ADDRESS = "//div[@id='billing-buttons-container']//button[text()='Continue']";
    public static final String SHIP_TO_SAME_ADDRESS_CHECKBOX = "//input[@id='ShipToSameAddress']";

    public static final String DYNAMIC_TEXT_BOX_BY_ID_AT_BILLING_ADDRESS = "//input[@id='BillingNewAddress_%s']";
    public static final String DROPDOWN_BY_ID_AT_BILLING_ADDRESS = "//select[@id='BillingNewAddress_%s']";

    public static final String SHIPPING_ADDRESS_DROPDOWN = "//select[@id='shipping-address-select']";
    public static final String DYNAMIC_TEXT_BOX_BY_ID_AT_SHIPPING_ADDRESS = "//input[@id='ShippingNewAddress_%s']";
    public static final String DROPDOWN_BY_ID_AT_SHIPPING_ADDRESS = "//select[@id='ShippingNewAddress_%s']";
    public static final String CONTINUE_BUTTON_AT_SHIPPING_ADDRESS = "//div[@id='shipping-buttons-container']//button[text()='Continue']";


    public static final String SHIPPING_METHOD_RADIO_BUTTON = "//div[@class='section shipping-method']//label[text()='%s']/preceding-sibling::input";
    public static final String CONTINUE_BUTTON_AT_SHIPPING_METHOD = "//div[@id='shipping-method-buttons-container']//button[text()='Continue']";

    public static final String PAYMENT_METHOD_RADIO_BUTTON = "//div[@class='section payment-method']//label[text()='%s']/preceding-sibling::input";
    public static final String CONTINUE_BUTTON_AT_PAYMENT_METHOD = "//div[@id='payment-method-buttons-container']//button[text()='Continue']";

    public static final String ORDER_INFORMATION = "//div[@class='section payment-info']";
    public static final String CONTINUE_BUTTON_AT_ORDER_INFORMATION = "//div[@id='payment-info-buttons-container']//button[text()='Continue']";

    public static final String DYNAMIC_TEXT_BILLING_ADDRESS_AT_CONFIRM_ORDER = "//div[@class='billing-info']//ul[@class='info-list']//li[@class='%s']";
    public static final String DYNAMIC_TEXT_SHIPPING_ADDRESS_AT_CONFIRM_ORDER = "//div[@class='shipping-info']//ul[@class='info-list']//li[@class='%s']";

    public static final String TEXT_PAYMENT_AT_CONFIRM_ORDER = "//div[@class='payment-method-info']//ul[@class='info-list']//li[@class='payment-method']/span[@class='value']";
    public static final String TEXT_SHIPPING_AT_CONFIRM_ORDER = "//div[@class='shipping-method-info']//ul[@class='info-list']//span[@class='value']";
}
