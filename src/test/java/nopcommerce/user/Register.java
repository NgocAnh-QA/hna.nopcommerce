package nopcommerce.user;

import commons.*;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.User.HomePagePO;
import pageObjects.User.RegisterPO;
import testdata.UserData;

import java.io.File;

@Feature("Register Test")
public class Register extends AbstractTest {
    private WebDriver driver;
    private int randomNumber = getRandomNumber();
    private UserData userData;
    private HomePagePO homePage;
    private RegisterPO registerPage;
    RoleAccess roleAccess;

    @Parameters({"browser"})
    @BeforeClass
    private void beforeClass(String browserName) {
        String role = System.getProperty("role");
        ConfigFactory.setProperty("role", role);
        roleAccess = ConfigFactory.create(RoleAccess.class);
        driver = getBrowserDriver(browserName, roleAccess.url());

        userData = UserData.getFiles(GlobalConstants.ROOT_FOLDER + File.separator + "src/test/java" + File.separator + "testdata" + File.separator + "UserData.json");

        log.info("Register - Precondition - Step 01: Open Home Page");
        homePage = PageGeneratorManagerUser.getHomePage(driver);

        log.info("Register - Precondition - Step 02: Click to Register link at Home Page");
        registerPage = homePage.clickToRegisterLink();
    }

    @Story("Register with empty data")
    @Test
    private void TC_01_Register_Empty_Data() {
        log.info("Register - Step 01: Click to Register button at Register Page");
        registerPage.clickToRegisterButton();

        log.info("Register - Step 02: Verify error message displayed at FirstName textbox");
        verifyTrue(registerPage.isMandatoryFieldErrorDisplayed("FirstName"));

        log.info("Register - Step 03: Verify error message displayed at LastName textbox");
        verifyTrue(registerPage.isMandatoryFieldErrorDisplayed("LastName"));

        log.info("Register - Step 04: Verify error message displayed at Email textbox");
        verifyTrue(registerPage.isMandatoryFieldErrorDisplayed("Email"));

        log.info("Register - Step 05: Verify error message displayed at Password textbox");
        verifyTrue(registerPage.isMandatoryFieldErrorDisplayed("Password"));

        log.info("Register - Step 06: Verify error message displayed at ConfirmPassword textbox");
        verifyTrue(registerPage.isMandatoryFieldErrorDisplayed("ConfirmPassword"));

        log.info("Register - Step 07: Refresh Register Page");
        registerPage.refreshCurrentPage(driver);
    }

    @Story("Register with invalid email")
    @Test
    private void TC_02_Register_Invalid_Email() {
        log.info("Register - Step 01: Click to Gender radio button with value: Male");
        registerPage.clickToRadioButtonByID(driver, "gender-male");

        log.info("Register - Step 02: Input to FirstName textbox with value: " + userData.getFirstNameValid());
        registerPage.inputToTextBoxByID(driver, "FirstName", userData.getFirstNameValid());

        log.info("Register - Step 03: Input to LastName text box with value: " + userData.getLastNameValid());
        registerPage.inputToTextBoxByID(driver, "LastName", userData.getLastNameValid());

        log.info("Register - Step 04: Select Day Dropdown with value: " + userData.getDateOfBirthValid());
        registerPage.selectDropdownByName(driver, "DateOfBirthDay", userData.getDateOfBirthValid());

        log.info("Register - Step 05: Select Month Dropdown with value: " + userData.getMonthOfBirthValid());
        registerPage.selectDropdownByName(driver, "DateOfBirthMonth", userData.getMonthOfBirthValid());

        log.info("Register - Step 06: Select Year Dropdown with value: " + userData.getYearOfYearValid());
        registerPage.selectDropdownByName(driver, "DateOfBirthYear", userData.getYearOfYearValid());

        log.info("Register - Step 07: Input to Email textbox with value: " + userData.getEmailAddressInvalid());
        registerPage.inputToTextBoxByID(driver, "Email", userData.getEmailAddressInvalid());

        log.info("Register - Step 08: Input to Company textbox with value: " + userData.getCompanyNameValid());
        registerPage.inputToTextBoxByID(driver, "Company", userData.getCompanyNameValid());

        log.info("Register - Step 10: Input to Password textbox with value: " + userData.getPasswordValid());
        registerPage.inputToTextBoxByID(driver, "Password", userData.getPasswordValid());

        log.info("Register - Step 11: Input to Confirm Password textbox with value: " + userData.getConfirmPasswordValid());
        registerPage.inputToTextBoxByID(driver, "ConfirmPassword", userData.getConfirmPasswordValid());

        log.info("Register - Step 12: Click to Register button at Register Page");
        registerPage.clickToRegisterButton();

        log.info("Register - Step 13: Verify error message displayed");
        registerPage.sleepInSecond(5);
        verifyEquals(registerPage.getValidationErrorMessage(), "Wrong email");

        log.info("Register - Step 14: Refresh Register Page");
        registerPage.refreshCurrentPage(driver);
    }

