package pageObjects.Admin;

import commons.AbstractPage;
import commons.PageGeneratorManagerAdmin;
import org.openqa.selenium.WebDriver;
import pageUIs.Admin.LoginPageUI;

public class CustomersPO extends AbstractPage {
    WebDriver driver;

    public CustomersPO(WebDriver driver) {
        this.driver = driver;
    }

}
