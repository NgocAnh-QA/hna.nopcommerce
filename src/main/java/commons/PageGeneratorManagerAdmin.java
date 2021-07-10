package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.Admin.*;

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

    public static ProductDetailPO getProductDetailPage(WebDriver driver) {
        return new ProductDetailPO(driver);
    }

    public static CustomersPO getCustomersPage(WebDriver driver) {
        return new CustomersPO(driver);
    }

    public static CustomerDetailPO getCustomerDetailPage(WebDriver driver) {
        return new CustomerDetailPO(driver);
    }

}
