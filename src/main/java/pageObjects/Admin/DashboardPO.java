package pageObjects.Admin;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

public class DashboardPO extends AbstractPage {
    WebDriver driver;

    public DashboardPO(WebDriver driver) {
        this.driver = driver;
    }
}
