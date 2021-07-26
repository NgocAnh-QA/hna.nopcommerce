package commons;

import io.qameta.allure.Step;
import io.qameta.allure.Story;
import pageObjects.User.*;
import org.openqa.selenium.WebDriver;
import pageUIs.User.ProductDetailPageUI;

public class PageGeneratorManagerUser {

    @Step("Open Home Page")
    public static HomePagePO getHomePage(WebDriver driver) {
        return new HomePagePO(driver);
    }

    @Step("Open Register Page")
    public static RegisterPO getRegisterPage(WebDriver driver) {
        return new RegisterPO(driver);
    }

    @Step("Open Login Page")
    public static LoginPO getLoginPage(WebDriver driver) {
        return new LoginPO(driver);
    }

    @Step("Open Customer Info Page")
    public static CustomerInfoPO getCustomerInfoPage(WebDriver driver) {
        return new CustomerInfoPO(driver);
    }

    @Step("Open Change Password Page")
    public static ChangePasswordPO getChangePasswordPage(WebDriver driver) {
        return new ChangePasswordPO(driver);
    }

    @Step("Open Address Page")
    public static AddressesPO getAddressesPage(WebDriver driver) {
        return new AddressesPO(driver);
    }

    @Step("Open Product Detail Page")
    public static ProductDetailPO getProductDetailPage(WebDriver driver) {
        return new ProductDetailPO(driver);
    }

    @Step("Open Product Review Page")
    public static ProductReviewPO getProductReviewPage(WebDriver driver) {
        return new ProductReviewPO(driver);
    }

    @Step("Open My Product Review Page")
    public static MyProductReviewPO getMyProductReviewPage(WebDriver driver) {
        return new MyProductReviewPO(driver);
    }

    @Step("Open Search Page")
    public static SearchPO getSearchPage(WebDriver driver) {
        return new SearchPO(driver);
    }

    @Step("Open Products Page")
    public static ProductPO getProductPage(WebDriver driver) {
        return new ProductPO(driver);
    }

    @Step("Open Wishlist Page")
    public static WishlistPO getWishlistPage(WebDriver driver) {
        return new WishlistPO(driver);
    }

    @Step("Open Cart Page")
    public static CartPO getCartPage(WebDriver driver) {
        return new CartPO(driver);
    }

    @Step("Open Compare Product Page")
    public static CompareProductPO getCompareProductPage(WebDriver driver) {
        return new CompareProductPO(driver);
    }

    @Step("Open Recently Reviewed Products Page")
    public static RecentlyViewedProductsPO getRecentlyViewedProductsPage(WebDriver driver) {
        return new RecentlyViewedProductsPO(driver);
    }

    @Step("Open Checkout Page")
    public static CheckoutPO getCheckoutPage(WebDriver driver) {
        return new CheckoutPO(driver);
    }

    @Step("Open Order Information Page")
    public static OrderInformationPO getOrderInformationPage(WebDriver driver) {
        return new OrderInformationPO(driver);
    }

    @Step("Open Order History Page")
    public static OrderHistoryPO getOrderHistoryPage(WebDriver driver) {
        return new OrderHistoryPO(driver);
    }
}

