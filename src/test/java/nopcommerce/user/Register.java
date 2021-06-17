package nopcommerce.user;


import commons.AbstractTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.User.HomePagePO;
import pageObjects.User.RegisterPO;
import testdata.UserData;

import java.io.File;

public class Register extends AbstractTest {
    WebDriver driver;
    int randomNumber = getRandomNumber();
    UserData userData;
    HomePagePO homePage;
    RegisterPO registerPage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String urlValue) {
        driver = getBrowser(browserName, urlValue);
        userData = UserData.getFiles(GlobalConstants.ROOT_FOLDER + File.separator + "src/test/java/testdata"+ File.separator + "testdata" + File.separator + "UserData.json");
    }

    @Test
    public void TC_01_Register_Empty_Data() {
        log.info("Validate - Step 01: Open Home Page");
        homePage = PageGeneratorManager.getHomePageUser(driver);

        log.info("Validate - Step 02: Click to Register link at Home Page");
        registerPage = homePage.clickToRegisterLink();

        log.info("Register - Step 03: Click to Register button at Register Page");
        registerPage.clickToRegisterButton();

        log.info("Register - Step 04: Verify error message displayed at FirstName textbox");
        verifyTrue(registerPage.isMandantoryFieldErrorDisplayed("FirstName"));

        log.info("Register - Step 05: Verify error message displayed at LastName textbox");
        verifyTrue(registerPage.isMandantoryFieldErrorDisplayed("LastName"));

        log.info("Register - Step 06: Verify error message displayed at Email textbox");
        verifyTrue(registerPage.isMandantoryFieldErrorDisplayed("Email"));

        log.info("Register - Step 07: Verify error message displayed at Password textbox");
        verifyTrue(registerPage.isMandantoryFieldErrorDisplayed("Password"));

        log.info("Register - Step 08: Verify error message displayed at ConfirmPassword textbox");
        verifyTrue(registerPage.isMandantoryFieldErrorDisplayed("ConfirmPassword"));

        log.info("Register - Step 09: Refresh Register Page");
        registerPage.refreshCurrentPage(driver);
    }


    @Test
    public void TC_02_Register_Invalid_Email() {
        log.info("Register - Step 01: Click to Gender radio button with value: Male");
        registerPage.clickToRadioButtonByID(driver, "gender-male");

        log.info("Register - Step 02: Input to FirstName textbox with value: " + userData.getFirstName());
        registerPage.inputToTextboxByID(driver, "FirstName", userData.getFirstName());

        log.info("Register - Step 03: Input to LastName textbox with value: " + userData.getLastName());
        registerPage.inputToTextboxByID(driver, "LastName", userData.getLastName());

        log.info("Register - Step 04: Select Day Dropdown with value: " + userData.getDateOfBirth());
        registerPage.selectDropdownByName(driver, "DateOfBirthDay", userData.getDateOfBirth());

        log.info("Register - Step 05: Select Month Dropdown with value: " + userData.getMonthOfBirth());
        registerPage.selectDropdownByName(driver, "DateOfBirthMonth", userData.getMonthOfBirth());

        log.info("Register - Step 06: Select Year Dropdown with value: " + userData.getYearOfYear());
        registerPage.selectDropdownByName(driver, "DateOfBirthYear", userData.getYearOfYear());

        log.info("Register - Step 07: Input to Email textbox with value: " + userData.getEmailAddress() + randomNumber + "@edu.vn.com");
        registerPage.inputToTextboxByID(driver, "Email", userData.getEmailAddress() + randomNumber + "@edu.vn.com");

        log.info("Register - Step 08: Input to Company textbox ");
        registerPage.inputToTextboxByID(driver, "Company", userData.getCompanyName());

        log.info("Register - Step 10: Input to Password textbox with value: " + userData.getPassword());
        registerPage.inputToTextboxByID(driver, "Password", userData.getPassword());

        log.info("Register - Step 11: Input to Confirm Password textbox with value: " + userData.getPassword());
        registerPage.inputToTextboxByID(driver, "ConfirmPassword", userData.getPassword());

        log.info("Register - Step 12: Click to Register button at Register Page");
        registerPage.clickToRegisterButton();

        log.info("Register - Step 13: Verify error messsage displayed");
        verifyEquals(registerPage.getValidationErrorMessage(), "Wrong email");

        log.info("Register - Step 14: Refresh Register Page");
        registerPage.refreshCurrentPage(driver);
    }

    @Test
    public void TC_03_Register_Account_Exists() {
        log.info("Register - Step 01: Click to Gender radio button with value: Male");
        registerPage.clickToRadioButtonByID(driver, "gender-male");

        log.info("Register - Step 02: Input to FirstName textbox with value: " + userData.getFirstName());
        registerPage.inputToTextboxByID(driver, "FirstName", userData.getFirstName());

        log.info("Register - Step 03: Input to LastName textbox with value: " + userData.getLastName());
        registerPage.inputToTextboxByID(driver, "LastName", userData.getLastName());

        log.info("Register - Step 04: Select Day Dropdown with value: " + userData.getDateOfBirth());
        registerPage.selectDropdownByName(driver, "DateOfBirthDay", userData.getDateOfBirth());

        log.info("Register - Step 05: Select Month Dropdown with value: " + userData.getMonthOfBirth());
        registerPage.selectDropdownByName(driver, "DateOfBirthMonth", userData.getMonthOfBirth());

        log.info("Register - Step 06: Select Year Dropdown with value: " + userData.getYearOfYear());
        registerPage.selectDropdownByName(driver, "DateOfBirthYear", userData.getYearOfYear());

        log.info("Register - Step 07: Input to Email textbox with value: " + userData.getEmailAddress() + randomNumber + "@edu.vn.com");
        registerPage.inputToTextboxByID(driver, "Email", userData.getEmailAddress() + randomNumber + "@edu.vn.com");

        log.info("Register - Step 08: Input to Company textbox ");
        registerPage.inputToTextboxByID(driver, "Company", userData.getCompanyName());

        log.info("Register - Step 10: Input to Password textbox with value: " + userData.getPassword());
        registerPage.inputToTextboxByID(driver, "Password", userData.getPassword());

        log.info("Register - Step 11: Input to Confirm Password textbox with value: " + userData.getPassword());
        registerPage.inputToTextboxByID(driver, "ConfirmPassword", userData.getPassword());

        log.info("Register - Step 12: Click to Register button at Register Page");
        registerPage.clickToRegisterButton();

        log.info("Register - Step 13: Verify error messsage displayed");
        verifyEquals(registerPage.getValidationErrorMessage(), "The specified email already exists");

        log.info("Register - Step 14: Refresh Register Page");
        registerPage.refreshCurrentPage(driver);

    }

    @Test
    public void TC_04_Register_Password_Less_6_Characters() {
        log.info("Register - Step 01: Click to Gender radio button with value: Male");
        registerPage.clickToRadioButtonByID(driver, "gender-male");

        log.info("Register - Step 02: Input to FirstName textbox with value: " + userData.getFirstName());
        registerPage.inputToTextboxByID(driver, "FirstName", userData.getFirstName());

        log.info("Register - Step 03: Input to LastName textbox with value: " + userData.getLastName());
        registerPage.inputToTextboxByID(driver, "LastName", userData.getLastName());

        log.info("Register - Step 04: Select Day Dropdown with value: " + userData.getDateOfBirth());
        registerPage.selectDropdownByName(driver, "DateOfBirthDay", userData.getDateOfBirth());

        log.info("Register - Step 05: Select Month Dropdown with value: " + userData.getMonthOfBirth());
        registerPage.selectDropdownByName(driver, "DateOfBirthMonth", userData.getMonthOfBirth());

        log.info("Register - Step 06: Select Year Dropdown with value: " + userData.getYearOfYear());
        registerPage.selectDropdownByName(driver, "DateOfBirthYear", userData.getYearOfYear());

        log.info("Register - Step 07: Input to Email textbox with value: " + userData.getEmailAddress() + randomNumber + "@edu.vn.com");
        registerPage.inputToTextboxByID(driver, "Email", userData.getEmailAddress() + randomNumber + "@edu.vn.com");

        log.info("Register - Step 08: Input to Company textbox ");
        registerPage.inputToTextboxByID(driver, "Company", userData.getCompanyName());

        log.info("Register - Step 10: Input to Password textbox with value: " + userData.getPassword());
        registerPage.inputToTextboxByID(driver, "Password", userData.getPassword());

        log.info("Register - Step 11: Input to Confirm Password textbox with value: " + userData.getPassword());
        registerPage.inputToTextboxByID(driver, "ConfirmPassword", userData.getPassword());

        log.info("Register - Step 12: Click to Register button at Register Page");
        registerPage.clickToRegisterButton();

        log.info("Register - Step 13: Verify error messsage displayed");
        verifyEquals(registerPage.getValidationErrorMessage(), "Password must meet the following rules: must have at least 6 characters");

        log.info("Register - Step 14: Refresh Register Page");
        registerPage.refreshCurrentPage(driver);


        /*********** Chỗ này chưa xử lí được xpath nè *************/
//        Assert.assertEquals(registerPage.getElementText(driver, UserRegisterPageUI.ACCOUNT_EXISTS_ERROR),
//                "Password must meet the following rules: must have at least 6 characters");
//        registerPage.clickToRegisterLink(driver);

    }

    @Test
    public void TC_05_Register_Password_Not_Match() {
        log.info("Register - Step 01: Click to Gender radio button with value: Male");
        registerPage.clickToRadioButtonByID(driver, "gender-male");

        log.info("Register - Step 02: Input to FirstName textbox with value: " + userData.getFirstName());
        registerPage.inputToTextboxByID(driver, "FirstName", userData.getFirstName());

        log.info("Register - Step 03: Input to LastName textbox with value: " + userData.getLastName());
        registerPage.inputToTextboxByID(driver, "LastName", userData.getLastName());

        log.info("Register - Step 04: Select Day Dropdown with value: " + userData.getDateOfBirth());
        registerPage.selectDropdownByName(driver, "DateOfBirthDay", userData.getDateOfBirth());

        log.info("Register - Step 05: Select Month Dropdown with value: " + userData.getMonthOfBirth());
        registerPage.selectDropdownByName(driver, "DateOfBirthMonth", userData.getMonthOfBirth());

        log.info("Register - Step 06: Select Year Dropdown with value: " + userData.getYearOfYear());
        registerPage.selectDropdownByName(driver, "DateOfBirthYear", userData.getYearOfYear());

        log.info("Register - Step 07: Input to Email textbox with value: " + userData.getEmailAddress() + randomNumber + "@edu.vn.com");
        registerPage.inputToTextboxByID(driver, "Email", userData.getEmailAddress() + randomNumber + "@edu.vn.com");

        log.info("Register - Step 08: Input to Company textbox ");
        registerPage.inputToTextboxByID(driver, "Company", userData.getCompanyName());

        log.info("Register - Step 10: Input to Password textbox with value: " + userData.getPassword());
        registerPage.inputToTextboxByID(driver, "Password", userData.getPassword());

        log.info("Register - Step 11: Input to Confirm Password textbox with value: " + userData.getPassword());
        registerPage.inputToTextboxByID(driver, "ConfirmPassword", userData.getPassword());

        log.info("Register - Step 12: Click to Register button at Register Page");
        registerPage.clickToRegisterButton();

        log.info("Register - Step 13: Verify error messsage displayed");
        verifyEquals(registerPage.getValidationErrorMessage(), "The password and confirmation password do not match.");

        log.info("Register - Step 14: Refresh Register Page");
        registerPage.refreshCurrentPage(driver);
    }

    @Test
    public void TC_06_Register_Valid_Data() {
        log.info("Register - Step 01: Click to Gender radio button with value: Male");
        registerPage.clickToRadioButtonByID(driver, "gender-male");

        log.info("Register - Step 02: Input to FirstName textbox with value: " + userData.getFirstName());
        registerPage.inputToTextboxByID(driver, "FirstName", userData.getFirstName());

        log.info("Register - Step 03: Input to LastName textbox with value: " + userData.getLastName());
        registerPage.inputToTextboxByID(driver, "LastName", userData.getLastName());

        log.info("Register - Step 04: Select Day Dropdown with value: " + userData.getDateOfBirth());
        registerPage.selectDropdownByName(driver, "DateOfBirthDay", userData.getDateOfBirth());

        log.info("Register - Step 05: Select Month Dropdown with value: " + userData.getMonthOfBirth());
        registerPage.selectDropdownByName(driver, "DateOfBirthMonth", userData.getMonthOfBirth());

        log.info("Register - Step 06: Select Year Dropdown with value: " + userData.getYearOfYear());
        registerPage.selectDropdownByName(driver, "DateOfBirthYear", userData.getYearOfYear());

        log.info("Register - Step 07: Input to Email textbox with value: " + userData.getEmailAddress() + randomNumber + "@edu.vn.com");
        registerPage.inputToTextboxByID(driver, "Email", userData.getEmailAddress() + randomNumber + "@edu.vn.com");

        log.info("Register - Step 08: Input to Company textbox ");
        registerPage.inputToTextboxByID(driver, "Company", userData.getCompanyName());

        log.info("Register - Step 10: Input to Password textbox with value: " + userData.getPassword());
        registerPage.inputToTextboxByID(driver, "Password", userData.getPassword());

        log.info("Register - Step 11: Input to Confirm Password textbox with value: " + userData.getPassword());
        registerPage.inputToTextboxByID(driver, "ConfirmPassword", userData.getPassword());

        log.info("Register - Step 12: Click to Register button at Register Page");
        registerPage.clickToRegisterButton();

        log.info("Register - Step 13: Verify register successfully");
        verifyEquals(registerPage.getValidationErrorMessage(), "Your registration completed");
    }

    @AfterClass
    public void afterClass() {
    }


}
