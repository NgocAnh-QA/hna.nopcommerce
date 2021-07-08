package pageUIs.User;

public class AbstractPageUI {
    public static final String LOGIN_LINK = "//a[@class='ico-login']";
    public static final String MY_ACCOUNT_LINK = "//a[@class='ico-account']";
    public static final String SHOPPING_CART_LINK = "//a[@class='ico-cart']";
    public static final String REGISTER_LINK = "//a[@class='ico-register']";
    public static final String DYNAMIC_RADIO_BUTTON_BY_ID = "//input[@id='%s']";
    public static final String DYNAMIC_CHECKBOX_BY_ID = "//input[@id='%s']";
    public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
    public static final String DYNAMIC_DROPDOWN_BY_NAME = "//select[@name='%s']";
    public static final String LOGOUT_LINK = "//a[@class='ico-logout']";

    public static final String DYNAMIC_LINK_ASIDE = "//div[@class='listbox']//a[text()='%s']";
    public static final String DYNAMIC_TEXT_BY_CLASS = "//li[@class='%s']";

    public static final String HOME_PAGE_LINK = "//div[@class='header-logo']//a";

    public static final String DYNAMIC_PRODUCT_DETAIL_LINK = "//h2[@class='product-title']/a[text()='%s']";
    public static final String DYNAMIC_LINK_TEXT_AT_FOOTER = "//div[@class='footer-upper']//a[text()='%s']";

    public static final String DYNAMIC_MENU_NAVIGATION = "//ul[@class='top-menu notmobile']/li/a[contains(.,'%s')]";
    public static final String DYNAMIC_SUBMENU_NAVIGATION = "//ul[@class='top-menu notmobile']/li/a[contains(.,'%s')]/parent::li//li/a[contains(.,'%s')]";
    public static final String WISHLIST_LINK = "//a[@class='ico-wishlist']";

    public static final String QUALITY_IN_WISHLIST_ICON = "//a[@class='ico-wishlist']//span[@class='wishlist-qty']";
    public static final String QUALITY_IN_CART_ICON = "//a[@class='ico-cart']//span[@class='cart-qty']";

    public static final String DYNAMIC_COMPARE_PRODUCT_NAME = "//a[text()='%s']/parent::h2/following-sibling::div[@class='add-info']//button[@title='Add to compare list']";

    public static final String ADD_COMPARE_SUCCESS_MESSAGE = "//p[@class='content']";
    public static final String CLOSE_ADD_COMPARE_SUCCESS_BUTTON = "//div[@class='bar-notification success']/span";

    public static final String NUMBER_ITEMS_IN_CART_TEXT = "//div[@class='flyout-cart active']//div[@class='count']";
    public static final String SUB_TOTAL_IN_CART_TEXT = "//div[@class='flyout-cart active']//div[@class='totals']/strong";

    public static final String DYNAMIC_PRODUCT_NAME_IN_CART_ICON_IN_HEADER = "//div[@class='flyout-cart active']//div[@class='product']/div[@class='name']/a[text()='%s']";
    public static final String PRODUCT_INFORMATION_IN_CART_ICON_IN_HEADER = "//div[@class='flyout-cart active']//div[@class='product']/div[@class='name']/a[text()='Build your own computer']/parent::div/following-sibling::div[@class='attributes']";

    public static final String ORDER_NUMBER_TEXT = "//div[@class='page-body checkout-data']//div[@class='order-number']/strong";


}
