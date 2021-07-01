package pageObjects.User;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.User.CartPageUI;
import pageUIs.User.SearchPageUI;

public class CartPO extends AbstractPage {
    WebDriver driver;

    public CartPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDirectPageToCartPage() {
        waitForElementVisible(driver, CartPageUI.SHOPPING_CART_TITLE_PAGE);
        return isElementDisplayed(driver, CartPageUI.SHOPPING_CART_TITLE_PAGE);
    }

    public String getProductNameInCart() {
        waitForElementVisible(driver, CartPageUI.NAME_PRODUCT_IN_CART);
        return getElementText(driver, CartPageUI.NAME_PRODUCT_IN_CART);
    }


}
