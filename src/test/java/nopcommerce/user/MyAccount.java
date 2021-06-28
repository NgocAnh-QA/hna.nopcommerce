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
import testdata.UserData;

import java.io.File;

public class MyAccount extends AbstractTest {
    private WebDriver driver;
    private int randomNumber = getRandomNumber();
    private UserData userData;
    private HomePagePO homePage;
    private RegisterPO registerPage;
    private LoginPO loginPage;
    private CustomerInfoPO customerInfoPage;
    private ChangePasswordPO changePasswordPage;
    RoleAccess roleAccess;
    private String email, password, emailUpdate;

    @Parameters({"browser"})
    @BeforeClass
    private void beforeClass(String browserName) {
        String role = System.getProperty("role");
        ConfigFactory.setProperty("role", role);
        roleAccess = ConfigFactory.create(RoleAccess.class);
        driver = getBrowserDriver(browserName, roleAccess.url());

        userData = UserData.getFiles(GlobalConstants.ROOT_FOLDER + File.separator + "src/test/java" + File.separator + "testdata" + File.separator + "UserData.json");

        log.info("Register - Precondition - Step 01: Open Home Page");
        homePage = PageGeneratorManager.getHomePage(driver);

        log.info("Register - Precondition - Step 02: Click to Register link at Home Page");
        registerPage = homePage.clickToRegisterLink();

        log.info("Register - Precondition - Step 01: Click to Gender radio button with value: Male");
        registerPage.clickToRadioButtonByID(driver, "gender-male");

        log.info("Register - Precondition - Step 02: Input to FirstName textbox with value: " + userData.getFirstNameValid());
        registerPage.inputToTextboxByID(driver, "FirstName", userData.getFirstNameValid());

        log.info("Register - Precondition - Step 03: Input to LastName textbox with value: " + userData.getLastNameValid());
        registerPage.inputToTextboxByID(driver, "LastName", userData.getLastNameValid());

        log.info("Register - Precondition - Step 04: Select Day Dropdown with value: " + userData.getDateOfBirthValid());
        registerPage.selectDropdownByName(driver, "DateOfBirthDay", userData.getDateOfBirthValid());

        log.info("Register - Precondition - Step 05: Select Month Dropdown with value: " + userData.getMonthOfBirthValid());
        registerPage.selectDropdownByName(driver, "DateOfBirthMonth", userData.getMonthOfBirthValid());

        log.info("Register - Precondition - Step 06: Select Year Dropdown with value: " + userData.getYearOfYearValid());
        registerPage.selectDropdownByName(driver, "DateOfBirthYear", userData.getYearOfYearValid());

        email = userData.getEmailAddressValid() + randomNumber + "@edu.vn.com";
        log.info("Register - Precondition - Step 07: Input to Email textbox with value: " + email);
        registerPage.inputToTextboxByID(driver, "Email", email);

        log.info("Register - Precondition - Step 08: Input to Company textbox with value: " + userData.getCompanyNameValid());
        registerPage.inputToTextboxByID(driver, "Company", userData.getCompanyNameValid());


        password = userData.getPasswordValid();
        log.info("Register - Precondition - Step 10: Input to Password textbox with value: " + password);
        registerPage.inputToTextboxByID(driver, "Password", password);

        log.info("Register - Precondition - Step 11: Input to Confirm Password textbox with value: " + userData.getConfirmPasswordValid());
        registerPage.inputToTextboxByID(driver, "ConfirmPassword", userData.getConfirmPasswordValid());

        log.info("Register - Precondition - Step 12: Click to Register button at Register Page");
        registerPage.clickToRegisterButton();

        registerPage.sleepInSecond(5);
        log.info("Register - Precondition - Step 13: Verify register successfully");
        verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

        log.info("Register - Precondition - Step 13: Click to logout link");
        homePage = registerPage.clickToLogoutLink(driver);

        log.info("Register - Precondition - Step 01: Click to Login link");
        loginPage = homePage.clickToLoginLink();

        log.info("Register - Precondition - Step 01: Input to Email with value: " + email);
        loginPage.inputToEmailTextbox(email);

        log.info("Register - Precondition - Step 02: Input to Password with value: " + password);
        loginPage.inputToPasswordTextbox(password);

        log.info("Register - Precondition - Step 02: Click to Login button");
        homePage = loginPage.clickToLoginButton();

        log.info("Register - Precondition - Step 02: Click to My Account link");
        customerInfoPage = homePage.clickToMyAccountLink(driver);
    }



