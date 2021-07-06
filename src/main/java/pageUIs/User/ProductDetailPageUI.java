package pageUIs.User;

public class ProductDetailPageUI {
    public static final String ADD_YOUR_REVIEW_LINK = "//a[text()='Add your review']";


    public static final String ADD_TO_WISHLIST_BUTTON = "//div[@class='overview']//button[text()='Add to wishlist']";
    public static final String ADD_WISHLIST_SUCCESS_MESSAGE = "//div[@class='bar-notification success']//p";
    public static final String CLOSE_SUCCESS_IN_BAR_BUTTON = "//div[@class='bar-notification success']//span";


    public static final String DYNAMIC_SOFTWARE_CHECKBOX = "//label[text()='%s']/preceding-sibling::input";
    public static final String SOFTWARE_CHECKBOX_ALL = "//dd[@id='product_attribute_input_5']//li//input";
    public static final String PROCESSOR_DROPDOWN = "//select[@id='product_attribute_1']";
    public static final String RAM_DROPDOWN = "//select[@id='product_attribute_2']";
    public static final String DYNAMIC_HDD_RADIO_BUTTON = "//label[text()='%s']/preceding-sibling::input";
    public static final String DYNAMIC_OS_RADIO_BUTTON = "//label[text()='%s']/preceding-sibling::input";

    public static final String ADD_TO_CART_BUTTON = "//button[@id='add-to-cart-button-1']";
    public static final String ADD_TO_CART_SUCCESS_MESSAGE = "//div[@class='bar-notification success']//p";
    public static final String CLOSE_ADD_TO_CART_SUCCESS_MESSAGE_BUTTON = "//div[@class='bar-notification success']//span";


    public static final String UPDATE_BUTTON = "//button[@id='add-to-cart-button-1']";
    public static final String QUANTITY_TEXT_BOX = "//input[@id='product_enteredQuantity_1']";
    public static final String PRICE_PRODUCT = "//div[@class='product-price']/span";
}
