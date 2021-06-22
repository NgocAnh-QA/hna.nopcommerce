package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;

public class Chrome implements BrowserSetup {
    private String projectFolder = System.getProperty("user.dir");
    private WebDriver driver;

    public Chrome(WebDriver driver) {
        this.driver = driver;
    }


    @Override
    public void check() {
      //  WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOpt = new ChromeOptions();
        // Disable log
        System.setProperty("webdriver.chrome.args", "--disable-logging");
        System.setProperty("webdriver.chrome.silentOutput", "true");

        // Add extension
//			File file = new File(projectFolder + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "browserExtensions" + File.separator + "extension_2_0_9_0.crx");
//			ChromeOptions chromeOptions = new ChromeOptions();
//			chromeOptions.addExtensions(file);

        // Automation infor bar
//			chromeOptions.setExperimentalOption("useAutomationExtension", false);
//			chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
//
//			// disable developer mode
//			chromeOptions.addArguments("--disable-infobars");
//
//			// disable notification popup
//			chromeOptions.addArguments("--disable-notifications");
//
//			// disabel location popup
//			chromeOptions.addArguments("--disable-geolocation");
//
//			// language = vietnamese
//			chromeOptions.addArguments("--lang=vi");

        // auto sav/download
//			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
//			chromePrefs.put("profile.default_content_settings_popups", 0);
//			chromePrefs.put("download.default_directory", projectFolder + File.separator + "src" + File.separator + "main" + File.separator + "resources"  + File.separator + "downloadFiles");
//			chromeOptions.setExperimentalOption("prefs", chromePrefs);
//
        driver = new ChromeDriver(chromeOpt);
    }
//    private WebDriver driver;
//    private ChromeOptions chromeOptions;
//
//    public Chrome() {
//        chromeOptions = new ChromeOptions();
//    }
//
//    public ChromeOptions getChromeOptions() {
//        return chromeOptions;
//    }
//
//    @Override
//    public void logBrowserDisabled() {
//        System.setProperty("webdriver.chrome.args", "--disable-logging");
//        System.setProperty("webdriver.chrome.silentOutput", "true");
//    }
//
//    @Override
//    public void addExtension() {
//        File file = new File(projectFolder + File.separator + "src/main/resources/browserExtensions" + File.separator + "extension_2_0_9_0.crx");
//        chromeOptions.addExtensions(file);
//    }
//
//    @Override
//    public void languageBrowser() {
//        chromeOptions.addArguments("--lang=vi");
//    }
//
//    @Override
//    public void autoSaveAndDownload() {
//        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
//        chromePrefs.put("profile.default_content_settings_popups", 0);
//        chromePrefs.put("download.default_directory", projectFolder + File.separator + "src/main/resources" + File.separator + "downloadFiles");
//        chromeOptions.setExperimentalOption("prefs", chromePrefs);
//    }
//
//    @Override
//    public void inforBarDisabled() {
//        chromeOptions.setExperimentalOption("useAutomationExtension", false);
//        chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
//    }
//
//    @Override
//    public void notificationPopup() {
//        chromeOptions.addArguments("--disable-notifications");
//    }
//
//    @Override
//    public void developerModeDisabled() {
//        chromeOptions.addArguments("--disable-infobars");
//    }
//
//    @Override
//    public void locationPopupDisabled() {
//        chromeOptions.addArguments("--disable-geolocation");
//    }
//
//    @Override
//    public void setUpBrowserOptions() {
//        //driver = new ChromeDriver(chromeOptions);
//    }
}
