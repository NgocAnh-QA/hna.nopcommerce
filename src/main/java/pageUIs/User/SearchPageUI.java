package pageUIs.User;

public class
SearchPageUI {
    public static final String SEARCH_BUTTON = "//button[@class='button-1 search-button']";
    public static final String DATA_EMPTY_ERROR_MESSAGE = "//div[@class='warning']";
    public static final String DATA_NO_EXIST_ERROR_MESSAGE = "//div[@class='no-result']";
    public static final String SEARCH_TEXTBOX = "//div[@class='inputs']/input";
    public static final String RESULT_SEARCH_PRODUCTS = "//h2[@class='product-title']/a";

    public static final String ADVANCED_SEACH_CHECKBOX = "//input[@id='advs']";
  //  public static final String DYNAMIC_CATEGORY_DROPDOWN = "//label[text()='Category:']//following-sibling::select/option[text()='%s']";
    public static final String CATEGORY_DROPDOWN = "//label[text()='Category:']//following-sibling::select";
    public static final String MANUFACTURER_DROPDOWN = "//label[text()='Manufacturer:']//following-sibling::select";
    public static final String AUTOMATICALLY_SEARCH_CHECKBOX = "//input[@id='isc']";
}
