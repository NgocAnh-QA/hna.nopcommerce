package pageObjects.User;

import commons.AbstractPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.User.ProductPageUI;

public class ProductPO extends AbstractPage {
    WebDriver driver;

    public ProductPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Select sort by name: A to Z")
    public void selectSortByNameAToZ() {
        waitForElementVisible(driver, ProductPageUI.SORT_BY_DROPDOWN);
        selectItemByVisible(driver, "Name: A to Z", ProductPageUI.SORT_BY_DROPDOWN);
        sleepInSecond(2);
    }

    @Step("Select sort by name: Z to A")
    public void selectSortByNameZToA() {
        waitForElementVisible(driver, ProductPageUI.SORT_BY_DROPDOWN);
        selectItemByVisible(driver, "Name: Z to A", ProductPageUI.SORT_BY_DROPDOWN);
        sleepInSecond(2);
    }

    @Step("Select sort by price: Low to High")
    public void selectSortByPriceLowToHigh() {
        waitForElementVisible(driver, ProductPageUI.SORT_BY_DROPDOWN);
        selectItemByVisible(driver, "Price: Low to High", ProductPageUI.SORT_BY_DROPDOWN);
        sleepInSecond(2);
    }

    @Step("Select sort by price: High to Low")
    public void selectSortByPriceHighToLow() {
        waitForElementVisible(driver, ProductPageUI.SORT_BY_DROPDOWN);
        selectItemByVisible(driver, "Price: High to Low", ProductPageUI.SORT_BY_DROPDOWN);
        sleepInSecond(2);
    }

    @Step("Verify Products are sorted by name ascending")
    public boolean areProductsSortedByNameAscending() {
        waitForElementVisible(driver, ProductPageUI.PRODUCTS_TITLE_TEXTLINK);
        return isDataStringSortedAscending(driver, ProductPageUI.PRODUCTS_TITLE_TEXTLINK);
    }

    @Step("Verify Products are sorted by name descending")
    public boolean areProductsSortedByNameDescending() {
        waitForElementVisible(driver, ProductPageUI.PRODUCTS_TITLE_TEXTLINK);
        return isDataStringSortedDescending(driver, ProductPageUI.PRODUCTS_TITLE_TEXTLINK);
    }

    @Step("Verify Products are sorted by price: low to high")
    public boolean areProductsSortedByPriceLowToHigh() {
        waitForElementVisible(driver, ProductPageUI.PRODUCTS_PRICE_TEXT);
        return isDataFloatSortedAscending(driver, ProductPageUI.PRODUCTS_PRICE_TEXT);
    }

    @Step("Verify Products are sorted by price: high to low")
    public boolean areProductsSortedByPriceHighToLow() {
        waitForElementVisible(driver, ProductPageUI.PRODUCTS_PRICE_TEXT);
        return isDataFloatSortedDescending(driver, ProductPageUI.PRODUCTS_PRICE_TEXT);
    }

    @Step("Select Products display: {0} per page")
    public void selectDisplayPerpage(String numberOfItems) {
        waitForElementVisible(driver, ProductPageUI.DISPLAY_DROPDOWN);
        selectItemByVisible(driver, numberOfItems, ProductPageUI.DISPLAY_DROPDOWN);
        sleepInSecond(4);
    }

    @Step("Verify Products are displayed: {0} per page ")
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

    @Step("Verify next icon is displayed")
    public boolean isNextIconDisplayed() {
        waitForElementVisible(driver, ProductPageUI.NEXT_PAGE_BUTTON);
        return isElementDisplayed(driver, ProductPageUI.NEXT_PAGE_BUTTON);
    }

    @Step("Verify previous icon is displayed")
    public boolean isPreviousIconDisplay() {
        waitForElementVisible(driver, ProductPageUI.PREVIOUS_PAGE_BUTTON);
        return isElementDisplayed(driver, ProductPageUI.PREVIOUS_PAGE_BUTTON);
    }

    @Step("Click to move to page")
    public void clickMoveToPage(String pageNumber) {
        waitForElementVisible(driver, ProductPageUI.DYNAMIC_PAGE_NUMBER, pageNumber);
        clickToElement(driver, ProductPageUI.DYNAMIC_PAGE_NUMBER, pageNumber);
    }

    @Step("Verify Paging is undisplayed")
    public boolean isPagingUnDisplayed() {
        return isElementUnDisplayed(driver, ProductPageUI.PAGING);
    }
}
