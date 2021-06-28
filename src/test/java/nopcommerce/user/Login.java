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
import pageObjects.User.LoginPO;
import pageObjects.User.RegisterPO;
import testdata.UserData;

import java.io.File;


public class Login extends AbstractTest {
    private WebDriver driver;
    private int randomNumber = getRandomNumber();
    private UserData userData;
    private LoginPO loginPage;
    private HomePagePO homePage;
    private RegisterPO registerPage;
    RoleAccess roleAccess;
    private String email, password;

    @Parameters({"browser"})
    @BeforeClass
    private void beforeClass(String browserName) {
        String role = System.getProperty("role");
        ConfigFactory.setProperty("role", role);
        roleAccess = ConfigFactory.create(RoleAccess.class);
        driver = getBrowserDriver(browserName, roleAccess.url());
        userData = UserData.getFiles(GlobalConstants.ROOT_FOLDER + File.separator + "src/test/java" + File.separator + "testdata" + File.separator + "UserData.json");

        log.info("Login - Precondition - Step 01: Open Home Page");
        homePage = PageGeneratorManager.getHomePage(driver);

        log.info("Login - Precondition - Step 02: Click to Register link at Home Page");
        registerPage = homePage.clickToRegisterLink(driver);

        log.info("Login - Precondition - Step 03: Click to Gender radio button with value: Male");
        registerPage.clickToRadioButtonByID(driver, "gender-male");

        log.info("Login - Precondition - Step 04: Input to FirstName textbox with value: " + userData.getFirstNameValid());
        registerPage.inputToTextboxByID(driver, "FirstName", userData.getFirstNameValid());

        log.info("Login - Precondition - Step 05: Input to LastName textbox with value: " + userData.getLastNameValid());
        registerPage.inputToTextboxByID(driver, "LastName", userData.getLastNameValid());

        log.info("Login - Precondition - Step 06: Select Day Dropdown with value: " + userData.getDateOfBirthValid());
        registerPage.selectDropdownByName(driver, "DateOfBirthDay", userData.getDateOfBirthValid());

        log.info("Login - Precondition - Step 07: Select Month Dropdown with value: " + userData.getMonthOfBirthValid());
        registerPage.selectDropdownByName(driver, "DateOfBirthMonth", userData.getMonthOfBirthValid());

        log.info("Login - Precondition - Step 08: Select Year Dropdown with value: " + userData.getYearOfYearValid());
        registerPage.selectDropdownByName(driver, "DateOfBirthYear", userData.getYearOfYearValid());

        email = userData.getEmailAddressValid() + randomNumber + "@hotmail.com";
        log.info("Login - Precondition - Step 09: Input to Email textbox with value: " + email);
        registerPage.inputToTextboxByID(driver, "Email", email);

        log.info("Login - Precondition - Step 10: Input to Company textbox with value: " + userData.getCompanyNameValid());
        registerPage.inputToTextboxByID(driver, "Company", userData.getCompanyNameValid());

        password = userData.getPasswordValid();
        log.info("Login - Precondition - Step 11: Input to Password textbox with value: " + password);
        registerPage.inputToTextboxByID(driver, "Password", password);

        log.info("Login - Precondition - Step 12: Input to Confirm Password textbox with value: " + userData.getConfirmPasswordValid());
        registerPage.inputToTextboxByID(driver, "ConfirmPassword", userData.getConfirmPasswordValid());

        log.info("Login - Precondition - Step 13: Click to Register button at Register Page");
        registerPage.clickToRegisterButton();

        log.info("Login - Precondition - Step 14: Verify register successfully");
        verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

        log.info("Login - Precondition - Step 15: Click to Logout link");
        homePage = registerPage.clickToLogoutLink(driver);

        log.info("Login - Precondition - Step 16: Click to Login link at Home Page");
        loginPage = homePage.clickToLoginLink();
    }

