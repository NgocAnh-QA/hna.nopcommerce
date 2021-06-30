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
import pageObjects.User.HomePagePO;
import pageObjects.User.ProductPO;
import testdata.UserData;

import java.io.File;

public class Sort_Display_Paging extends AbstractTest {
    private WebDriver driver;
    private int randomNumber = getRandomNumber();
    private UserData userData;
    private HomePagePO homePage;
    private ProductPO productPage;
    RoleAccess roleAccess;

    @Parameters({"browser"})
    @BeforeClass
    private void beforeClass(String browserName) {
        String role = System.getProperty("role");
        ConfigFactory.setProperty("role", role);
        roleAccess = ConfigFactory.create(RoleAccess.class);
        driver = getBrowserDriver(browserName, roleAccess.url());
        userData = UserData.getFiles(GlobalConstants.ROOT_FOLDER + File.separator + "src/test/java" + File.separator + "testdata" + File.separator + "UserData.json");

        log.info("Sort_Display_Paging - Precondition - Step 01: Open Home Page");
        homePage = PageGeneratorManager.getHomePage(driver);

        log.info("Sort_Display_Paging - Precondition - Step 02: Open sub menu Notebooks");
        productPage = homePage.openSubMenu(driver,"Computers", "Notebooks");
    }

    @Test
    public void TC_01_Sort_Name_A_Z() {
        log.info("Sort_Display_Paging - Sort name AZ - Step 01: Select sort by: Name: A-Z");
        productPage.selectSortByNameAToZ();

        log.info("Sort_Display_Paging - Sort name AZ - Step 02: Verify products display correctly by: Name: A-Z");
        verifyTrue(productPage.areProductsSortedByNameAscending());

        log.info("Sort_Display_Paging - Sort name AZ - Step 03: Refresh page and open again");
        productPage = productPage.openSubMenu(driver,"Computers", "Notebooks");
    }

    @Test
    public void TC_02_Sort_Name_Z_A() {
        log.info("Sort_Display_Paging - Sort name ZA - Step 01: Select sort by: Name: Z-A");
        productPage.selectSortByNameZToA();

        log.info("Sort_Display_Paging - Sort name ZA - Step 02: Verify products display correctly by: Name: Z-A");
        verifyTrue(productPage.areProductsSortedByNameDescending());

        log.info("Sort_Display_Paging - Sort name ZA - Step 03: Refresh page and open again");
        productPage = productPage.openSubMenu(driver,"Computers", "Notebooks");
    }

    @Test
    public void TC_03_Sort_Price_Low_To_High() {
        log.info("Sort_Display_Paging - Sort price low to high - Step 01: Select sort by: Price: Low to High");
        productPage.selectSortByPriceLowToHigh();

        log.info("Sort_Display_Paging - Sort price low to high - Step 02: Verify products display correctly by: Price: Low to High");
        verifyTrue(productPage.areProductsSortedByPriceLowToHigh());

        log.info("Sort_Display_Paging - Sort price low to high - Step 03: Refresh page and open again");
        productPage = productPage.openSubMenu(driver,"Computers", "Notebooks");
    }

    @Test
    public void TC_04_Sort_Price_High_To_Low() {
        log.info("Sort_Display_Paging - Sort price high to low - Step 01: Select sort by: Price: High to Low");
        productPage.selectSortByPriceHighToLow();

        log.info("Sort_Display_Paging - Sort price high to low - Step 02: Verify products display correctly by: Price: High to Low");
        verifyTrue(productPage.areProductsSortedByPriceHighToLow());

        log.info("Sort_Display_Paging - Sort price high to low - Step 03: Refresh page and open again");
        productPage = productPage.openSubMenu(driver,"Computers", "Notebooks");
    }


    @AfterClass
    public void afterClass() {
    }


}
