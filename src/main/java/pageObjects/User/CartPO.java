package pageObjects.User;

import commons.AbstractPage;
import commons.PageGeneratorManagerUser;
import org.openqa.selenium.WebDriver;
import pageUIs.User.CartPageUI;

import java.util.ArrayList;

public class CartPO extends AbstractPage {
    WebDriver driver;

    public CartPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDirectPageToCartPage() {
        waitForElementVisible(driver, CartPageUI.SHOPPING_CART_TITLE_PAGE);
        return isElementDisplayed(driver, CartPageUI.SHOPPING_CART_TITLE_PAGE);
    }

    public String getProductNameInCart() {
        waitForElementVisible(driver, CartPageUI.NAME_PRODUCT_IN_CART);
        return getElementText(driver, CartPageUI.NAME_PRODUCT_IN_CART);
    }


    public ProductDetailPO clickToEditLink() {
        waitForElementClickable(driver, CartPageUI.EDIT_LINK);
        clickToElement(driver, CartPageUI.EDIT_LINK);
        return PageGeneratorManagerUser.getProductDetailPage(driver);
    }

    public boolean isProductExistedInCartPage(String productName, String processor, String ram, String hdd, String os, String... software) {
        boolean check = true;
        waitForElementVisible(driver, CartPageUI.DYNAMIC_PRODUCT_NAME_IN_CART_PAGE, productName);
        ArrayList<String> listOption = new ArrayList<>();
        listOption.add(processor);
        listOption.add(ram);
        listOption.add(hdd);
        listOption.add(os);
        for (int i = 0; i < software.length; i++) {
            listOption.add(software[i]);
            System.out.println(software[i]);
        }
        String infoProduct = getElementText(driver, CartPageUI.PRODUCT_INFORMATION_IN_CART_PAGE, productName);
        for (String info : listOption) {
            if (infoProduct.contains(info)) {
                check = true;
            } else {
                check = false;
            }
        }
        return check;

    }

    public String getTotalPriceInCart() {
        waitForElementVisible(driver, CartPageUI.TOTAL_ORDER);
        return formatPrice(getElementText(driver, CartPageUI.TOTAL_ORDER));
    }

    public boolean isCartEmptyMessageDisplayed() {
        waitForElementVisible(driver, CartPageUI.CART_EMPTY_MESSAGE);
        return isElementDisplayed(driver, CartPageUI.CART_EMPTY_MESSAGE);
    }

    public void clickToRemoveProductFromCart(String productName) {
        waitForElementClickable(driver, CartPageUI.DYNAMIC_REMOVE_BY_PRODUCT_NAME_IN_CART_PAGE, productName);
        clickToElement(driver, CartPageUI.DYNAMIC_REMOVE_BY_PRODUCT_NAME_IN_CART_PAGE, productName);
    }

    public void inputToQuantity(String quantity) {
        waitForElementVisible(driver, CartPageUI.QUANTITY_TEXT_BOX);
        sendKeyToElement(driver, CartPageUI.QUANTITY_TEXT_BOX,quantity);
    }

    public void clickToUpdateShoppingCart() {
        waitForElementVisible(driver, CartPageUI.UPDATE_SHOPPING_CART_BUTTON);
        clickToElement(driver, CartPageUI.UPDATE_SHOPPING_CART_BUTTON);

    }

    public void checktoTermOfService() {
        waitForElementVisible(driver, CartPageUI.TERM_OF_SERVICE_CHECKBOX);
        clickToElement(driver, CartPageUI.TERM_OF_SERVICE_CHECKBOX);
    }

    public CheckoutPO clickToCheckoutButton() {
        waitForElementVisible(driver, CartPageUI.CHECKOUT_BUTTON);
        clickToElement(driver, CartPageUI.CHECKOUT_BUTTON);
        return PageGeneratorManagerUser.getCheckoutPage(driver);
    }

    public void selectToGiftWrappingDropdown(String giftWrappingValue) {
        waitForElementVisible(driver, CartPageUI.GIFT_WRAPPING_DROPDOWN);
        selectItemByVisible(driver, giftWrappingValue, CartPageUI.GIFT_WRAPPING_DROPDOWN);
    }
}
