package nopcommerce.user;


import commons.AbstractTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import commons.RoleAccess;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.User.*;
import testdata.ProductData;

import java.io.File;

public class Order extends AbstractTest {
    private WebDriver driver;
    private ProductData productData;
    private ProductDetailPO productDetailPage;
    private ProductPO productPage;
    private HomePagePO homePage;
    private LoginPO loginPage;
    private CartPO cartPage;
    RoleAccess roleAccess;

    @Parameters({"browser"})
    @BeforeClass
    private void beforeClass(String browserName) {
        String role = System.getProperty("role");
        ConfigFactory.setProperty("role", role);
        roleAccess = ConfigFactory.create(RoleAccess.class);
        driver = getBrowserDriver(browserName, roleAccess.url());

        productData = ProductData.getFiles(GlobalConstants.ROOT_FOLDER + File.separator + "src/test/java" + File.separator + "testdata" + File.separator + "ProductData.json");

        log.info("Order - Precondition - Step 01: Open Home Page");
        homePage = PageGeneratorManager.getHomePage(driver);

        log.info("Order - Precondition - Step 02: Click to Login link");
        loginPage = homePage.clickToLoginLink();

        log.info("Order - Precondition - Step 03: Input to Email with value: " + RegisterToSystem.EMAIL);
        loginPage.inputToEmailTextbox(RegisterToSystem.EMAIL);

        log.info("Order - Precondition - Step 04: Input to Password with value: " + RegisterToSystem.PASSWORD);
        loginPage.inputToPasswordTextbox(RegisterToSystem.PASSWORD);

        log.info("Order - Precondition - Step 05: Click to Login button");
        homePage = loginPage.clickToLoginButton();
    }


    @Test
    public void TC_01_Add_Product_To_Cart() {
        log.info("Order - Add Product To Cart - Step 01: Open Submenu: Desktops");
        productPage = homePage.openSubMenu(driver, "Computers", "Desktops");

        log.info("Order - Add Product To Cart - Step 02: Click on product: " + productData.getProduct_03_name());
        productDetailPage = productPage.clickToProductByNameOfProduct(driver, productData.getProduct_03_name());

        log.info("Order - Add Product To Cart - Step 03: Select dropdown Processor with value: " + productData.getProduct_03_processor());
        productDetailPage.selectProcessorInDropdown(productData.getProduct_03_processor());

        log.info("Order - Add Product To Cart - Step 04: Select dropdown RAM with value: " + productData.getProduct_03_ram());
        productDetailPage.selectRAMInDropdown(productData.getProduct_03_ram());

        log.info("Order - Add Product To Cart - Step 05: Click to radio button HDD with value: " + productData.getProduct_03_hdd());
        productDetailPage.clickToHDDRadioButton(productData.getProduct_03_hdd());

        log.info("Order - Add Product To Cart - Step 06: Click to radio button OS with value: " + productData.getProduct_03_os());
        productDetailPage.clickToOSRadioButton(productData.getProduct_03_os());

        log.info("Order - Add Product To Cart - Step 07: Click to check box Software with value: " + productData.getProduct_03_software_ms_office() + ", " + productData.getProduct_03_software_reader()  + ", " +  productData.getProduct_03_software_commander());
        productDetailPage.clickToCheckboxSoftwareOption(productData.getProduct_03_software_ms_office(), productData.getProduct_03_software_reader(), productData.getProduct_03_software_commander());

        log.info("Order - Add Product To Cart - Step 08: Click Add to cart button");
        productDetailPage.clickToAddToCartButton();

        log.info("Order - Add Product To Cart - Step 09: Verify Add to cart successfully displays");
        verifyTrue(productDetailPage.isAddToCartSuccessMessageDisplayed());

        log.info("Order - Add Product To Cart - Step 10: Verify Add to cart successfully displays");
        productDetailPage.clickToCloseMessageAddToCartSuccess();

        log.info("Order - Add Product To Cart - Step 11: Hover on Shopping cart link on header");
        productDetailPage.hoverOnShoppingCartIconInHeader(driver);

        log.info("Order - Add Product To Cart - Step 12: Verify Quantity title displays on Cart");
        verifyEquals(productDetailPage.getNumberOfItemsInCart(driver), "There are 1 item(s) in your cart.");

        log.info("Order - Add Product To Cart - Step 13: Verify Product displays on Cart");
        verifyTrue(productDetailPage.isProductExistedInCartIconInHeader(driver, productData.getProduct_03_name(), productData.getProduct_03_processor(), productData.getProduct_03_ram(), productData.getProduct_03_hdd(), productData.getProduct_03_os(), productData.getProduct_03_software_ms_office(), productData.getProduct_03_software_reader(), productData.getProduct_03_software_commander()));

        log.info("Order - Add Product To Cart - Step 14: Verify Sub-Total displays on Cart");
        verifyEquals(productDetailPage.getSubTotalInCart(driver), "1500.00");

    }

