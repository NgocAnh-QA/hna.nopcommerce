package nopcommerce.admin;

import commons.AbstractTest;
import commons.GlobalConstants;
import commons.PageGeneratorManagerAdmin;
import commons.RoleAccess;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.Admin.*;
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
    private AddressesCustomerPO addressesCustomerPage;


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

        log.info("Customer - Create new customer - Step 20: Verify Customer roles text box displays with value: " + adminData.getCustomerRoles_02());
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
        verifyTrue(customersPage.isCustomerDetailDataDisplayedAtTable(adminData.getEmail_02() + randomNumber + "@hotmail.com", adminData.getFirstName_02(), adminData.getLastName_02(), adminData.getCustomerRoles_02(), adminData.getCompanyName_02()));

        log.info("Customer - Create new customer - Step 28: Open Dashboard page");
        dashboardPage = customersPage.openDashboardPage(driver);

    }

    @Test
    private void TC_02_Search_Customer_With_Email() {
        log.info("Customer - Search customer with email - Step 01: Input to Email text box with value: Open Search panel");
        customersPage.openSearchPanel();

        log.info("Customer - Search customer with email - Step 02: Input to Email text box with value: " + adminData.getEmail_02() + randomNumber + "@hotmail.com");
        customersPage.inputToEmailTextbox(adminData.getEmail_02() + randomNumber + "@hotmail.com");

        log.info("Customer - Search customer with email - Step 03: Input to Customer roles with value: " + adminData.getCustomerRoles_02());
        customersPage.inputToCustomerRolesTextbox(adminData.getCustomerRoles_02());

        log.info("Customer - Search customer with email - Step 04: Click to Search button");
        customersPage.clickToSearchButton();

        log.info("Customer - Search customer with email - Step 05: Verify Customer detail displays at table");
        verifyTrue(customersPage.isCustomerDetailDataDisplayedAtTable(adminData.getEmail_02() + randomNumber + "@hotmail.com", adminData.getFirstName_02(), adminData.getLastName_02(), adminData.getCustomerRoles_02(), adminData.getCompanyName_02()));
    }

    @Test
    private void TC_03_Search_Customer_With_FirstName_And_LastName() {
        log.info("Customer - Search customer with firstName and lastName - Step 01: Open Search panel");
        customersPage.openSearchPanel();

        log.info("Customer - Search customer with firstName and lastName - Step 02: Input to First name text box with value: Victoria");
        customersPage.inputToFirstNameTextbox("Victoria");

        log.info("Customer - Search customer with firstName and lastName - Step 03: Input to Last name text box with value: Terces");
        customersPage.inputToLastNameTextbox("Terces");

        log.info("Customer - Search customer with firstName and lastName - Step 04: Input to Customer roles with value: Registered");
        customersPage.inputToCustomerRolesTextbox("Registered");

        log.info("Customer - Search customer with firstName and lastName - Step 05: Click to Search button");
        customersPage.clickToSearchButton();

        log.info("Customer - Search customer with firstName and lastName - Step 06: Verify Customer detail displays at table");
        verifyTrue(customersPage.isCustomerDetailDataDisplayedAtTableByColumnName("Name", "Victoria Terces"));


    }

    @Test
    private void TC_04_Search_Customer_With_Company() {
        log.info("Customer - Search customer with company - Step 01: Open Search panel");
        customersPage.openSearchPanel();

        log.info("Customer - Search customer with company - Step 02: Input to Company text box with value: " + adminData.getCompanyName_02());
        customersPage.inputToCompanyTextbox(adminData.getCompanyName_02());

        log.info("Customer - Search customer with company - Step 03: Input to Customer roles with value: " + adminData.getCustomerRoles_02());
        customersPage.inputToCustomerRolesTextbox(adminData.getCustomerRoles_02());

        log.info("Customer - Search customer with company - Step 04: Click to Search button");
        customersPage.clickToSearchButton();

        log.info("Customer - Search customer with company - Step 05: Verify Customer detail displays at table");
        verifyTrue(customersPage.isCustomerDetailDataDisplayedAtTableByColumnName("Company name", adminData.getCompanyName_02()));

    }

    @Test
    private void TC_05_Search_Customer_With_Full_Data() {
        log.info("Customer - Search customer with full data - Step 01: Open Search panel");
        customersPage.openSearchPanel();

        log.info("Customer - Search customer with full data - Step 02: Input to Email text box with value: " + adminData.getEmail_02() + randomNumber + "@hotmail.com");
        customersPage.inputToEmailTextbox(adminData.getEmail_02() + randomNumber + "@hotmail.com");

        log.info("Customer - Search customer with full data - Step 03: Input to First Name text box with value: " + adminData.getFirstName_02());
        customersPage.inputToFirstNameTextbox(adminData.getFirstName_02());

        log.info("Customer - Search customer with full data - Step 04: Input to Last Name text box with value: " + adminData.getLastName_02());
        customersPage.inputToLastNameTextbox(adminData.getLastName_02());

        log.info("Customer - Search customer with full data - Step 05: Select Month of Birth dropdown with value: " + customersPage.getMonthOfBirthFromData(adminData.getDateOfBirth_02()));
        customersPage.selectMonthOfBirthDropdown(customersPage.getMonthOfBirthFromData(adminData.getDateOfBirth_02()));

        log.info("Customer - Search customer with full data - Step 06: Select Day of Birth dropdown with value: " + customersPage.getDayOfBirthFromData(adminData.getDateOfBirth_02()));
        customersPage.selectDayOfBirthDropdown(customersPage.getDayOfBirthFromData(adminData.getDateOfBirth_02()));

        log.info("Customer - Search customer with full data - Step 07: Input to Company text box with value: " + adminData.getCompanyName_02());
        customersPage.inputToCompanyTextbox(adminData.getCompanyName_02());

        log.info("Customer - Search customer with full data - Step 08: Input to Customer roles with value: " + adminData.getCustomerRoles_02());
        customersPage.inputToCustomerRolesTextbox(adminData.getCustomerRoles_02());

        log.info("Customer - Search customer with full data - Step 09: Click to Search button");
        customersPage.clickToSearchButton();

        log.info("Customer - Search customer with full data - Step 10: Verify Customer detail displays at table");
        verifyTrue(customersPage.isCustomerDetailDataDisplayedAtTable(adminData.getEmail_02() + randomNumber + "@hotmail.com", adminData.getFirstName_02(), adminData.getLastName_02(), adminData.getCustomerRoles_02(), adminData.getCompanyName_02()));


    }

    @Test
    private void TC_06_Edit_Customer() {
        log.info("Customer - Edit customer - Step 01: Click to Edit button");
        customerDetailPage = customersPage.clickToEditButton(adminData.getEmail_02() + randomNumber + "@hotmail.com");

        log.info("Customer - Edit customer - Step 02: Edit Customer with value Email: " + adminData.getEmail_03() + randomNumber + "@hotmail.com");
        customerDetailPage.inputToTextboxByIDAtCustomerDetail("Email", adminData.getEmail_03() + randomNumber + "@hotmail.com");

        log.info("Customer - Edit customer - Step 03: Edit Customer with value First Name: " + adminData.getFirstName_03());
        customerDetailPage.inputToTextboxByIDAtCustomerDetail("FirstName", adminData.getFirstName_03());

        log.info("Customer - Edit customer - Step 04: Edit Customer with value Last Name: " + adminData.getLastName_03());
        customerDetailPage.inputToTextboxByIDAtCustomerDetail("LastName", adminData.getLastName_03());

        log.info("Customer - Edit customer - Step 05: Edit Customer with value Date of birth: " + adminData.getDateOfBirth_03());
        customerDetailPage.inputToTextboxByIDAtCustomerDetail("DateOfBirth", adminData.getDateOfBirth_03());

        log.info("Customer - Edit customer - Step 06: Edit Customer with value Company: " + adminData.getCompanyName_03());
        customerDetailPage.inputToTextboxByIDAtCustomerDetail("Company", adminData.getCompanyName_03());

        log.info("Customer - Edit customer - Step 07: Edit Customer with value Admin comment: " + adminData.getAdminComment_03());
        customerDetailPage.inputToTextareaByIDAtCustomerDetail("AdminComment", adminData.getAdminComment_03());

        log.info("Customer - Edit customer - Step 08: Edit Click to Save button");
        customersPage = customerDetailPage.clickToSaveButton();

        log.info("Customer - Edit customer - Step 09: Verify Updated successfully message displays");
        verifyTrue(customersPage.isUpdatedSuccessfullyMessageDisplayed());

        log.info("Customer - Edit customer - Step 10: Open Search panel");
        customersPage.openSearchPanel();

        log.info("Customer - Edit customer - Step 11: Input to Email text box with value: " + adminData.getEmail_03() + randomNumber + "@hotmail.com");
        customersPage.inputToEmailTextbox(adminData.getEmail_03() + randomNumber + "@hotmail.com");

        log.info("Customer - Edit customer - Step 12: Input to First Name text box with value: " + adminData.getFirstName_03());
        customersPage.inputToFirstNameTextbox(adminData.getFirstName_03());

        log.info("Customer - Edit customer - Step 13: Input to Last Name text box with value: " + adminData.getLastName_03());
        customersPage.inputToLastNameTextbox(adminData.getLastName_03());

        log.info("Customer - Edit customer - Step 14: Select Month of Birth dropdown with value: " + customersPage.getMonthOfBirthFromData(adminData.getDateOfBirth_03()));
        customersPage.selectMonthOfBirthDropdown(customersPage.getMonthOfBirthFromData(adminData.getDateOfBirth_03()));

        log.info("Customer - Edit customer - Step 15: Select Day of Birth dropdown with value: " + customersPage.getDayOfBirthFromData(adminData.getDateOfBirth_03()));
        customersPage.selectDayOfBirthDropdown(customersPage.getDayOfBirthFromData(adminData.getDateOfBirth_03()));

        log.info("Customer - Edit customer - Step 16: Input to Company text box with value: " + adminData.getCompanyName_03());
        customersPage.inputToCompanyTextbox(adminData.getCompanyName_03());

        log.info("Customer - Edit customer - Step 17: Input to Customer roles with value: " + adminData.getCustomerRoles_03());
        customersPage.inputToCustomerRolesTextbox(adminData.getCustomerRoles_03());

        log.info("Customer - Edit customer - Step 18: Click to Search button");
        customersPage.clickToSearchButton();

        log.info("Customer - Edit customer - Step 19: Verify Customer detail displays at table");
        verifyTrue(customersPage.isCustomerDetailDataDisplayedAtTable(adminData.getEmail_03() + randomNumber + "@hotmail.com", adminData.getFirstName_03(), adminData.getLastName_03(), adminData.getCustomerRoles_03(), adminData.getCompanyName_03()));
    }

    @Test
    private void TC_07_Add_New_Address_In_Customer_Detail() {
        log.info("Customer - Add new address - Step 01: Click to Edit button");
        customerDetailPage = customersPage.clickToEditButton(adminData.getEmail_03() + randomNumber + "@hotmail.com");

        log.info("Customer - Add new address - Step 02: Open Address panel");
        customerDetailPage.openPanelByNameText("Addresses");

        log.info("Customer - Add new address - Step 03: Click to Add new address button");
        addressesCustomerPage = customerDetailPage.clickToAddNewAddressButton();

        log.info("Customer - Add new address - Step 04: Input to First Name text box with value: " + adminData.getFirstName_02());
        addressesCustomerPage.inputToTextboxByIDAtAddressPage("FirstName", adminData.getFirstName_02());

        log.info("Customer - Add new address - Step 05: Input to Last Name text box  with value: " + adminData.getLastName_02());
        addressesCustomerPage.inputToTextboxByIDAtAddressPage("LastName", adminData.getLastName_02());

        log.info("Customer - Add new address - Step 06: Input to Email with text box  value: " + adminData.getEmail_02() + randomNumber + 2 + "@hotmail.com");
        addressesCustomerPage.inputToTextboxByIDAtAddressPage("Email", adminData.getEmail_02() + randomNumber + 2 + "@hotmail.com");

        log.info("Customer - Add new address - Step 07: Input to Company text box  with value: " + adminData.getCompanyName_02());
        addressesCustomerPage.inputToTextboxByIDAtAddressPage("Company", adminData.getCompanyName_02());

        log.info("Customer - Add new address - Step 08: Select to Country dropdown with value: " + adminData.getCountry_02());
        addressesCustomerPage.selectDropdownByIDAtAddressPage("CountryId", adminData.getCountry_02());

        log.info("Customer - Add new address - Step 09: Select to State/Province dropdown with value: " + adminData.getStateProvince_02());
        addressesCustomerPage.selectDropdownByIDAtAddressPage("StateProvinceId", adminData.getStateProvince_02());

        log.info("Customer - Add new address - Step 10: Input to City text box  with value: " + adminData.getCity_02());
        addressesCustomerPage.inputToTextboxByIDAtAddressPage("City", adminData.getCity_02());

        log.info("Customer - Add new address - Step 11: Input to Address1 text box  with value: " + adminData.getAddress1_02());
        addressesCustomerPage.inputToTextboxByIDAtAddressPage("Address1", adminData.getAddress1_02());

        log.info("Customer - Add new address - Step 12: Input to Address2 text box  with value: " + adminData.getAddress2_02());
        addressesCustomerPage.inputToTextboxByIDAtAddressPage("Address2", adminData.getAddress2_02());

        log.info("Customer - Add new address - Step 13: Input to Zip/Postal Code text box  with value: " + adminData.getZipPostal_02());
        addressesCustomerPage.inputToTextboxByIDAtAddressPage("ZipPostalCode", adminData.getZipPostal_02());

        log.info("Customer - Add new address - Step 14: Input to Phone Number text box  with value: " + adminData.getPhoneNumber_02());
        addressesCustomerPage.inputToTextboxByIDAtAddressPage("PhoneNumber", adminData.getPhoneNumber_02());

        log.info("Customer - Add new address - Step 15: Input to Fax Number text box  with value: " + adminData.getFaxNumber_02());
        addressesCustomerPage.inputToTextboxByIDAtAddressPage("FaxNumber", adminData.getFaxNumber_02());

        log.info("Customer - Add new address - Step 16: Click to Save button");
        addressesCustomerPage.clickToSaveButton();

        log.info("Customer - Add new address - Step 17: Verify Add successfully message displays");
        verifyTrue(addressesCustomerPage.isAddSuccessMessageDisplayed());

        log.info("Customer - Add new address - Step 18: Verify First Name displays with value: " + adminData.getFirstName_02());
        verifyEquals(addressesCustomerPage.getAttributeTextboxByIDAtAddressPage("FirstName"), adminData.getFirstName_02());

        log.info("Customer - Add new address - Step 19: Verify Last Name displays with value: " + adminData.getLastName_02());
        verifyEquals(addressesCustomerPage.getAttributeTextboxByIDAtAddressPage("LastName"), adminData.getLastName_02());

        log.info("Customer - Add new address - Step 20: Verify Email displays with value: " + adminData.getEmail_02() + randomNumber + 2 + "@hotmail.com");
        verifyEquals(addressesCustomerPage.getAttributeTextboxByIDAtAddressPage("Email"), adminData.getEmail_02() + randomNumber + 2 + "@hotmail.com");

        log.info("Customer - Add new address - Step 21: Verify Company displays with value: " + adminData.getCompanyName_02());
        verifyEquals(addressesCustomerPage.getAttributeTextboxByIDAtAddressPage("Company"), adminData.getCompanyName_02());

        log.info("Customer - Add new address - Step 22: Verify Country displays with value: " + adminData.getCountry_02());
        verifyEquals(addressesCustomerPage.getFirstSelectedInDropdownByID("CountryId"), adminData.getCountry_02());

        log.info("Customer - Add new address - Step 23: Verify State/Province displays with value: " + adminData.getStateProvince_02());
        verifyEquals(addressesCustomerPage.getFirstSelectedInDropdownByID("StateProvinceId"), adminData.getStateProvince_02());

        log.info("Customer - Add new address - Step 24: Verify City displays with value: " + adminData.getCity_02());
        verifyEquals(addressesCustomerPage.getAttributeTextboxByIDAtAddressPage("City"), adminData.getCity_02());

        log.info("Customer - Add new address - Step 25: Verify Address1 displays with value: " + adminData.getAddress1_02());
        verifyEquals(addressesCustomerPage.getAttributeTextboxByIDAtAddressPage("Address1"), adminData.getAddress1_02());

        log.info("Customer - Add new address - Step 26: Verify Address2 displays with value: " + adminData.getAddress2_02());
        verifyEquals(addressesCustomerPage.getAttributeTextboxByIDAtAddressPage("Address2"), adminData.getAddress2_02());

        log.info("Customer - Add new address - Step 27: Verify Zip/Postal Code displays with value: " + adminData.getZipPostal_02());
        verifyEquals(addressesCustomerPage.getAttributeTextboxByIDAtAddressPage("ZipPostalCode"), adminData.getZipPostal_02());

        log.info("Customer - Add new address - Step 28: Verify Phone Number displays with value: " + adminData.getPhoneNumber_02());
        verifyEquals(addressesCustomerPage.getAttributeTextboxByIDAtAddressPage("PhoneNumber"), adminData.getPhoneNumber_02());

        log.info("Customer - Add new address - Step 29: Verify Fax Number displays with value: " + adminData.getFaxNumber_02());
        verifyEquals(addressesCustomerPage.getAttributeTextboxByIDAtAddressPage("FaxNumber"), adminData.getFaxNumber_02());

        log.info("Customer - Add new address - Step 30: Click to Back to customer details link");
        customerDetailPage = addressesCustomerPage.clickToBackToCustomerDetailsLink();

        log.info("Customer - Add new address - Step 31: Open Address panel");
        customerDetailPage.openPanelByNameText("Addresses");

        log.info("Customer - Add new address - Step 32: Verify Address has been already created displays at table");
        verifyTrue(customerDetailPage.isAddressDetailsDisplayedAtTable(adminData.getFirstName_02(), adminData.getLastName_02(), adminData.getEmail_02() + randomNumber + 2 + "@hotmail.com", adminData.getPhoneNumber_02(), adminData.getFaxNumber_02(), adminData.getCompanyName_02(), adminData.getAddress1_02(), adminData.getAddress2_02(), adminData.getCity_02(), adminData.getStateProvince_02(), adminData.getZipPostal_02(), adminData.getCountry_02()));
    }

    @Test
    private void TC_08_Edit_Address_In_Customer_Detail() {
        log.info("Customer - Edit address in customer detail - Step 01: Click to Edit button");
        customerDetailPage = customersPage.clickToEditButton(adminData.getEmail_03() + randomNumber + "@hotmail.com");

        log.info("Customer - Edit address in customer detail - Step 02: Open Address panel");
        customerDetailPage.openPanelByNameText("Addresses");

        log.info("Customer - Edit address in customer detail - Step 03: Click to Edit button at Address panel");
        addressesCustomerPage = customerDetailPage.clickToEditButtonAtAddressesPanel(adminData.getCompanyName_02(), adminData.getAddress1_02(), adminData.getAddress2_02(), adminData.getCity_02(), adminData.getStateProvince_02(), adminData.getZipPostal_02(), adminData.getCountry_02());

        log.info("Customer - Edit address in customer details - Step 04: Input to Company text box  with value: " + adminData.getCompanyName_03());
        addressesCustomerPage.inputToTextboxByIDAtAddressPage("Company", adminData.getCompanyName_03());

        log.info("Customer - Edit address in customer details - Step 05: Select to Country dropdown with value: " + adminData.getCountry_03());
        addressesCustomerPage.selectDropdownByIDAtAddressPage("CountryId", adminData.getCountry_03());

        log.info("Customer - Edit address in customer details - Step 06: Select to State/Province dropdown with value: " + adminData.getStateProvince_03());
        addressesCustomerPage.selectDropdownByIDAtAddressPage("StateProvinceId", adminData.getStateProvince_03());

        log.info("Customer - Edit address in customer details - Step 07: Input to City text box  with value: " + adminData.getCity_03());
        addressesCustomerPage.inputToTextboxByIDAtAddressPage("City", adminData.getCity_03());

        log.info("Customer - Edit address in customer details - Step 08: Input to Address1 text box  with value: " + adminData.getAddress1_03());
        addressesCustomerPage.inputToTextboxByIDAtAddressPage("Address1", adminData.getAddress1_03());

        log.info("Customer - Edit address in customer details - Step 09: Input to Address2 text box  with value: " + adminData.getAddress2_03());
        addressesCustomerPage.inputToTextboxByIDAtAddressPage("Address2", adminData.getAddress2_03());

        log.info("Customer - Edit address in customer details - Step 10: Input to Zip/Postal Code text box  with value: " + adminData.getZipPostal_03());
        addressesCustomerPage.inputToTextboxByIDAtAddressPage("ZipPostalCode", adminData.getZipPostal_03());

        log.info("Customer - Edit address in customer details - Step 11: Click to Save button");
        addressesCustomerPage.clickToSaveButton();

        log.info("Customer - Edit address in customer details - Step 12: Verify Add successfully message displays");
        verifyTrue(addressesCustomerPage.isAddSuccessMessageDisplayed());

        log.info("Customer - Edit address in customer details - Step 13: Verify Company displays with value: " + adminData.getCompanyName_03());
        verifyEquals(addressesCustomerPage.getAttributeTextboxByIDAtAddressPage("Company"), adminData.getCompanyName_03());

        log.info("Customer - Edit address in customer details - Step 14: Verify Country displays with value: " + adminData.getCountry_03());
        verifyEquals(addressesCustomerPage.getFirstSelectedInDropdownByID("CountryId"), adminData.getCountry_03());

        log.info("Customer - Edit address in customer details - Step 15: Verify State/Province displays with value: " + adminData.getStateProvince_03());
        verifyEquals(addressesCustomerPage.getFirstSelectedInDropdownByID("StateProvinceId"), adminData.getStateProvince_03());

        log.info("Customer - Edit address in customer details - Step 16: Verify City displays with value: " + adminData.getCity_03());
        verifyEquals(addressesCustomerPage.getAttributeTextboxByIDAtAddressPage("City"), adminData.getCity_03());

        log.info("Customer - Edit address in customer details - Step 17: Verify Address1 displays with value: " + adminData.getAddress1_03());
        verifyEquals(addressesCustomerPage.getAttributeTextboxByIDAtAddressPage("Address1"), adminData.getAddress1_03());

        log.info("Customer - Edit address in customer details - Step 18: Verify Address2 displays with value: " + adminData.getAddress2_03());
        verifyEquals(addressesCustomerPage.getAttributeTextboxByIDAtAddressPage("Address2"), adminData.getAddress2_03());

        log.info("Customer - Edit address in customer details - Step 19: Verify Zip/Postal Code displays with value: " + adminData.getZipPostal_03());
        verifyEquals(addressesCustomerPage.getAttributeTextboxByIDAtAddressPage("ZipPostalCode"), adminData.getZipPostal_03());

        log.info("Customer - Edit address in customer details - Step 20: Click to Back to customer details link");
        customerDetailPage = addressesCustomerPage.clickToBackToCustomerDetailsLink();

        log.info("Customer - Edit address in customer details - Step 21: Verify Address has been already created displays at table");
        verifyTrue(customerDetailPage.isAddressDetailsDisplayedAtTable(adminData.getFirstName_02(), adminData.getLastName_02(), adminData.getEmail_02() + randomNumber + 2 + "@hotmail.com", adminData.getPhoneNumber_02(), adminData.getFaxNumber_02(), adminData.getCompanyName_03(), adminData.getAddress1_03(), adminData.getAddress2_03(), adminData.getCity_03(), adminData.getStateProvince_03(), adminData.getZipPostal_03(), adminData.getCountry_03()));

        log.info("Customer - Edit address in customer details - Step 22: Click back to customer page");
        customersPage = customerDetailPage.clickToBackToCustomerListLink();

    }

    @Test
    private void TC_09_Delete_Address_In_Customer_Detail() {
        log.info("Customer - Delete address in customer detail - Step 01: Click to Edit button");
        customerDetailPage = customersPage.clickToEditButton(adminData.getEmail_03() + randomNumber + "@hotmail.com");

        log.info("Customer - Delete address in customer detail - Step 02: Open Address panel");
        customerDetailPage.openPanelByNameText("Addresses");

        log.info("Customer - Delete address in customer detail - Step 03: Click to Edit button at Address panel");
        customerDetailPage.clickToDeleteButtonAtAddressesPanel(adminData.getCompanyName_03(), adminData.getAddress1_03(), adminData.getAddress2_03(), adminData.getCity_03(), adminData.getStateProvince_03(), adminData.getZipPostal_03(), adminData.getCountry_03());

        log.info("Customer - Delete address in customer detail - Step 04: Accept alert");
        customerDetailPage.acceptAlert(driver);

        log.info("Customer - Delete address in customer detail - Step 05: Open Address panel");
        customerDetailPage.openPanelByNameText("Addresses");

        log.info("Customer - Delete address in customer detail - Step 06: Verify No data in table at addresses panel");
        verifyTrue(customerDetailPage.isNoDataInTableAtAddressesPanel());

    }

    @AfterClass
    private void afterClass() {
        closeBrowserAndDriver(driver);
    }

}
