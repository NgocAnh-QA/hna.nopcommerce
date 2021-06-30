package pageUIs.User;

public class AbstractPageUI {
    public static final String LOGIN_LINK = "//a[@class='ico-login']";
    public static final String MY_ACCOUNT_LINK = "//a[@class='ico-account']";
    public static final String REGISTER_LINK = "//a[@class='ico-register']";
    public static final String DYNAMIC_RADIO_BUTTON_BY_ID = "//input[@id='%s']";
    public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
    public static final String DYNAMIC_DROPDOWN_BY_NAME = "//select[@name='%s']";
    public static final String LOGOUT_LINK = "//a[@class='ico-logout']";

    public static final String DYNAMIC_LINK_ASIDE = "//div[@class='listbox']//a[text()='%s']";
    public static final String DYNAMIC_TEXT_BY_CLASS = "//li[@class='%s']";

    public static final String HOME_PAGE_LINK = "//div[@class='header-logo']//a";

    public static final String DYNAMIC_PRODUCT_DETAIL_LINK = "//h2[@class='product-title']/a[text()='%s']";
    public static final String DYNAMIC_LINK_TEXT_AT_FOOTER = "//div[@class='footer-upper']//a[text()='%s']";

    public static final String DYNAMIC_MENU_NAVIGATION = "//ul[@class='top-menu notmobile']//a[text()='%s ']";
    public static final String DYNAMIC_SUBMENU_NAVIGATION = "//ul[@class='top-menu notmobile']//a[text()='%s ']/parent::li//li/a[text()='%s ']";
}
