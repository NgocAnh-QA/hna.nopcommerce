package pageObjects.User;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.User.CartPageUI;
import pageUIs.User.CompareProductPageUI;

public class CompareProductPO extends AbstractPage {
    WebDriver driver;

    public CompareProductPO(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isDirectToComparePage() {
        waitForElementVisible(driver, CompareProductPageUI.TITLE_PAGE);
        return isElementDisplayed(driver, CompareProductPageUI.TITLE_PAGE);
    }

    public boolean isClearListButtonDisplay() {
        waitForElementVisible(driver, CompareProductPageUI.CLEAR_LIST_BUTTON);
        return isElementDisplayed(driver, CompareProductPageUI.CLEAR_LIST_BUTTON);
    }

    public void clickToClearListButton() {
        waitForElementVisible(driver, CompareProductPageUI.CLEAR_LIST_BUTTON);
        clickToElement(driver, CompareProductPageUI.CLEAR_LIST_BUTTON);
    }

    public boolean isRemoveIconDisplayedAtTable(String productName) {
        waitForElementVisible(driver, CompareProductPageUI.DYNAMIC_PRECEDING_PRODUCT_NAME, productName);
        int countElement = countElementSize(driver, CompareProductPageUI.DYNAMIC_PRECEDING_PRODUCT_NAME, productName) +1;
        return isElementDisplayed(driver, CompareProductPageUI.DYNAMIC_REMOVE_ICON_AT_TABLE_COMPARE, String.valueOf(countElement));
    }

    public String getProductNameAtTable(String productName) {
        waitForElementVisible(driver, CompareProductPageUI.DYNAMIC_PRECEDING_PRODUCT_NAME, productName);
        int countElement = countElementSize(driver, CompareProductPageUI.DYNAMIC_PRECEDING_PRODUCT_NAME, productName) +1;
        return getElementText(driver, CompareProductPageUI.DYNAMIC_PRODUCT_NAME_AT_TABLE_COMPARE, String.valueOf(countElement));
    }

    public String getProductPriceAtTable(String productName) {
        waitForElementVisible(driver, CompareProductPageUI.DYNAMIC_PRECEDING_PRODUCT_NAME, productName);
        int countElement = countElementSize(driver, CompareProductPageUI.DYNAMIC_PRECEDING_PRODUCT_NAME, productName) +1;
        return getElementText(driver, CompareProductPageUI.DYNAMIC_PRODUCT_PRICE_AT_TABLE_COMPARE, String.valueOf(countElement)).replace("$", "").replace(",", "");
    }

    public String getTextNoItemsComparePageMessage() {
        waitForElementVisible(driver, CompareProductPageUI.NO_DATA_COMPARE_MESSAGE);
        return getElementText(driver, CompareProductPageUI.NO_DATA_COMPARE_MESSAGE);
    }

    public boolean isNoProductInComparePage() {
        return isElementUnDisplayed(driver, CompareProductPageUI.CLEAR_LIST_BUTTON);
    }
}
