package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

public class Firefox implements BrowserSetup {
    @Override
    public void check() {

    }
//    private String projectFolder = System.getProperty("user.dir");
//    private WebDriver driver;
//    private FirefoxOptions firefoxOptions = new FirefoxOptions();
//
//    @Override
//    public void logBrowserDisabled() {
//        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
//        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, projectFolder + File.separator + "src/main/resources/browserLog" + File.separator + "FirefoxLog.txt");
//    }
//
//    @Override
//    public void addExtension() {
//        FirefoxProfile profile = new FirefoxProfile();
//        File translate = new File(projectFolder + File.separator + "src/main/resources/browserExtensions" + File.separator + "google_translate-4.1.0-fx.xpi");
//        profile.addExtension(translate);
//        firefoxOptions.setProfile(profile);
//    }
//
//    @Override
//    public void languageBrowser() {
//        firefoxOptions.addPreference("intl.accept_languages", "vi-vn, vi, en-us, en");
//    }
//
//    @Override
//    public void autoSaveAndDownload() {
//        firefoxOptions.addPreference("browser.download.folderList", 2);
//        firefoxOptions.addPreference("browser.download.dir", projectFolder + File.separator + "src/main/resources/downloadFiles");
//        firefoxOptions.addPreference("browser.download.useDownloadDir", true);
//        firefoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk", true);
//        firefoxOptions.addPreference("pdfjs.disabled", "multipart/x-zip, application/zip, application/x-zip-compressed," + " application/x-compressed, application/msword, application/csv, text/csv, " + "image/png, image/jpeg, application/pdf, text/html, " + "text/plain, application/excel, application/vnd.ms-excel, " + "application/x-excel, application/x-msexcel, application/octer-stream");
////        driver = new FirefoxDriver(firefoxOptions);
//    }
//
//    @Override
//    public void inforBarDisabled() {
//
//    }
//
//    @Override
//    public void notificationPopup() {
//
//    }
//
//    @Override
//    public void developerModeDisabled() {
//
//    }
//
//    @Override
//    public void locationPopupDisabled() {
//
//    }
//
//    @Override
//    public void setUpBrowserOptions() {
//
//    }
}
