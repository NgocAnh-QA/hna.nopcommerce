package pageUIs.User;

public class
ProductPageUI {
    public static final String SORT_BY_DROPDOWN = "//select[@id='products-orderby']";
    public static final String DISPLAY_DROPDOWN = "//select[@id='products-pagesize']";
    public static final String PRODUCTS_TITLE_TEXTLINK = "//h2[@class='product-title']/a";

    public static final String PRODUCTS_PRICE_TEXT = "//div[@class='prices']/span";
    
    public static final String NEXT_PAGE_BUTTON = "//li[@class='next-page']/a";
    public static final String PREVIOUS_PAGE_BUTTON = "//li[@class='previous-page']/a";
    public static final String DYNAMIC_PAGE_NUMBER = "//li[@class='individual-page']/a[text()='%s']";
    public static final String PAGING = "//div[@class='pager']";
}
