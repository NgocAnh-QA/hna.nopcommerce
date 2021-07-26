package pageObjects.User;

import commons.AbstractPage;
import commons.PageGeneratorManagerUser;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.User.ProductDetailPageUI;

import java.util.List;

public class ProductDetailPO extends AbstractPage {
    WebDriver driver;
    public ProductDetailPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click to Add your review")
    public ProductReviewPO clickToAddYourReview() {
        waitForElementClickable(driver, ProductDetailPageUI.ADD_YOUR_REVIEW_LINK);
        clickToElement(driver, ProductDetailPageUI.ADD_YOUR_REVIEW_LINK);
        return PageGeneratorManagerUser.getProductReviewPage(driver);
    }

    @Step("Click to Add to wishlist")
    public void clickToAddToWishlist() {
        waitForElementVisible(driver, ProductDetailPageUI.ADD_TO_WISHLIST_BUTTON);
        clickToElement(driver, ProductDetailPageUI.ADD_TO_WISHLIST_BUTTON);
    }

    @Step("Get Add to wishlist success message")
    public String getAddToWishlistSuccessMessage() {
        waitForElementVisible(driver, ProductDetailPageUI.ADD_WISHLIST_SUCCESS_MESSAGE);
        return getElementText(driver, ProductDetailPageUI.ADD_WISHLIST_SUCCESS_MESSAGE);
    }

    @Step("Click to Close wishlist notification button")
    public void clickToCloseWishListNotiButton() {
        waitForElementVisible(driver, ProductDetailPageUI.CLOSE_SUCCESS_IN_BAR_BUTTON);
        clickToElement(driver, ProductDetailPageUI.CLOSE_SUCCESS_IN_BAR_BUTTON);
    }

    @Step("Back to products page")
    public ProductPO backToProductsPage() {
        backToPage(driver);
        return PageGeneratorManagerUser.getProductPage(driver);
    }

    @Step("Check to Check box software")
    public void clickToCheckboxSoftwareOption(String...softwareName) {
        waitForElementVisible(driver, ProductDetailPageUI.SOFTWARE_CHECKBOX_ALL);
        List<WebElement> listElements = getElements(driver, ProductDetailPageUI.SOFTWARE_CHECKBOX_ALL);
        for (WebElement e: listElements) {
            if (e.isSelected()) {
                e.click();
            }
        }
        for (int i = 0; i < softwareName.length; i++){
            checkToCheckBox(driver, ProductDetailPageUI.DYNAMIC_SOFTWARE_CHECKBOX, softwareName[i]);
        }
    }

    @Step("Select Processor with value {0}")
    public void selectProcessorInDropdown(String processorName) {
        waitForElementVisible(driver, ProductDetailPageUI.PROCESSOR_DROPDOWN);
        selectItemByVisible(driver, processorName, ProductDetailPageUI.PROCESSOR_DROPDOWN);
        sleepInSecond(1);
    }

    @Step("Select Ram with value {0}")
    public void selectRAMInDropdown(String ramName) {
        waitForElementVisible(driver, ProductDetailPageUI.RAM_DROPDOWN);
        selectItemByVisible(driver, ramName, ProductDetailPageUI.RAM_DROPDOWN);
        sleepInSecond(1);

    }

    @Step("Click to HDD radio button {0}")
    public void clickToHDDRadioButton(String hddName) {
        waitForElementVisible(driver, ProductDetailPageUI.DYNAMIC_HDD_RADIO_BUTTON, hddName);
        clickToElement(driver, ProductDetailPageUI.DYNAMIC_HDD_RADIO_BUTTON, hddName);
        sleepInSecond(1);
    }

    @Step("Click to OS radio button {0}")
    public void clickToOSRadioButton(String osName) {
        waitForElementVisible(driver, ProductDetailPageUI.DYNAMIC_OS_RADIO_BUTTON, osName);
        clickToElement(driver, ProductDetailPageUI.DYNAMIC_OS_RADIO_BUTTON, osName);
        sleepInSecond(1);
    }

    @Step("Click to Add to cart button")
    public void clickToAddToCartButton() {
        waitForElementVisible(driver, ProductDetailPageUI.ADD_TO_CART_BUTTON);
        clickToElement(driver, ProductDetailPageUI.ADD_TO_CART_BUTTON);
        sleepInSecond(3);
    }

    @Step("Verify Add to cart success message is displayed")
    public boolean isAddToCartSuccessMessageDisplayed() {
        waitForElementVisible(driver, ProductDetailPageUI.ADD_TO_CART_SUCCESS_MESSAGE);
        return isElementDisplayed(driver, ProductDetailPageUI.ADD_TO_CART_SUCCESS_MESSAGE);
    }

    @Step("Click to Close add to cart success message")
    public void clickToCloseMessageAddToCartSuccess() {
        waitForElementVisible(driver, ProductDetailPageUI.CLOSE_ADD_TO_CART_SUCCESS_MESSAGE_BUTTON);
        clickToElement(driver, ProductDetailPageUI.CLOSE_ADD_TO_CART_SUCCESS_MESSAGE_BUTTON);
    }

    @Step("Input to quantity text box with value: {0}")
    public void inputToQuantityTextBox(String quantity) {
        waitForElementVisible(driver, ProductDetailPageUI.QUANTITY_TEXT_BOX);
        sendKeyToElement(driver, ProductDetailPageUI.QUANTITY_TEXT_BOX, quantity);
        sleepInSecond(5);
    }

    @Step("Click to Update cart button")
    public void clickToUpdateCartButton() {
        waitForElementVisible(driver, ProductDetailPageUI.UPDATE_BUTTON);
        clickToElement(driver, ProductDetailPageUI.UPDATE_BUTTON);
    }

    @Step("Get price detail product")
    public String getPriceInDetailProduct() {
        waitForElementVisible(driver, ProductDetailPageUI.PRICE_PRODUCT);
        return getElementText(driver, ProductDetailPageUI.PRICE_PRODUCT).replace("$", "").replace(",","");
    }
}