    @Story("Register with account exists")
    @Test
    private void TC_03_Register_Account_Exists() {
        log.info("Register - Step 01: Click to Gender radio button with value: Male");
        registerPage.clickToRadioButtonByID(driver, "gender-male");

        log.info("Register - Step 02: Input to FirstName text box with value: " + userData.getFirstNameValid());
        registerPage.inputToTextBoxByID(driver, "FirstName", userData.getFirstNameValid());

        log.info("Register - Step 03: Input to LastName text box with value: " + userData.getLastNameValid());
        registerPage.inputToTextBoxByID(driver, "LastName", userData.getLastNameValid());

        log.info("Register - Step 04: Select Day Dropdown with value: " + userData.getDateOfBirthValid());
        registerPage.selectDropdownByName(driver, "DateOfBirthDay", userData.getDateOfBirthValid());

        log.info("Register - Step 05: Select Month Dropdown with value: " + userData.getMonthOfBirthValid());
        registerPage.selectDropdownByName(driver, "DateOfBirthMonth", userData.getMonthOfBirthValid());

        log.info("Register - Step 06: Select Year Dropdown with value: " + userData.getYearOfYearValid());
        registerPage.selectDropdownByName(driver, "DateOfBirthYear", userData.getYearOfYearValid());

        String email = userData.getEmailAddressValid() + randomNumber + "@edu.vn.com";
        log.info("Register - Step 07: Input to Email text box with value: " + email);
        registerPage.inputToTextBoxByID(driver, "Email", email);

        log.info("Register - Step 08: Input to Company text box with value: " + userData.getCompanyNameValid());
        registerPage.inputToTextBoxByID(driver, "Company", userData.getCompanyNameValid());

        log.info("Register - Step 10: Input to Password text box with value: " + userData.getPasswordValid());
        registerPage.inputToTextBoxByID(driver, "Password", userData.getPasswordValid());

        log.info("Register - Step 11: Input to Confirm Password text box with value: " + userData.getConfirmPasswordValid());
        registerPage.inputToTextBoxByID(driver, "ConfirmPassword", userData.getConfirmPasswordValid());

        log.info("Register - Step 12: Click to Register button at Register Page");
        registerPage.clickToRegisterButton();

        log.info("Register - Step 13: Verify register successfully");
        verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

        log.info("Register - Step 14: Click to Logout link");
        homePage = registerPage.clickToLogoutLink(driver);

        log.info("Validate - Step 15: Click to Register link at Home Page");
        registerPage = homePage.clickToRegisterLink();

        log.info("Register - Step 16: Click to Gender radio button with value: Male");
        registerPage.clickToRadioButtonByID(driver, "gender-male");

        log.info("Register - Step 17: Input to FirstName text box with value: " + userData.getFirstNameValid());
        registerPage.inputToTextBoxByID(driver, "FirstName", userData.getFirstNameValid());

        log.info("Register - Step 18: Input to LastName text box with value: " + userData.getLastNameValid());
        registerPage.inputToTextBoxByID(driver, "LastName", userData.getLastNameValid());

        log.info("Register - Step 19: Select Day Dropdown with value: " + userData.getDateOfBirthValid());
        registerPage.selectDropdownByName(driver, "DateOfBirthDay", userData.getDateOfBirthValid());

        log.info("Register - Step 20: Select Month Dropdown with value: " + userData.getMonthOfBirthValid());
        registerPage.selectDropdownByName(driver, "DateOfBirthMonth", userData.getMonthOfBirthValid());

        log.info("Register - Step 21: Select Year Dropdown with value: " + userData.getYearOfYearValid());
        registerPage.selectDropdownByName(driver, "DateOfBirthYear", userData.getYearOfYearValid());

        log.info("Register - Step 22: Input to Email text box with value: " + email);
        registerPage.inputToTextBoxByID(driver, "Email", email);

        log.info("Register - Step 23: Input to Company text box with value: " + userData.getCompanyNameValid());
        registerPage.inputToTextBoxByID(driver, "Company", userData.getCompanyNameValid());

        log.info("Register - Step 24: Input to Password text box with value: " + userData.getPasswordValid());
        registerPage.inputToTextBoxByID(driver, "Password", userData.getPasswordValid());

        log.info("Register - Step 25: Input to Confirm Password text box with value: " + userData.getConfirmPasswordValid());
        registerPage.inputToTextBoxByID(driver, "ConfirmPassword", userData.getConfirmPasswordValid());

        log.info("Register - Step 26: Click to Register button at Register Page");
        registerPage.clickToRegisterButton();

        log.info("Register - Step 27: Verify Email already exists message");
        verifyEquals(registerPage.getEmailExistsErrorMessage(), "The specified email already exists");

        log.info("Register - Step 28: Click to Register link");
        registerPage.clickToRegisterLink(driver);
    }

