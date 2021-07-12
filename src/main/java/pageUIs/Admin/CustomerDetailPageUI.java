package pageUIs.Admin;

public class CustomerDetailPageUI {
    public static final String DYNAMIC_TEXT_BOX_BY_ID = "//input[@id='%s']";
    public static final String DYNAMIC_RADIO_BUTTON_BY_ID = "//input[@id='%s']";
    public static final String DYNAMIC_CHECK_BOX_BY_ID = "//input[@id='%s']";
    public static final String DYNAMIC_TEXT_AREA_BY_ID = "//textarea[@id='%s']";
    public static final String SAVE_AND_CONTINUE_EDIT_BUTTON = "//button[@name='save-continue']";
    public static final String ADDED_SUCCESSFULLY_MESSAGE = "//div[contains(@class,'alert-success')]";
    public static final String BACK_TO_CUSTOMER_LIST_LINK = "//a[text()='back to customer list']";
    public static final String CUSTOMER_ROLES_TEXT_BOX = "//ul[@id='SelectedCustomerRoleIds_taglist']/following-sibling::input";
    public static final String DYNAMIC_CUSTOMER_ROLES_SELECTED = "//ul[@id='SelectedCustomerRoleIds_taglist']//span[text()='%s']";
    public static final String CLOSE_DEFAULT_VALUE_DROPDOWN = "//span[text()='Registered']/following-sibling::span";
    public static final String SAVE_BUTTON = "//button[@name='save']";
    public static final String DYNAMIC_PANEL_NAME_TEXT_CLOSE_ICON = "//div[@class='card-title' and text()='%s']/following-sibling::div//i[contains(@class,'plus')]";
    public static final String ADD_NEW_ADDRESS_BUTTON = "//button[contains(.,'Add new address')]";
    public static final String ADDRESS_DETAIL_ON_TABLE_AT_ADDRESSES_PANEL = "//table[@id='customer-addresses-grid']//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[contains(.,'%s%s%s%s,%s,%s%s')]";
    public static final String EDIT_AT_ADDRESS_DETAIL_ON_TABLE = "//table[@id='customer-addresses-grid']//following-sibling::td[contains(.,'%s%s%s%s,%s,%s%s')]/following-sibling::td[contains(.,'Edit')]";
    public static final String DELETE_AT_ADDRESS_DETAIL_ON_TABLE = "//table[@id='customer-addresses-grid']//following-sibling::td[contains(.,'%s%s%s%s,%s,%s%s')]/following-sibling::td[contains(.,'Delete')]";
    public static final String NO_DATA_IN_TABLE_AT_ADDRESSES_PANEL_MESSAGE = "//table[@id='customer-addresses-grid']//td[text()='No data available in table']";
}
