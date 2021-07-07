package pageUIs.User;


public class CartPageUI {
    public static final String SHOPPING_CART_TITLE_PAGE = "//div[@class='page shopping-cart-page']//h1";

    public static final String NAME_PRODUCT_IN_CART = "//td[@class='product']/a[@class='product-name']";
    public static final String EDIT_LINK = "//div[@class='edit-item']/a";
    public static final String TOTAL_ORDER = "//tr[@class='order-total']//span/strong";

    public static final String DYNAMIC_PRODUCT_NAME_IN_CART_PAGE = "//table[@class='cart']//td[@class='product']/a[text()='%s']";
    public static final String PRODUCT_INFORMATION_IN_CART_PAGE = "//table[@class='cart']//td[@class='product']/a[text()='%s']/following-sibling::div[@class='attributes']";

    public static final String DYNAMIC_REMOVE_BY_PRODUCT_NAME_IN_CART_PAGE = "//a[@class='product-name' and text()='%s']/parent::td/following-sibling::td//button[@class='remove-btn']";
    public static final String CART_EMPTY_MESSAGE = "//div[@class='no-data']";

    public static final String QUANTITY_TEXT_BOX = "//input[@class='qty-input']";
    public static final String UPDATE_SHOPPING_CART_BUTTON = "//button[contains(@class,'update-cart-button')]";

    public static final String TERM_OF_SERVICE_CHECKBOX = "//input[@id='termsofservice']";
    public static final String CHECKOUT_BUTTON = "//button[@id='checkout']";
    public static final String GIFT_WRAPPING_DROPDOWN = "//div[@class='checkout-attributes']//select";
}
