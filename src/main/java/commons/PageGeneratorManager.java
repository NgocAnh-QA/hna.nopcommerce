package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.Admin.*;
import pageObjects.User.*;
public class PageGeneratorManager {

	// để static: truy cập trực tiếp thông qua tên class mà hong cần khởi tạo đối tượng
	
	public static UserLoginPO getUserLoginPage(WebDriver driver) {
		return new UserLoginPO(driver);
	}
	

}
