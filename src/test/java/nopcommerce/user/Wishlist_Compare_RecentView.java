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
import testdata.UserData;

import java.io.File;

public class Wishlist_Compare_RecentView extends AbstractTest {
    private WebDriver driver;
    private ProductData productData;
    private LoginPO loginPage;
    private HomePagePO homePage;
    private ProductDetailPO productDetailPage;
    private WishlistPO wishlistPage;
    private CartPO cartPage;
    private CompareProductPO compareProductPage;
    private ProductPO productPage;
    private RecentlyViewedProductsPO recentlyViewedProductsPage;
    RoleAccess roleAccess;

    @Parameters({"browser"})
    @BeforeClass
    private void beforeClass(String browserName) {
        String role = System.getProperty("role");
        ConfigFactory.setProperty("role", role);
        roleAccess = ConfigFactory.create(RoleAccess.class);
        driver = getBrowserDriver(browserName, roleAccess.url());
        productData = ProductData.getFiles(GlobalConstants.ROOT_FOLDER + File.separator + "src/test/java" + File.separator + "testdata" + File.separator + "ProductData.json");

        log.info("Wishlist_Compare_RecentView - Precondition - Step 01: Open Home Page");
        homePage = PageGeneratorManager.getHomePage(driver);

        log.info("Wishlist_Compare_RecentView - Precondition - Step 02: Login to system");
        loginPage = homePage.clickToLoginLink();
        loginPage.inputToEmailTextbox(RegisterToSystem.EMAIL);
        loginPage.inputToPasswordTextbox(RegisterToSystem.PASSWORD);

        log.info("Wishlist_Compare_RecentView - Precondition - Step 01: Open Home Page");
        homePage = loginPage.clickToLoginButton();

        log.info("Wishlist_Compare_RecentView - Precondition - Step 02: Click to Product with value: Apple MacBook Pro 13-inch");
        productDetailPage = homePage.clickToProductByNameOfProduct(driver, "Apple MacBook Pro 13-inch");

    }

    @Test
    public void TC_01_Add_To_WishList() {
        log.info("Wishlist_Compare_RecentView - Add to wishlist - Step 01: Click to Add to wishlist button");
        productDetailPage.clickToAddToWishlist();

        log.info("Wishlist_Compare_RecentView - Add to wishlist - Step 02: Verify added to wishlist successfully");
        verifyEquals(productDetailPage.getAddToWishlistSuccessMessage(), "The product has been added to your wishlist");

        log.info("Wishlist_Compare_RecentView - Add to wishlist - Step 03: Close notification");
        productDetailPage.clickToCloseWishListNotiButton();

        log.info("Wishlist_Compare_RecentView - Add to wishlist - Step 04: Click to wishlist link at header");
        wishlistPage = productDetailPage.clickToWishlistLink(driver);

        log.info("Wishlist_Compare_RecentView - Add to wishlist - Step 05: Verify product is at table wishlist");
        verifyEquals(wishlistPage.getTextProductNameInWishlistPage(), "Apple MacBook Pro 13-inch");

        log.info("Wishlist_Compare_RecentView - Add to wishlist - Step 06: Click to wishlist sharing link");
        wishlistPage.clickToLinkWishlistSharing();

        log.info("Wishlist_Compare_RecentView - Add to wishlist - Step 07: Verify product is at table wishlist sharing");
        verifyEquals(wishlistPage.getTextProductNameInWishlistPage(), "Apple MacBook Pro 13-inch");
    }


    @Test
    public void TC_02_Add_Product_To_Cart_From_Wishlist() {
        log.info("Wishlist_Compare_RecentView - Add product to cart from wishlist - Step 01: Open wishlist page");
        wishlistPage = wishlistPage.clickToWishlistLink(driver);

        log.info("Wishlist_Compare_RecentView - Add product to cart from wishlist - Step 02: Check to Add to cart checkbox");
        wishlistPage.clickToCheckboxAddToCart();

        log.info("Wishlist_Compare_RecentView - Add product to cart from wishlist - Step 03: Click to Add to cart button");
        cartPage = wishlistPage.clickToAddToCartButton();

        log.info("Wishlist_Compare_RecentView - Add product to cart from wishlist - Step 04: Verify user directed to cart page");
        verifyTrue(cartPage.isDirectPageToCartPage());

        log.info("Wishlist_Compare_RecentView - Add product to cart from wishlist - Step 05: Verify product is at cart page");
        verifyEquals(cartPage.getProductNameInCart(), "Apple MacBook Pro 13-inch");

        log.info("Wishlist_Compare_RecentView - Add product to cart from wishlist - Step 06: Back to wishlist page");
        wishlistPage = cartPage.clickToWishlistLink(driver);

        log.info("Wishlist_Compare_RecentView - Add product to cart from wishlist - Step 07: Remove product in wishlist page");
        wishlistPage.clickToRemoveIcon();

        log.info("Wishlist_Compare_RecentView - Add product to cart from wishlist - Step 08: Verify no item on wishlist");
        verifyEquals(cartPage.getQualityProductsInWishlistIcon(driver), "0");

        log.info("Wishlist_Compare_RecentView - Add product to cart from wishlist - Step 09: Open home page");
        homePage = cartPage.openHomePage(driver);
    }

