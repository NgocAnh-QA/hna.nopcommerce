package nopcommerce.user;

import commons.AbstractTest_browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo1 extends AbstractTest_browser {
    private WebDriver driver;
    @Parameters({ "browser", "url" })
    @BeforeClass
    public void beforeClass(String browserName, String urlValue) {
        driver = getBrowser(browserName, urlValue);

    }

    @Test
    public void TC_01_Test() {
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
