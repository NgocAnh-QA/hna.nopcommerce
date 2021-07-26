package pageObjects.User;

import commons.AbstractPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.User.CartPageUI;
import pageUIs.User.CompareProductPageUI;

public class CompareProductPO extends AbstractPage {
    WebDriver driver;

    public CompareProductPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Verify user is on Compage page")
    public boolean isDirectToComparePage() {
        waitForElementVisible(driver, CompareProductPageUI.TITLE_PAGE);
        return isElementDisplayed(driver, CompareProductPageUI.TITLE_PAGE);
    }

    @Step("Verify Clear list button is displayed")
    public boolean isClearListButtonDisplay() {
        waitForElementVisible(driver, CompareProductPageUI.CLEAR_LIST_BUTTON);
        return isElementDisplayed(driver, CompareProductPageUI.CLEAR_LIST_BUTTON);
    }

    @Step("CLick to clear list button")
    public void clickToClearListButton() {
        waitForElementVisible(driver, CompareProductPageUI.CLEAR_LIST_BUTTON);
        clickToElement(driver, CompareProductPageUI.CLEAR_LIST_BUTTON);
    }

    @Step("Verify Remove icon is displayed at table")
    public boolean isRemoveIconDisplayedAtTable(String productName) {
        waitForElementVisible(driver, CompareProductPageUI.DYNAMIC_PRECEDING_PRODUCT_NAME, productName);
        int countElement = countElementSize(driver, CompareProductPageUI.DYNAMIC_PRECEDING_PRODUCT_NAME, productName) +1;
        return isElementDisplayed(driver, CompareProductPageUI.DYNAMIC_REMOVE_ICON_AT_TABLE_COMPARE, String.valueOf(countElement));
    }

    @Step("Get value of product name at table")
    public String getProductNameAtTable(String productName) {
        waitForElementVisible(driver, CompareProductPageUI.DYNAMIC_PRECEDING_PRODUCT_NAME, productName);
        int countElement = countElementSize(driver, CompareProductPageUI.DYNAMIC_PRECEDING_PRODUCT_NAME, productName) +1;
        return getElementText(driver, CompareProductPageUI.DYNAMIC_PRODUCT_NAME_AT_TABLE_COMPARE, String.valueOf(countElement));
    }

    @Step("Get value of product price at table")
    public String getProductPriceAtTable(String productName) {
        waitForElementVisible(driver, CompareProductPageUI.DYNAMIC_PRECEDING_PRODUCT_NAME, productName);
        int countElement = countElementSize(driver, CompareProductPageUI.DYNAMIC_PRECEDING_PRODUCT_NAME, productName) +1;
        return getElementText(driver, CompareProductPageUI.DYNAMIC_PRODUCT_PRICE_AT_TABLE_COMPARE, String.valueOf(countElement)).replace("$", "").replace(",", "");
    }

    @Step("Get No items compare page message")
    public String getTextNoItemsComparePageMessage() {
        waitForElementVisible(driver, CompareProductPageUI.NO_DATA_COMPARE_MESSAGE);
        return getElementText(driver, CompareProductPageUI.NO_DATA_COMPARE_MESSAGE);
    }

    @Step("Verify no products in compare page displayed")
    public boolean isNoProductInComparePageDisplayed() {
        return isElementUnDisplayed(driver, CompareProductPageUI.CLEAR_LIST_BUTTON);
    }
}
