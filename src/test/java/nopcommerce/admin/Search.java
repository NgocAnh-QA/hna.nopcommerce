package nopcommerce.admin;

import commons.AbstractTest;
import commons.GlobalConstants;
import commons.PageGeneratorManagerAdmin;
import commons.RoleAccess;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.Admin.DashboardPO;
import pageObjects.Admin.LoginPO;
import pageObjects.Admin.ProductDetailPO;
import pageObjects.Admin.ProductsPO;
import testdata.AdminData;
import testdata.ProductData;

import java.io.File;

public class Search extends AbstractTest {
    WebDriver driver;

    RoleAccess roleAccess;
    AdminData adminData;
    private DashboardPO dashboardPage;
    private LoginPO loginPage;
    private ProductsPO productsPage;
    private ProductDetailPO productDetailPage;

    ProductData productData;

    @Parameters({"browser"})
    @BeforeClass
    private void beforeClass(String browserName) {
        String role = System.getProperty("role");
        ConfigFactory.setProperty("role", role);
        roleAccess = ConfigFactory.create(RoleAccess.class);
        driver = getBrowserDriver(browserName, roleAccess.url());

        adminData = AdminData.getFiles(GlobalConstants.ROOT_FOLDER + File.separator + "src/test/java" + File.separator + "testdata" + File.separator + "AdminData.json");
        productData = ProductData.getFiles(GlobalConstants.ROOT_FOLDER + File.separator + "src/test/java" + File.separator + "testdata" + File.separator + "ProductData.json");

        log.info("Search - Pre condition - Step 01: Login to system admin");
        loginPage = PageGeneratorManagerAdmin.getLoginPageAdmin(driver);
        dashboardPage = loginPage.clickToLoginButton(adminData.getEmailAddress(), adminData.getPassword());

    }

    @BeforeMethod
    private void beforeMethod(){
        log.info("Search - Pre condition - Step 02: Open catalog > products");
        productsPage = (ProductsPO) dashboardPage.openSubMenuAtNav(driver, "Catalog", "Products");
    }

    @Test
    private void TC_01_Search_With_Product_Name() {
        log.info("Search - Search with product name - Step 01: Open search panel");
        productsPage.openSearchPanel();

        log.info("Search - Search with product name - Step 02: Input to product name with value: " + productData.getProduct_05_name());
        productsPage.inputToProductNameTextbox(productData.getProduct_05_name());

        log.info("Search - Search with product name - Step 03: Click Search button");
        productsPage.clickToSeachButton();

        log.info("Search - Search with product name - Step 04: Verify product detail displays at table");
        verifyTrue(productsPage.isProductDetailDisplayedAtTable(productData.getProduct_05_name(), productData.getProduct_05_sku(), productsPage.formatPrice(productData.getProduct_05_price())));

        log.info("Search - Search with product name - Step 05: Verify 1 product detail displays at table");
        verifyEquals(productsPage.getProductsAtTable(), 1);

        log.info("Search - Search with product name - Step 06: Open Dashboard page");
        dashboardPage = productsPage.openDashboardPage(driver);

    }

    @Test
    private void TC_02_Search_With_Product_Name_Parent_Category_Uncheck_Subcategories() {
        log.info("Search - Search with product name & parent category & uncheck subcategories - Step 01: Open search panel");
        productsPage.openSearchPanel();

        log.info("Search - Search with product name & parent category & uncheck subcategories - Step 02: Input to product name with value: " + productData.getProduct_05_name());
        productsPage.inputToProductNameTextbox(productData.getProduct_05_name());

        log.info("Search - Search with product name & parent category & uncheck subcategories - Step 03: Select categories with value: Computers");
        productsPage.selectCategoryDropdown("Computers");

        log.info("Search - Search with product name & parent category & uncheck subcategories - Step 04: Uncheck to subcategories check box");
        productsPage.unCheckToSubcatogories();

        log.info("Search - Search with product name & parent category & uncheck subcategories - Step 05: Click to Search button");
        productsPage.clickToSeachButton();

        log.info("Search - Search with product name & parent category & uncheck subcategories - Step 06: Verify no data in table");
        verifyTrue(productsPage.isNoDataAvailableMessageDisplayed());

        log.info("Search - Search with product name & parent category & uncheck subcategories - Step 07: Open dashboard page");
        dashboardPage = productsPage.openDashboardPage(driver);

    }

