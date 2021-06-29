package pageObjects.User;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.User.SearchPageUI;

public class SearchPO extends AbstractPage {
    WebDriver driver;

    public SearchPO(WebDriver driver) {
        this.driver = driver;
    }


    public void clickToClickSearchButton() {
        waitForElementVisible(driver, SearchPageUI.SEARCH_BUTTON);
        clickToElement(driver, SearchPageUI.SEARCH_BUTTON);

    }

    public String getTextEmptyDataMessage() {
        waitForElementVisible(driver, SearchPageUI.DATA_EMPTY_ERROR_MESSAGE);
        return getElementText(driver, SearchPageUI.DATA_EMPTY_ERROR_MESSAGE);
    }

    public void inputToSearchTextBox(String value) {
        waitForElementVisible(driver, SearchPageUI.SEARCH_TEXTBOX, value);
        sendKeyToElement(driver, SearchPageUI.SEARCH_TEXTBOX, value);
    }

    public String getTextDataNoExistMessage() {
        waitForElementVisible(driver, SearchPageUI.DATA_NO_EXIST_ERROR_MESSAGE);
        return getElementText(driver, SearchPageUI.DATA_NO_EXIST_ERROR_MESSAGE);
    }

    public boolean areProductsContainKeyword(String keyword) {
        return isResultContainsKeyword(driver, keyword, SearchPageUI.RESULT_SEARCH_PRODUCTS);
    }

    public boolean areProductsEqualKeyword(String keyword) {
        return isResultEqualsKeyword(driver, keyword, SearchPageUI.RESULT_SEARCH_PRODUCTS);
    }

    public void checkAdvancedSearch() {
        waitForElementVisible(driver, SearchPageUI.ADVANCED_SEACH_CHECKBOX);
        clickToElement(driver, SearchPageUI.ADVANCED_SEACH_CHECKBOX);

    }

    public void selectToCategoryDropdownByText(String textValue) {
        waitForElementVisible(driver, SearchPageUI.CATEGORY_DROPDOWN);
        selectItemByVisible(driver, textValue, SearchPageUI.CATEGORY_DROPDOWN);
    }

    public void clickToAutomaticallySearch() {
        waitForElementClickable(driver, SearchPageUI.AUTOMATICALLY_SEARCH_CHECKBOX);
        clickToElement(driver, SearchPageUI.AUTOMATICALLY_SEARCH_CHECKBOX);
    }

    public void selectToManufacturerDropdownByText(String textValue) {
        waitForElementVisible(driver, SearchPageUI.MANUFACTURER_DROPDOWN);
        selectItemByVisible(driver, textValue, SearchPageUI.MANUFACTURER_DROPDOWN);
    }
}
