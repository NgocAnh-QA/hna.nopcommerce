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

public class Search extends AbstractTest {
    private WebDriver driver;
    private int randomNumber = getRandomNumber();
    private UserData userData;
    private ProductData productData;
    private HomePagePO homePage;
    private LoginPO loginPage;
    private SearchPO searchPage;
    RoleAccess roleAccess;

    @Parameters({"browser"})
    @BeforeClass
    private void beforeClass(String browserName) {
        String role = System.getProperty("role");
        ConfigFactory.setProperty("role", role);
        roleAccess = ConfigFactory.create(RoleAccess.class);
        driver = getBrowserDriver(browserName, roleAccess.url());

        userData = UserData.getFiles(GlobalConstants.ROOT_FOLDER + File.separator + "src/test/java" + File.separator + "testdata" + File.separator + "UserData.json");
        productData = ProductData.getFiles(GlobalConstants.ROOT_FOLDER + File.separator + "src/test/java" + File.separator + "testdata" + File.separator + "ProductData.json");

        log.info("Search - Precondition - Step 01: Open Home Page");
        homePage = PageGeneratorManager.getHomePage(driver);

        log.info("Search - Precondition - Step 02: Click to Login link");
        loginPage = homePage.clickToLoginLink();

        log.info("Search - Precondition - Step 03: Input to Email with value: " + RegisterToSystem.EMAIL);
        loginPage.inputToEmailTextbox(RegisterToSystem.EMAIL);

        log.info("Search - Precondition - Step 04: Input to Password with value: " + RegisterToSystem.PASSWORD);
        loginPage.inputToPasswordTextbox(RegisterToSystem.PASSWORD);

        log.info("Search - Precondition - Step 05: Click to Login button");
        homePage = loginPage.clickToLoginButton();

        log.info("Search - Precondition - Step 06: Open Search link at footer");
        searchPage = (SearchPO) homePage.openLinkByTextAtFooter(driver, "Search");
    }

    @Test
    public void TC_01_Search_Empty_Data() {
        log.info("Search - Search Empty Data - Step 01: Click to Search button");
        searchPage.clickToClickSearchButton();

        log.info("Search - Search Empty Data - Step 02: Verify Error empty data message is displayed");
        verifyEquals(searchPage.getTextEmptyDataMessage(), "Search term minimum length is 3 characters");

        log.info("Search - Search Empty Data - Step 03: Open Search link at footer");
        searchPage = (SearchPO) searchPage.openLinkByTextAtFooter(driver, "Search");
    }

    @Test
    public void TC_02_Search_Data_Not_Exist() {
        log.info("Search - Search Data Not Exist - Step 01: Input to Search textbox with value: " + productData.getProduct_01_incorrect_name());
        searchPage.inputToSearchTextBox(productData.getProduct_01_incorrect_name());

        log.info("Search - Search Data Not Exist - Step 02: Click to Search button");
        searchPage.clickToClickSearchButton();

        log.info("Search - Search Data Not Exists - Step 03: Verify Error data not exists message is displayed");
        verifyEquals(searchPage.getTextDataNoExistMessage(), "No products were found that matched your criteria.");

        log.info("Search - Search Data Not Exists - Step 04: Open Search link at footer");
        searchPage = (SearchPO) searchPage.openLinkByTextAtFooter(driver, "Search");
    }

    @Test
    public void TC_03_Search_Product_Name_Relative() {
        log.info("Search - Search Product Relative Name - Step 01: Input to Search textbox with value: " + productData.getProduct_01_relative_name());
        searchPage.inputToSearchTextBox(productData.getProduct_01_relative_name());

        log.info("Search - Search Product Relative Name - Step 02: Click to Search button");
        searchPage.clickToClickSearchButton();

        log.info("Search - Search Product Relative Name - Step 03: Results contain products with relative name: " + productData.getProduct_01_relative_name());
        verifyTrue(searchPage.areProductsContainKeyword(productData.getProduct_01_relative_name()));

        log.info("Search - Search Product Relative Name - Step 04: Open Search link at footer");
        searchPage = (SearchPO) searchPage.openLinkByTextAtFooter(driver, "Search");
    }

    @Test
    public void TC_04_Search_Product_Name_Absolute() {
        log.info("Search - Search Product Absolute Name - Step 01: Input to Search textbox with value: " + productData.getProduct_01_name());
        searchPage.inputToSearchTextBox(productData.getProduct_01_name());

        log.info("Search - Search Product Absolute Name - Step 02: Click to Search button");
        searchPage.clickToClickSearchButton();

        log.info("Search - Search Product Absolute Name - Step 03: Results contain products with absolute name: " + productData.getProduct_01_name());
        verifyTrue(searchPage.areProductsEqualKeyword(productData.getProduct_01_name()));

        log.info("Search - Search Product Absolute Name - Step 04: Open Search link at footer");
        searchPage = (SearchPO) searchPage.openLinkByTextAtFooter(driver, "Search");
    }

