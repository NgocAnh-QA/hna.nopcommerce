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

    @Test
    public void TC_01_Search_With_Product_Name() {
        log.info("Search - Search with product name - Step 01: Open catalog > products");
        productsPage = dashboardPage.openSubMenuAtNav(driver, "Catalog", "Products");

        log.info("Search - Search with product name - Step 02: Open search panel");
        productsPage.openSearchPanel();

        log.info("Search - Search with product name - Step 03: Input to product name with value: " + productData.getProduct_05_name());
        productsPage.inputToProductNameTextbox(productData.getProduct_05_name());

        log.info("Search - Search with product name - Step 04: Click Search button");
        productsPage.clickToSeachButton();

        log.info("Search - Search with product name - Step 05: Verify product detail displays at table");
        verifyTrue(productsPage.isProductDetailDisplayedAtTable(productData.getProduct_05_name(), productData.getProduct_05_sku(), productsPage.formatPrice(productData.getProduct_05_price())));

        log.info("Search - Search with product name - Step 06: Verify 1 product detail displays at table");
        verifyEquals(productsPage.getProductsAtTable(), 1);

        log.info("Search - Search with product name - Step 07: Open Dashboard page");
        dashboardPage = productsPage.openDashboardPage(driver);

    }

    @Test
    public void TC_02_Search_With_Product_Name_Parent_Category_Uncheck_Subcategories() {
        log.info("Search - Search with product name & parent category & uncheck subcategories - Step 01: Open catalog > products");
        productsPage = dashboardPage.openSubMenuAtNav(driver, "Catalog", "Products");

        log.info("Search - Search with product name & parent category & uncheck subcategories - Step 02: Open search panel");
        productsPage.openSearchPanel();

        log.info("Search - Search with product name & parent category & uncheck subcategories - Step 03: Input to product name with value: " + productData.getProduct_05_name());
        productsPage.inputToProductNameTextbox(productData.getProduct_05_name());

        log.info("Search - Search with product name & parent category & uncheck subcategories - Step 04: Select categories with value: Computers");
        productsPage.selectCategoryDropdown("Computers");

        log.info("Search - Search with product name & parent category & uncheck subcategories - Step 05: Uncheck to subcategories check box");
        productsPage.unCheckToSubcatogories();

        log.info("Search - Search with product name & parent category & uncheck subcategories - Step 06: Click to Search button");
        productsPage.clickToSeachButton();

        log.info("Search - Search with product name & parent category & uncheck subcategories - Step 07: Verify no data in table");
        verifyTrue(productsPage.isNoDataAvailableMessageDisplayed());

        log.info("Search - Search with product name & parent category & uncheck subcategories - Step 08: Open dashboard page");
        dashboardPage = productsPage.openDashboardPage(driver);

    }

    @Test
    public void TC_03_Search_With_Product_Name_Parent_Category_Check_Subcategories() {
        log.info("Search - Search with product name & parent category & check subcategories - Step 01: Open catalog > products");
        productsPage = dashboardPage.openSubMenuAtNav(driver, "Catalog", "Products");

        log.info("Search - Search with product name & parent category & check subcategories - Step 02: Open search panel");
        productsPage.openSearchPanel();

        log.info("Search - Search with product name & parent category & check subcategories - Step 03: Input to product name with value: " + productData.getProduct_05_name());
        productsPage.inputToProductNameTextbox(productData.getProduct_05_name());

        log.info("Search - Search with product name & parent category & check subcategories - Step 04: Select categories with value: Computers");
        productsPage.selectCategoryDropdown("Computers");

        log.info("Search - Search with product name & parent category & check subcategories - Step 05: Check to subcategories check box");
        productsPage.checkToSubcatogories();

        log.info("Search - Search with product name & parent category & check subcategories - Step 06: Click to Search button");
        productsPage.clickToSeachButton();

        log.info("Search - Search with product name & parent category & check subcategories - Step 07: Verify product detail displays at table");
        verifyTrue(productsPage.isProductDetailDisplayedAtTable(productData.getProduct_05_name(), productData.getProduct_05_sku(), productsPage.formatPrice(productData.getProduct_05_price())));

        log.info("Search - Search with product name & parent category & check subcategories - Step 08: Verify 1 product detail displays at table");
        verifyEquals(productsPage.getProductsAtTable(), 1);

        log.info("Search - Search with product name & parent category & check subcategories - Step 09: Open dashboard page");
        dashboardPage = productsPage.openDashboardPage(driver);

    }

    @Test
    public void TC_04_Search_With_Product_Name_Child_Category_Uncheck_Subcategories() {
        log.info("Search - Search with product name & child category & uncheck subcategories- Step 01: Open catalog > products");
        productsPage = dashboardPage.openSubMenuAtNav(driver, "Catalog", "Products");

        log.info("Search - Search with product name & child category & uncheck subcategories - Step 02: Open search panel");
        productsPage.openSearchPanel();

        log.info("Search - Search with product name & child category & uncheck subcategories - Step 03: Input to product name with value: " + productData.getProduct_05_name());
        productsPage.inputToProductNameTextbox(productData.getProduct_05_name());

        log.info("Search - Search with product name & child category & uncheck subcategories - Step 04: Select child categories with value: Computers >> Desktops");
        productsPage.selectCategoryDropdown("Computers >> Desktops");

        log.info("Search - Search with product name & child category & uncheck subcategories - Step 05: Uncheck to subcategories check box");
        productsPage.unCheckToSubcatogories();

        log.info("Search - Search with product name & child category & uncheck subcategories - Step 06: Click to Search button");
        productsPage.clickToSeachButton();

        log.info("Search - Search with product name & child category & uncheck subcategories - Step 07: Verify product detail displays at table");
        verifyTrue(productsPage.isProductDetailDisplayedAtTable(productData.getProduct_05_name(), productData.getProduct_05_sku(), productsPage.formatPrice(productData.getProduct_05_price())));

        log.info("Search - Search with product name & child category & uncheck subcategories - Step 08: Verify 1 product detail displays at table");
        verifyEquals(productsPage.getProductsAtTable(), 1);

        log.info("Search - Search with product name & child category & uncheck subcategories - Step 09: Open dashboard page");

        dashboardPage = productsPage.openDashboardPage(driver);


    }

    @Test
    public void TC_05_Search_With_Product_Name_Manufacturer() {
        log.info("Search - Search with product name & Manufacturer- Step 01: Open catalog > products");
        productsPage = dashboardPage.openSubMenuAtNav(driver, "Catalog", "Products");

        log.info("Search - Search with product name & Manufacturer- Step 02: Open search panel");
        productsPage.openSearchPanel();

        log.info("Search - Search with product name & Manufacturer- Step 03: Input to product name with value: " + productData.getProduct_05_name());
        productsPage.inputToProductNameTextbox(productData.getProduct_05_name());

        log.info("Search - Search with product name & Manufacturer- Step 04: Select categories with value: All");
        productsPage.selectCategoryDropdown("All");

        log.info("Search - Search with product name & Manufacturer- Step 05: Uncheck to subcategories check box");
        productsPage.unCheckToSubcatogories();

        log.info("Search - Search with product name & Manufacturer- Step 06: Select manufacturer with value: Apple");
        productsPage.selectManufacturerDropdown("Apple");

        log.info("Search - Search with product name & Manufacturer- Step 07: Click to Search button");
        productsPage.clickToSeachButton();

        log.info("Search - Search with product name & Manufacturer- Step 08: Verify no data in table");
        verifyTrue(productsPage.isNoDataAvailableMessageDisplayed());

        log.info("Search - Search with product name & Manufacturer- Step 08: Open Dashboard page");
        dashboardPage = productsPage.openDashboardPage(driver);


    }

    @Test
    public void TC_06_Go_Directly_To_Product_SKU() {
    }

    @AfterClass
    public void afterClass() {
        closeBrowserAndDriver();
    }

}
