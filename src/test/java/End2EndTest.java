import data.Utils;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ShippingPage;

public class End2EndTest extends BaseTest {
    @Test
    public void placeOrderTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.completeLogin();
        CartPage cartPage = new CartPage(driver);
        cartPage.completeCart();
        Utils.waitInSeconds(2);
        ShippingPage shippingPage = new ShippingPage(driver);
        shippingPage.completeShipping();
        Utils.waitInSeconds(2);
        Utils.scroll(driver, 0, 2000);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        shippingPage.clickNextButton();
        Utils.waitInSeconds(2);
        Utils.scroll(driver, 0, 500);
        checkoutPage.clickPlaceOrderButton();
        Utils.waitInSeconds(5);
    }
}
