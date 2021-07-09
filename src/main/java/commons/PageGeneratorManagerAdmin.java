package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.Admin.DashboardPO;
import pageObjects.Admin.LoginPO;
import pageObjects.Admin.ProductsPO;

public class PageGeneratorManagerAdmin {

    public static LoginPO getLoginPageAdmin(WebDriver driver) {
        return new LoginPO(driver);
    }

    public static DashboardPO getDashboardPage(WebDriver driver) {
        return new DashboardPO(driver);
    }

    public static ProductsPO getProductsPage(WebDriver driver) {
        return new ProductsPO(driver);
    }

}
