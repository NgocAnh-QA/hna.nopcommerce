package pageUIs.Admin;

public class ProductsPageUI {
    public static final String CLOSE_SEARCH_PANEL_ICON = "//div[@class='row search-row']/div[@class='icon-collapse']//i[@class='far fa-angle-down']";
    public static final String OPEN_SEARCH_PANEL_ICON = "//div[@class='row search-row opened']/div[@class='icon-collapse']//i[@class='far fa-angle-up']";

    public static final String PRODUCT_NAME_TEXT_BOX = "//input[@id='SearchProductName']";
    public static final String CATEGORY_DROPDOWN = "//select[@id='SearchCategoryId']";
    public static final String SUB_CATEGORIES_CHECK_BOX = "//input[@id='SearchIncludeSubCategories']";
    public static final String MANUFACTURER_DROPDOWN = "//select[@id='SearchManufacturerId']";
    public static final String SEARCH_BUTTON = "//button[@id='search-products']";

    public static final String DYNAMIC_PRODUCT_DETAIL_AT_TABLE = "//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']";
    public static final String COUNT_ROW_AT_TABLE = "//table[@id='products-grid']/tbody/tr";

    public static final String NO_DATA_AT_TABLE_MESSAGE = "//td[@class='dataTables_empty']";


    public static final String SKU_TEXT_BOX = "//input[@id='GoDirectlyToSku']";
    public static final String GO_BUTTON_AT_SKU_FIELD = "//button[@id='go-to-product-by-sku']";
}
