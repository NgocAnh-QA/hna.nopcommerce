package commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import PageUIs.User.AbstractPageUI;
import PageUIs.User.RegisterPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.User.HomePagePO;

public class AbstractPage {
	WebDriverWait explicitWait;
	WebElement element;
	JavascriptExecutor jsExecutor;
	Actions action;
	Select select;

	public void openPageUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getCurrentPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void acceptAler(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAler(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getTextAler(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void setTextAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	// Windows
	public String getWindowID(WebDriver driver) {
		return driver.getWindowHandle();
	}

	public Set<String> getListWindowsID(WebDriver driver) {
		return driver.getWindowHandles();
	}

	public void switchWindowByID(WebDriver driver, String ID) {
		Set<String> IdWinDow = driver.getWindowHandles();
		for (String a : IdWinDow) {
			if (!a.equals(ID)) {
				driver.switchTo().window(a);
			}
		}
	}

	public void switchWindowByTitle(WebDriver driver, String expectedTitle) {
		Set<String> windows = driver.getWindowHandles();

		for (String a : windows) {
			driver.switchTo().window(a);

			if (driver.getTitle().equals(expectedTitle)) {
				break;
			}
		}
		sleepInSecond(4);
	}

	public void closeAllWindowsWithoutParent(WebDriver driver, String ID) {
		Set<String> IdWinDow = driver.getWindowHandles();
		for (String a : IdWinDow) {
			if (!a.equals(ID)) {
				driver.switchTo().window(a);
				sleepInSecond(2);
				driver.close();
			}
		}
	}

	// Element
	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpth(locator));
	}

	public WebElement getElement(WebDriver driver, String locator, String... values) {
		return driver.findElement(getByXpth(castToParameter(locator, values)));
	}

	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpth(locator));
	}

	public List<WebElement> getElements(WebDriver driver, String locator, String... values) {
		return driver.findElements(getByXpth(castToParameter(locator, values)));
	}

	public int getSizeElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpth(locator)).size();
	}

	public int getSizeElements(WebDriver driver, String locator, String... values) {
		return driver.findElements(getByXpth(castToParameter(locator, values))).size();
	}

	public By getByXpth(String locator) {
		return By.xpath(locator);
	}

	public void clickToElement(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		element.click();
	}

	public void clickToElement(WebDriver driver, String locator, String... values) {
		element = getElement(driver, castToParameter(locator, values));
		element.click();
	}

	public void sendKeyToElement(WebDriver driver, String locator, String value) {
		element = getElement(driver, locator);
		element.clear();
		element.sendKeys(value);
	}

	public void sendKeyToElement(WebDriver driver, String value, String locator, String... values) {
		element = getElement(driver, castToParameter(locator, values));
		element.clear();
		element.sendKeys(value);
	}

	public void clickToTextboxTypeNumber(WebDriver driver, String locator, String values) {
		element = getElement(driver, castToParameter(locator, values));
		for (int i = 0; i < Integer.parseInt(values); i++) {
			clickToElement(driver, locator);
		}
	}

	public void clearTextbox(WebDriver driver, String locator, String... values) {
		element = getElement(driver, castToParameter(locator, values));
		element.clear();
	}

	public void clearTextbox(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		element.clear();
	}

	public void selectItemByVisible(WebDriver driver, String textValue, String locator) {
		element = getElement(driver, locator);
		select = new Select(element);
		select.selectByVisibleText(textValue);
	}

	public void selectItemByVisible(WebDriver driver, String textValue, String locator, String... values) {
		element = getElement(driver, castToParameter(locator, values));
		select = new Select(element);
		select.selectByVisibleText(textValue);
	}

	public String getFirstSelectedTextInDropdown(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		select = new Select(element);
		return select.isMultiple();
	}

	public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
		element = getElement(driver, locator);
		return element.getAttribute(attributeName);
	}

	public String getElementText(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		return element.getText();
	}

	public String getElementText(WebDriver driver, String locator, String... values) {
		element = getElement(driver, castToParameter(locator, values));
		return element.getText();
	}

	public int countElementSize(WebDriver driver, String locator) {
		return getElements(driver, locator).size();
	}

	public void checkToCheckBox(WebDriver driver, String locator, String... values) {
		element = getElement(driver, castToParameter(locator, values));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void checkToCheckBox(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void unCheckToCheckBox(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		if (element.isSelected()) {
			element.click();
		}
	}

	// Undisplay
	public boolean isElementUnDisplayed(WebDriver driver, String locator) {
		overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
		List<WebElement> elements = getElements(driver, locator);
		overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isElementUnDisplayed(WebDriver driver, String locator, String... values) {
		overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
		List<WebElement> elements = getElements(driver, locator, values);
		overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		boolean status = true;
		try {
			if (getElement(driver, locator).isDisplayed()) {
				return status;
			}
		} catch (Exception e) {
			status = false;
		}
		return status;

	}

	public boolean isElementDisplayed(WebDriver driver, String locator, String... values) {
		return getElement(driver, castToParameter(locator, values)).isDisplayed();
	}

	public boolean isElementEnabled(WebDriver driver, String locator) {
		return getElement(driver, locator).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected();
	}

	public boolean isElementSelected(WebDriver driver, String locator, String... values) {
		return getElement(driver, castToParameter(locator, values)).isSelected();
	}

	public void switchToFrame(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		driver.switchTo().frame(element);
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.doubleClick(getElement(driver, locator)).perform();
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(getElement(driver, locator)).perform();
	}

	public void hoverMouseToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.moveToElement(getElement(driver, locator)).perform();
	}

	public void hoverMouseToElement(WebDriver driver, String locator, String... value) {
		action = new Actions(driver);
		action.moveToElement(getElement(driver, String.format(locator, (Object[]) value))).perform();
	}

	public void clickAndHoleToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.clickAndHold(getElement(driver, locator)).perform();
	}

	public void dragAnđropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		action = new Actions(driver);
		action.dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
	}

	public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(getElement(driver, locator), key).perform();
	}

	// Custom dropdown

	public void selectItemInCustomDropdown(WebDriver driver, String locatorParent, String locatorAllItem, String valueExpected, String locatorExpected) {
		sleepInSecond(2);
		// 1. Click vào thẻ bất kỳ để xổ hết tất cả các item trong dropdown ra
		clickToElement(driver, locatorParent);

		// 2. Chờ cho tất cả item được xuất hiện / có trong HTML DOM
		waitAllElementsPresence(driver, locatorAllItem);

		// 3. Lấy tất cả item này đưa vào 1 list WebElement
		List<WebElement> listAllElement = getElements(driver, locatorAllItem);

		// 4. Duyệt qua từng cái Item
		for (WebElement itemElement : listAllElement) {
			// 5. Mỗi lần duyệt kiểm tra xem text của item đó có bằng với items mình cần
			// click hay hông
			if (itemElement.getText().equals(valueExpected)) {
				// Trước khi Click thì scroll xuống chính nó
				scrollToElementByJS(driver, locatorExpected);

				waitForElementClickable(driver, locatorExpected);
				// 6. Nếu như = thì click vào và thoát khỏi vòng lặp
				// 7.Nếu như hông = thì lại duyệt tiếp cho đến hết tất cả item
				sleepInSecond(2);

				itemElement.click();
				sleepInSecond(2);
				break;
			}
		}

	}

	public void multipleSelect(WebDriver driver, String xpathParent, String xpathAllItem, String... expectedValue) {
		// 1. Click vào dropdown cho nó xổ hết tất cả các item ra
		driver.findElement(By.xpath(xpathParent)).click();

		// 2. Chờ cho tất cả các item được load thành công
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpathAllItem)));

		// 3. Đưa các item vào 1 list
		List<WebElement> allItems = driver.findElements(By.xpath(xpathAllItem));

		// 4. Duyêt tất cả phần từ trong list cho đến khi thỏa mản điều kiện (Tức là tìm
		// được cái đã chọn)
		for (WebElement items : allItems) {
			for (String item : expectedValue) {
				if (items.getText().equals(item)) {
					// 5. Scroll đến item cần chọn
					jsExecutor.executeScript("arguments[0].scrollIntoView(true)", items);
					sleepInSecond(1);
					// 6. Click vào item cần chọn
					items.click();
					break;
				}
			}
		}
	}

	public void selectElementInDropdown(WebDriver driver, String xpathParent, String xpatAllItem, String textExpected) {
		// 1. Click vào thẻ bất kỳ để xổ hết tất cả các item trong dropdown ra
		driver.findElement(By.xpath(xpathParent)).click();

		// 2. Chờ cho tất cả item được xuất hiện / có trong HTML DOM
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpatAllItem)));

		// 3. Lấy tất cả item này đưa vào 1 list WebElement
		List<WebElement> listAllElement = driver.findElements(By.xpath(xpatAllItem));

		// 4. Duyệt qua từng cái Item
		for (WebElement itemElement : listAllElement) {
			// 5. Mỗi lần duyệt kiểm tra xem text của item đó có bằng với items mình cần
			// click hay hông
			if (itemElement.getText().equals(textExpected)) {
				// Trước khi Click thì scroll xuống chính nó
				jsExecutor.executeScript("arguments[0].scrollIntoView(true)", itemElement);

				explicitWait.until(ExpectedConditions.elementToBeClickable(itemElement));
				// 6. Nếu như = thì click vào và thoát khỏi vòng lặp
				// 7.Nếu như hông = thì lại duyệt tiếp cho đến hết tất cả item
				sleepInSecond(2);

				itemElement.click();
				sleepInSecond(2);
				break;
			}
		}

	}

	public void selectItemInDropdown(WebDriver driver, String locator, String itemValue, String... values) {
		element = getElement(driver, locator, values);
		select = new Select(element);
		select.selectByVisibleText(itemValue);

	}

	public void checkSelectedItem(WebDriver driver, String locatorListItems, String locatorSelectedItem, String locatorResult, String[] expectedValue) {
		List<WebElement> AllItems = getElements(driver, locatorListItems);
		List<WebElement> itemsSelected = getElements(driver, locatorSelectedItem);

		int numberSelected = itemsSelected.size();
		int numberItems = AllItems.size() - 1;

		Assert.assertEquals(numberSelected, expectedValue.length);

		String selectedText = getElementText(driver, locatorResult);
		if (numberSelected <= 3 && numberSelected >= 0) {
			for (String items : expectedValue) {
				if (selectedText.contains(items)) {
					break;
				}
			}
		} else {
			Assert.assertEquals(getElementText(driver, locatorResult), numberSelected + " of " + numberItems + " selected");
		}
	}

	// Javascript Executor
	public void sendKeyToElementByJS(WebDriver driver, String locator, String text) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value','" + text + "')", getElement(driver, locator));
	}

	public void sendKeyToElementByJS(WebDriver driver, String text, String locator, String... values) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value','" + text + "')", getElement(driver, String.format(locator, (Object[]) values)));
	}

	public void clickElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click()", getElement(driver, locator));
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location='" + url + "'");
	}

	public Object getDomainByJS(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript("return document.domain");
	}

	public Object getTitleByJS(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript("return document.title");
	}

	public Object getUrlByJS(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript("return document.URL");
	}

	public Object getInnerTextByJS(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript("return document.documentElement.innerText");

	}

	public String getHiddentTextByJS(WebDriver driver, String cssLocator) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.querySelector(\"" + cssLocator + "\").textContent");

	}

	public Object scrollToElementByJS(WebDriver driver, String locator, String... values) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript("arguments[0].scrollIntoView(true)", getElement(driver, castToParameter(locator, values)));
	}

	public Object scrollToBottomPageByJS(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public Object removeAttributeByJS(WebDriver driver, String locator, String attribute) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript("arguments[0].removeAttribute('" + attribute + "')", getElement(driver, locator));
	}

	public void highlightElement(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		getElement(driver, locator);
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth !=\"underfined\"&& arguments[0].naturalWidth > 0", getElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	// Wait
	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void waitForAllElementsVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		try {
			explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpth(locator)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void waitForAllElementsVisible(WebDriver driver, String locator, String...values) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		try {
			explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpth(castToParameter(locator, values))));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void waitForElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		try {
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpth(locator)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitForElementVisible(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpth(castToParameter(locator, values))));
	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpth(locator)));
	}

	public void waitForElementClickable(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpth(castToParameter(locator, values))));
	}

	public String castToParameter(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		return locator;
	}

	public void waitForElementInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
		overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpth(locator)));
		overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
	}

	public void waitAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void waitElementPresence(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(getByXpth(locator)));
	}

	public void waitAllElementsPresence(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpth(locator)));
	}

	public void overrideGlobalTimeout(WebDriver driver, long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}

