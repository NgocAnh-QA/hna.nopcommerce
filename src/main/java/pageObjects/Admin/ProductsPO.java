package pageObjects.Admin;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.Admin.ProductsPageUI;

public class ProductsPO extends AbstractPage {
    WebDriver driver;

    public ProductsPO(WebDriver driver) {
        this.driver = driver;
    }

    public void openSearchPanel() {
        if (!isElementUnDisplayed(driver, ProductsPageUI.CLOSE_SEARCH_PANEL_ICON)){
            clickToElement(driver, ProductsPageUI.OPEN_SEARCH_PANEL_ICON);
        }
    }

    public void inputToProductNameTextbox(String productName) {
        waitForElementVisible(driver, ProductsPageUI.PRODUCT_NAME_TEXT_BOX);
        sendKeyToElement(driver, ProductsPageUI.PRODUCT_NAME_TEXT_BOX, productName);
    }

    public void clickToSeachButton() {
        waitForElementVisible(driver, ProductsPageUI.SEARCH_BUTTON);
        clickToElement(driver, ProductsPageUI.SEARCH_BUTTON);
        waitAjaxLoadingInvisible(driver);
    }


    public boolean isProductDetailDisplayedAtTable(String productName, String sku, String price) {
        waitForElementVisible(driver, ProductsPageUI.DYNAMIC_PRODUCT_DETAIL_AT_TABLE, productName, sku, price);
        return isElementDisplayed(driver, ProductsPageUI.DYNAMIC_PRODUCT_DETAIL_AT_TABLE, productName, sku, price);
    }

    public int getProductsAtTable() {
        waitForElementVisible(driver, ProductsPageUI.COUNT_ROW_AT_TABLE);
        return countElementSize(driver, ProductsPageUI.COUNT_ROW_AT_TABLE);

    }

    public boolean isNoDataAvailableMessageDisplayed() {
        waitForElementVisible(driver, ProductsPageUI.NO_DATA_AT_TABLE_MESSAGE);
        return isElementDisplayed(driver, ProductsPageUI.NO_DATA_AT_TABLE_MESSAGE);

    }

    public void selectCategoryDropdown(String textValue) {
        waitForElementVisible(driver, ProductsPageUI.CATEGORY_DROPDOWN);
        selectItemByVisible(driver, textValue,  ProductsPageUI.CATEGORY_DROPDOWN);

    }

    public void unCheckToSubcatogories() {
        waitForElementVisible(driver, ProductsPageUI.SUB_CATEGORIES_CHECK_BOX);
        unCheckToCheckBox(driver, ProductsPageUI.SUB_CATEGORIES_CHECK_BOX);
    }

    public void checkToSubcatogories() {
        waitForElementVisible(driver, ProductsPageUI.SUB_CATEGORIES_CHECK_BOX);
        checkToCheckBox(driver, ProductsPageUI.SUB_CATEGORIES_CHECK_BOX);
    }

    public void selectManufacturerDropdown(String textValue) {
        waitForElementVisible(driver, ProductsPageUI.MANUFACTURER_DROPDOWN);
        selectItemByVisible(driver, textValue,  ProductsPageUI.MANUFACTURER_DROPDOWN);
    }

    public String formatPrice(String price){
        return price.substring(0, price.lastIndexOf("."));
    }
}
