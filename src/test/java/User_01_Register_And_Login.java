import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;

public class User_01_Register_And_Login extends AbstractTest {
    WebDriver driver;
    String loginPageUrl, userID, password;

    @Parameters({"browser", "environment"})
    @BeforeClass
    public void beforeClass(String browserName, String envName) {

        driver = getBrowserDriver(browserName, envName);
    }

    @Test
    public void TC_01_Register() {
        loginPageUrl = driver.getCurrentUrl();

        driver.findElement(By.xpath("//a[text()='here']")).click();

        driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("automationfc@gmail.com");

        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        userID = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
        password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
    }

    @Test

    public void TC_02_Login() {
        driver.get(loginPageUrl);

        driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userID);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);

        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//marquee[@class='heading3']")).getText(), "Welcome To Manager's Page of GTPL Bank");
    }


    @AfterClass
    public void afterClass() {
        driver.close();
    }

}
