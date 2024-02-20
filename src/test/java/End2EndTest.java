import data.Utils;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ShippingPage;

public class End2EndTest extends BaseTest {
    @Test(description = """
            Steps:
            Step1: Go to Magento Software URL
            Step2: Click SignIn Button
            Step3: Input valid data in login fields
            Step4: Click Submit Button
            Step5: Click men category button
            Step6: Click tops subcategory button
            Step7: Scroll down
            Step8: Click on wanted item
            Step9: Scroll down
            Step10: Click XL size button
            Step11: Click blue color button
            Step12: Clear quantity field
            Step13: Insert "3" in qty field
            Step14: Scroll down
            Step15: Click add to cart button
            Step16: Scroll up
            Step17: Click checkout button
            Step18: Scroll down
            Step19: Input all shipping fields
            Step20: Click shipping method button
            Step21: Scroll down
            Step22: Click next button
            Step23: Scroll down
            Step24: Click place order button
            """)
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
