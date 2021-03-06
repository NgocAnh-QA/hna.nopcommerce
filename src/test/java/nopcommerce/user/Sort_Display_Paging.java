package nopcommerce.user;


import commons.AbstractTest;
import commons.GlobalConstants;
import commons.PageGeneratorManagerUser;
import commons.RoleAccess;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
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

@Feature("Sort/Display/Paging Test")
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
        homePage = PageGeneratorManagerUser.getHomePage(driver);

        log.info("Sort_Display_Paging - Precondition - Step 02: Open sub menu Notebooks");
        productPage = homePage.openSubMenu(driver,"Computers", "Notebooks");
    }

    @Story("Sort name: A to Z")
    @Test
    public void TC_01_Sort_Name_A_Z() {
        log.info("Sort_Display_Paging - Sort name AZ - Step 01: Select sort by: Name: A-Z");
        productPage.selectSortByNameAToZ();

        log.info("Sort_Display_Paging - Sort name AZ - Step 02: Verify products display correctly by: Name: A-Z");
        verifyTrue(productPage.areProductsSortedByNameAscending());

        log.info("Sort_Display_Paging - Sort name AZ - Step 03: Refresh page and open again");
        productPage = productPage.openSubMenu(driver,"Computers", "Notebooks");
    }

    @Story("Sort name: Z to A")
    @Test
    public void TC_02_Sort_Name_Z_A() {
        log.info("Sort_Display_Paging - Sort name ZA - Step 01: Select sort by: Name: Z-A");
        productPage.selectSortByNameZToA();

        log.info("Sort_Display_Paging - Sort name ZA - Step 02: Verify products display correctly by: Name: Z-A");
        verifyTrue(productPage.areProductsSortedByNameDescending());

        log.info("Sort_Display_Paging - Sort name ZA - Step 03: Refresh page and open again");
        productPage = productPage.openSubMenu(driver,"Computers", "Notebooks");
    }

    @Story("Sort price: low to high")
    @Test
    public void TC_03_Sort_Price_Low_To_High() {
        log.info("Sort_Display_Paging - Sort price low to high - Step 01: Select sort by: Price: Low to High");
        productPage.selectSortByPriceLowToHigh();

        log.info("Sort_Display_Paging - Sort price low to high - Step 02: Verify products display correctly by: Price: Low to High");
        verifyTrue(productPage.areProductsSortedByPriceLowToHigh());

        log.info("Sort_Display_Paging - Sort price low to high - Step 03: Refresh page and open again");
        productPage = productPage.openSubMenu(driver,"Computers", "Notebooks");
    }

    @Story("Sort price: high to low")
    @Test
    public void TC_04_Sort_Price_High_To_Low() {
        log.info("Sort_Display_Paging - Sort price high to low - Step 01: Select sort by: Price: High to Low");
        productPage.selectSortByPriceHighToLow();

        log.info("Sort_Display_Paging - Sort price high to low - Step 02: Verify products display correctly by: Price: High to Low");
        verifyTrue(productPage.areProductsSortedByPriceHighToLow());

        log.info("Sort_Display_Paging - Sort price high to low - Step 03: Refresh page and open again");
        productPage = productPage.openSubMenu(driver,"Computers", "Notebooks");
    }

    @Story("Display 3 items")
    @Test
    public void TC_05_Display_3_Items() {
        log.info("Sort_Display_Paging - Display 3 items - Step 01: Select display 3 items");
        productPage.selectDisplayPerpage("3");

        log.info("Sort_Display_Paging - Display 3 items - Step 02: Verify displays maximum 3 items at per page");
        verifyTrue(productPage.areProductsDisplayedPerPage(3));

        log.info("Sort_Display_Paging - Display 3 items - Step 03: Verify next icon displays");
        verifyTrue(productPage.isNextIconDisplayed());

        log.info("Sort_Display_Paging - Display 3 items - Step 04: Move to page 2");
        productPage.clickMoveToPage("2");

        log.info("Sort_Display_Paging - Display 3 items - Step 05: Verify previous icon displays");
        verifyTrue(productPage.isPreviousIconDisplay());

        log.info("Sort_Display_Paging - Display 3 items - Step 06: Refresh page and open again");
        productPage = productPage.openSubMenu(driver,"Computers", "Notebooks");
    }

    @Story("Display 6 items")
    @Test
    public void TC_06_Display_6_Items() {
        log.info("Sort_Display_Paging - Display 6 items - Step 01: Select display 6 items");
        productPage.selectDisplayPerpage("6");

        log.info("Sort_Display_Paging - Display 6 items - Step 02: Verify displays maximum 6 items at per page");
        verifyTrue(productPage.areProductsDisplayedPerPage(6));

        log.info("Sort_Display_Paging - Display 6 items - Step 03: Verify paging undisplays");
        verifyTrue(productPage.isPagingUnDisplayed());

        log.info("Sort_Display_Paging - Display 6 items - Step 04: Refresh page and open again");
        productPage = productPage.openSubMenu(driver,"Computers", "Notebooks");
    }

    @Story("Display 9 items")
    @Test
    public void TC_07_Display_9_Items() {
        log.info("Sort_Display_Paging - Display 9 items - Step 01: Select display 9 items");
        productPage.selectDisplayPerpage("9");

        log.info("Sort_Display_Paging - Display 9 items - Step 02: Verify displays maximum 9 items at per page");
        verifyTrue(productPage.areProductsDisplayedPerPage(9));

        log.info("Sort_Display_Paging - Display 9 items - Step 03: Verify paging undisplays");
        verifyTrue(productPage.isPagingUnDisplayed());

        log.info("Sort_Display_Paging - Display 9 items - Step 04: Refresh page and open again");
        productPage = productPage.openSubMenu(driver,"Computers", "Notebooks");
    }

    @AfterClass
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }


}
