package nopcommerce.user;


import commons.AbstractTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import commons.RoleAccess;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.User.*;
import testdata.ProductData;
import testdata.UserData;

import java.io.File;

public class Order extends AbstractTest {
    private WebDriver driver;
    private int randomNumber = getRandomNumber();

    private ProductData productData;
    private UserData userData;

    private ProductDetailPO productDetailPage;
    private ProductPO productPage;
    private HomePagePO homePage;
    private LoginPO loginPage;
    private CartPO cartPage;
    private CheckoutPO checkoutPage;
    private CustomerInfoPO customerPage;
    private OrderInformationPO orderInformationPage;
    private OrderHistoryPO orderHistoryPage;

    RoleAccess roleAccess;
    String orderNumber = "";

    @Parameters({"browser"})
    @BeforeClass
    private void beforeClass(String browserName) {
        String role = System.getProperty("role");
        ConfigFactory.setProperty("role", role);
        roleAccess = ConfigFactory.create(RoleAccess.class);
        driver = getBrowserDriver(browserName, roleAccess.url());

        productData = ProductData.getFiles(GlobalConstants.ROOT_FOLDER + File.separator + "src/test/java" + File.separator + "testdata" + File.separator + "ProductData.json");
        userData = UserData.getFiles(GlobalConstants.ROOT_FOLDER + File.separator + "src/test/java" + File.separator + "testdata" + File.separator + "UserData.json");

        log.info("Order - Precondition - Step 01: Open Home Page");
        homePage = PageGeneratorManager.getHomePage(driver);

        log.info("Order - Precondition - Step 02: Click to Login link");
        loginPage = homePage.clickToLoginLink();

        log.info("Order - Precondition - Step 03: Input to Email with value: " + RegisterToSystem.EMAIL);
        loginPage.inputToEmailTextbox(RegisterToSystem.EMAIL);

        log.info("Order - Precondition - Step 04: Input to Password with value: " + RegisterToSystem.PASSWORD);
        loginPage.inputToPasswordTextbox(RegisterToSystem.PASSWORD);

        log.info("Order - Precondition - Step 05: Click to Login button");
        homePage = loginPage.clickToLoginButton();
    }


    public void TC_01_Add_Product_To_Cart() {
        log.info("Order - Add Product To Cart - Step 01: Open Submenu: Desktops");
        productPage = homePage.openSubMenu(driver, "Computers", "Desktops");

        log.info("Order - Add Product To Cart - Step 02: Click on product: " + productData.getProduct_03_name());
        productDetailPage = productPage.clickToProductByNameOfProduct(driver, productData.getProduct_03_name());

        log.info("Order - Add Product To Cart - Step 03: Select dropdown Processor with value: " + productData.getProduct_03_processor());
        productDetailPage.selectProcessorInDropdown(productData.getProduct_03_processor());

        log.info("Order - Add Product To Cart - Step 04: Select dropdown RAM with value: " + productData.getProduct_03_ram());
        productDetailPage.selectRAMInDropdown(productData.getProduct_03_ram());

        log.info("Order - Add Product To Cart - Step 05: Click to radio button HDD with value: " + productData.getProduct_03_hdd());
        productDetailPage.clickToHDDRadioButton(productData.getProduct_03_hdd());

        log.info("Order - Add Product To Cart - Step 06: Click to radio button OS with value: " + productData.getProduct_03_os());
        productDetailPage.clickToOSRadioButton(productData.getProduct_03_os());

        log.info("Order - Add Product To Cart - Step 07: Click to check box Software with value: " + productData.getProduct_03_software_ms_office() + ", " + productData.getProduct_03_software_reader() + ", " + productData.getProduct_03_software_commander());
        productDetailPage.clickToCheckboxSoftwareOption(productData.getProduct_03_software_ms_office(), productData.getProduct_03_software_reader(), productData.getProduct_03_software_commander());

        log.info("Order - Add Product To Cart - Step 08: Click Add to cart button");
        productDetailPage.clickToAddToCartButton();

        log.info("Order - Add Product To Cart - Step 09: Verify Add to cart successfully displays");
        verifyTrue(productDetailPage.isAddToCartSuccessMessageDisplayed());

        log.info("Order - Add Product To Cart - Step 10: Verify Add to cart successfully displays");
        productDetailPage.clickToCloseMessageAddToCartSuccess();

        log.info("Order - Add Product To Cart - Step 11: Hover on Shopping cart link on header");
        productDetailPage.hoverOnShoppingCartIconInHeader(driver);

        log.info("Order - Add Product To Cart - Step 12: Verify Quantity title displays on Cart");
        verifyEquals(productDetailPage.getNumberOfItemsInCart(driver), "There are 1 item(s) in your cart.");

        log.info("Order - Add Product To Cart - Step 13: Verify Product displays on Cart");
        verifyTrue(productDetailPage.isProductExistedInCartIconInHeader(driver, productData.getProduct_03_name(), productData.getProduct_03_processor(), productData.getProduct_03_ram(), productData.getProduct_03_hdd(), productData.getProduct_03_os(), productData.getProduct_03_software_ms_office(), productData.getProduct_03_software_reader(), productData.getProduct_03_software_commander()));

        log.info("Order - Add Product To Cart - Step 14: Verify Sub-Total displays on Cart");
        verifyEquals(productDetailPage.getSubTotalInCart(driver), "1500.00");

    }


