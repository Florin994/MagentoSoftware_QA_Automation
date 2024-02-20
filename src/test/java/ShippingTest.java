import data.Utils;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ShippingPage;

public class ShippingTest extends BaseTest {
    private LoginPage loginPage;
    private CartPage cartPage;

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
            """)
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
            """)
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
