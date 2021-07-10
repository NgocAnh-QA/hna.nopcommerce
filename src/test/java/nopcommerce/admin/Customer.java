package nopcommerce.admin;

import commons.AbstractTest;
import commons.GlobalConstants;
import commons.PageGeneratorManagerAdmin;
import commons.RoleAccess;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.Admin.CustomerDetailPO;
import pageObjects.Admin.CustomersPO;
import pageObjects.Admin.DashboardPO;
import pageObjects.Admin.LoginPO;
import testdata.AdminData;

import java.io.File;

public class Customer extends AbstractTest {
    WebDriver driver;
    private int randomNumber = getRandomNumber();

    RoleAccess roleAccess;
    AdminData adminData;
    private DashboardPO dashboardPage;
    private CustomersPO customersPage;
    private LoginPO loginPage;
    private CustomerDetailPO customerDetailPage;


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
    private void beforeMethod() {
        log.info("Customer - Pre condition - Step 02: Open Customers > Customers");
        customersPage = (CustomersPO) dashboardPage.openSubMenuAtNav(driver, "Customers", "Customers");

    }

    @AfterMethod
    private void afterMethod() {
        log.info("Customer: Open Dashboard page");
        dashboardPage = customersPage.openDashboardPage(driver);
    }

    @Test
    private void TC_01_Create_New_Customer() {
        log.info("Customer - Create new customer - Step 01: Click to Add new button");
        customerDetailPage = customersPage.clickToAddNewButton();

        log.info("Customer - Create new customer - Step 02: Input to Email text box with value: " + adminData.getEmail_02() + randomNumber + "@hotmail.com");
        customerDetailPage.inputToTextboxByIDAtCustomerDetail("Email", adminData.getEmail_02() + randomNumber + "@hotmail.com");

        log.info("Customer - Create new customer - Step 03: Input to Password text box  with value: " + adminData.getPassword_02());
        customerDetailPage.inputToTextboxByIDAtCustomerDetail("Password", adminData.getPassword_02());

        log.info("Customer - Create new customer - Step 04: Input to First name text box  with value: " + adminData.getFirstName_02());
        customerDetailPage.inputToTextboxByIDAtCustomerDetail("FirstName", adminData.getFirstName_02());

        log.info("Customer - Create new customer - Step 05: Input to Last name text box  with value: " + adminData.getLastName_02());
        customerDetailPage.inputToTextboxByIDAtCustomerDetail("LastName", adminData.getLastName_02());

        log.info("Customer - Create new customer - Step 06: Click to Gender radio button with value: Female");
        customerDetailPage.clickToRadioButtonByIDAtCustomerDetail("Gender_Female");

        log.info("Customer - Create new customer - Step 07: Input to Date of birth text box with value: " + adminData.getDateOfBirth_02());
        customerDetailPage.inputToTextboxByIDAtCustomerDetail("DateOfBirth", adminData.getDateOfBirth_02());

        log.info("Customer - Create new customer - Step 08: Input to Company text box with value: " + adminData.getCompanyName_02());
        customerDetailPage.inputToTextboxByIDAtCustomerDetail("Company", adminData.getCompanyName_02());

        log.info("Customer - Create new customer - Step 09: Input to Customer roles text box with value: " + adminData.getCustomerRoles_02());
        customerDetailPage.inputToCustomerRolesTextboxAtCustomerDetail(adminData.getCustomerRoles_02());

        log.info("Customer - Create new customer - Step 10: Check to Active check box");
        customerDetailPage.checkToCheckboxByIDAtCustomerDetail("Active");

        log.info("Customer - Create new customer - Step 11: Input to Admin comment text area with value: ");
        customerDetailPage.inputToTextareaByIDAtCustomerDetail("AdminComment", adminData.getAdminComment_02());

        log.info("Customer - Create new customer - Step 12: Click to Save and continue edit button");
        customerDetailPage.clickToSaveAndContinueEditButton();

        log.info("Customer - Create new customer - Step 13: Verify Add successfully message displays");
        verifyTrue(customerDetailPage.isAddedSuccessfullyMessageDisplayed());

        log.info("Customer - Create new customer - Step 14: Verify Email text box displays with value: " + adminData.getEmail_02() + randomNumber + "@hotmail.com");
        verifyEquals(customerDetailPage.getTextboxByIDAtCustomerDetail("Email"), adminData.getEmail_02() + randomNumber + "@hotmail.com");

        log.info("Customer - Create new customer - Step 15: Verify First name text box displays with value: " + adminData.getFirstName_02());
        verifyEquals(customerDetailPage.getTextboxByIDAtCustomerDetail("FirstName"), adminData.getFirstName_02());

        log.info("Customer - Create new customer - Step 16: Verify Last name text box displays with value: " + adminData.getLastName_02());
        verifyEquals(customerDetailPage.getTextboxByIDAtCustomerDetail("LastName"), adminData.getLastName_02());

        log.info("Customer - Create new customer - Step 17: Verify Gender radio button displays with value: Female");
        verifyTrue(customerDetailPage.isRadionButtonByIDAtCustomerDetailSelected("Gender_Female"));

        log.info("Customer - Create new customer - Step 18: Verify Date of birth text box displays with value: " + adminData.getDateOfBirth_02());
        verifyEquals(customerDetailPage.getTextboxByIDAtCustomerDetail("DateOfBirth"), adminData.getDateOfBirth_02());

        log.info("Customer - Create new customer - Step 19: Verify Company text box displays with value: " + adminData.getCompanyName_02());
        verifyEquals(customerDetailPage.getTextboxByIDAtCustomerDetail("Company"), adminData.getCompanyName_02());

        log.info("Customer - Create new customer - Step 20: Verify Customer roles text box displays with value: "+ adminData.getCustomerRoles_02());
        verifyTrue(customerDetailPage.isCustomerRolesValueDisplayed(adminData.getCustomerRoles_02()));

        log.info("Customer - Create new customer - Step 21: Verify Active is checked");
        verifyTrue(customerDetailPage.isCheckboxByIDAtCustomerDetailChecked("Active"));

        log.info("Customer - Create new customer - Step 22: Verify Admin comment text area displays with value: " + adminData.getAdminComment_02());
        verifyEquals(customerDetailPage.getTextAreaByIDAtCustomerDetail("AdminComment"), adminData.getAdminComment_02());

        log.info("Customer - Create new customer - Step 23: Click to Back to customer list links");
        customersPage = customerDetailPage.clickToBackToCustomerListLink();

        log.info("Customer - Create new customer - Step 24: Open Search panel");
        customersPage.openSearchPanel();

        log.info("Customer - Create new customer - Step 25: Input to Customer roles with value: " + adminData.getCustomerRoles_02());
        customersPage.inputToCustomerRolesTextbox(adminData.getCustomerRoles_02());

        log.info("Customer - Create new customer - Step 26: Click to Search button");
        customersPage.clickToSearchButton();

        log.info("Customer - Create new customer - Step 27: Verify Customer detail displays at table");
        verifyTrue(customersPage.isCustomerDetailDataDisplayedAtTable(adminData.getEmail_02() + randomNumber + "@hotmail.com", adminData.getFirstName_02() , adminData.getLastName_02(), adminData.getCustomerRoles_02(), adminData.getCompanyName_02()));

        log.info("Customer - Create new customer - Step 28: Open Dashboard page");
        dashboardPage = customersPage.openDashboardPage(driver);

    }

