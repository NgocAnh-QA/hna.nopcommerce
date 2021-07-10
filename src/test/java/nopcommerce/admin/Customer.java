package nopcommerce.admin;

import commons.AbstractTest;
import commons.GlobalConstants;
import commons.PageGeneratorManagerAdmin;
import commons.RoleAccess;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.Admin.CustomersPO;
import pageObjects.Admin.DashboardPO;
import pageObjects.Admin.LoginPO;
import testdata.AdminData;

import java.io.File;

public class Customer extends AbstractTest {
    WebDriver driver;

    RoleAccess roleAccess;
    AdminData adminData;
    private DashboardPO dashboardPage;
    private CustomersPO customersPage;
    private LoginPO loginPage;


    @Parameters({"browser"})
    @BeforeClass
    private void beforeClass(String browserName) {
        String role = System.getProperty("role");
        ConfigFactory.setProperty("role", role);
        roleAccess = ConfigFactory.create(RoleAccess.class);
        driver = getBrowserDriver(browserName, roleAccess.url());

        adminData = AdminData.getFiles(GlobalConstants.ROOT_FOLDER + File.separator + "src/test/java" + File.separator + "testdata" + File.separator + "AdminData.json");

        log.info("Customer - Pre condition - Step 01: Login to system admin");
        loginPage = PageGeneratorManagerAdmin.getLoginPageAdmin(driver);
        dashboardPage = loginPage.clickToLoginButton(adminData.getEmailAddress(), adminData.getPassword());
    }

    @BeforeMethod
    private void beforeMethod(){
        log.info("Customer - Pre condition - Step 02: Open Customers > Customers");
        customersPage = (CustomersPO) dashboardPage.openSubMenuAtNav(driver, "Customers", "Customers");

    }
    @Test
    private void TC_01_Create_New_Customer(){

    }
//
//    @Test
//    private void TC_02_Search_Customer_With_Email(){
//
//    }
//
//    @Test
//    private void TC_03_Search_Customer_With_FirstName_And_LastName(){
//
//    }
//
//    @Test
//    private void TC_04_Search_Customer_With_Company(){
//
//    }
//
//    @Test
//    private void TC_05_Search_Customer_With_Full_Data(){
//
//    }
//
//    @Test
//    private void TC_06_Edit_Customer(){
//
//    }

    @AfterClass
    private void afterClass(){

    }

}