    public void TC_02_Edit_Product_In_Cart() {
        log.info("Order - Edit Product In Cart - Step 01: Open Cart page");
        cartPage = productDetailPage.clickToShoppingCartLink(driver);

        log.info("Order - Edit Product In Cart - Step 01: Click to Edit link");
        productDetailPage = cartPage.clickToEditLink();

        log.info("Order - Edit Product In Cart - Step 03: Select dropdown Processor with value: " + productData.getProduct_04_processor());
        productDetailPage.selectProcessorInDropdown(productData.getProduct_04_processor());

        log.info("Order - Edit Product In Cart - Step 04: Select dropdown RAM with value: " + productData.getProduct_04_ram());
        productDetailPage.selectRAMInDropdown(productData.getProduct_04_ram());

        log.info("Order - Edit Product In Cart - Step 05: Click to radio button HDD with value: " + productData.getProduct_04_hdd());
        productDetailPage.clickToHDDRadioButton(productData.getProduct_04_hdd());

        log.info("Order - Edit Product In Cart - Step 06: Click to radio button OS with value: " + productData.getProduct_04_os());
        productDetailPage.clickToOSRadioButton(productData.getProduct_04_os());

        log.info("Order - Edit Product In Cart - Step 07: Click to check box Software with value: " + productData.getProduct_04_software_ms_office());
        productDetailPage.clickToCheckboxSoftwareOption(productData.getProduct_04_software_ms_office());

        log.info("Order - Edit Product In Cart - Step 08: Input to quantity with value: " + productData.getProduct_04_quantity());
        productDetailPage.inputToQuantityTextbox(productData.getProduct_04_quantity());

        log.info("Order - Edit Product In Cart - Step 09: Click to Update cart button ");
        productDetailPage.clickToUpdateCartButton();

        log.info("Order - Edit Product In Cart - Step 10: Verify Add to cart successfully displays");
        verifyTrue(productDetailPage.isAddToCartSuccessMessageDisplayed());

        log.info("Order - Edit Product In Cart - Step 11: Close add to cart success message");
        productDetailPage.clickToCloseMessageAddToCartSuccess();

        log.info("Order - Edit Product In Cart - Step 12: Verify new price");
        verifyEquals(productDetailPage.getPriceInDetailProduct(), "1320.00");

        log.info("Order - Edit Product In Cart - Step 13: Open Shopping Cart");
        cartPage = productDetailPage.clickToShoppingCartLink(driver);

        log.info("Order - Edit Product In Cart - Step 14: Verify Update product correctly");
        verifyTrue(cartPage.isProductExistedInCartPage(productData.getProduct_04_name(), productData.getProduct_04_processor(), productData.getProduct_04_ram(), productData.getProduct_04_hdd(), productData.getProduct_04_os(), productData.getProduct_04_software_ms_office()));

        log.info("Order - Edit Product In Cart - Step 15: Verify Total");
        verifyEquals(cartPage.getTotalPriceInCart(), "2640.00");

    }


    public void TC_03_Remove_Product_From_Cart() {
        log.info("Order - Remove Product From Cart - Step 01: Click to Remove icon");
        cartPage.clickToRemoveProductFromCart(productData.getProduct_04_name());

        log.info("Order - Remove Product From Cart - Step 01: Verify message Your shopping cart is empty");
        verifyTrue(cartPage.isCartEmptyMessageDisplayed());

        log.info("Order - Remove Product From Cart - Step 01: Verify product is not available in cart");
        verifyEquals(cartPage.getQualityProductsInShoppingCartIcon(driver), "0");
    }


    public void TC_04_Update_Shopping_Cart() {
        log.info("Order - Update shopping cart - Step 01: Open Submenu: Desktops");
        productPage = cartPage.openSubMenu(driver, "Computers", "Desktops");

        log.info("Order - Update shopping cart - Step 02: Click on product: " + productData.getProduct_05_name());
        productDetailPage = productPage.clickToProductByNameOfProduct(driver, productData.getProduct_05_name());

        log.info("Order - Update shopping cart - Step 03: Click Add to cart");
        productDetailPage.clickToAddToCartButton();

        log.info("Order - Update shopping cart - Step 04: Open cart page");
        cartPage = productDetailPage.clickToShoppingCartLink(driver);

        log.info("Order - Update shopping cart - Step 05: Verify Total Order with 1 product");
        verifyEquals(cartPage.getTotalPriceInCart(), "500.00");

        log.info("Order - Update shopping cart - Step 06: Update quantity to " + productData.getProduct_05_quantity());
        cartPage.inputToQuantity(productData.getProduct_05_quantity());

        log.info("Order - Update shopping cart - Step 07: Click to Update shopping cart button");
        cartPage.clickToUpdateShoppingCart();

        log.info("Order - Update shopping cart - Step 08: Verify Total Order with " + productData.getProduct_05_quantity() + " products");
        verifyEquals(cartPage.getTotalPriceInCart(), "2500.00");
    }

