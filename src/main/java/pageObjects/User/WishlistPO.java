package pageObjects.User;

import commons.AbstractPage;
import commons.PageGeneratorManagerUser;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.User.WishlistPageUI;

public class WishlistPO extends AbstractPage {
    WebDriver driver;

    public WishlistPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Get Product name in wishlist page")
    public String getTextProductNameInWishlistPage() {
        waitForElementClickable(driver, WishlistPageUI.NAME_PRODUCT_IN_WISHLIST_PAGE);
        return getElementText(driver, WishlistPageUI.NAME_PRODUCT_IN_WISHLIST_PAGE);
    }

    @Step("Click to link wishlist sharing ")
    public void clickToLinkWishlistSharing() {
        waitForElementClickable(driver, WishlistPageUI.WISHLIST_SHARING_LINK);
        clickToElement(driver, WishlistPageUI.WISHLIST_SHARING_LINK);
    }

    @Step("Check to check box add to cart")
    public void clickToCheckboxAddToCart() {
        waitForElementClickable(driver, WishlistPageUI.ADD_TO_CART_CHECKBOX);
        clickToElement(driver, WishlistPageUI.ADD_TO_CART_CHECKBOX);
    }

    @Step("Click to Add to cart button")
    public CartPO clickToAddToCartButton() {
        waitForElementClickable(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
        clickToElement(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
        return PageGeneratorManagerUser.getCartPage(driver);
    }

    @Step("Click to remove icon")
    public void clickToRemoveIcon() {
        waitForElementClickable(driver, WishlistPageUI.REMOVE_ICON);
        clickToElement(driver, WishlistPageUI.REMOVE_ICON);
    }

    @Step("Get text with list empty message")
    public String getTextWishlistEmptyMessage() {
        waitForElementVisible(driver, WishlistPageUI.WISHLIST_EMPTY_MESSAGE);
        return getElementText(driver, WishlistPageUI.WISHLIST_EMPTY_MESSAGE);
    }
}
