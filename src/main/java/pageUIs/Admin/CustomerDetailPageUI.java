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
}
