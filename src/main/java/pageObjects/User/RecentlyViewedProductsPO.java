package pageObjects.User;

import commons.AbstractPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.User.CartPageUI;
import pageUIs.User.RecentlyViewedProductsPageUI;

public class RecentlyViewedProductsPO extends AbstractPage {
    WebDriver driver;

    public RecentlyViewedProductsPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Verify product: {0} is displayed")
    public boolean isProductNameDisplayed(String productName) {
        waitForElementVisible(driver, RecentlyViewedProductsPageUI.DYNAMIC_PRODUCT_NAME, productName);
        return isElementDisplayed(driver, RecentlyViewedProductsPageUI.DYNAMIC_PRODUCT_NAME, productName);

    }

    @Step("Count number of products")
    public int countProducts() {
        waitForElementVisible(driver, RecentlyViewedProductsPageUI.LIST_PRODUCTS);
        return countElementSize(driver, RecentlyViewedProductsPageUI.LIST_PRODUCTS);
    }
}
