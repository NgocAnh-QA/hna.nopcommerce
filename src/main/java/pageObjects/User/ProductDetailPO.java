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

}
