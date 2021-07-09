package commons;

import pageObjects.User.*;
import org.openqa.selenium.WebDriver;
import pageUIs.User.ProductDetailPageUI;

public class PageGeneratorManagerUser {

    public static HomePagePO getHomePage(WebDriver driver) {
        return new HomePagePO(driver);
    }

    public static RegisterPO getRegisterPage(WebDriver driver) {
        return new RegisterPO(driver);
    }

    public static LoginPO getLoginPage(WebDriver driver) {
        return new LoginPO(driver);
    }

    public static CustomerInfoPO getCustomerInfoPage(WebDriver driver) {
        return new CustomerInfoPO(driver);
    }

    public static ChangePasswordPO getChangePasswordPage(WebDriver driver) {
        return new ChangePasswordPO(driver);
    }

    public static AddressesPO getAddressesPage(WebDriver driver) {
        return new AddressesPO(driver);
    }

    public static ProductDetailPO getProductDetailPage(WebDriver driver) {
        return new ProductDetailPO(driver);
    }

    public static ProductReviewPO getProductReviewPage(WebDriver driver) {
        return new ProductReviewPO(driver);
    }

    public static MyProductReviewPO getMyProductReviewPage(WebDriver driver) {
        return new MyProductReviewPO(driver);
    }

    public static SearchPO getSearchPage(WebDriver driver) {
        return new SearchPO(driver);
    }

    public static ProductPO getProductPage(WebDriver driver) {
        return new ProductPO(driver);
    }

    public static WishlistPO getWishlistPage(WebDriver driver) {
        return new WishlistPO(driver);
    }

    public static CartPO getCartPage(WebDriver driver) {
        return new CartPO(driver);
    }

    public static CompareProductPO getCompareProductPage(WebDriver driver) {
        return new CompareProductPO(driver);
    }

    public static RecentlyViewedProductsPO getRecentlyViewedProductsPage(WebDriver driver) {
        return new RecentlyViewedProductsPO(driver);
    }

    public static CheckoutPO getCheckoutPage(WebDriver driver) {
        return new CheckoutPO(driver);
    }

    public static OrderInformationPO getOrderInformationPage(WebDriver driver) {
        return new OrderInformationPO(driver);
    }

    public static OrderHistoryPO getOrderHistoryPage(WebDriver driver) {
        return new OrderHistoryPO(driver);
    }
}