    @Story("Register with password less 6 characters")
    @Test
    private void TC_04_Register_Password_Less_6_Characters() {
        log.info("Register - Step 01: Click to Gender radio button with value: Male");
        registerPage.clickToRadioButtonByID(driver, "gender-male");

        log.info("Register - Step 02: Input to FirstName textbox with value: " + userData.getFirstNameValid());
        registerPage.inputToTextBoxByID(driver, "FirstName", userData.getFirstNameValid());

        log.info("Register - Step 03: Input to LastName textbox with value: " + userData.getLastNameValid());
        registerPage.inputToTextBoxByID(driver, "LastName", userData.getLastNameValid());

        log.info("Register - Step 04: Select Day Dropdown with value: " + userData.getDateOfBirthValid());
        registerPage.selectDropdownByName(driver, "DateOfBirthDay", userData.getDateOfBirthValid());

        log.info("Register - Step 05: Select Month Dropdown with value: " + userData.getMonthOfBirthValid());
        registerPage.selectDropdownByName(driver, "DateOfBirthMonth", userData.getMonthOfBirthValid());

        log.info("Register - Step 06: Select Year Dropdown with value: " + userData.getYearOfYearValid());
        registerPage.selectDropdownByName(driver, "DateOfBirthYear", userData.getYearOfYearValid());

        log.info("Register - Step 07: Input to Email textbox with value: " + userData.getEmailAddressValid() + randomNumber + "@edu.vn.com");
        registerPage.inputToTextBoxByID(driver, "Email", userData.getEmailAddressValid() + randomNumber + "@edu.vn.com");

        log.info("Register - Step 08: Input to Company textbox with value: " + userData.getCompanyNameValid());
        registerPage.inputToTextBoxByID(driver, "Company", userData.getCompanyNameValid());

        log.info("Register - Step 10: Input to Password textbox with value: " + userData.getPasswordInvalid());
        registerPage.inputToTextBoxByID(driver, "Password", userData.getPasswordInvalid());

        log.info("Register - Step 11: Click to Register button at Register Page");
        registerPage.clickToRegisterButton();

        log.info("Register - Step 12: Verify error messsage displayed");
        verifyEquals(registerPage.getValidationPasswordMessage(), "Password must meet the following rules: must have at least 6 characters");

        log.info("Register - Step 13: Refresh Register Page");
        registerPage.refreshCurrentPage(driver);
    }

