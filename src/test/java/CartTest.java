import data.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;

public class CartTest extends BaseTest {
    private CartPage cartPage;
    private LoginPage loginPage;

    @Test(description = """
            Steps:
            Step1: Go to Magento Software URL
            Step2: Click SignIn Button
            Step3: Input valid data in login fields
            Step4: Click Submit Button
            Step5: Click show cart button
            Step6: Click empty cart button
            Step7: Click confirm empty cart
            Step8: Confirm if the cart is empty
            """)
    public void emptyCartTest() {
        loginPage = new LoginPage(driver);
        loginPage.completeLogin();
        Utils.waitInSeconds(2);
        cartPage = new CartPage(driver);
        cartPage.clickShowCartButton();
        Utils.waitInSeconds(1);
        cartPage.clickEmptyCartButton();
        Utils.waitInSeconds(2);
        cartPage.clickConfirmEmptyCartButton();
        Utils.waitInSeconds(3);
        Assert.assertTrue(cartPage.checkIfCartIsEmpty(), "Error: the cart is not empty");
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
            """)
    public void addToCartTest() {
        loginPage = new LoginPage(driver);
        loginPage.completeLogin();
        Utils.waitInSeconds(2);
        cartPage = new CartPage(driver);
        cartPage.clickMenCategoryButton();
        cartPage.clickTopsSubCategoryButton();
        Utils.scroll(driver, 0, 500);
        cartPage.clickWantedItem();
        Utils.scroll(driver, 0, 500);
        cartPage.clickSelectedSizeButton();
        cartPage.clickColorButton();
        cartPage.clearQtyField();
        cartPage.setQtyField();
        Utils.scroll(driver, 0, 300);
        cartPage.clickAddToCartButton();
        Utils.scroll(driver, 0, -800);
    }
}
