package pageObjects.User;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.User.AbstractPageUI;
import pageUIs.User.CartPageUI;
import pageUIs.User.SearchPageUI;

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
        return PageGeneratorManager.getProductDetailPage(driver);
    }

    public boolean isProductExistedInCartPage(String productName, String processor, String ram, String hdd, String os, String...software) {
        boolean check = true;
        waitForElementVisible(driver, CartPageUI.DYNAMIC_PRODUCT_NAME_IN_CART_PAGE, productName);
        ArrayList<String> listOption = new ArrayList<>();
        listOption.add(processor);
        listOption.add(ram);
        listOption.add(hdd);
        listOption.add(os);
        for (int i = 0; i < software.length; i++){
            listOption.add(software[i]);
            System.out.println(software[i]);
        }
        String infoProduct = getElementText(driver, CartPageUI.PRODUCT_INFORMATION_IN_CART_PAGE,productName);
        for (String info : listOption) {
            if (infoProduct.contains(info)){
                check = true;
            }else {
                check = false;
            }
        }
        return check;

    }

    public String getTotalPriceInCart() {
        waitForElementVisible(driver, CartPageUI.TOTAL_ORDER);
        return getElementText(driver, CartPageUI.TOTAL_ORDER).replace("$", "").replace(",", "");
    }
}