    @Test
    public void TC_03_Remove_Product_In_Wishlist() {
        log.info("Wishlist_Compare_RecentView - Remove product in wishlist - Step 01: Click to Product with value: HTC One M8 Android L 5.0 Lollipop");
        productDetailPage = homePage.clickToProductByNameOfProduct(driver, "HTC One M8 Android L 5.0 Lollipop");

        log.info("Wishlist_Compare_RecentView - Remove product in wishlist - Step 02: Click to Add to wishlist button");
        productDetailPage.clickToAddToWishlist();

        log.info("Wishlist_Compare_RecentView - Remove product in wishlist - Step 03: Verify product added to wishlist successfully");
        verifyEquals(productDetailPage.getAddToWishlistSuccessMessage(), "The product has been added to your wishlist");

        log.info("Wishlist_Compare_RecentView - Remove product in wishlist - Step 04: Close notification messsage");
        productDetailPage.clickToCloseWishListNotiButton();

        log.info("Wishlist_Compare_RecentView - Remove product in wishlist - Step 05: Click to wishlist link at header");
        wishlistPage = productDetailPage.clickToWishlistLink(driver);

        log.info("Wishlist_Compare_RecentView - Remove product in wishlist - Step 06: Verify product is at wishlist table");
        verifyEquals(wishlistPage.getTextProductNameInWishlistPage(), "HTC One M8 Android L 5.0 Lollipop");

        log.info("Wishlist_Compare_RecentView - Remove product in wishlist - Step 07: Click to remove product at wishlist page");
        wishlistPage.clickToRemoveIcon();

        log.info("Wishlist_Compare_RecentView - Remove product in wishlist - Step 08: Verify the wishlist is empty");
        verifyEquals(wishlistPage.getTextWishlistEmptyMessage(), "The wishlist is empty!");

        log.info("Wishlist_Compare_RecentView - Remove product in wishlist - Step 09: Verify no item at wishlist icon");
        verifyEquals(wishlistPage.getQualityProductsInWishlistIcon(driver), "0");

        log.info("Wishlist_Compare_RecentView - Remove product in wishlist - Step 10: Open home page");
        homePage = wishlistPage.openHomePage(driver);
    }


    @Test
    public void TC_04_Add_To_Compare_2_Products() {
        log.info("Wishlist_Compare_RecentView - Add 2 products to compare - Step 01: Click add to compare product with value: " + productData.getProduct_02_name());
        homePage.clickOnAddToCompareByNameOfProduct(driver, productData.getProduct_02_name());

        log.info("Wishlist_Compare_RecentView - Add 2 products to compare - Step 02: Verify product is added successfully");
        verifyEquals(homePage.getCompareSuccessMessage(driver), "The product has been added to your product comparison");

        log.info("Wishlist_Compare_RecentView - Add 2 products to compare - Step 03: Click add to compare product with value: " + productData.getProduct_03_name());
        homePage.clickOnAddToCompareByNameOfProduct(driver, productData.getProduct_03_name());

        log.info("Wishlist_Compare_RecentView - Add 2 products to compare - Step 04: Verify product is added successfully");
        verifyEquals(homePage.getCompareSuccessMessage(driver), "The product has been added to your product comparison");

        log.info("Wishlist_Compare_RecentView - Add 2 products to compare - Step 05: Open link Compare product list at footer");
        compareProductPage = (CompareProductPO) homePage.openLinkByTextAtFooter(driver, "Compare products list");

        log.info("Wishlist_Compare_RecentView - Add 2 products to compare - Step 06: Verify user directed to compare page");
        verifyTrue(compareProductPage.isDirectToComparePage());

        log.info("Wishlist_Compare_RecentView - Add 2 products to compare - Step 07: Verify remove icon of " + productData.getProduct_02_name() + " is on table at compare page");
        verifyTrue(compareProductPage.isRemoveIconDisplayedAtTable(productData.getProduct_02_name()));

        log.info("Wishlist_Compare_RecentView - Add 2 products to compare - Step 08: Verify " + productData.getProduct_02_name() + " is on table at compare page");
        verifyEquals(compareProductPage.getProductNameAtTable(productData.getProduct_02_name()), productData.getProduct_02_name());

        log.info("Wishlist_Compare_RecentView - Add 2 products to compare - Step 09: Verify price of " + productData.getProduct_02_name() + " is on table at compare page");
        verifyEquals(compareProductPage.getProductPriceAtTable(productData.getProduct_02_name()), productData.getProduct_02_price());

        log.info("Wishlist_Compare_RecentView - Add 2 products to compare - Step 10: Verify remove icon of " + productData.getProduct_03_name() + " is on table at compare page");
        verifyTrue(compareProductPage.isRemoveIconDisplayedAtTable(productData.getProduct_03_name()));

        log.info("Wishlist_Compare_RecentView - Add 2 products to compare - Step 11: Verify  " + productData.getProduct_03_name() + " is on table at compare page");
        verifyEquals(compareProductPage.getProductNameAtTable(productData.getProduct_03_name()), productData.getProduct_03_name());

        log.info("Wishlist_Compare_RecentView - Add 2 products to compare - Step 12: Verify price of " + productData.getProduct_03_name() + " is on table at compare page");
        verifyEquals(compareProductPage.getProductPriceAtTable(productData.getProduct_03_name()), productData.getProduct_03_price());

        log.info("Wishlist_Compare_RecentView - Add 2 products to compare - Step 13: Verify list button is displayed");
        verifyTrue(compareProductPage.isClearListButtonDisplay());

        log.info("Wishlist_Compare_RecentView - Add 2 products to compare - Step 14: Click to clean list button");
        compareProductPage.clickToClearListButton();

        log.info("Wishlist_Compare_RecentView - Add 2 products to compare - Step 15: Verify message no items to compare displays");
        verifyEquals(compareProductPage.getTextNoItemsComparePageMessage(), "You have no items to compare.");

        log.info("Wishlist_Compare_RecentView - Add 2 products to compare - Step 16: Verify table undisplayed");
        verifyTrue(compareProductPage.isNoProductInComparePage());

        log.info("Wishlist_Compare_RecentView - Add 2 products to compare - Step 17: Open home page");
        homePage = compareProductPage.openHomePage(driver);
    }


