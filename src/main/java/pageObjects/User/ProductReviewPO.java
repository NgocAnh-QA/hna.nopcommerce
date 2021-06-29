package pageObjects.User;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.User.ProductReviewPageUI;

public class ProductReviewPO extends AbstractPage {
    WebDriver driver;
    public ProductReviewPO(WebDriver driver) {
        this.driver = driver;
    }


    public void inputToReviewContentTextArea(String reviewContent) {
        waitForElementVisible(driver, ProductReviewPageUI.REVIEW_CONTENT_TEXTAREA);
        sendKeyToElement(driver, ProductReviewPageUI.REVIEW_CONTENT_TEXTAREA, reviewContent);
    }

    public void clickToSubmitReview() {
        waitForElementClickable(driver, ProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
        clickToElement(driver, ProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
    }

    public Object getResultMessage() {
        waitForElementVisible(driver, ProductReviewPageUI.RESULT_MESSAGE);
        return getElementText(driver, ProductReviewPageUI.RESULT_MESSAGE).trim();
    }
}
