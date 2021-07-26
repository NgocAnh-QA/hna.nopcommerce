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
import pageObjects.User.*;
import testdata.UserData;

import java.io.File;

@Feature("My Account Test")
public class MyAccount extends AbstractTest {
    private WebDriver driver;
    private int randomNumber = getRandomNumber();
    private UserData userData;
    private HomePagePO homePage;
    private LoginPO loginPage;
    private CustomerInfoPO customerInfoPage;
    private ChangePasswordPO changePasswordPage;
    private AddressesPO addressPage;
    private ProductDetailPO productDetailPage;
    private ProductReviewPO productReview;
    private MyProductReviewPO myProductReviewPage;
    RoleAccess roleAccess;
    private String emailUpdate;

    @Parameters({"browser"})
    @BeforeClass
    private void beforeClass(String browserName) {
        String role = System.getProperty("role");
        ConfigFactory.setProperty("role", role);
        roleAccess = ConfigFactory.create(RoleAccess.class);
        driver = getBrowserDriver(browserName, roleAccess.url());

        userData = UserData.getFiles(GlobalConstants.ROOT_FOLDER + File.separator + "src/test/java" + File.separator + "testdata" + File.separator + "UserData.json");

        log.info("My Account - Precondition - Step 01: Open Home Page");
        homePage = PageGeneratorManagerUser.getHomePage(driver);

        log.info("My Account - Precondition - Step 02: Click to Login link");
        loginPage = homePage.clickToLoginLink();

        log.info("My Account - Precondition - Step 03: Input to Email with value: " + RegisterToSystem.EMAIL);
        loginPage.inputToEmailTextBox(RegisterToSystem.EMAIL);

        log.info("My Account - Precondition - Step 04: Input to Password with value: " + RegisterToSystem.PASSWORD);
        loginPage.inputToPasswordTextBox(RegisterToSystem.PASSWORD);

        log.info("My Account - Precondition - Step 05: Click to Login button");
        homePage = loginPage.clickToLoginButton();

        log.info("My Account - Precondition - Step 06: Click to My Account link");
        customerInfoPage = homePage.clickToMyAccountLink(driver);
    }

    @Story("Update Customer Info")
    @Test
    public void TC_01_Update_Customer_Info() {
        log.info("My Account - Update Customer Info - Step 01: Click to Gender at Customer info with value: Male");
        customerInfoPage.clickToRadioButtonByID(driver, "gender-female");

        log.info("My Account - Update Customer Info - Step 02: Input to First Name at Customer info with value: " + userData.getFirstName_01());
        customerInfoPage.inputToTextBoxByID(driver, "FirstName", userData.getFirstName_01());

        log.info("My Account - Update Customer Info - Step 03: Input to Last Name at Customer info with value:" + userData.getLastName_01());
        customerInfoPage.inputToTextBoxByID(driver, "LastName", userData.getLastName_01());

        log.info("My Account - Update Customer Info - Step 04: Select to Day of birth at Customer info with value: " + userData.getDateOfBirth_01());
        customerInfoPage.selectDropdownByName(driver, "DateOfBirthDay", userData.getDateOfBirth_01());

        log.info("My Account - Update Customer Info - Step 05: Select to Month of birth at Customer info with value: " + userData.getMonthOfBirth_01());
        customerInfoPage.selectDropdownByName(driver, "DateOfBirthMonth", userData.getMonthOfBirth_01());

        log.info("My Account - Update Customer Info - Step 06: Select to Year of birth at Customer info with value: " + userData.getYearOfYear_01());
        customerInfoPage.selectDropdownByName(driver, "DateOfBirthYear", userData.getYearOfYear_01());

        emailUpdate = userData.getEmailAddress_01() + randomNumber + 1 + "@hotmail.com";
        log.info("My Account - Update Customer Info - Step 07: Input to Email at Customer info with value:" + emailUpdate);
        customerInfoPage.inputToTextBoxByID(driver, "Email", emailUpdate);

        log.info("My Account - Update Customer Info - Step 08: Input to Company Name Name at Customer info with value:" + userData.getCompanyName_01());
        customerInfoPage.inputToTextBoxByID(driver, "Company", userData.getCompanyName_01());

        log.info("My Account - Update Customer Info - Step 09: Click to Save button at Customer info");
        customerInfoPage.clickToSaveButton();

        log.info("My Account - Update Customer Info - Step 10: Verify Gender radio is selected correctly");
        verifyTrue(customerInfoPage.isRadioButtonSelectedByID(driver, "gender-male"));

        log.info("My Account - Update Customer Info - Step 11: Verify First Name updated with value: " + userData.getFirstName_01());
        verifyEquals(customerInfoPage.getAttributeTextBoxByID(driver, "FirstName", "value"), userData.getFirstName_01());

        log.info("My Account - Update Customer Info - Step 12: Verify Last Name updated with value: " + userData.getLastName_01());
        verifyEquals(customerInfoPage.getAttributeTextBoxByID(driver, "LastName", "value"), userData.getLastName_01());

        log.info("My Account - Update Customer Info - Step 13: Verify Date of birth updated with value: " + userData.getDateOfBirth_01());
        verifyEquals(customerInfoPage.getFirstSelectedInDropdownByName(driver, "DateOfBirthDay"), userData.getDateOfBirth_01());

        log.info("My Account - Update Customer Info - Step 14: Verify Month of birth updated with value: " + userData.getMonthOfBirth_01());
        verifyEquals(customerInfoPage.getFirstSelectedInDropdownByName(driver, "DateOfBirthMonth"), userData.getMonthOfBirth_01());

        log.info("My Account - Update Customer Info - Step 15: Verify Year of birth updated with value: " + userData.getYearOfYear_01());
        verifyEquals(customerInfoPage.getFirstSelectedInDropdownByName(driver, "DateOfBirthYear"), userData.getYearOfYear_01());

        log.info("My Account - Update Customer Info - Step 16: Verify Email address updated with value: " + emailUpdate);
        verifyEquals(customerInfoPage.getAttributeTextBoxByID(driver, "Email", "value"), emailUpdate);

        log.info("My Account - Update Customer Info - Step 17: Verify Company Name updated with value: " + userData.getCompanyName_01());
        verifyEquals(customerInfoPage.getAttributeTextBoxByID(driver, "Company", "value"), userData.getCompanyName_01());
    }

