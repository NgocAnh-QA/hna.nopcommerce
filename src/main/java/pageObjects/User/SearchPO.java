package pageObjects.User;

import commons.AbstractPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.User.SearchPageUI;

public class SearchPO extends AbstractPage {
    WebDriver driver;

    public SearchPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click to Click Search button")
    public void clickToClickSearchButton() {
        waitForElementVisible(driver, SearchPageUI.SEARCH_BUTTON);
        clickToElement(driver, SearchPageUI.SEARCH_BUTTON);

    }

    @Step("Get text empty data message")
    public String getTextEmptyDataMessage() {
        waitForElementVisible(driver, SearchPageUI.DATA_EMPTY_ERROR_MESSAGE);
        return getElementText(driver, SearchPageUI.DATA_EMPTY_ERROR_MESSAGE);
    }

    @Step("Input to search text box with value: {0}")
    public void inputToSearchTextBox(String value) {
        waitForElementVisible(driver, SearchPageUI.SEARCH_TEXTBOX, value);
        sendKeyToElement(driver, SearchPageUI.SEARCH_TEXTBOX, value);
    }

    @Step("Get text data no exist message")
    public String getTextDataNoExistMessage() {
        waitForElementVisible(driver, SearchPageUI.DATA_NO_EXIST_ERROR_MESSAGE);
        return getElementText(driver, SearchPageUI.DATA_NO_EXIST_ERROR_MESSAGE);
    }

    @Step("Verify products contain keyword: {0}")
    public boolean areProductsContainKeyword(String keyword) {
        return isResultContainsKeyword(driver, keyword, SearchPageUI.RESULT_SEARCH_PRODUCTS);
    }

    @Step("Verify products equal keyword: {0}")
    public boolean areProductsEqualKeyword(String keyword) {
        return isResultEqualsKeyword(driver, keyword, SearchPageUI.RESULT_SEARCH_PRODUCTS);
    }

    @Step("Check to Advance Search")
    public void checkAdvancedSearch() {
        waitForElementVisible(driver, SearchPageUI.ADVANCED_SEACH_CHECKBOX);
        clickToElement(driver, SearchPageUI.ADVANCED_SEACH_CHECKBOX);
    }

    @Step("Select to category dropdown with value: {0}")
    public void selectToCategoryDropdownByText(String textValue) {
        waitForElementVisible(driver, SearchPageUI.CATEGORY_DROPDOWN);
        selectItemByVisible(driver, textValue, SearchPageUI.CATEGORY_DROPDOWN);
    }

    @Step("Click to Automatically Search")
    public void clickToAutomaticallySearch() {
        waitForElementClickable(driver, SearchPageUI.AUTOMATICALLY_SEARCH_CHECKBOX);
        clickToElement(driver, SearchPageUI.AUTOMATICALLY_SEARCH_CHECKBOX);
    }

    @Step("Select to Manufacturer dropdown with value: {0}")
    public void selectToManufacturerDropdownByText(String textValue) {
        waitForElementVisible(driver, SearchPageUI.MANUFACTURER_DROPDOWN);
        selectItemByVisible(driver, textValue, SearchPageUI.MANUFACTURER_DROPDOWN);
    }
}
