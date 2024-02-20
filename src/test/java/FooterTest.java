import data.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FooterPage;
import pages.LoginPage;

public class FooterTest extends BaseTest {
    @Test(description = """
            Steps:
            Step1: Go to Magento Software URL
            Step2: Click SignIn Button
            Step3: Input email
            Step4: Input password
            Step5: Scroll down
            Step6: Click Submit Button
            Step7: Scroll down
            Step8: Click contact us button
                Step9: Check if "Contact" message appears
            """)
    public void goToContactTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSingInButton();
        loginPage.inputEmail();
        loginPage.inputPassword();
        Utils.scroll(driver, 0, 500);
        loginPage.clickLoginSubmitButton();
        Utils.scroll(driver, 0, 2500);
        FooterPage footerPage = new FooterPage(driver);
        footerPage.clickContactUsButton();
        String actualText = footerPage.contactUsValidator();
        Assert.assertEquals(actualText, "Contact", "Error: incorrect text");
    }
}
