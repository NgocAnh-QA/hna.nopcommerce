package pageObjects.User;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

public class LoginPO extends AbstractPage {
    WebDriver driver;
    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }
}
