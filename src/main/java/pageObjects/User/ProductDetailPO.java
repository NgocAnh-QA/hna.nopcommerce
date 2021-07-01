package pageObjects.User;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.User.LoginPageUI;
import pageUIs.User.ProductDetailPageUI;

public class ProductDetailPO extends AbstractPage {
    WebDriver driver;
    public ProductDetailPO(WebDriver driver) {
        this.driver = driver;
    }

    public ProductReviewPO clickToAddYourReview() {
        waitForElementClickable(driver, ProductDetailPageUI.ADD_YOUR_REVIEW_LINK);
        clickToElement(driver, ProductDetailPageUI.ADD_YOUR_REVIEW_LINK);
        return PageGeneratorManager.getProductReviewPage(driver);
    }

    public void clickToAddToWishlist() {
        waitForElementVisible(driver, ProductDetailPageUI.ADD_TO_WISHLIST_BUTTON);
        clickToElement(driver, ProductDetailPageUI.ADD_TO_WISHLIST_BUTTON);
    }

    public String getAddToWishlistSuccessMessage() {
        waitForElementVisible(driver, ProductDetailPageUI.ADD_WISHLIST_SUCCESS_MESSAGE);
        return getElementText(driver, ProductDetailPageUI.ADD_WISHLIST_SUCCESS_MESSAGE);
    }

    public void clickToCloseWishListNotiButton() {
        waitForElementVisible(driver, ProductDetailPageUI.CLOSE_SUCCESS_IN_BAR_BUTTON);
        clickToElement(driver, ProductDetailPageUI.CLOSE_SUCCESS_IN_BAR_BUTTON);
    }

    public ProductPO backToProductsPage() {
        backToPage(driver);
        return PageGeneratorManager.getProductPage(driver);
    }
}
