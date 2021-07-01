package pageObjects.User;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.User.WishlistPageUI;

public class WishlistPO extends AbstractPage {
    WebDriver driver;

    public WishlistPO(WebDriver driver) {
        this.driver = driver;
    }


    public String getTextProductNameInWishlistPage() {
        waitForElementClickable(driver, WishlistPageUI.NAME_PRODUCT_IN_WISHLIST_PAGE);
        return getElementText(driver, WishlistPageUI.NAME_PRODUCT_IN_WISHLIST_PAGE);
    }

    public void clickToLinkWishlistSharing() {
        waitForElementClickable(driver, WishlistPageUI.WISHLIST_SHARING_LINK);
        clickToElement(driver, WishlistPageUI.WISHLIST_SHARING_LINK);
    }

    public void clickToCheckboxAddToCart() {
        waitForElementClickable(driver, WishlistPageUI.ADD_TO_CART_CHECKBOX);
        clickToElement(driver, WishlistPageUI.ADD_TO_CART_CHECKBOX);

    }

    public CartPO clickToAddToCartButton() {
        waitForElementClickable(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
        clickToElement(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
        return PageGeneratorManager.getCartPage(driver);
    }

    public void clickToRemoveIcon() {
        waitForElementClickable(driver, WishlistPageUI.REMOVE_ICON);
        clickToElement(driver, WishlistPageUI.REMOVE_ICON);

    }

    public String getTextWishlistEmptyMessage() {
        waitForElementVisible(driver, WishlistPageUI.WISHLIST_EMPTY_MESSAGE);
        return getElementText(driver, WishlistPageUI.WISHLIST_EMPTY_MESSAGE);
    }
}
