package pageObjects.User;

import commons.AbstractPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.User.ProductReviewPageUI;

public class ProductReviewPO extends AbstractPage {
    WebDriver driver;
    public ProductReviewPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Input to review content text area with value: {0}")
    public void inputToReviewContentTextArea(String reviewContent) {
        waitForElementVisible(driver, ProductReviewPageUI.REVIEW_CONTENT_TEXTAREA);
        sendKeyToElement(driver, ProductReviewPageUI.REVIEW_CONTENT_TEXTAREA, reviewContent);
    }

    @Step("Click to submit review")
    public void clickToSubmitReview() {
        waitForElementClickable(driver, ProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
        clickToElement(driver, ProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
    }

    @Step("Get result message")
    public Object getResultMessage() {
        waitForElementVisible(driver, ProductReviewPageUI.RESULT_MESSAGE);
        return getElementText(driver, ProductReviewPageUI.RESULT_MESSAGE).trim();
    }
}