    @Test
    public void TC_05_Search_Parent_Categories() {
        log.info("Search - Search Parent Categories - Step 01: Input to Search textbox with value: " + productData.getProduct_01_search_keyword());
        searchPage.inputToSearchTextBox(productData.getProduct_01_search_keyword());

        log.info("Search - Search Parent Categories - Step 02: Check to advanced search");
        searchPage.checkAdvancedSearch();

        log.info("Search - Search Parent Categories - Step 03: Select categories with value: Computers");
        searchPage.selectToCategoryDropdownByText("Computers");

        log.info("Search - Search Parent Categories - Step 04: Click to search button");
        searchPage.clickToClickSearchButton();

        log.info("Search - Search Parent Categories - Step 05: Verify error message is displayed");
        verifyEquals(searchPage.getTextDataNoExistMessage(), "No products were found that matched your criteria.");

        log.info("Search - Search Parent Categories - Step 06: Click to Search link at footer");
        searchPage = (SearchPO) searchPage.openLinkByTextAtFooter(driver, "Search");
    }

    @Test
    public void TC_06_Search_Sub_Categories() {
        log.info("Search - Search Sub Categories - Step 01: Input to Search textbox with value: " + productData.getProduct_01_search_keyword());
        searchPage.inputToSearchTextBox(productData.getProduct_01_search_keyword());

        log.info("Search - Search Sub Categories - Step 02: Check to advanced search check box");
        searchPage.checkAdvancedSearch();

        log.info("Search - Search Sub Categories - Step 03: Select Categories dropdown with value: Computers");
        searchPage.selectToCategoryDropdownByText("Computers");

        log.info("Search - Search Sub Categories - Step 04: Check to Automatically Search check box");
        searchPage.clickToAutomaticallySearch();

        log.info("Search - Search Sub Categories - Step 05:Click to Search button");
        searchPage.clickToClickSearchButton();

        log.info("Search - Search Sub Categories - Step 06: Verify results contain product that user is searching");
        verifyTrue(searchPage.areProductsContainKeyword(productData.getProduct_01_search_keyword()));

        log.info("Search - Search Sub Categories - Step 07: Click to Search link at footer");
        searchPage = (SearchPO) searchPage.openLinkByTextAtFooter(driver, "Search");
    }

    @Test
    public void TC_07_Search_Incorrect_Manufacturer() {
        log.info("Search - Search Incorrect Manufacturer - Step 01: Input to Search textbox with value: " + productData.getProduct_01_search_keyword());
        searchPage.inputToSearchTextBox(productData.getProduct_01_search_keyword());

        log.info("Search - Search Incorrect Manufacturer - Step 02: Check to Advanced search check box");
        searchPage.checkAdvancedSearch();

        log.info("Search - Search Incorrect Manufacturer - Step 03: Select Categories dropdown with value: Computers");
        searchPage.selectToCategoryDropdownByText("Computers");

        log.info("Search - Search Incorrect Manufacturer - Step 04: Check to Automatically Search check box");
        searchPage.clickToAutomaticallySearch();

        log.info("Search - Search Incorrect Manufacturer - Step 05: Select Manufacturer dropdown with value: HP");
        searchPage.selectToManufacturerDropdownByText("HP");

        log.info("Search - Search Incorrect Manufacturer - Step 06: Click to Search button");
        searchPage.clickToClickSearchButton();

        log.info("Search - Search Incorrect Manufacturer - Step 07: Verify error message is displayed");
        verifyEquals(searchPage.getTextDataNoExistMessage(), "No products were found that matched your criteria.");

        log.info("Search - Search Incorrect Manufacturer - Step 08: Click to Search link at footer");
        searchPage = (SearchPO) searchPage.openLinkByTextAtFooter(driver, "Search");
    }

    @Test
    public void TC_08_Search_Correct_Manufacturer() {
        log.info("Search - Search Correct Manufacturer - Step 01: Input to Search textbox with value: " + productData.getProduct_01_search_keyword());
        searchPage.inputToSearchTextBox(productData.getProduct_01_search_keyword());

        log.info("Search - Search Correct Manufacturer - Step 02: Check to Advanced search check box");
        searchPage.checkAdvancedSearch();

        log.info("Search - Search Correct Manufacturer - Step 03: Select Categories dropdown with value: Computers");
        searchPage.selectToCategoryDropdownByText("Computers");

        log.info("Search - Search Correct Manufacturer - Step 04: Check to Automatically Search check box");
        searchPage.clickToAutomaticallySearch();

        log.info("Search - Search Correct Manufacturer - Step 05: Select Manufacturer dropdown with value: Apple");
        searchPage.selectToManufacturerDropdownByText("Apple");

        log.info("Search - Search Correct Manufacturer - Step 06: Click to Search button");
        searchPage.clickToClickSearchButton();

        log.info("Search - Search Correct Manufacturer - Step 07: Verify results contain product that user is searching");
        verifyTrue(searchPage.areProductsContainKeyword(productData.getProduct_01_search_keyword()));

        log.info("Search - Search Correct Manufacturer - Step 08: Click to Search link at footer");
        searchPage = (SearchPO) searchPage.openLinkByTextAtFooter(driver, "Search");
    }

    @AfterClass
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }


}