    @Test
    private void TC_03_Search_With_Product_Name_Parent_Category_Check_Subcategories() {
        log.info("Search - Search with product name & parent category & check subcategories - Step 01: Open search panel");
        productsPage.openSearchPanel();

        log.info("Search - Search with product name & parent category & check subcategories - Step 02: Input to product name with value: " + productData.getProduct_05_name());
        productsPage.inputToProductNameTextbox(productData.getProduct_05_name());

        log.info("Search - Search with product name & parent category & check subcategories - Step 03: Select categories with value: Computers");
        productsPage.selectCategoryDropdown("Computers");

        log.info("Search - Search with product name & parent category & check subcategories - Step 04: Check to subcategories check box");
        productsPage.checkToSubcatogories();

        log.info("Search - Search with product name & parent category & check subcategories - Step 05: Click to Search button");
        productsPage.clickToSeachButton();

        log.info("Search - Search with product name & parent category & check subcategories - Step 06: Verify product detail displays at table");
        verifyTrue(productsPage.isProductDetailDisplayedAtTable(productData.getProduct_05_name(), productData.getProduct_05_sku(), productsPage.formatPrice(productData.getProduct_05_price())));

        log.info("Search - Search with product name & parent category & check subcategories - Step 07: Verify 1 product detail displays at table");
        verifyEquals(productsPage.getProductsAtTable(), 1);

        log.info("Search - Search with product name & parent category & check subcategories - Step 08: Open dashboard page");
        dashboardPage = productsPage.openDashboardPage(driver);

    }

    @Test
    private void TC_04_Search_With_Product_Name_Child_Category_Uncheck_Subcategories() {
        log.info("Search - Search with product name & child category & uncheck subcategories - Step 01: Open search panel");
        productsPage.openSearchPanel();

        log.info("Search - Search with product name & child category & uncheck subcategories - Step 02: Input to product name with value: " + productData.getProduct_05_name());
        productsPage.inputToProductNameTextbox(productData.getProduct_05_name());

        log.info("Search - Search with product name & child category & uncheck subcategories - Step 03: Select child categories with value: Computers >> Desktops");
        productsPage.selectCategoryDropdown("Computers >> Desktops");

        log.info("Search - Search with product name & child category & uncheck subcategories - Step 04: Uncheck to subcategories check box");
        productsPage.unCheckToSubcatogories();

        log.info("Search - Search with product name & child category & uncheck subcategories - Step 05: Click to Search button");
        productsPage.clickToSeachButton();

        log.info("Search - Search with product name & child category & uncheck subcategories - Step 06: Verify product detail displays at table");
        verifyTrue(productsPage.isProductDetailDisplayedAtTable(productData.getProduct_05_name(), productData.getProduct_05_sku(), productsPage.formatPrice(productData.getProduct_05_price())));

        log.info("Search - Search with product name & child category & uncheck subcategories - Step 07: Verify 1 product detail displays at table");
        verifyEquals(productsPage.getProductsAtTable(), 1);

        log.info("Search - Search with product name & child category & uncheck subcategories - Step 08: Open dashboard page");
        dashboardPage = productsPage.openDashboardPage(driver);
    }

    @Test
    private void TC_05_Search_With_Product_Name_Manufacturer() {
        log.info("Search - Search with product name & Manufacturer - Step 01: Open search panel");
        productsPage.openSearchPanel();

        log.info("Search - Search with product name & Manufacturer - Step 02: Input to product name with value: " + productData.getProduct_05_name());
        productsPage.inputToProductNameTextbox(productData.getProduct_05_name());

        log.info("Search - Search with product name & Manufacturer - Step 03: Select categories with value: All");
        productsPage.selectCategoryDropdown("All");

        log.info("Search - Search with product name & Manufacturer - Step 04: Uncheck to subcategories check box");
        productsPage.unCheckToSubcatogories();

        log.info("Search - Search with product name & Manufacturer - Step 05: Select manufacturer with value: Apple");
        productsPage.selectManufacturerDropdown("Apple");

        log.info("Search - Search with product name & Manufacturer - Step 06: Click to Search button");
        productsPage.clickToSeachButton();

        log.info("Search - Search with product name & Manufacturer - Step 07: Verify no data in table");
        verifyTrue(productsPage.isNoDataAvailableMessageDisplayed());

        log.info("Search - Search with product name & Manufacturer - Step 08: Open Dashboard page");
        dashboardPage = productsPage.openDashboardPage(driver);


    }

    @Test
    private void TC_06_Go_Directly_To_Product_SKU() {
        log.info("Search - Go directly to product sky - Step 01: Open search panel");
        productsPage.openSearchPanel();

        log.info("Search - Go directly to product sky - Step 02: Input to SKU textbox with value: " + productData.getProduct_05_sku());
        productsPage.inputToSkuTexbox(productData.getProduct_05_sku());

        log.info("Search - Go directly to product sky - Step 03: Click to Go button");
        productDetailPage = productsPage.clickToGoButton();

        log.info("Search - Go directly to product sky - Step 04: Verify directly to Edit product details");
        verifyTrue(productDetailPage.isEditProductDetailPageDisplayed());

        log.info("Search - Go directly to product sky - Step 05: Verify Product name displays with value: ");
        verifyEquals(productDetailPage.getProductNameTextbox(), productData.getProduct_05_name());
    }

    @AfterClass
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }

}