    @Test
    public void TC_05_Check_Out_Order_Payment_By_Cheque() {
        log.info("Order - Check out order payment by cheque - Step 01: Open sub menu Notebooks");
        productPage = homePage.openSubMenu(driver, "Computers", "Notebooks");

        log.info("Order - Check out order payment by cheque - Step 02: Click product with value: " + productData.getProduct_02_name());
        productDetailPage = productPage.clickToProductByNameOfProduct(driver, productData.getProduct_02_name());

        log.info("Order - Check out order payment by cheque - Step 03: Click to add to cart");
        productDetailPage.clickToAddToCartButton();

        log.info("Order - Check out order payment by cheque - Step 04: Click on Shopping Cart at footer");
        cartPage = (CartPO) productDetailPage.openLinkByTextAtFooter(driver, "Shopping cart");

        log.info("Order - Check out order payment by cheque - Step 05: Select to Gift wrapping with value: No");
        cartPage.selectToGiftWrappingDropdown("No");

        log.info("Order - Check out order payment by cheque - Step 06: Click to check box the terms of service");
        cartPage.checktoTermOfService();

        log.info("Order - Check out order payment by cheque - Step 01: Click to Check out button");
        checkoutPage = cartPage.clickToCheckoutButton();

        /* BILLING ADDRESS  */
        log.info("Order - Check out order payment by cheque - Step 01: Uncheck ship to same address");
        checkoutPage.unCheckShipToSameAddress();

        log.info("Order - Check out order payment by cheque - Step 01: Input to first name on Billing address with value: " + userData.getFirstName_01());
        checkoutPage.inputToTextboxByIdAtBillingAddress("FirstName", userData.getFirstName_01());

        log.info("Order - Check out order payment by cheque - Step 01: Input to last name on Billing address with value: " + userData.getLastName_01());
        checkoutPage.inputToTextboxByIdAtBillingAddress("LastName", userData.getLastName_01());

        log.info("Order - Check out order payment by cheque - Step 01: Input to email on Billing address with value: " + userData.getEmailAddress_01() + randomNumber + "@hotmail.com.vn");
        checkoutPage.inputToTextboxByIdAtBillingAddress("Email", userData.getEmailAddress_01() + randomNumber + "@hotmail.com.vn");

        log.info("Order - Check out order payment by cheque - Step 01: Select to country on Billing address with value: " + userData.getCountry_01());
        checkoutPage.selectDropdownByIdAtBillingAddress("CountryId", userData.getCountry_01());

        log.info("Order - Check out order payment by cheque - Step 01: Select to state/province on Billing address with value: " + userData.getStateProvince_01());
        checkoutPage.selectDropdownByIdAtBillingAddress("StateProvinceId", userData.getStateProvince_01());

        log.info("Order - Check out order payment by cheque - Step 01: Input to city on Billing address with value: " + userData.getCity_01());
        checkoutPage.inputToTextboxByIdAtBillingAddress("City", userData.getCity_01());

        log.info("Order - Check out order payment by cheque - Step 01: Input to address1 on Billing address with value: " + userData.getAddress1_01());
        checkoutPage.inputToTextboxByIdAtBillingAddress("Address1", userData.getAddress1_01());

        log.info("Order - Check out order payment by cheque - Step 01: Input to zip code on Billing address with value: " + userData.getZipPostal_01());
        checkoutPage.inputToTextboxByIdAtBillingAddress("ZipPostalCode", userData.getZipPostal_01());

        log.info("Order - Check out order payment by cheque - Step 01: Input to phone number on Billing address with value: " + userData.getPhoneNumber_01());
        checkoutPage.inputToTextboxByIdAtBillingAddress("PhoneNumber", userData.getPhoneNumber_01());

        log.info("Order - Check out order payment by cheque - Step 01: Input to phone number on Billing address with value: " + userData.getFaxNumber_02());
        checkoutPage.inputToTextboxByIdAtBillingAddress("FaxNumber", userData.getFaxNumber_01());


        log.info("Order - Check out order payment by cheque - Step 01: Click to Continue button on Billing address");
        checkoutPage.clickToContinueButtonAtBillingAddress();

        /* SHIPPING ADDRESS  */
        log.info("Order - Check out order payment by cheque - Step 01: Select to New Address option in dropdown");
        checkoutPage.selectShippingAddressDropdown("New Address");

        log.info("Order - Check out order payment by cheque - Step 01: Input to first name on Shipping address with value: " + userData.getFirstName_02());
        checkoutPage.inputToTextboxByIdAtShippingAddress("FirstName", userData.getFirstName_02());

        log.info("Order - Check out order payment by cheque - Step 01: Input to last name on Shipping address with value: " + userData.getLastName_02());
        checkoutPage.inputToTextboxByIdAtShippingAddress("LastName", userData.getLastName_02());

        log.info("Order - Check out order payment by cheque - Step 01: Input to email on Shipping address with value: " + userData.getEmailAddress_02() + randomNumber + 1 + "@hotmail.com.vn");
        checkoutPage.inputToTextboxByIdAtShippingAddress("Email", userData.getEmailAddress_02() + randomNumber + 1 + "@hotmail.com.vn");

        log.info("Order - Check out order payment by cheque - Step 01: Select to country on Shipping address with value: " + userData.getCountry_02());
        checkoutPage.selectByIdAtShippingAddress("CountryId", userData.getCountry_02());

        log.info("Order - Check out order payment by cheque - Step 01: Select to state/province on Shipping address with value: " + userData.getStateProvince_02());
        checkoutPage.selectByIdAtShippingAddress("StateProvinceId", userData.getStateProvince_02());

        log.info("Order - Check out order payment by cheque - Step 01: Input to city on Shipping address with value: " + userData.getCity_02());
        checkoutPage.inputToTextboxByIdAtShippingAddress("City", userData.getCity_02());

        log.info("Order - Check out order payment by cheque - Step 01: Input to address1 on Shipping address with value: " + userData.getAddress1_02());
        checkoutPage.inputToTextboxByIdAtShippingAddress("Address1", userData.getAddress1_02());

        log.info("Order - Check out order payment by cheque - Step 01: Input to zip code on Shipping address with value: " + userData.getZipPostal_02());
        checkoutPage.inputToTextboxByIdAtShippingAddress("ZipPostalCode", userData.getZipPostal_02());

        log.info("Order - Check out order payment by cheque - Step 01: Input to phone number on Shipping address with value: " + userData.getPhoneNumber_02());
        checkoutPage.inputToTextboxByIdAtShippingAddress("PhoneNumber", userData.getPhoneNumber_02());

        log.info("Order - Check out order payment by cheque - Step 01: Input to phone number on Shipping address with value: " + userData.getFaxNumber_02());
        checkoutPage.inputToTextboxByIdAtShippingAddress("FaxNumber", userData.getFaxNumber_02());

        log.info("Order - Check out order payment by cheque - Step 01: Click to Continue button on Shipping address");
        checkoutPage.clickToContinueButtonAtShippingAddress();

        /* SHIPPING METHOD  */
        log.info("Order - Check out order payment by cheque - Step 01: Click to Shipping method with value: Ground ($0.00)");
        checkoutPage.clickToRadioButtonAtShippingMethod("Ground ($0.00)");

        log.info("Order - Check out order payment by cheque - Step 01: Click to Continue button on Shipping method");
        checkoutPage.clickToContinueButtonAtShippingMethod();

        /* PAYMENT METHOD  */
        log.info("Order - Check out order payment by cheque - Step 01: Click to Payment method with value: Check / Money Order");
        checkoutPage.clickToRadioButtonAtPaymentMethod("Check / Money Order");

        log.info("Order - Check out order payment by cheque - Step 01: Click to Continue button on Payment method");
        checkoutPage.clickToContinueButtonAtPaymentMethod();

        /* PAYMENT INFORMATION  */
        log.info("Order - Check out order payment by cheque - Step 01: Verify Payment Information displayed");
        verifyTrue(checkoutPage.isOrderInformationDisplayed());
        log.info("Order - Check out order payment by cheque - Step 01: Click to Continue button on Payment Information");
        checkoutPage.clickToContinueButtonAtOrderInformation();


        /* CONFIRM ORDER  */
        log.info("Order - Check out order payment by cheque - Step 01: Verify Billing address displays correctly");
        verifyEquals(checkoutPage.getBillingAddressOfConfirmOrderByClass("name"), userData.getFirstName_01() + " " + userData.getLastName_01());
        verifyEquals(checkoutPage.getBillingAddressOfConfirmOrderByClass("email"), "Email: " + userData.getEmailAddress_01() + randomNumber + "@hotmail.com.vn");
        verifyEquals(checkoutPage.getBillingAddressOfConfirmOrderByClass("phone"), "Phone: " + userData.getPhoneNumber_01());
        verifyEquals(checkoutPage.getBillingAddressOfConfirmOrderByClass("fax"), "Fax: " + userData.getFaxNumber_01());
        verifyEquals(checkoutPage.getBillingAddressOfConfirmOrderByClass("address1"), userData.getAddress1_01());
        verifyEquals(checkoutPage.getBillingAddressOfConfirmOrderByClass("city-state-zip"), userData.getCity_01() + "," + userData.getStateProvince_01() + "," + userData.getZipPostal_01());
        verifyEquals(checkoutPage.getBillingAddressOfConfirmOrderByClass("country"), userData.getCountry_01());

        log.info("Order - Check out order payment by cheque - Step 01: Verify Payment displays correctly");
        verifyEquals(checkoutPage.getPaymentOfConfirmOrderByClass(), "Check / Money Order");

        log.info("Order - Check out order payment by cheque - Step 01: Verify Shipping address displays correctly");
        verifyEquals(checkoutPage.getShippingAddressOfConfirmOrderByClass("name"), userData.getFirstName_02() + " " + userData.getLastName_02());
        verifyEquals(checkoutPage.getShippingAddressOfConfirmOrderByClass("email"), "Email: " + userData.getEmailAddress_02() + randomNumber + 1 + "@hotmail.com.vn");
        verifyEquals(checkoutPage.getShippingAddressOfConfirmOrderByClass("phone"), "Phone: " + userData.getPhoneNumber_02());
        verifyEquals(checkoutPage.getShippingAddressOfConfirmOrderByClass("fax"), "Fax: " + userData.getFaxNumber_02());
        verifyEquals(checkoutPage.getShippingAddressOfConfirmOrderByClass("address1"), userData.getAddress1_02());
        verifyEquals(checkoutPage.getShippingAddressOfConfirmOrderByClass("city-state-zip"), userData.getCity_02() + "," + userData.getStateProvince_02() + "," + userData.getZipPostal_02());
        verifyEquals(checkoutPage.getShippingAddressOfConfirmOrderByClass("country"), userData.getCountry_02());


        log.info("Order - Check out order payment by cheque - Step 01: Verify Shipping displays correctly");
        verifyEquals(checkoutPage.getShippingOfConfirmOrderByClass(), "Ground");

        log.info("Order - Check out order payment by cheque - Step 01: Verify Product(s) displays correctly with value " + productData.getProduct_02_name());
        verifyTrue(checkoutPage.isProductNameDisplayedAtRowNumber(productData.getProduct_02_name()));

        log.info("Order - Check out order payment by cheque - Step 01: Verify Price displays correctly with value " + productData.getProduct_02_price());
        verifyTrue(checkoutPage.isProductInfoDisplayedAtRowNumber("Price", productData.getProduct_02_price()));

        log.info("Order - Check out order payment by cheque - Step 01: Verify Quantity displays correctly with value " + productData.getProduct_02_quantity());
        verifyTrue(checkoutPage.isProductInfoDisplayedAtRowNumber("Qty", productData.getProduct_02_quantity()));

        log.info("Order - Check out order payment by cheque - Step 01: Verify Total displays correctly with value $3,600.00");
        verifyTrue(checkoutPage.isProductInfoDisplayedAtRowNumber("Total", "3600.00"));

        log.info("Order - Check out order payment by cheque - Step 01: Verify Sub total displays correctly with value: ");
        verifyEquals(checkoutPage.getSubTotal(), "3600.00");

        log.info("Order - Check out order payment by cheque - Step 01: Verify Shipping displays correctly with value: 0");
        verifyEquals(checkoutPage.getShippingCost(), "0.00");

        log.info("Order - Check out order payment by cheque - Step 01: Verify Tax displays correctly with value: 0");
        verifyEquals(checkoutPage.getTax(), "0.00");

        log.info("Order - Check out order payment by cheque - Step 01: Verify Total order displays correctly with value: ");
        verifyEquals(checkoutPage.getTotalOrder(), "3600.00");

        log.info("Order - Check out order payment by cheque - Step 01: Click to Confirm button on Confirm order");
        checkoutPage.clickToConfirmButtonAtConfirmOrder();

        log.info("Order - Check out order payment by cheque - Step 01: Verify Thank you displays");
        verifyTrue(checkoutPage.isThankYouMessageDisplayed());

        log.info("Order - Check out order payment by cheque - Step 01: Verify Order successfully message displays");
        verifyTrue(checkoutPage.isOrderSuccessMessageDisplayed());

        log.info("Order - Check out order payment by cheque - Step 01: Verify Order number displays");
        verifyTrue(checkoutPage.isOrderNumberisplayed());
        orderNumber = checkoutPage.getOrderNumberAtOrder(driver);

        log.info("Order - Check out order payment by cheque - Step 01: Click to My Account link in header");
        customerPage = checkoutPage.clickToMyAccountLink(driver);

        log.info("Order - Check out order payment by cheque - Step 01: Open Orders Page in my account");
        orderHistoryPage = (OrderHistoryPO) customerPage.openLinkByPageNameAtMyAccount(driver, "Orders");

        log.info("Order - Check out order payment by cheque - Step 01: Verify Order number");
        verifyEquals(orderHistoryPage.getOrderNumber(), orderNumber);


        log.info("Order - Check out order payment by cheque - Step 01: Click to Detail tab");
        orderInformationPage = orderHistoryPage.clickToDetailButton(orderNumber);


        log.info("Order - Check out order payment by cheque - Step 01: Verify Order number displays");
        verifyEquals(orderInformationPage.getOrderNumber(), orderNumber);

        log.info("Order - Check out order payment by cheque - Step 01: Verify Order status displays with value Pending");
        verifyEquals(orderInformationPage.getOrderStatus(), "Pending");

        log.info("Order - Check out order payment by cheque - Step 01: Verify Order Total displays with value: 3,600");
        verifyEquals(orderInformationPage.getOrderTotal(), "3600.00");

        log.info("Order - Check out order payment by cheque - Step 01: Verify Billing address displays correctly");
        verifyEquals(orderInformationPage.getBillingAddressOfConfirmOrderByClass("name"), userData.getFirstName_01() + " " + userData.getLastName_01());
        verifyEquals(orderInformationPage.getBillingAddressOfConfirmOrderByClass("email"), "Email: " + userData.getEmailAddress_01() + randomNumber + "@hotmail.com.vn");
        verifyEquals(orderInformationPage.getBillingAddressOfConfirmOrderByClass("phone"), "Phone: " + userData.getPhoneNumber_01());
        verifyEquals(orderInformationPage.getBillingAddressOfConfirmOrderByClass("fax"), "Fax: " + userData.getFaxNumber_01());
        verifyEquals(orderInformationPage.getBillingAddressOfConfirmOrderByClass("address1"), userData.getAddress1_01());
        verifyEquals(orderInformationPage.getBillingAddressOfConfirmOrderByClass("city-state-zip"), userData.getCity_01() + "," + userData.getStateProvince_01() + "," + userData.getZipPostal_01());
        verifyEquals(orderInformationPage.getBillingAddressOfConfirmOrderByClass("country"), userData.getCountry_01());


        log.info("Order - Check out order payment by cheque - Step 01: Verify Payment displays correctly");
        verifyEquals(orderInformationPage.getPaymentMethod(), "Check / Money Order");
        verifyEquals(orderInformationPage.getPaymentStatus(), "Pending");

        log.info("Order - Check out order payment by cheque - Step 01: Verify Shipping address displays correctly");
        verifyEquals(orderInformationPage.getShippingAddressOfConfirmOrderByClass("name"), userData.getFirstName_02() + " " + userData.getLastName_02());
        verifyEquals(orderInformationPage.getShippingAddressOfConfirmOrderByClass("email"), "Email: " + userData.getEmailAddress_02() + randomNumber + 1 + "@hotmail.com.vn");
        verifyEquals(orderInformationPage.getShippingAddressOfConfirmOrderByClass("phone"), "Phone: " + userData.getPhoneNumber_02());
        verifyEquals(orderInformationPage.getShippingAddressOfConfirmOrderByClass("fax"), "Fax: " + userData.getFaxNumber_02());
        verifyEquals(orderInformationPage.getShippingAddressOfConfirmOrderByClass("address1"), userData.getAddress1_02());
        verifyEquals(orderInformationPage.getShippingAddressOfConfirmOrderByClass("city-state-zip"), userData.getCity_02() + "," + userData.getStateProvince_02() + "," + userData.getZipPostal_02());
        verifyEquals(orderInformationPage.getShippingAddressOfConfirmOrderByClass("country"), userData.getCountry_02());

        log.info("Order - Check out order payment by cheque - Step 01: Verify Shipping displays correctly");
        verifyEquals(orderInformationPage.getShippingMethod(), "Ground");
        verifyEquals(orderInformationPage.getShippingStatus(), "Not yet shipped");


        log.info("Order - Check out order payment by cheque - Step 01: Verify Product(s) displays correctly with value " + productData.getProduct_02_name());
        verifyTrue(orderInformationPage.isProductNameDisplayedAtRowNumber(productData.getProduct_02_name()));

        log.info("Order - Check out order payment by cheque - Step 01: Verify Price displays correctly with value " + productData.getProduct_02_price());
        verifyTrue(orderInformationPage.isProductInfoDisplayedAtRowNumber("Price", productData.getProduct_02_price()));

        log.info("Order - Check out order payment by cheque - Step 01: Verify Quantity displays correctly with value " + productData.getProduct_02_quantity());
        verifyTrue(orderInformationPage.isProductInfoDisplayedAtRowNumber("Quantity", productData.getProduct_02_quantity()));

        log.info("Order - Check out order payment by cheque - Step 01: Verify Total displays correctly with value ");
        verifyTrue(orderInformationPage.isProductInfoDisplayedAtRowNumber("Total", "3600.00"));

        log.info("Order - Check out order payment by cheque - Step 01: Verify Gift wrapping: No");
        verifyEquals(orderInformationPage.getGiftWrapping(), "No");

        log.info("Order - Check out order payment by cheque - Step 01: Verify Sub total displays correctly with value");
        verifyEquals(orderInformationPage.getSubTotal(), "3600.00");

        log.info("Order - Check out order payment by cheque - Step 01: Verify Shipping displays correctly with value: 0");
        verifyEquals(orderInformationPage.getShippingCost(), "0.00");

        log.info("Order - Check out order payment by cheque - Step 01: Verify Tax displays correctly with value: 0");
        verifyEquals(orderInformationPage.getTax(), "0.00");

        log.info("Order - Check out order payment by cheque - Step 01: Verify Total order displays correctly with value: ");
        verifyEquals(orderInformationPage.getTotalOrder(), "3600.00");
    }