//	// 10 => 15 pages
//	public AbstractPage openLinkByPageName(WebDriver driver, String pageName) {
//		waitForElementClickable(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
//		clickToElement(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
//		switch (pageName) {
//		case "Addresses":
//			return PageGeneratorManager.getUserAddressesPage(driver);
//		case "My product reviews":
//			return PageGeneratorManager.getUserMyProductReviewPage(driver);
//		case "Customer info":
//			return PageGeneratorManager.getUserCustomerInfoPage(driver);
//		default:
//			return PageGeneratorManager.getUserOrdersPage(driver);
//		}
//	}

	public List<String> getElementsText(WebDriver driver, String parentLocator) {
		List<WebElement> items = getElements(driver, parentLocator);
		ArrayList<String> listItems = new ArrayList<String>();
		for (WebElement webElement : items) {
			listItems.add(webElement.getText().trim());
		}
		return listItems;
	}

	public boolean isResultContainsKeyword(WebDriver driver, String keyword, String resultLocator) {
		int check = 0;
		List<String> listItems = getElementsText(driver, resultLocator);
		for (String p : listItems) {
			if (p.trim().contains(keyword)) {
				check++;
			}
		}
		if (listItems.size() == check) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isResultContainsKeyword(WebDriver driver, String resultLocator, String... valueExpected) {
		int check = 0;
		List<String> listItems = getElementsText(driver, resultLocator);
		String[] arrayItems = new String[listItems.size()];
		arrayItems = listItems.toArray(arrayItems);

		for (int i = 0; i < arrayItems.length; i++) {
			for (int j = 0; j < valueExpected.length; j++) {
				if (arrayItems[i].equals(valueExpected[j])) {
					check++;
				}
			}
		}
		if (listItems.size() == check) {
			return true;
		} else {
			return false;
		}
	}


	public void selectInListCheckBox(WebDriver driver, String listLocatorCheckboxItems, String LocatorLabelItems, String... nameOptions) {
		List<WebElement> checkboxList = getElements(driver, listLocatorCheckboxItems);
		List<WebElement> checkboxLabelList = getElements(driver, LocatorLabelItems);

		for (WebElement w : checkboxList) {
			if (w.isSelected()) {
				w.click();
			}
		}
		WebElement[] arrayCheckbox = new WebElement[checkboxList.size()];
		WebElement[] arrayLabel = new WebElement[checkboxLabelList.size()];

		arrayCheckbox = checkboxList.toArray(arrayCheckbox);
		arrayLabel = checkboxLabelList.toArray(arrayLabel);
		for (int i = 0; i < nameOptions.length; i++) {
			for (int j = 0; j < arrayCheckbox.length; j++) {
				if (nameOptions[i].equals(arrayLabel[j].getText())) {
					if (!arrayCheckbox[j].isSelected()) {
						arrayCheckbox[j].click();
					}
				}
			}
		}
		sleepInSecond(2);
	}


	public boolean isDataDisplayedAtTable(WebDriver driver, String locatorColumnName, String locatorColumn, String columnName, String textValue) {
		boolean check = false;
		int indexOfColumnName = getSizeElements(driver, locatorColumnName, columnName) + 1;
		locatorColumn = castToParameter(locatorColumn, String.valueOf(indexOfColumnName));
		List<String> items = getElementsText(driver, locatorColumn);
		for (String s : items) {
			if (s.contains(textValue)) {
				check = true;
			}
		}
		return check;
	}

//	public void uploadFileByPanelName(WebDriver driver, String panelName, String... fileNames) {
//		String filePath = GlobalConstants.UPLOAD_FOLDER;
//		String fullFileName = "";
//		for (String file : fileNames) {
//			fullFileName = fullFileName + filePath + file + "\n";
//		}
//		fullFileName = fullFileName.trim();
//		getElement(driver, AbstractPageUI.UPLOAD_FILE_TYPE_BY_PANEL_NAME, panelName).sendKeys(fullFileName);
//
//	}

//	public void uploadMultipleFiles(WebDriver driver, String... filesName) {
//		String filePath = GlobalConstants.UPLOAD_FOLDER;
//		String fullFileName = "";
//		for (String file : filesName) {
//			fullFileName = fullFileName + filePath + file + "\n";
//		}
//		fullFileName = fullFileName.trim();
//		sendKeyToElement(driver, AbstractPageUI.UPLOAD_FILE_TYPE, fullFileName);
//	}



	public boolean isDataStringSortedAscending(WebDriver driver, String locator) {
		// Khai bao 1 Array LIst
		ArrayList<String> arrayList = new ArrayList<String>();

		// Tim tat ca Elements matching voi dieu kien (Name/Price/Type)
		List<WebElement> elementList = driver.findElements(By.xpath(locator));

		// Lay text cua tung Element add vao Array List
		for (WebElement element : elementList) {
			arrayList.add(element.getText());
		}

		System.out.println("----- Du lieu tren UI ----------");
		for (String name : arrayList) {
			System.out.println(name);
		}

		// Copy qua 1 array list moi de sort trong CODE
		ArrayList<String> sortedList = new ArrayList<>();
		for (String child : arrayList) {
			sortedList.add(child);
		}

		// Thuc hien SORT ASC
		Collections.sort(sortedList);

		System.out.println("-------- Du lieu da sort asc trong code ---------");
		for (String name : sortedList) {
			System.out.println(name);
		}

		// verify 2 array bang nhau - neu du lieu sort tren UI khong chinh xac thi tra
		// ve false
		return sortedList.equals(arrayList);

	}

	public boolean isDataStringSortedDescending(WebDriver driver, String locator) {
		// Khai bao 1 Array LIst
		ArrayList<String> arrayList = new ArrayList<String>();

		// Tim tat ca Elements matching voi dieu kien (Name/Price/Type)
		List<WebElement> elementList = driver.findElements(By.xpath(locator));

		// Lay text cua tung Element add vao Array List
		for (WebElement element : elementList) {
			arrayList.add(element.getText());
		}

		System.out.println("----- Du lieu tren UI ----------");
		for (String name : arrayList) {
			System.out.println(name);
		}

		// Copy qua 1 array list moi de sort trong CODE
		ArrayList<String> sortedList = new ArrayList<>();
		for (String child : arrayList) {
			sortedList.add(child);
		}

		// Thuc hien SORT ASC
		Collections.sort(sortedList);

		System.out.println("-------- Du lieu da sort asc trong code ---------");
		for (String name : sortedList) {
			System.out.println(name);
		}

		// Reverse data de sort desc
		Collections.reverse(sortedList);

		System.out.println("-------- Du lieu da sort desc trong code --------- ");
		for (String name : sortedList) {
			System.out.println(name);
		}

		// verify 2 array bang nhau - neu du lieu sort tren UI khong chinh xac thi tra
		// ve false
		return sortedList.equals(arrayList);

	}

	public boolean isDataFloatSortedAscending(WebDriver driver, String locator) {
		// Khai bao 1 Array LIst
		ArrayList<Float> arrayList = new ArrayList<Float>();

		// Tim tat ca Elements matching voi dieu kien (Name/Price/Type)
		List<WebElement> elementList = driver.findElements(By.xpath(locator));

		// Lay text cua tung Element add vao Array List
		for (WebElement element : elementList) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").trim()));
		}
		System.out.println("----- Du lieu tren UI ----------");
		for (Float name : arrayList) {
			System.out.println(name);
		}
		// Copy qua 1 array list moi de sort trong CODE
		ArrayList<Float> sortedList = new ArrayList<Float>();
		for (Float child : arrayList) {
			sortedList.add(child);
		}

		// Thuc hien SORT ASC
		Collections.sort(sortedList);

		System.out.println("-------- Du lieu da sort asc trong code ---------");
		for (Float name : sortedList) {
			System.out.println(name);
		}

		// verify 2 array bang nhau - neu du lieu sort tren UI khong chinh xac thi tra
		// ve false
		return sortedList.equals(arrayList);
	}
	
	public boolean isDataFloatSortedDescending(WebDriver driver, String locator) {
		// Khai bao 1 Array LIst
		ArrayList<Float> arrayList = new ArrayList<Float>();

		// Tim tat ca Elements matching voi dieu kien (Name/Price/Type)
		List<WebElement> elementList = driver.findElements(By.xpath(locator));

		// Lay text cua tung Element add vao Array List
		for (WebElement element : elementList) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").trim()));
		}
		System.out.println("----- Du lieu tren UI ----------");
		for (Float name : arrayList) {
			System.out.println(name);
		}
		// Copy qua 1 array list moi de sort trong CODE
		ArrayList<Float> sortedList = new ArrayList<Float>();
		for (Float child : arrayList) {
			sortedList.add(child);
		}

		// Thuc hien SORT ASC
		Collections.sort(sortedList);

		System.out.println("-------- Du lieu da sort asc trong code ---------");
		for (Float name : sortedList) {
			System.out.println(name);
		}
		
		// Reverse data de sort desc
		Collections.reverse(sortedList);
		
		System.out.println("-------- Du lieu da sort desc trong code --------- ");
		for (Float name : sortedList) {
			System.out.println(name);
		}

		// verify 2 array bang nhau - neu du lieu sort tren UI khong chinh xac thi tra
		// ve false
		return sortedList.equals(arrayList);
	}
	
	public boolean isDataDateSortedAscending(WebDriver driver, String locator) {
		ArrayList<Date> arrayList = new ArrayList<Date>();
		List<WebElement> elementList = driver.findElements(By.xpath(locator));
		for(WebElement element : elementList) {
			arrayList.add(convertStringToDate(element.getText()));
		}
		
		System.out.println("--------- Du lieu tren UI ------------");
		for(Date name : arrayList) {
			System.out.println(name);
		}
		
		ArrayList<Date> sortedList = new ArrayList<Date>(); 
		for(Date child : arrayList) {
			sortedList.add(child);
		}
		
		Collections.sort(sortedList);
		System.out.println("------ Du lieu da sort ASC trong code ----------");
		for(Date name : sortedList) {
			System.out.println(name);
		}
		return sortedList.equals(arrayList);
	}
	
	
	public Date convertStringToDate(String dateInString) {
		dateInString  = dateInString.replace(".", "");
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd yyyy");
		Date date = null; 
		try {
			date = formatter.parse(dateInString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public void clickToRadioButtonByID(WebDriver driver, String radioButtonID) {
		waitForElementClickable(driver, AbstractPageUI.DYNAMIC_RADIO_BUTTON_BY_ID, radioButtonID);
		clickToElement(driver, AbstractPageUI.DYNAMIC_RADIO_BUTTON_BY_ID, radioButtonID);
	}

	public void inputToTextboxByID(WebDriver driver, String textboxID, String value) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		sendKeyToElement(driver, value, AbstractPageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
	}

	public void selectDropdownByName(WebDriver driver, String selectDropdownID, String value) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_DROPDOWN_BY_NAME, selectDropdownID);
		selectItemByVisible(driver, value, AbstractPageUI.DYNAMIC_DROPDOWN_BY_NAME, selectDropdownID);
	}

	public HomePagePO clickToLogoutLink(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageUI.LOGOUT_LINK);
		clickToElement(driver, AbstractPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePageUser(driver);
	}
}
