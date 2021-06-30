package pageObjects.User;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.User.LoginPageUI;
import pageUIs.User.ProductPageUI;

public class ProductPO extends AbstractPage {
    WebDriver driver;

    public ProductPO(WebDriver driver) {
        this.driver = driver;
    }


    public void selectSortByNameAToZ() {
        waitForElementVisible(driver, ProductPageUI.SORT_BY_DROPDOWN);
        selectItemByVisible(driver, "Name: A to Z", ProductPageUI.SORT_BY_DROPDOWN);
        sleepInSecond(2);
    }

    public void selectSortByNameZToA() {
        waitForElementVisible(driver, ProductPageUI.SORT_BY_DROPDOWN);
        selectItemByVisible(driver, "Name: Z to A", ProductPageUI.SORT_BY_DROPDOWN);
        sleepInSecond(2);
    }

    public void selectSortByPriceLowToHigh() {
        waitForElementVisible(driver, ProductPageUI.SORT_BY_DROPDOWN);
        selectItemByVisible(driver, "Price: Low to High", ProductPageUI.SORT_BY_DROPDOWN);
        sleepInSecond(2);
    }

    public void selectSortByPriceHighToLow() {
        waitForElementVisible(driver, ProductPageUI.SORT_BY_DROPDOWN);
        selectItemByVisible(driver, "Price: High to Low", ProductPageUI.SORT_BY_DROPDOWN);
        sleepInSecond(2);
    }

    public boolean areProductsSortedByNameAscending() {
        waitForElementVisible(driver, ProductPageUI.PRODUCTS_TITLE_TEXTLINK);
        return isDataStringSortedAscending(driver, ProductPageUI.PRODUCTS_TITLE_TEXTLINK);
    }

    public boolean areProductsSortedByNameDescending() {
        waitForElementVisible(driver, ProductPageUI.PRODUCTS_TITLE_TEXTLINK);
        return isDataStringSortedDescending(driver, ProductPageUI.PRODUCTS_TITLE_TEXTLINK);
    }

    public boolean areProductsSortedByPriceLowToHigh() {
        waitForElementVisible(driver, ProductPageUI.PRODUCTS_PRICE_TEXT);
        return isDataFloatSortedAscending(driver, ProductPageUI.PRODUCTS_PRICE_TEXT);
    }

    public boolean areProductsSortedByPriceHighToLow() {
        waitForElementVisible(driver, ProductPageUI.PRODUCTS_PRICE_TEXT);
        return isDataFloatSortedDescending(driver, ProductPageUI.PRODUCTS_PRICE_TEXT);
    }

    public void selectDisplayPerpage(String numberOfItems) {
        waitForElementVisible(driver, ProductPageUI.DISPLAY_DROPDOWN);
        selectItemByVisible(driver, numberOfItems, ProductPageUI.DISPLAY_DROPDOWN);
        sleepInSecond(2);
    }

    public boolean areProductsDisplayedPerPage(int expectedNumber) {
        boolean check;
        int result = countElementSize(driver, ProductPageUI.PRODUCTS_TITLE_TEXTLINK);
        waitForElementVisible(driver, ProductPageUI.PRODUCTS_TITLE_TEXTLINK);
        if (result < expectedNumber || result == expectedNumber) {
            check = true;
        } else {
            check = false;
        }
        return check;
    }

    public boolean isNextIconDisplayed() {
        waitForElementVisible(driver, ProductPageUI.NEXT_PAGE_BUTTON);
        return isElementDisplayed(driver, ProductPageUI.NEXT_PAGE_BUTTON);
    }

    public boolean isPreviousIconDisplay() {
        waitForElementVisible(driver, ProductPageUI.PREVIOUS_PAGE_BUTTON);
        return isElementDisplayed(driver, ProductPageUI.PREVIOUS_PAGE_BUTTON);
    }

    public void clickMoveToPage(String pageNumber) {
        waitForElementVisible(driver, ProductPageUI.DYNAMIC_PAGE_NUMBER, pageNumber);
        clickToElement(driver, ProductPageUI.DYNAMIC_PAGE_NUMBER, pageNumber);
    }

    public boolean isPagingUnDisplayed() {
        return isElementUnDisplayed(driver, ProductPageUI.PAGING);
    }
}
