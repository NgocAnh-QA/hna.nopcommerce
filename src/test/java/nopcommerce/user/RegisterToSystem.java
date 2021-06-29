package nopcommerce.user;

import commons.AbstractTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import commons.RoleAccess;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pageObjects.User.HomePagePO;
import pageObjects.User.RegisterPO;
import testdata.UserData;

import java.io.File;

public class RegisterToSystem extends AbstractTest {
    public static String EMAIL, PASSWORD;
    RoleAccess roleAccess;
    WebDriver driver;
    UserData userData;
    private HomePagePO homePage;
    private RegisterPO registerPage;
    private int randomNumber = getRandomNumber();
    @Parameters("browser")
    @BeforeTest
    public void beforeTest(String browserName) {
        String role = System.getProperty("role");
        ConfigFactory.setProperty("role", role);
        roleAccess = ConfigFactory.create(RoleAccess.class);
        driver = getBrowserDriver(browserName, roleAccess.url());

        userData = UserData.getFiles(GlobalConstants.ROOT_FOLDER + File.separator + "src/test/java" + File.separator + "testdata" + File.separator + "UserData.json");

        log.info("Register - Step 01: Open Home Page");
        homePage = PageGeneratorManager.getHomePage(driver);

        log.info("Register - Step 02: Click to Register link at Home Page");
        registerPage = homePage.clickToRegisterLink();

        log.info("Register - Step 03: Click to Gender radio button with value: Male");
        registerPage.clickToRadioButtonByID(driver, "gender-male");

        log.info("Register - Step 04: Input to FirstName textbox with value: " + userData.getFirstNameValid());
        registerPage.inputToTextboxByID(driver, "FirstName", userData.getFirstNameValid());

        log.info("Register - Step 05: Input to LastName textbox with value: " + userData.getLastNameValid());
        registerPage.inputToTextboxByID(driver, "LastName", userData.getLastNameValid());

        log.info("Register - Step 06: Select Day Dropdown with value: " + userData.getDateOfBirthValid());
        registerPage.selectDropdownByName(driver, "DateOfBirthDay", userData.getDateOfBirthValid());

        log.info("Register - Step 07: Select Month Dropdown with value: " + userData.getMonthOfBirthValid());
        registerPage.selectDropdownByName(driver, "DateOfBirthMonth", userData.getMonthOfBirthValid());

        log.info("Register - Step 08: Select Year Dropdown with value: " + userData.getYearOfYearValid());
        registerPage.selectDropdownByName(driver, "DateOfBirthYear", userData.getYearOfYearValid());

        EMAIL = userData.getEmailAddressValid() + randomNumber + "@edu.vn.com";
        log.info("Register - Step 09: Input to Email textbox with value: " + EMAIL);
        registerPage.inputToTextboxByID(driver, "Email", EMAIL);

        log.info("Register - Step 10: Input to Company textbox with value: " + userData.getCompanyNameValid());
        registerPage.inputToTextboxByID(driver, "Company", userData.getCompanyNameValid());

        PASSWORD = userData.getPasswordValid();
        log.info("Register - Step 11: Input to Password textbox with value: " + PASSWORD);
        registerPage.inputToTextboxByID(driver, "Password", PASSWORD);

        log.info("Register - Step 12: Input to Confirm Password textbox with value: " + userData.getConfirmPasswordValid());
        registerPage.inputToTextboxByID(driver, "ConfirmPassword", userData.getConfirmPasswordValid());

        log.info("Register - Step 13: Click to Register button at Register Page");
        registerPage.clickToRegisterButton();

        log.info("Register - Step 14: Verify register successfully");
        verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

        log.info("Register - Step 15: Quit browser");
        closeBrowserAndDriver(driver);
    }


}