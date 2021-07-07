package pageObjects.User;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.User.LoginPageUI;

public class OrderInformationPO extends AbstractPage {
    WebDriver driver;
    public OrderInformationPO(WebDriver driver) {
        this.driver = driver;
    }

}
