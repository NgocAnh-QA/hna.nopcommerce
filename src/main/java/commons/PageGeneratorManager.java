package commons;

import pageObjects.User.HomePagePO;
import org.openqa.selenium.WebDriver;
import pageObjects.User.RegisterPO;

public class PageGeneratorManager {

	// để static: truy cập trực tiếp thông qua tên class mà hong cần khởi tạo đối tượng
	
	public static HomePagePO getHomePageUser(WebDriver driver) {
		return new HomePagePO(driver);
	}

	public static RegisterPO getRegisterPage(WebDriver driver) {
		return new RegisterPO(driver);
	}
	

}