    @Story("Register password not match")
    @Test
    private void TC_05_Register_Password_Not_Match() {
        log.info("Register - Step 01: Click to Gender radio button with value: Male");
        registerPage.clickToRadioButtonByID(driver, "gender-male");

        log.info("Register - Step 02: Input to FirstName textbox with value: " + userData.getFirstNameValid());
        registerPage.inputToTextBoxByID(driver, "FirstName", userData.getFirstNameValid());

        log.info("Register - Step 03: Input to LastName textbox with value: " + userData.getLastNameValid());
        registerPage.inputToTextBoxByID(driver, "LastName", userData.getLastNameValid());

        log.info("Register - Step 04: Select Day Dropdown with value: " + userData.getDateOfBirthValid());
        registerPage.selectDropdownByName(driver, "DateOfBirthDay", userData.getDateOfBirthValid());

        log.info("Register - Step 05: Select Month Dropdown with value: " + userData.getMonthOfBirthValid());
        registerPage.selectDropdownByName(driver, "DateOfBirthMonth", userData.getMonthOfBirthValid());

        log.info("Register - Step 06: Select Year Dropdown with value: " + userData.getYearOfYearValid());
        registerPage.selectDropdownByName(driver, "DateOfBirthYear", userData.getYearOfYearValid());

        log.info("Register - Step 07: Input to Email textbox with value: " + userData.getEmailAddressValid() + randomNumber + "@edu.vn.com");
        registerPage.inputToTextBoxByID(driver, "Email", userData.getEmailAddressValid() + randomNumber + "@edu.vn.com");

        log.info("Register - Step 08: Input to Company textbox with value: " + userData.getCompanyNameValid());
        registerPage.inputToTextBoxByID(driver, "Company", userData.getCompanyNameValid());

        log.info("Register - Step 10: Input to Password textbox with value: " + userData.getPasswordValid());
        registerPage.inputToTextBoxByID(driver, "Password", userData.getPasswordValid());

        log.info("Register - Step 11: Input to Confirm Password textbox with value: " + userData.getConfirmPasswordInvalid());
        registerPage.inputToTextBoxByID(driver, "ConfirmPassword", userData.getConfirmPasswordInvalid());

        log.info("Register - Step 12: Click to Register button at Register Page");
        registerPage.clickToRegisterButton();

        log.info("Register - Step 13: Verify error messsage displayed");
        verifyEquals(registerPage.getValidationErrorMessage(), "The password and confirmation password do not match.");

        registerPage.sleepInSecond(5);
        log.info("Register - Step 14: Refresh Register Page");
        registerPage.refreshCurrentPage(driver);
    }

    @Story("Register valid data")
    @Test
    private void TC_06_Register_Valid_Data() {
        log.info("Register - Step 01: Click to Gender radio button with value: Male");
        registerPage.clickToRadioButtonByID(driver, "gender-male");

        log.info("Register - Step 02: Input to FirstName textbox with value: " + userData.getFirstNameValid());
        registerPage.inputToTextBoxByID(driver, "FirstName", userData.getFirstNameValid());

        log.info("Register - Step 03: Input to LastName textbox with value: " + userData.getLastNameValid());
        registerPage.inputToTextBoxByID(driver, "LastName", userData.getLastNameValid());

        log.info("Register - Step 04: Select Day Dropdown with value: " + userData.getDateOfBirthValid());
        registerPage.selectDropdownByName(driver, "DateOfBirthDay", userData.getDateOfBirthValid());

        log.info("Register - Step 05: Select Month Dropdown with value: " + userData.getMonthOfBirthValid());
        registerPage.selectDropdownByName(driver, "DateOfBirthMonth", userData.getMonthOfBirthValid());

        log.info("Register - Step 06: Select Year Dropdown with value: " + userData.getYearOfYearValid());
        registerPage.selectDropdownByName(driver, "DateOfBirthYear", userData.getYearOfYearValid());

        log.info("Register - Step 07: Input to Email textbox with value: " + userData.getEmailAddressValid() + randomNumber+1 + "@edu.vn.com");
        registerPage.inputToTextBoxByID(driver, "Email", userData.getEmailAddressValid() + randomNumber+1 + "@edu.vn.com");

        log.info("Register - Step 08: Input to Company textbox with value: " + userData.getCompanyNameValid());
        registerPage.inputToTextBoxByID(driver, "Company", userData.getCompanyNameValid());

        log.info("Register - Step 10: Input to Password textbox with value: " + userData.getPasswordValid());
        registerPage.inputToTextBoxByID(driver, "Password", userData.getPasswordValid());

        log.info("Register - Step 11: Input to Confirm Password textbox with value: " + userData.getConfirmPasswordValid());
        registerPage.inputToTextBoxByID(driver, "ConfirmPassword", userData.getConfirmPasswordValid());

        log.info("Register - Step 12: Click to Register button at Register Page");
        registerPage.clickToRegisterButton();

        registerPage.sleepInSecond(5);
        log.info("Register - Step 13: Verify register successfully");
        verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
    }

    @AfterClass
    private void afterClass() {
        closeBrowserAndDriver(driver);
    }


}
