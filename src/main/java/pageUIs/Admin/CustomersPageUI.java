package pageUIs.Admin;

public class CustomersPageUI {

    public static final String CLOSE_SEARCH_PANEL_ICON = "//div[@class='row search-row ']/div[@class='icon-collapse']/i[@class='far fa-angle-down']";
    public static final String OPEN_SEARCH_PANEL_ICON = "//div[@class='row search-row opened']/div[@class='icon-collapse']/i[@class='far fa-angle-up']";

    public static final String ADD_NEW_BUTTON = "//div[@class='content-header clearfix']/div/a";
    public static final String CUSTOMER_ROLES_TEXTBOX = "//ul[@id='SelectedCustomerRoleIds_taglist']/following-sibling::input";
    public static final String SEARCH_BUTTON = "//button[@id='search-customers']";

    public static final String COLUMN_INDEX_AT_TABLE_CUSTOMER_LIST= "//table/thead/tr/th[text()='%s']/preceding-sibling::th";
    public static final String CELL_INDEX_AT_TABLE_CUSTOMER_LIST= "//table[@id='customers-grid']/tbody/tr/td[%s]";

    public static final String CUSTOMER_DETAIL_DATA_AT_TABLE = "//table[@id='customers-grid']/tbody/tr/td[text()='%s']/parent::tr/td[text()='%s']/parent::tr/td[text()='%s']/parent::tr/td[text()='%s']";

    public static final String CLOSE_DEFAULT_VALUE_DROPDOWN = "//span[text()='Registered']/following-sibling::span";

    public static final String EMAIL_TEXT_BOX = "//input[@id='SearchEmail']";
    public static final String FIRST_NAME_TEXT_BOX = "//input[@id='SearchFirstName']";
    public static final String LAST_NAME_TEXT_BOX = "//input[@id='SearchLastName']";
    public static final String COMPANY_TEXT_BOX = "//input[@id='SearchCompany']";
    public static final String MONTH_OF_BIRTH_DROPDOWN = "//select[@id='SearchMonthOfBirth']";
    public static final String DAY_OF_BIRTH_DROPDOWN = "//select[@id='SearchDayOfBirth']";

    public static final String EDIT_BUTTON_BY_EMAIL = "//td[text()='%s']/following-sibling::td/a[text()='Edit']";
    public static final String UDPATE_SUCCESS_MESSAGE = "//div[contains(@class, 'alert-success')]";
}
