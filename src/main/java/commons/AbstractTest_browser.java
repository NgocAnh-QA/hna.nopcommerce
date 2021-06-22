package commons;

import browser.BrowserSetup;
import browser.Chrome;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AbstractTest_browser {
	WebDriver driver;
	private String projectFolder = System.getProperty("user.dir");

	public synchronized WebDriver getBrowser(String browserName, String urlValue) {
		BrowserSetup browser;
		if (browserName.equals("chrome")){
			WebDriverManager.chromedriver().setup();

			browser = new Chrome(driver);
			browser.check();
//			browser.inforBarDisabled();
//			browser.languageBrowser();
//			browser.setUpBrowserOptions();
//			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(urlValue);
		return driver;

	}
}
