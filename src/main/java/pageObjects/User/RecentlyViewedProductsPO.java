package pageObjects.User;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.User.CartPageUI;
import pageUIs.User.RecentlyViewedProductsPageUI;

public class RecentlyViewedProductsPO extends AbstractPage {
    WebDriver driver;

    public RecentlyViewedProductsPO(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isProductNameDisplayed(String productName) {
        waitForElementVisible(driver, RecentlyViewedProductsPageUI.DYNAMIC_PRODUCT_NAME, productName);
        return isElementDisplayed(driver, RecentlyViewedProductsPageUI.DYNAMIC_PRODUCT_NAME, productName);

    }

    public int countProducts() {
        waitForElementVisible(driver, RecentlyViewedProductsPageUI.LIST_PRODUCTS);
        return countElementSize(driver, RecentlyViewedProductsPageUI.LIST_PRODUCTS);
    }
}