    public void TC_01_Update_Customer_Info() {
        log.info("My Account - Update Customer Info - Step 01: Click to Gender at Customer infor with value: Male");
        customerInfoPage.clickToRadioButtonByID(driver, "gender-female");

        log.info("My Account - Update Customer Info - Step 02: Input to First Name at Customer infor with value: " + userData.getFirstName_01());
        customerInfoPage.inputToTextboxByID(driver, "FirstName", userData.getFirstName_01());

        log.info("My Account - Update Customer Info - Step 03: Input to Last Name at Customer infor with value:" + userData.getLastName_01());
        customerInfoPage.inputToTextboxByID(driver, "LastName", userData.getLastName_01());

        log.info("My Account - Update Customer Info - Step 04: Select to Day of birth at Customer infor with value: " + userData.getDateOfBirth_01());
        customerInfoPage.selectDropdownByName(driver, "DateOfBirthDay", userData.getDateOfBirth_01());

        log.info("My Account - Update Customer Info - Step 05: Select to Month of birth at Customer infor with value: " + userData.getMonthOfBirth_01());
        customerInfoPage.selectDropdownByName(driver, "DateOfBirthMonth", userData.getMonthOfBirth_01());

        log.info("My Account - Update Customer Info - Step 06: Select to Year of birth at Customer infor with value: " + userData.getYearOfYear_01());
        customerInfoPage.selectDropdownByName(driver, "DateOfBirthYear", userData.getYearOfYear_01());

        emailUpdate = userData.getEmailAddress_01() + randomNumber + 1 + "@hotmail.com";
        log.info("My Account - Update Customer Info - Step 07: Input to Email at Customer infor with value:" + emailUpdate);
        customerInfoPage.inputToTextboxByID(driver, "Email", emailUpdate);

        log.info("My Account - Update Customer Info - Step 08: Input to Company Name Name at Customer infor with value:" + userData.getCompanyName_01());
        customerInfoPage.inputToTextboxByID(driver, "Company", userData.getCompanyName_01());

        log.info("My Account - Update Customer Info - Step 09: Click to Save button at Customer infor");
        customerInfoPage.clickToSaveButton();

        log.info("My Account - Update Customer Info - Step 10: Verify Gender radio is selected correctly");
        verifyTrue(customerInfoPage.isRadioButtonSelectedByID(driver, "gender-male"));

        log.info("My Account - Update Customer Info - Step 11: Verify First Name updated with value: " + userData.getFirstName_01());
        verifyEquals(customerInfoPage.getAttributeTextboxByID(driver, "FirstName", "value"), userData.getFirstName_01());

        log.info("My Account - Update Customer Info - Step 12: Verify Last Name updated with value: " + userData.getLastName_01());
        verifyEquals(customerInfoPage.getAttributeTextboxByID(driver, "LastName", "value"), userData.getLastName_01());

        log.info("My Account - Update Customer Info - Step 13: Verify Date of birth updated with value: " + userData.getDateOfBirth_01());
        verifyEquals(customerInfoPage.getFirstSelectedInDropdownByName(driver, "DateOfBirthDay"), userData.getDateOfBirth_01());

        log.info("My Account - Update Customer Info - Step 14: Verify Month of birth updated with value: " + userData.getMonthOfBirth_01());
        verifyEquals(customerInfoPage.getFirstSelectedInDropdownByName(driver, "DateOfBirthMonth"), userData.getMonthOfBirth_01());

        log.info("My Account - Update Customer Info - Step 15: Verify Year of birth updated with value: " + userData.getYearOfYear_01());
        verifyEquals(customerInfoPage.getFirstSelectedInDropdownByName(driver, "DateOfBirthYear"), userData.getYearOfYear_01());

        log.info("My Account - Update Customer Info - Step 16: Verify Email address updated with value: " + emailUpdate);
        verifyEquals(customerInfoPage.getAttributeTextboxByID(driver, "Email", "value"), emailUpdate);

        log.info("My Account - Update Customer Info - Step 17: Verify Company Name updated with value: " + userData.getCompanyName_01());
        verifyEquals(customerInfoPage.getAttributeTextboxByID(driver, "Company", "value"), userData.getCompanyName_01());
    }


    @Test
    public void TC_03_Change_Password() {
        log.info("My Account - Change Password - Step 01: Open Change Password link");
        changePasswordPage = (ChangePasswordPO) customerInfoPage.openLinkByPageNameAtMyAccount(driver, "Change password");

        log.info("My Account - Change Password - Step 02: Input to old password with value: " + password);
        changePasswordPage.inputToTextboxByID(driver, "OldPassword", password);

        log.info("My Account - Change Password - Step 03: Input to new password with value: " + userData.getPassword_01());
        changePasswordPage.inputToTextboxByID(driver, "NewPassword", userData.getPassword_01());

        log.info("My Account - Change Password - Step 04: Input to confirm new password with value: " + userData.getConfirmPassword_01());
        changePasswordPage.inputToTextboxByID(driver, "ConfirmNewPassword", userData.getConfirmPassword_01());

        log.info("My Account - Change Password - Step 05: Click to Save Change");
        changePasswordPage.clickToSaveChange();

        log.info("My Account - Change Password - Step 06: Verify Password changed successfully");
        verifyEquals(changePasswordPage.getResultMessage(), "Password was changed");
    }

    @AfterClass
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }


}
