import data.Utils;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ShippingPage;

public class ShippingTest extends BaseTest {
    private LoginPage loginPage;
    private CartPage cartPage;

    @Test
    public void goToShippingPageTest() {
        loginPage = new LoginPage(driver);
        loginPage.completeLogin();
        Utils.waitInSeconds(2);
        cartPage = new CartPage(driver);
        cartPage.completeCart();
        cartPage.clickShowCartButton();
        Utils.waitInSeconds(1);
        cartPage.clickProceedToCheckoutButton();
    }

    @Test
    public void completeShippingFieldsTest() {
        loginPage = new LoginPage(driver);
        loginPage.completeLogin();
        Utils.waitInSeconds(2);
        cartPage = new CartPage(driver);
        cartPage.completeCart();
        cartPage.clickShowCartButton();
        Utils.waitInSeconds(1);
        cartPage.clickProceedToCheckoutButton();
        Utils.waitInSeconds(3);
        Utils.scroll(driver, 0, 500);
        ShippingPage shippingPage = new ShippingPage(driver);
        shippingPage.inputAllFields();
        shippingPage.clickShippingMethodButton();
        Utils.scroll(driver, 0, 1000);
    }
}
