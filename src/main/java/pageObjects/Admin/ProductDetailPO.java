package pageObjects.Admin;

import commons.AbstractPage;
import commons.PageGeneratorManagerAdmin;
import org.openqa.selenium.WebDriver;
import pageUIs.Admin.LoginPageUI;
import pageUIs.Admin.ProductDetailPageUI;

public class ProductDetailPO extends AbstractPage {
    WebDriver driver;

    public ProductDetailPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isEditProductDetailPageDisplayed() {
        waitForElementVisible(driver, ProductDetailPageUI.TITLE_HEADER_PRODUCT_DETAIL_PAGE);
        String textActual = getElementText(driver, ProductDetailPageUI.TITLE_HEADER_PRODUCT_DETAIL_PAGE).trim();
        return textActual.contains("Edit product details") ? true : false;
    }

    public String getProductNameTextbox() {
        waitForElementVisible(driver, ProductDetailPageUI.PRODUCT_NAME_TEXT_BOX);
        return getElementAttribute(driver, ProductDetailPageUI.PRODUCT_NAME_TEXT_BOX, "value");

    }
}
