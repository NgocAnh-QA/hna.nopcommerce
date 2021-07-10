package pageObjects.Admin;

import commons.AbstractPage;
import commons.PageGeneratorManagerAdmin;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageUIs.Admin.CustomerDetailPageUI;
import pageUIs.Admin.CustomersPageUI;
import pageUIs.Admin.LoginPageUI;
import pageUIs.Admin.ProductsPageUI;

import java.util.List;

public class CustomersPO extends AbstractPage {
    WebDriver driver;

    public CustomersPO(WebDriver driver) {
        this.driver = driver;
    }

    public CustomerDetailPO clickToAddNewButton() {
        waitForElementClickable(driver, CustomersPageUI.ADD_NEW_BUTTON);
        clickToElement(driver, CustomersPageUI.ADD_NEW_BUTTON);
        return PageGeneratorManagerAdmin.getCustomerDetailPage(driver);
    }

    public void openSearchPanel() {
        if (!isElementUnDisplayed(driver, CustomersPageUI.CLOSE_SEARCH_PANEL_ICON)){
            clickToElement(driver, CustomersPageUI.OPEN_SEARCH_PANEL_ICON);
        }
    }

    public void inputToCustomerRolesTextbox(String textValue) {
        waitForElementVisible(driver, CustomersPageUI.CLOSE_DEFAULT_VALUE_DROPDOWN);
        clickToElement(driver, CustomersPageUI.CLOSE_DEFAULT_VALUE_DROPDOWN);
        sendKeyToElement(driver, CustomersPageUI.CUSTOMER_ROLES_TEXTBOX, textValue);
        sendKeyBoardToElement(driver, CustomersPageUI.CUSTOMER_ROLES_TEXTBOX, Keys.ENTER);
    }

    public void clickToSearchButton() {
        waitForElementVisible(driver, CustomersPageUI.SEARCH_BUTTON);
        clickToElement(driver, CustomersPageUI.SEARCH_BUTTON);
        waitAjaxLoadingInvisible(driver);
    }

    public boolean isCustomerDetailDataDisplayedAtTable(String email, String firstName, String lastName, String customerRoles, String companyName) {
        waitForElementVisible(driver, CustomersPageUI.CUSTOMER_DETAIL_DATA_AT_TABLE, email, firstName + " " + lastName, customerRoles, companyName);
        return isElementDisplayed(driver, CustomersPageUI.CUSTOMER_DETAIL_DATA_AT_TABLE, email, firstName + " " + lastName, customerRoles, companyName);
    }

    public boolean isCustomerDetailDataDisplayedAtTableByColumnName(String columnName, String expectedValue){
        boolean check = true;
        int indexColumn = countElementSize(driver, CustomersPageUI.COLUMN_INDEX_AT_TABLE_CUSTOMER_LIST, columnName) + 1 ;
        List<String> actualValues = getElementsText(driver, CustomersPageUI.CELL_INDEX_AT_TABLE_CUSTOMER_LIST, String.valueOf(indexColumn));
        for (String actualValue : actualValues) {
            if (actualValue.equals(expectedValue)){
                System.out.println(actualValue);
                check = true;
            }
            else {
                check = false;
            }
        }
        return check;
    }

    public void inputToEmailTextbox(String textValue) {
        waitForElementVisible(driver, CustomersPageUI.EMAIL_TEXT_BOX);
        sendKeyToElement(driver, CustomersPageUI.EMAIL_TEXT_BOX, textValue);
    }

    public void inputToFirstNameTextbox(String textValue) {
        waitForElementVisible(driver, CustomersPageUI.FIRST_NAME_TEXT_BOX);
        sendKeyToElement(driver, CustomersPageUI.FIRST_NAME_TEXT_BOX, textValue);
    }

    public void inputToLastNameTextbox(String textValue) {
        waitForElementVisible(driver, CustomersPageUI.LAST_NAME_TEXT_BOX);
        sendKeyToElement(driver, CustomersPageUI.LAST_NAME_TEXT_BOX, textValue);
    }

    public void inputToCompanyTextbox(String textValue) {
        waitForElementVisible(driver, CustomersPageUI.COMPANY_TEXT_BOX);
        sendKeyToElement(driver, CustomersPageUI.COMPANY_TEXT_BOX, textValue);
    }
}
