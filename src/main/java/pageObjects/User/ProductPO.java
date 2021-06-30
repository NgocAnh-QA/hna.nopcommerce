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

    public boolean areProductsSortedByNameAscending(){
        waitForElementVisible(driver, ProductPageUI.PRODUCTS_TITLE_TEXTLINK);
        return isDataStringSortedAscending(driver, ProductPageUI.PRODUCTS_TITLE_TEXTLINK);
    }

    public boolean areProductsSortedByNameDescending(){
        waitForElementVisible(driver, ProductPageUI.PRODUCTS_TITLE_TEXTLINK);
        return isDataStringSortedDescending(driver, ProductPageUI.PRODUCTS_TITLE_TEXTLINK);
    }

    public boolean areProductsSortedByPriceLowToHigh(){
        waitForElementVisible(driver, ProductPageUI.PRODUCTS_PRICE_TEXT);
        return isDataFloatSortedAscending(driver, ProductPageUI.PRODUCTS_PRICE_TEXT);
    }

    public boolean areProductsSortedByPriceHighToLow(){
        waitForElementVisible(driver, ProductPageUI.PRODUCTS_PRICE_TEXT);
        return isDataFloatSortedDescending(driver, ProductPageUI.PRODUCTS_PRICE_TEXT);
    }
}
