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
import pageObjects.User.LoginPO;
import testdata.UserData;

import java.io.File;

@Feature("Login Test")
public class Login extends AbstractTest {
    private WebDriver driver;
    private int randomNumber = getRandomNumber();
    private UserData userData;
    private LoginPO loginPage;
    private HomePagePO homePage;
    RoleAccess roleAccess;

    @Parameters({"browser"})
    @BeforeClass
    private void beforeClass(String browserName) {
        String role = System.getProperty("role");
        ConfigFactory.setProperty("role", role);
        roleAccess = ConfigFactory.create(RoleAccess.class);
        driver = getBrowserDriver(browserName, roleAccess.url());
        userData = UserData.getFiles(GlobalConstants.ROOT_FOLDER + File.separator + "src/test/java" + File.separator + "testdata" + File.separator + "UserData.json");

        log.info("Login - Precondition - Step 01: Open Home Page");
        homePage = PageGeneratorManagerUser.getHomePage(driver);
    }

    @Story("Login with empty data")
    @Test
    public void TC_01_Login_Empty_Data() {
        log.info("Login - Step 01: Click to Login link at Home Page");
        loginPage = homePage.clickToLoginLink();

        log.info("Login - Step 02: Input to Email without data");
        loginPage.inputToEmailTextBox("");

        log.info("Login - Step 03: Input to Password without data");
        loginPage.inputToPasswordTextBox("");

        log.info("Login - Step 04: Click to Login button");
        loginPage.clickToLoginButton();

        log.info("Login - Step 05: Verify empty data login message is correctly displayed");
        verifyEquals(loginPage.getEmptyInvalidDataLoginMessage(), "Please enter your email");

        log.info("Login - Step 06: Refresh login page");
        loginPage.refreshCurrentPage(driver);
    }

    @Story("Login with invalid email")
    @Test
    public void TC_02_Login_Invalid_Email() {
        log.info("Login - Step 01: Input to Email with value: " + userData.getEmailAddressInvalid());
        loginPage.inputToEmailTextBox(userData.getEmailAddressInvalid());

        log.info("Login - Step 02: Click to Login button");
        loginPage.clickToLoginButton();

        log.info("Login - Step 03: Verify empty data login message is correctly displayed");
        verifyEquals(loginPage.getEmptyInvalidDataLoginMessage(), "Wrong email");

        log.info("Login - Step 04: Refresh login page");
        loginPage.refreshCurrentPage(driver);
    }

    @Story("Login with unregistered account")
    @Test
    public void TC_03_Login_Unregister() {
        log.info("Login - Step 01: Input to Email with value: " + userData.getEmailAddressValid() + "@hotmail.com");
        loginPage.inputToEmailTextBox(userData.getEmailAddressValid() + "@hotmail.com");

        log.info("Login - Step 02: Input to Password with value: " + userData.getPasswordValid());
        loginPage.inputToPasswordTextBox(userData.getPasswordValid());

        log.info("Login - Step 03: Click to Login button");
        loginPage.clickToLoginButton();

        log.info("Login - Step 04: Verify error login message is correctly đisplayed");
        verifyEquals(loginPage.getAccountLoginMessage(), "Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");

        log.info("Login - Step 05: Refresh login page");
        loginPage.refreshCurrentPage(driver);
    }

    @Story("Login with registered account but leave empty password")
    @Test
    public void TC_04_Registered_Login_Empty_Password() {
        log.info("Login - Step 01: Input to Email with value: " + RegisterToSystem.EMAIL);
        loginPage.inputToEmailTextBox(RegisterToSystem.EMAIL);

        log.info("Login - Step 02: Leave empty password");
        loginPage.inputToPasswordTextBox("");

        log.info("Login - Step 03: Click to login button");
        loginPage.clickToLoginButton();

        log.info("Login - Step 04: Verify error message is correctly displayed");
        verifyEquals(loginPage.getAccountLoginMessage(), "Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");

        log.info("Login - Step 05: Refresh login page");
        loginPage.refreshCurrentPage(driver);
    }

    @Story("Login with registered account but incorrect password")
    @Test
    public void TC_05_Registered_Login_Incorrect_Password() {
        log.info("Login - Step 01: Input to Email with value: " + RegisterToSystem.EMAIL);
        loginPage.inputToEmailTextBox(RegisterToSystem.EMAIL);

        log.info("Login - Step 02: Input to password with value: " + userData.getConfirmPasswordInvalid());
        loginPage.inputToPasswordTextBox(userData.getConfirmPasswordInvalid());

        log.info("Login - Step 03: Click to Login button");
        loginPage.clickToLoginButton();

        log.info("Login - Step 04: Verify error message is correctly displayed");
        verifyEquals(loginPage.getAccountLoginMessage(), "Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");

        log.info("Login - Step 05: Refresh login page");
        loginPage.refreshCurrentPage(driver);
    }

    @Story("Login with registered account")
    @Test
    public void TC_06_Registered_Login_Correct_Password() {
        log.info("Login - Step 01: Input to Email with value: " + RegisterToSystem.EMAIL);
        loginPage.inputToEmailTextBox(RegisterToSystem.EMAIL);

        log.info("Login - Step 02: Input to Password with value: " + RegisterToSystem.PASSWORD);
        loginPage.inputToPasswordTextBox(RegisterToSystem.PASSWORD);

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