    @Test
    public void TC_01_Login_Empty_Data() {
        log.info("Login - Step 01: Input to Email without data");
        loginPage.inputToEmailTextbox("");

        log.info("Login - Step 02: Input to Password without data");
        loginPage.inputToPasswordTextbox("");

        log.info("Login - Step 03: Click to Login button");
        loginPage.clickToLoginButton();

        log.info("Login - Step 04: Verify empty data login message is correctly displayed");
        verifyEquals(loginPage.getEmptyInvalidDataLoginMessage(), "Please enter your email");

        log.info("Login - Step 05: Refresh login page");
        loginPage.refreshCurrentPage(driver);
    }

    @Test
    public void TC_02_Login_Invalid_Email() {
        log.info("Login - Step 01: Input to Email with value: " + userData.getEmailAddressInvalid());
        loginPage.inputToEmailTextbox(userData.getEmailAddressInvalid());

        log.info("Login - Step 02: Click to Login button");
        loginPage.clickToLoginButton();

        log.info("Login - Step 03: Verify empty data login message is correctly displayed");
        verifyEquals(loginPage.getEmptyInvalidDataLoginMessage(), "Wrong email");

        log.info("Login - Step 04: Refresh login page");
        loginPage.refreshCurrentPage(driver);
    }

    @Test
    public void TC_03_Login_Unregister() {
        log.info("Login - Step 01: Input to Email with value: " + userData.getEmailAddressValid() + "@hotmail.com");
        loginPage.inputToEmailTextbox(userData.getEmailAddressValid() + "@hotmail.com");

        log.info("Login - Step 02: Input to Password with value: " + userData.getPasswordValid());
        loginPage.inputToPasswordTextbox(userData.getPasswordValid());

        log.info("Login - Step 03: Click to Login button");
        loginPage.clickToLoginButton();

        log.info("Login - Step 04: Verify error login message is correctly đisplayed");
        verifyEquals(loginPage.getAccountLoginMessage(), "Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");

        log.info("Login - Step 05: Refresh login page");
        loginPage.refreshCurrentPage(driver);
    }

    @Test
    public void TC_04_Registered_Login_Empty_Password() {
        log.info("Login - Step 01: Input to Email with value: " + email);
        loginPage.inputToEmailTextbox(email);

        log.info("Login - Step 02: Leave empty password");
        loginPage.inputToPasswordTextbox("");

        log.info("Login - Step 03: Click to login button");
        loginPage.clickToLoginButton();

        log.info("Login - Step 04: Verify error message is correctly displayed");
        verifyEquals(loginPage.getAccountLoginMessage(), "Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");

        log.info("Login - Step 05: Refresh login page");
        loginPage.refreshCurrentPage(driver);
    }

    @Test
    public void TC_05_Registered_Login_Incorrect_Password() {
        log.info("Login - Step 01: Input to Email with value: " + email);
        loginPage.inputToEmailTextbox(email);

        log.info("Login - Step 02: Input to password with value: " + userData.getConfirmPasswordInvalid());
        loginPage.inputToPasswordTextbox(userData.getConfirmPasswordInvalid());

        log.info("Login - Step 03: Click to Login button");
        loginPage.clickToLoginButton();

        log.info("Login - Step 04: Verify error message is correctly displayed");
        verifyEquals(loginPage.getAccountLoginMessage(), "Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");

        log.info("Login - Step 05: Refresh login page");
        loginPage.refreshCurrentPage(driver);
    }

    @Test
    public void TC_06_Registered_Login_Correct_Password() {
        log.info("Login - Step 01: Input to Email with value: " + email);
        loginPage.inputToEmailTextbox(email);

        log.info("Login - Step 02: Input to Password with value: " + password);
        loginPage.inputToPasswordTextbox(password);

        log.info("Login - Step 03: Click to Login button");
        homePage = loginPage.clickToLoginButton();

        log.info("Login - Step 04: Verify My Account link is displayed at the top");
        verifyTrue(homePage.isMyAccountLinkDisplayed());

    }

    @AfterClass
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }


}
