package commons;

import pageObjects.User.*;
import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

    public static HomePagePO getHomePage(WebDriver driver) {
        return new HomePagePO(driver);
    }

    public static RegisterPO getRegisterPage(WebDriver driver) {
        return new RegisterPO(driver);
    }

    public static LoginPO getLoginPage(WebDriver driver) {
        return new LoginPO(driver);
    }

    public static CustomerInfoPO getCustomerInfoPage(WebDriver driver) {
        return new CustomerInfoPO(driver);
    }

    public static ChangePasswordPO getChangePassword(WebDriver driver) {
        return new ChangePasswordPO(driver);
    }


}
