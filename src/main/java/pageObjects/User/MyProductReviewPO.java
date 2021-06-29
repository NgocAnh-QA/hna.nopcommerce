package pageObjects.User;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.User.MyProductReviewPageUI;
import pageUIs.User.ProductDetailPageUI;

public class MyProductReviewPO extends AbstractPage {
    WebDriver driver;
    public MyProductReviewPO(WebDriver driver) {
        this.driver = driver;
    }


    public String getReviewTitleInMyAccount() {
        waitForElementVisible(driver, MyProductReviewPageUI.REVIEW_TITLE_TEXT);
        return getElementText(driver, MyProductReviewPageUI.REVIEW_TITLE_TEXT);
    }

    public String getReviewContentInMyAccount() {
        waitForElementVisible(driver, MyProductReviewPageUI.REVIEW_CONTENT_TEXT);
        return getElementText(driver, MyProductReviewPageUI.REVIEW_CONTENT_TEXT);
    }
}
