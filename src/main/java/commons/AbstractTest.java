package commons;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractTest {
	private WebDriver driver;
	private String projectFolder = System.getProperty("user.dir");

	// Define Log variable
	protected final Log log;

	// Constructor
	public AbstractTest() {
		// Init log
		log = LogFactory.getLog(getClass());
	}

	public WebDriver getDriver() {
		return driver;
	}

//	protected WebDriver getBrowser(String browserName, String urlValue) {
//		BrowserName browser = BrowserName.valueOf(browserName.toUpperCase());
//
//		// Object browser = browserName.toUpperCase();
//
//		if (browser == BrowserName.FIREFOX) {
//			WebDriverManager.firefoxdriver().setup();
//
//			// Disable log
//			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
//			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, projectFolder + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "browserLog" + File.separator + "FirefoxLog.txt");
//
//			// Add extension
////			FirefoxProfile profile = new FirefoxProfile();
////			File translate = new File(projectFolder + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "browserExtensions" + File.separator + "google_translate-4.1.0-fx.xpi");
////			profile.addExtension(translate);
////			FirefoxOptions firefoxOptions = new FirefoxOptions();
////			firefoxOptions.setProfile(profile);
//
//			// language = vietnamese
//			//firefoxOptions.addPreference("intl.accept_languages", "vi-vn, vi, en-us, en");
//
//			// auto save/download
////			firefoxOptions.addPreference("browser.download.folderList", 2);
////			firefoxOptions.addPreference("browser.download.dir", projectFolder + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "downloadFiles");
////			firefoxOptions.addPreference("browser.download.useDownloadDir", true);
////			firefoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk", true);
////			firefoxOptions.addPreference("pdfjs.disabled", "multipart/x-zip, application/zip, application/x-zip-compressed," + " application/x-compressed, application/msword, application/csv, text/csv, " + "image/png, image/jpeg, application/pdf, text/html, " + "text/plain, application/excel, application/vnd.ms-excel, " + "application/x-excel, application/x-msexcel, application/octer-stream");
//
////			driver = new FirefoxDriver(firefoxOptions);
//
//		} else if (browser == BrowserName.CHROME) {
//			WebDriverManager.chromedriver().setup();
//
//			// Disable log
//			System.setProperty("webdriver.chrome.args", "--disable-logging");
//			System.setProperty("webdriver.chrome.silentOutput", "true");
//
//			// Add extension
////			File file = new File(projectFolder + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "browserExtensions" + File.separator + "extension_2_0_9_0.crx");
////			ChromeOptions chromeOptions = new ChromeOptions();
////			chromeOptions.addExtensions(file);
//
//			// Automation infor bar
////			chromeOptions.setExperimentalOption("useAutomationExtension", false);
////			chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
////
////			// disable developer mode
////			chromeOptions.addArguments("--disable-infobars");
////
////			// disable notification popup
////			chromeOptions.addArguments("--disable-notifications");
////
////			// disabel location popup
////			chromeOptions.addArguments("--disable-geolocation");
////
////			// language = vietnamese
////			chromeOptions.addArguments("--lang=vi");
//
//			// auto sav/download
////			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
////			chromePrefs.put("profile.default_content_settings_popups", 0);
////			chromePrefs.put("download.default_directory", projectFolder + File.separator + "src" + File.separator + "main" + File.separator + "resources"  + File.separator + "downloadFiles");
////			chromeOptions.setExperimentalOption("prefs", chromePrefs);
////
//			driver = new ChromeDriver();
//
//		} else if (browser == BrowserName.FIREFOX_HEADLESS) {
//			WebDriverManager.firefoxdriver().setup();
//			FirefoxOptions firefixOpt = new FirefoxOptions();
//			firefixOpt.setHeadless(true);
//			driver = new FirefoxDriver(firefixOpt);
//
//		} else if (browser == BrowserName.CHROME_HEADLESS) {
//			WebDriverManager.chromedriver().setup();
//			ChromeOptions chromeOpt = new ChromeOptions();
//			chromeOpt.addArguments("headless");
//			chromeOpt.addArguments("window-size=1920x1080");
//			driver = new ChromeDriver(chromeOpt);
//
//			// webdriver manager phải từ version 4.1.0 thì mới run đc chromium
//
//		} else if (browser == BrowserName.EDGE) {
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//		} else if (browser == BrowserName.IE) {
//			WebDriverManager.iedriver().arch32().setup();
//			driver = new InternetExplorerDriver();
//		} else {
//			throw new RuntimeException("Please input valid browser name");
//		}
//
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.get(urlValue);
//		return driver;
//	}

	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}

	protected void closeBrowserAndDriver(WebDriver driver) {
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String cmd = "";

			if (driver != null) {
				driver.quit();
			}

			// Quit driver executable file in Task Manager
			if (driver.toString().toLowerCase().contains("chrome")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill chromedriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				}
			} else if (driver.toString().toLowerCase().contains("internetexplorer")) {
				if (osName.toLowerCase().contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				}
			} else if (driver.toString().toLowerCase().contains("firefox")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill geckodriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				}
			} else if (driver.toString().toLowerCase().contains("edge")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill msedgedriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
				}
			}

			Process process = Runtime.getRuntime().exec(cmd);
			process.waitFor();

			log.info("---------- QUIT BROWSER SUCCESS ----------");
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	protected int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}


	protected WebDriver getBrowserDriver(String browserName, String environmentName) {
		if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if (browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else {
			throw new RuntimeException("Please input correct the browser name");
		}

		driver.get(environmentName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return driver;
	}
}
