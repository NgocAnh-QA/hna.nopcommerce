package pageObjects.User;

import commons.AbstractPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.User.MyProductReviewPageUI;

public class MyProductReviewPO extends AbstractPage {
    WebDriver driver;
    public MyProductReviewPO(WebDriver driver) {
        this.driver = driver;
    }


    @Step("Get review title in my account")
    public String getReviewTitleInMyAccount() {
        waitForElementVisible(driver, MyProductReviewPageUI.REVIEW_TITLE_TEXT);
        return getElementText(driver, MyProductReviewPageUI.REVIEW_TITLE_TEXT);
    }

    @Step("Get review content in my account")
    public String getReviewContentInMyAccount() {
        waitForElementVisible(driver, MyProductReviewPageUI.REVIEW_CONTENT_TEXT);
        return getElementText(driver, MyProductReviewPageUI.REVIEW_CONTENT_TEXT);
    }
}