    @Story("Add new address")
    @Test
    public void TC_02_Add_New_Address() {
        log.info("My Account - Add New Address - Step 01: Open Addresses link");
        addressPage = (AddressesPO) customerInfoPage.openLinkByPageNameAtMyAccount(driver, "Addresses");

        log.info("My Account - Add New Address - Step 02: Click to Add New Address button");
        addressPage.clickToAddNewButton();

        log.info("My Account - Add New Address - Step 03: Input to First Name text box with value: " + userData.getFirstName_01());
        addressPage.inputToTextBoxByID(driver, "Address_FirstName", userData.getFirstName_01());

        log.info("My Account - Add New Address - Step 04: Input to Last Name text box with value: " + userData.getLastName_01());
        addressPage.inputToTextBoxByID(driver, "Address_LastName", userData.getLastName_01());

        log.info("My Account - Add New Address - Step 05: Input to Email text box with value: " + emailUpdate);
        addressPage.inputToTextBoxByID(driver, "Address_Email", emailUpdate);

        log.info("My Account - Add New Address - Step 06: Input to Company  text box with value: " + userData.getCompanyName_01());
        addressPage.inputToTextBoxByID(driver, "Address_Company", userData.getCompanyName_01());

        log.info("My Account - Add New Address - Step 07: Select Country dropdown with value: " + userData.getCountry_01());
        addressPage.selectDropdownByName(driver, "Address.CountryId", userData.getCountry_01());

        log.info("My Account - Add New Address - Step 08: Select State Province dropdown with value: " + userData.getStateProvince_01());
        addressPage.selectDropdownByName(driver, "Address.StateProvinceId", userData.getStateProvince_01());

        log.info("My Account - Add New Address - Step 09: Input to City text box with value: " + userData.getCity_01());
        addressPage.inputToTextBoxByID(driver, "Address_City", userData.getCity_01());

        log.info("My Account - Add New Address - Step 10: Input to Address2 text box with value: " + userData.getAddress2_01());
        addressPage.inputToTextBoxByID(driver, "Address_Address2", userData.getAddress2_01());

        log.info("My Account - Add New Address - Step 11: Input to Address1 textbox with value: " + userData.getAddress1_01());
        addressPage.inputToTextBoxByID(driver, "Address_Address1", userData.getAddress1_01());

        log.info("My Account - Add New Address - Step 12: Input to Zip Postal Code textbox with value: " + userData.getZipPostal_01());
        addressPage.inputToTextBoxByID(driver, "Address_ZipPostalCode", userData.getZipPostal_01());

        log.info("My Account - Add New Address - Step 13: Input to Phone Number textbox with value: " + userData.getPhoneNumber_01());
        addressPage.inputToTextBoxByID(driver, "Address_PhoneNumber", userData.getPhoneNumber_01());

        log.info("My Account - Add New Address - Step 14: Input to Fax Number text box with value: " + userData.getFaxNumber_01());
        addressPage.inputToTextBoxByID(driver, "Address_FaxNumber", userData.getFaxNumber_01());

        log.info("My Account - Add New Address - Step 15: Click to Save New Address button");
        addressPage.clickToSaveNewButton();

        log.info("My Account - Add New Address - Step 16: Verify Name is added successfully");
        verifyEquals(addressPage.getTextByClass(driver, "name"), userData.getFirstName_01() + " " + userData.getLastName_01());

        log.info("My Account - Add New Address - Step 17: Verify Email is added successfully");
        verifyEquals(addressPage.getTextByClass(driver, "email"), "Email: " + emailUpdate);
        RegisterToSystem.EMAIL = emailUpdate;


        log.info("My Account - Add New Address - Step 18: Verify Phone is added successfully");
        verifyEquals(addressPage.getTextByClass(driver, "phone"), "Phone number: " + userData.getPhoneNumber_01());

        log.info("My Account - Add New Address - Step 19: Verify Fax is added successfully");
        verifyEquals(addressPage.getTextByClass(driver, "fax"), "Fax number: " + userData.getFaxNumber_01());

        log.info("My Account - Add New Address - Step 20: Verify Company is added successfully");
        verifyEquals(addressPage.getTextByClass(driver, "company"), userData.getCompanyName_01());

        log.info("My Account - Add New Address - Step 21: Verify Address1 is added successfully");
        verifyEquals(addressPage.getTextByClass(driver, "address1"), userData.getAddress1_01());

        log.info("My Account - Add New Address - Step 22: Verify Address2 is added successfully");
        verifyEquals(addressPage.getTextByClass(driver, "address2"), userData.getAddress2_01());

        log.info("My Account - Add New Address - Step 23: Verify City State Zip are added successfully");
        verifyEquals(addressPage.getTextByClass(driver, "city-state-zip"), userData.getCity_01() + ", " + userData.getStateProvince_01() + ", " + userData.getZipPostal_01());

        log.info("My Account - Add New Address - Step 24: Verify Country is added successfully");
        verifyEquals(addressPage.getTextByClass(driver, "country"), userData.getCountry_01());
    }

