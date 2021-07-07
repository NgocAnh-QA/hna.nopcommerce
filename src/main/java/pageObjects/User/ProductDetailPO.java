package pageObjects.User;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.User.ProductDetailPageUI;

import java.util.List;

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

    public void selectProcessorInDropdown(String processorName) {
        waitForElementVisible(driver, ProductDetailPageUI.PROCESSOR_DROPDOWN);
        selectItemByVisible(driver, processorName, ProductDetailPageUI.PROCESSOR_DROPDOWN);
        sleepInSecond(1);
    }

    public void selectRAMInDropdown(String ramName) {
        waitForElementVisible(driver, ProductDetailPageUI.RAM_DROPDOWN);
        selectItemByVisible(driver, ramName, ProductDetailPageUI.RAM_DROPDOWN);
        sleepInSecond(1);

    }

    public void clickToHDDRadioButton(String hddName) {
        waitForElementVisible(driver, ProductDetailPageUI.DYNAMIC_HDD_RADIO_BUTTON, hddName);
        clickToElement(driver, ProductDetailPageUI.DYNAMIC_HDD_RADIO_BUTTON, hddName);
        sleepInSecond(1);
    }

    public void clickToOSRadioButton(String osName) {
        waitForElementVisible(driver, ProductDetailPageUI.DYNAMIC_OS_RADIO_BUTTON, osName);
        clickToElement(driver, ProductDetailPageUI.DYNAMIC_OS_RADIO_BUTTON, osName);
        sleepInSecond(1);
    }

    public void clickToAddToCartButton() {
        waitForElementVisible(driver, ProductDetailPageUI.ADD_TO_CART_BUTTON);
        clickToElement(driver, ProductDetailPageUI.ADD_TO_CART_BUTTON);
        sleepInSecond(3);
    }

    public boolean isAddToCartSuccessMessageDisplayed() {
        waitForElementVisible(driver, ProductDetailPageUI.ADD_TO_CART_SUCCESS_MESSAGE);
        return isElementDisplayed(driver, ProductDetailPageUI.ADD_TO_CART_SUCCESS_MESSAGE);
    }

    public void clickToCloseMessageAddToCartSuccess() {
        waitForElementVisible(driver, ProductDetailPageUI.CLOSE_ADD_TO_CART_SUCCESS_MESSAGE_BUTTON);
        clickToElement(driver, ProductDetailPageUI.CLOSE_ADD_TO_CART_SUCCESS_MESSAGE_BUTTON);
    }

    public void inputToQuantityTextbox(String quantity) {
        waitForElementVisible(driver, ProductDetailPageUI.QUANTITY_TEXT_BOX);
        sendKeyToElement(driver, ProductDetailPageUI.QUANTITY_TEXT_BOX, quantity);
    }

    public void clickToUpdateCartButton() {
        waitForElementVisible(driver, ProductDetailPageUI.UPDATE_BUTTON);
        sleepInSecond(3);
        clickToElement(driver, ProductDetailPageUI.UPDATE_BUTTON);
    }

    public String getPriceInDetailProduct() {
        waitForElementVisible(driver, ProductDetailPageUI.PRICE_PRODUCT);
        return getElementText(driver, ProductDetailPageUI.PRICE_PRODUCT).replace("$", "").replace(",","");
    }
}