    @Test
    private void TC_02_Search_Customer_With_Email(){
        log.info("Customer - Search customer with email - Step 01: Input to Email text box with value: " + adminData.getEmail_02() + randomNumber + "@hotmail.com");
        customersPage.inputToEmailTextbox(adminData.getEmail_02() + randomNumber + "@hotmail.com");

        log.info("Customer - Search customer with email - Step 02: Input to Customer roles with value: " + adminData.getCustomerRoles_02());
        customersPage.inputToCustomerRolesTextbox(adminData.getCustomerRoles_02());

        log.info("Customer - Search customer with email - Step 03: Click to Search button");
        customersPage.clickToSearchButton();

        log.info("Customer - Search customer with email - Step 04: Verify Customer detail displays at table");
        verifyTrue(customersPage.isCustomerDetailDataDisplayedAtTable(adminData.getEmail_02() + randomNumber + "@hotmail.com", adminData.getFirstName_02() , adminData.getLastName_02(), adminData.getCustomerRoles_02(), adminData.getCompanyName_02()));
    }

    @Test
    private void TC_03_Search_Customer_With_FirstName_And_LastName(){
        log.info("Customer - Search customer with firstName and lastName - Step 01: Input to First name text box with value: Victoria");
        customersPage.inputToFirstNameTextbox("Victoria");

        log.info("Customer - Search customer with firstName and lastName - Step 02: Input to Last name text box with value: Terces");
        customersPage.inputToLastNameTextbox("Terces");

        log.info("Customer - Search customer with firstName and lastName - Step 03: Input to Customer roles with value: Registered");
        customersPage.inputToCustomerRolesTextbox("Registered");

        log.info("Customer - Search customer with firstName and lastName - Step 04: Click to Search button");
        customersPage.clickToSearchButton();

        log.info("Customer - Search customer with firstName and lastName - Step 05: Verify Customer detail displays at table");
        verifyTrue(customersPage.isCustomerDetailDataDisplayedAtTableByColumnName("Name", "Victoria Terces"));


    }

    @Test
    private void TC_04_Search_Customer_With_Company(){
        log.info("Customer - Search customer with company - Step 01: Input to Company text box with value: " + adminData.getCompanyName_02());
        customersPage.inputToCompanyTextbox(adminData.getCompanyName_02());

        log.info("Customer - Search customer with company - Step 02: Input to Customer roles with value: " + adminData.getCustomerRoles_02());
        customersPage.inputToCustomerRolesTextbox(adminData.getCustomerRoles_02());

        log.info("Customer - Search customer with company - Step 03: Click to Search button");
        customersPage.clickToSearchButton();

        log.info("Customer - Search customer with company - Step 04: Verify Customer detail displays at table");
        verifyTrue(customersPage.isCustomerDetailDataDisplayedAtTableByColumnName("Company name", adminData.getCompanyName_02()));


    }

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
    private void afterClass() {

    }

}
