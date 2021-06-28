package commons;

import pageObjects.User.HomePagePO;
import org.openqa.selenium.WebDriver;
import pageObjects.User.RegisterPO;

public class PageGeneratorManager {

	public static HomePagePO getHomePageUser(WebDriver driver) {
		return new HomePagePO(driver);
	}

	public static RegisterPO getRegisterPage(WebDriver driver) {
		return new RegisterPO(driver);
	}
	

}
