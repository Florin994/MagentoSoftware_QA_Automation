import data.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FooterPage;
import pages.LoginPage;

public class FooterTest extends BaseTest {
    @Test
    public void goToContactTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSingInButton();
        loginPage.inputEmail();
        loginPage.inputPassword();
        Utils.scroll(driver, 0, 500);
        loginPage.clickLoginSummitButton();
        Utils.scroll(driver, 0, 2500);
        FooterPage footerPage = new FooterPage(driver);
        footerPage.clickContactUsButton();
        String actualText = footerPage.contactUsValidator();
        Assert.assertEquals(actualText, "Contact", "Error: incorrect text");
    }
}