    @Test
    public void TC_02_Edit_Product_In_Cart() {
        log.info("Order - Edit Product In Cart - Step 01: Open Cart page");
        cartPage = productDetailPage.clickToShoppingCartLink(driver);

        log.info("Order - Edit Product In Cart - Step 01: Click to Edit link");
        productDetailPage = cartPage.clickToEditLink();

        log.info("Order - Edit Product In Cart - Step 03: Select dropdown Processor with value: " + productData.getProduct_04_processor());
        productDetailPage.selectProcessorInDropdown(productData.getProduct_04_processor());

        log.info("Order - Edit Product In Cart - Step 04: Select dropdown RAM with value: " + productData.getProduct_04_ram());
        productDetailPage.selectRAMInDropdown(productData.getProduct_04_ram());

        log.info("Order - Edit Product In Cart - Step 05: Click to radio button HDD with value: " + productData.getProduct_04_hdd());
        productDetailPage.clickToHDDRadioButton(productData.getProduct_04_hdd());

        log.info("Order - Edit Product In Cart - Step 06: Click to radio button OS with value: " + productData.getProduct_04_os());
        productDetailPage.clickToOSRadioButton(productData.getProduct_04_os());

        log.info("Order - Edit Product In Cart - Step 07: Click to check box Software with value: " + productData.getProduct_04_software_ms_office());
        productDetailPage.clickToCheckboxSoftwareOption(productData.getProduct_04_software_ms_office());

        log.info("Order - Edit Product In Cart - Step 08: Input to quantity with value: " + productData.getProduct_04_quantity());
        productDetailPage.inputToQuantityTextbox(productData.getProduct_04_quantity());

        log.info("Order - Edit Product In Cart - Step 09: Click to Update cart button ");
        productDetailPage.clickToUpdateCartButton();

        log.info("Order - Edit Product In Cart - Step 10: Verify Add to cart successfully displays");
        verifyTrue(productDetailPage.isAddToCartSuccessMessageDisplayed());

        log.info("Order - Edit Product In Cart - Step 11: Close add to cart success message");
        productDetailPage.clickToCloseMessageAddToCartSuccess();

        log.info("Order - Edit Product In Cart - Step 12: Verify new price");
        verifyEquals(productDetailPage.getPriceInDetailProduct(), "1320.00");

        log.info("Order - Edit Product In Cart - Step 13: Open Shopping Cart");
        cartPage = productDetailPage.clickToShoppingCartLink(driver);

        log.info("Order - Edit Product In Cart - Step 14: Verify Update product correctly");
        verifyTrue(cartPage.isProductExistedInCartPage(productData.getProduct_04_name(), productData.getProduct_04_processor(), productData.getProduct_04_ram(), productData.getProduct_04_hdd(), productData.getProduct_04_os(), productData.getProduct_04_software_ms_office()));

        log.info("Order - Edit Product In Cart - Step 15: Verify Total");
        verifyEquals(cartPage.getTotalPriceInCart(),"2640.00");

    }


    @AfterClass
    public void afterClass() {
    }


}
