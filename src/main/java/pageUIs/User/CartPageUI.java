package pageUIs.User;


public class CartPageUI {
    public static final String SHOPPING_CART_TITLE_PAGE = "//div[@class='page shopping-cart-page']//h1";

    public static final String NAME_PRODUCT_IN_CART = "//td[@class='product']/a[@class='product-name']";
    public static final String EDIT_LINK = "//div[@class='edit-item']/a";
    public static final String TOTAL_ORDER = "//tr[@class='order-total']//span/strong";

    public static final String DYNAMIC_PRODUCT_NAME_IN_CART_PAGE = "//table[@class='cart']//td[@class='product']/a[text()='%s']";
    public static final String PRODUCT_INFORMATION_IN_CART_PAGE = "//table[@class='cart']//td[@class='product']/a[text()='%s']/following-sibling::div[@class='attributes']";

}
