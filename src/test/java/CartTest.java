import data.Utils;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;

public class CartTest extends BaseTest {
    private CartPage cartPage;
    private LoginPage loginPage;

    @Test
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
        cartPage.checkIfCartIsEmpty();
    }

    @Test
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
