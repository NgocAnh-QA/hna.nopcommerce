package pageUIs.User;

public class CompareProductPageUI {
    public static final String TITLE_PAGE = "//div[@class='page-title']/h1";
    public static final String CLEAR_LIST_BUTTON = "//div[@class='page-body']/a";

    public static final String DYNAMIC_PRECEDING_PRODUCT_NAME = "//tr[@class='product-name']//td//a[text()='%s']/parent::td/preceding-sibling::td";
    public static final String DYNAMIC_REMOVE_ICON_AT_TABLE_COMPARE = "//tr[@class='remove-product']//td[%s]/button";
    public static final String DYNAMIC_PRODUCT_NAME_AT_TABLE_COMPARE = "//tr[@class='product-name']//td[%s]/a";
    public static final String DYNAMIC_PRODUCT_PRICE_AT_TABLE_COMPARE = "//tr[@class='product-price']//td[%s]";

    public static final String NO_DATA_COMPARE_MESSAGE = "//div[@class='no-data']";

}