    @Story("Change password")
    @Test
    public void TC_03_Change_Password() {
        log.info("My Account - Change Password - Step 01: Open Change Password link");
        changePasswordPage = (ChangePasswordPO) addressPage.openLinkByPageNameAtMyAccount(driver, "Change password");

        log.info("My Account - Change Password - Step 02: Input to old password with value: " + RegisterToSystem.PASSWORD);
        changePasswordPage.inputToTextBoxByID(driver, "OldPassword", RegisterToSystem.PASSWORD);

        log.info("My Account - Change Password - Step 03: Input to new password with value: " + userData.getPassword_01());
        changePasswordPage.inputToTextBoxByID(driver, "NewPassword", RegisterToSystem.PASSWORD + "1");

        log.info("My Account - Change Password - Step 04: Input to confirm new password with value: " + userData.getConfirmPassword_01());
        changePasswordPage.inputToTextBoxByID(driver, "ConfirmNewPassword", RegisterToSystem.PASSWORD + "1");

        log.info("My Account - Change Password - Step 05: Click to Save Change");
        changePasswordPage.clickToSaveChange();

        log.info("My Account - Change Password - Step 06: Verify Password changed successfully");
        verifyEquals(changePasswordPage.getResultMessage(), "Password was changed");
    }

    @Story("My product review")
    @Test
    public void TC_04_My_Product_Review() {
        log.info("My Account - My Product Review - Step 01: Open Home Page");
        homePage = changePasswordPage.openHomePage(driver);

        log.info("My Account - My Product Review - Step 02: Click to Product: Build your own computer");
        productDetailPage = homePage.clickToProductByNameOfProduct(driver, "Build your own computer");

        log.info("My Account - My Product Review - Step 03: Click Add to review");
        productReview = productDetailPage.clickToAddYourReview();

        log.info("My Account - My Product Review - Step 04: Input to Review title with value: " + userData.getReviewTitle_01());
        productReview.inputToTextBoxByID(driver, "AddProductReview_Title", userData.getReviewTitle_01());

        log.info("My Account - My Product Review - Step 05: Input to Review content with value: " + userData.getReviewContent_01());
        productReview.inputToReviewContentTextArea(userData.getReviewContent_01());

        log.info("My Account - My Product Review - Step 06: Click to rating of product");
        productReview.clickToRadioButtonByID(driver, "addproductrating_4");

        log.info("My Account - My Product Review - Step 07: Click to Submit button");
        productReview.clickToSubmitReview();

        log.info("My Account - My Product Review - Step 08: Verify Review is successfully added");
        verifyEquals(productReview.getResultMessage(), "Product review is successfully added.");

        log.info("My Account - My Product Review - Step 09: Click to My Account Link");
        customerInfoPage = productReview.clickToMyAccountLink(driver);

        log.info("My Account - My Product Review - Step 10: Click to My Product Review in My Account");
        myProductReviewPage = (MyProductReviewPO) customerInfoPage.openLinkByPageNameAtMyAccount(driver, "My product reviews");

        log.info("My Account - My Product Review - Step 11: Verify Review Title is displayed correctly");
        verifyEquals(myProductReviewPage.getReviewTitleInMyAccount(), userData.getReviewTitle_01());

        log.info("My Account - My Product Review - Step 12: Verify Review Content is displayed correctly");
        verifyEquals(myProductReviewPage.getReviewContentInMyAccount(), userData.getReviewContent_01());
    }

    @AfterClass
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }


}