    @Test
    public void TC_05_Recently_Viewed_Products() {
        log.info("Wishlist_Compare_RecentView - Recently Viewed Products - Step 01: Hover Menu: Computers and then click on submenu: Notebooks");
        productPage = homePage.openSubMenu(driver, "Computers", "Notebooks");

        log.info("Wishlist_Compare_RecentView - Recently Viewed Products - Step 02: Click on product: Apple MacBook Pro 13-inch");
        productDetailPage = productPage.clickToProductByNameOfProduct(driver, "Apple MacBook Pro 13-inch");

        log.info("Wishlist_Compare_RecentView - Recently Viewed Products - Step 03: Back to Notebooks page");
        productPage = productDetailPage.backToProductsPage();

        log.info("Wishlist_Compare_RecentView - Recently Viewed Products - Step 04: Click on product: Asus N551JK-XO076H Laptop");
        productDetailPage = productPage.clickToProductByNameOfProduct(driver, "Asus N551JK-XO076H Laptop");

        log.info("Wishlist_Compare_RecentView - Recently Viewed Products - Step 05: Back to Notebooks page");
        productPage = productDetailPage.backToProductsPage();

        log.info("Wishlist_Compare_RecentView - Recently Viewed Products - Step 06: Click on product: Samsung Series 9 NP900X4C Premium Ultrabook");
        productDetailPage = productPage.clickToProductByNameOfProduct(driver, "Samsung Series 9 NP900X4C Premium Ultrabook");

        log.info("Wishlist_Compare_RecentView - Recently Viewed Products - Step 07: Back to Notebooks page");
        productPage = productDetailPage.backToProductsPage();

        log.info("Wishlist_Compare_RecentView - Recently Viewed Products - Step 08: Click on product: HP Spectre XT Pro UltraBook");
        productDetailPage = productPage.clickToProductByNameOfProduct(driver, "HP Spectre XT Pro UltraBook");

        log.info("Wishlist_Compare_RecentView - Recently Viewed Products - Step 09: Back to Notebooks page");
        productPage = productDetailPage.backToProductsPage();

        log.info("Wishlist_Compare_RecentView - Recently Viewed Products - Step 10: Click on product: HP Envy 6-1180ca 15.6-Inch Sleekbook");
        productDetailPage = productPage.clickToProductByNameOfProduct(driver, "HP Envy 6-1180ca 15.6-Inch Sleekbook");

        log.info("Wishlist_Compare_RecentView - Recently Viewed Products - Step 11: Open Recently viewed products link at foooter");
        recentlyViewedProductsPage = (RecentlyViewedProductsPO) productDetailPage.openLinkByTextAtFooter(driver, "Recently viewed products");

        log.info("Wishlist_Compare_RecentView - Recently Viewed Products - Step 12: Verify only 3 products display");
        verifyEquals(recentlyViewedProductsPage.countProducts(), 3);

        log.info("Wishlist_Compare_RecentView - Recently Viewed Products - Step 13: Verify Samsung Series 9 NP900X4C Premium Ultrabook displays");
        verifyTrue(recentlyViewedProductsPage.isProductNameDisplayed("Samsung Series 9 NP900X4C Premium Ultrabook"));

        log.info("Wishlist_Compare_RecentView - Recently Viewed Products - Step 14: Verify HP Spectre XT Pro UltraBook displays");
        verifyTrue(recentlyViewedProductsPage.isProductNameDisplayed("HP Spectre XT Pro UltraBook"));

        log.info("Wishlist_Compare_RecentView - Recently Viewed Products - Step 15: Verify HP Envy 6-1180ca 15.6-Inch Sleekbook displays");
        verifyTrue(recentlyViewedProductsPage.isProductNameDisplayed("HP Envy 6-1180ca 15.6-Inch Sleekbook"));
    }

    @AfterClass
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }


}
