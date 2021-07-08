package pageObjects.User;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.User.LoginPageUI;
import pageUIs.User.OrderHistoryPageUI;

public class OrderHistoryPO extends AbstractPage {
    WebDriver driver;
    public OrderHistoryPO(WebDriver driver) {
        this.driver = driver;
    }

    public String getOrderNumber() {
        waitForElementVisible(driver, OrderHistoryPageUI.ORDER_NUMBER_TEXT);
        String orderNumber = getElementText(driver, OrderHistoryPageUI.ORDER_NUMBER_TEXT);
        return orderNumber.substring(orderNumber.lastIndexOf(" ")+1);
    }

    public OrderInformationPO clickToDetailButton(String orderNumber) {
        waitForElementVisible(driver, OrderHistoryPageUI.DETAIL_BUTTON, orderNumber);
        clickToElement(driver, OrderHistoryPageUI.DETAIL_BUTTON, orderNumber);
        return PageGeneratorManager.getOrderInformationPage(driver);

    }
}