    @Test
    public void TC_06_Re_Order() {
        log.info("Order - Re Order: Step 01: Click to Re-order button");
        cartPage = orderInformationPage.clickToReOrderButton();

        log.info("Order - Re Order: Step 01: Input to quantity text box");
        cartPage.inputToQuantity("10");

        log.info("Order - Re Order: Step 01: Click to Update shopping cart button");
        cartPage.clickToUpdateShoppingCart();

        log.info("Order - Re Order: Step 01: Check to agree the term of services");
        cartPage.checktoTermOfService();

        log.info("Order - Re Order: Step 01: Click to Check out button");
        checkoutPage = cartPage.clickToCheckoutButton();

        log.info("Order - Re Order: Step 01: Select new address at Billing address");
        checkoutPage.selectBillingAddressFrom("New Address");


        log.info("Order - Re Order - Step 01: Input to first name on Billing address with value: " + userData.getFirstName_01());
        checkoutPage.inputToTextboxByIdAtBillingAddress("FirstName", userData.getFirstName_01());

        log.info("Order - Re order - Step 01: Input to last name on Billing address with value: " + userData.getLastName_01());
        checkoutPage.inputToTextboxByIdAtBillingAddress("LastName", userData.getLastName_01());

        log.info("Order - Re order - Step 01: Input to email on Billing address with value: " + userData.getEmailAddress_01() + randomNumber + 3 + "@hotmail.com.vn");
        checkoutPage.inputToTextboxByIdAtBillingAddress("Email", userData.getEmailAddress_01() + randomNumber + "@hotmail.com.vn");

        log.info("Order - Re order - Step 01: Select to country on Billing address with value: " + userData.getCountry_01());
        checkoutPage.selectDropdownByIdAtBillingAddress("CountryId", userData.getCountry_01());

        log.info("Order - Re order - Step 01: Select to state/province on Billing address with value: " + userData.getStateProvince_01());
        checkoutPage.selectDropdownByIdAtBillingAddress("StateProvinceId", userData.getStateProvince_01());

        log.info("Order - Re order - Step 01: Input to city on Billing address with value: " + userData.getCity_01());
        checkoutPage.inputToTextboxByIdAtBillingAddress("City", userData.getCity_01());

        log.info("Order - Re order - Step 01: Input to address1 on Billing address with value: " + userData.getAddress1_01());
        checkoutPage.inputToTextboxByIdAtBillingAddress("Address1", userData.getAddress1_01());

        log.info("Order - Re order - Step 01: Input to zip code on Billing address with value: " + userData.getZipPostal_01());
        checkoutPage.inputToTextboxByIdAtBillingAddress("ZipPostalCode", userData.getZipPostal_01());

        log.info("Order - Re order - Step 01: Input to phone number on Billing address with value: " + userData.getPhoneNumber_01());
        checkoutPage.inputToTextboxByIdAtBillingAddress("PhoneNumber", userData.getPhoneNumber_01());

        log.info("Order - Re order - Step 01: Input to phone number on Billing address with value: " + userData.getFaxNumber_02());
        checkoutPage.inputToTextboxByIdAtBillingAddress("FaxNumber", userData.getFaxNumber_01());

        log.info("Order - Re order - Step 01: Click to Continue button on Shipping address");
        checkoutPage.clickToContinueButtonOfNewAddressAtShippingAddress();

        /* SHIPPING METHOD*/
        log.info("Order - Re order - Step 01: Click to Shipping method with value: Next Day Air ($0.00)");
        checkoutPage.clickToRadioButtonAtShippingMethod("Next Day Air ($0.00)");

        log.info("Order - Re order - Step 01: Click to Continue button on Shipping method");
        checkoutPage.clickToContinueButtonAtShippingMethod();

        /* PAYMENT METHOD  */
        log.info("Order - Re order - Step 01: Click to Payment method with value: Credit Card");
        checkoutPage.clickToRadioButtonAtPaymentMethod("Credit Card");
        checkoutPage.clickToContinueButtonAtPaymentMethod();

        checkoutPage.selectDropdownByIdAtCardPayment("CreditCardType", "Master card");
        checkoutPage.inputToTextboxByIdAtCardPayment("CardholderName", "Testing Automation");
        checkoutPage.inputToTextboxByIdAtCardPayment("CardNumber", "372301601726625");
        checkoutPage.selectDropdownByIdAtCardPayment("ExpireMonth", "08");
        checkoutPage.selectDropdownByIdAtCardPayment("ExpireYear", "2021");
        checkoutPage.inputToTextboxByIdAtCardPayment("CardCode", "2468");
        checkoutPage.clickToContinueButtonAtCardPayment();


        /* CONFIRM ORDER  */
        log.info("Order - Check out order payment by cheque - Step 01: Verify Billing address displays correctly");
        verifyEquals(checkoutPage.getBillingAddressOfConfirmOrderByClass("name"), userData.getFirstName_01() + " " + userData.getLastName_01());
        verifyEquals(checkoutPage.getBillingAddressOfConfirmOrderByClass("email"), "Email: " + userData.getEmailAddress_01() + randomNumber+3 + "@hotmail.com.vn");
        verifyEquals(checkoutPage.getBillingAddressOfConfirmOrderByClass("phone"), "Phone: " + userData.getPhoneNumber_01());
        verifyEquals(checkoutPage.getBillingAddressOfConfirmOrderByClass("fax"), "Fax: " + userData.getFaxNumber_01());
        verifyEquals(checkoutPage.getBillingAddressOfConfirmOrderByClass("address1"), userData.getAddress1_01());
        verifyEquals(checkoutPage.getBillingAddressOfConfirmOrderByClass("city-state-zip"), userData.getCity_01() + "," + userData.getStateProvince_01() + "," + userData.getZipPostal_01());
        verifyEquals(checkoutPage.getBillingAddressOfConfirmOrderByClass("country"), userData.getCountry_01());

        log.info("Order - Check out order payment by cheque - Step 01: Verify Payment displays correctly");
        verifyEquals(checkoutPage.getPaymentOfConfirmOrderByClass(), "Credit Card");

        log.info("Order - Check out order payment by cheque - Step 01: Verify Shipping address displays correctly");
        verifyEquals(checkoutPage.getShippingAddressOfConfirmOrderByClass("name"), userData.getFirstName_01() + " " + userData.getLastName_01());
        verifyEquals(checkoutPage.getShippingAddressOfConfirmOrderByClass("email"), "Email: " + userData.getEmailAddress_01() + randomNumber+3 + "@hotmail.com.vn");
        verifyEquals(checkoutPage.getShippingAddressOfConfirmOrderByClass("phone"), "Phone: " + userData.getPhoneNumber_01());
        verifyEquals(checkoutPage.getShippingAddressOfConfirmOrderByClass("fax"), "Fax: " + userData.getFaxNumber_01());
        verifyEquals(checkoutPage.getShippingAddressOfConfirmOrderByClass("address1"), userData.getAddress1_01());
        verifyEquals(checkoutPage.getShippingAddressOfConfirmOrderByClass("city-state-zip"), userData.getCity_01() + "," + userData.getStateProvince_01() + "," + userData.getZipPostal_01());
        verifyEquals(checkoutPage.getShippingAddressOfConfirmOrderByClass("country"), userData.getCountry_01());


        log.info("Order - Check out order payment by cheque - Step 01: Verify Shipping displays correctly");
        verifyEquals(checkoutPage.getShippingOfConfirmOrderByClass(), "Next Day Air");

        log.info("Order - Check out order payment by cheque - Step 01: Verify Product(s) displays correctly with value " + productData.getProduct_02_name());
        verifyTrue(checkoutPage.isProductNameDisplayedAtRowNumber(productData.getProduct_02_name()));

        log.info("Order - Check out order payment by cheque - Step 01: Verify Price displays correctly with value " + productData.getProduct_02_price());
        verifyTrue(checkoutPage.isProductInfoDisplayedAtRowNumber("Price", productData.getProduct_02_price()));

        log.info("Order - Check out order payment by cheque - Step 01: Verify Quantity displays correctly with value 10");
        verifyTrue(checkoutPage.isProductInfoDisplayedAtRowNumber("Qty", "10"));

        log.info("Order - Check out order payment by cheque - Step 01: Verify Total displays correctly with value $3,600.00");
        verifyTrue(checkoutPage.isProductInfoDisplayedAtRowNumber("Total", "18000.00"));

        log.info("Order - Check out order payment by cheque - Step 01: Verify Sub total displays correctly with value: ");
        verifyEquals(checkoutPage.getSubTotal(), "18000.00");

        log.info("Order - Check out order payment by cheque - Step 01: Verify Shipping displays correctly with value: 0");
        verifyEquals(checkoutPage.getShippingCost(), "0.00");

        log.info("Order - Check out order payment by cheque - Step 01: Verify Tax displays correctly with value: 0");
        verifyEquals(checkoutPage.getTax(), "0.00");

        log.info("Order - Check out order payment by cheque - Step 01: Verify Total order displays correctly with value: ");
        verifyEquals(checkoutPage.getTotalOrder(), "18000.00");

        log.info("Order - Check out order payment by cheque - Step 01: Click to Confirm button on Confirm order");
        checkoutPage.clickToConfirmButtonAtConfirmOrder();

        log.info("Order - Check out order payment by cheque - Step 01: Verify Thank you displays");
        verifyTrue(checkoutPage.isThankYouMessageDisplayed());

        log.info("Order - Check out order payment by cheque - Step 01: Verify Order successfully message displays");
        verifyTrue(checkoutPage.isOrderSuccessMessageDisplayed());

        log.info("Order - Check out order payment by cheque - Step 01: Verify Order number displays");
        verifyTrue(checkoutPage.isOrderNumberisplayed());
        orderNumber = checkoutPage.getOrderNumberAtOrder(driver);

        log.info("Order - Check out order payment by cheque - Step 01: Click to My Account link in header");
        customerPage = checkoutPage.clickToMyAccountLink(driver);

        log.info("Order - Check out order payment by cheque - Step 01: Open Orders Page in my account");
        orderHistoryPage = (OrderHistoryPO) customerPage.openLinkByPageNameAtMyAccount(driver, "Orders");

        log.info("Order - Check out order payment by cheque - Step 01: Verify Order number");
        verifyEquals(orderHistoryPage.getOrderNumber(), orderNumber);


        log.info("Order - Check out order payment by cheque - Step 01: Click to Detail tab");
        orderInformationPage = orderHistoryPage.clickToDetailButton(orderNumber);

        log.info("Order - Check out order payment by cheque - Step 01: Verify Order number displays");
        verifyEquals(orderInformationPage.getOrderNumber(), orderNumber);

        log.info("Order - Check out order payment by cheque - Step 01: Verify Order status displays with value Pending");
        verifyEquals(orderInformationPage.getOrderStatus(), "Pending");

        log.info("Order - Check out order payment by cheque - Step 01: Verify Order Total displays with value: 3,600");
        verifyEquals(orderInformationPage.getOrderTotal(), "3600.00");

        log.info("Order - Check out order payment by cheque - Step 01: Verify Billing address displays correctly");
        verifyEquals(orderInformationPage.getBillingAddressOfConfirmOrderByClass("name"), userData.getFirstName_01() + " " + userData.getLastName_01());
        verifyEquals(orderInformationPage.getBillingAddressOfConfirmOrderByClass("email"), "Email: " + userData.getEmailAddress_01() + randomNumber+3 + "@hotmail.com.vn");
        verifyEquals(orderInformationPage.getBillingAddressOfConfirmOrderByClass("phone"), "Phone: " + userData.getPhoneNumber_01());
        verifyEquals(orderInformationPage.getBillingAddressOfConfirmOrderByClass("fax"), "Fax: " + userData.getFaxNumber_01());
        verifyEquals(orderInformationPage.getBillingAddressOfConfirmOrderByClass("address1"), userData.getAddress1_01());
        verifyEquals(orderInformationPage.getBillingAddressOfConfirmOrderByClass("city-state-zip"), userData.getCity_01() + "," + userData.getStateProvince_01() + "," + userData.getZipPostal_01());
        verifyEquals(orderInformationPage.getBillingAddressOfConfirmOrderByClass("country"), userData.getCountry_01());


        log.info("Order - Check out order payment by cheque - Step 01: Verify Payment displays correctly");
        verifyEquals(orderInformationPage.getPaymentMethod(), "Credit Card");
        verifyEquals(orderInformationPage.getPaymentStatus(), "Pending");

        log.info("Order - Check out order payment by cheque - Step 01: Verify Shipping address displays correctly");
        verifyEquals(orderInformationPage.getShippingAddressOfConfirmOrderByClass("name"), userData.getFirstName_01() + " " + userData.getLastName_01());
        verifyEquals(orderInformationPage.getShippingAddressOfConfirmOrderByClass("email"), "Email: " + userData.getEmailAddress_01() + randomNumber + 3 + "@hotmail.com.vn");
        verifyEquals(orderInformationPage.getShippingAddressOfConfirmOrderByClass("phone"), "Phone: " + userData.getPhoneNumber_01());
        verifyEquals(orderInformationPage.getShippingAddressOfConfirmOrderByClass("fax"), "Fax: " + userData.getFaxNumber_01());
        verifyEquals(orderInformationPage.getShippingAddressOfConfirmOrderByClass("address1"), userData.getAddress1_01());
        verifyEquals(orderInformationPage.getShippingAddressOfConfirmOrderByClass("city-state-zip"), userData.getCity_01() + "," + userData.getStateProvince_01() + "," + userData.getZipPostal_01());
        verifyEquals(orderInformationPage.getShippingAddressOfConfirmOrderByClass("country"), userData.getCountry_01());

        log.info("Order - Check out order payment by cheque - Step 01: Verify Shipping displays correctly");
        verifyEquals(orderInformationPage.getShippingMethod(), "Next Day Air");
        verifyEquals(orderInformationPage.getShippingStatus(), "Not yet shipped");


        log.info("Order - Check out order payment by cheque - Step 01: Verify Product(s) displays correctly with value " + productData.getProduct_02_name());
        verifyTrue(orderInformationPage.isProductNameDisplayedAtRowNumber(productData.getProduct_02_name()));

        log.info("Order - Check out order payment by cheque - Step 01: Verify Price displays correctly with value " + productData.getProduct_02_price());
        verifyTrue(orderInformationPage.isProductInfoDisplayedAtRowNumber("Price", productData.getProduct_02_price()));

        log.info("Order - Check out order payment by cheque - Step 01: Verify Quantity displays correctly with value 10");
        verifyTrue(orderInformationPage.isProductInfoDisplayedAtRowNumber("Quantity", "10"));

        log.info("Order - Check out order payment by cheque - Step 01: Verify Total displays correctly with value ");
        verifyTrue(orderInformationPage.isProductInfoDisplayedAtRowNumber("Total", "18000.00"));

        log.info("Order - Check out order payment by cheque - Step 01: Verify Gift wrapping: No");
        verifyEquals(orderInformationPage.getGiftWrapping(), "No");

        log.info("Order - Check out order payment by cheque - Step 01: Verify Sub total displays correctly with value 18000");
        verifyEquals(orderInformationPage.getSubTotal(), "18000.00");

        log.info("Order - Check out order payment by cheque - Step 01: Verify Shipping displays correctly with value: 0");
        verifyEquals(orderInformationPage.getShippingCost(), "0.00");

        log.info("Order - Check out order payment by cheque - Step 01: Verify Tax displays correctly with value: 0");
        verifyEquals(orderInformationPage.getTax(), "0.00");

        log.info("Order - Check out order payment by cheque - Step 01: Verify Total order displays correctly with value: 18000");
        verifyEquals(orderInformationPage.getTotalOrder(), "18000.00");
    }

    @AfterClass
    public void afterClass() {
    }


}
