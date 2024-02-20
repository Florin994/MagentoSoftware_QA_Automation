import data.Utils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @BeforeTest(description = """
            Steps:
            Step1: Go to Magento Software URL
            Step2: maximize window
            """)
    @Override
    public void setUp() {
        super.setUp();
        loginPage = new LoginPage(driver);
    }

    @Test(description = """
            Steps:
            Step1: Go to Magento Software URL
            Step2: Click sing in button
            Step3: Input email address
            Step4: Input password
            Step5: Scroll down
            Step6: Click submit button
            Step7: Check if login is completed
            """)
    public void logInTest() {
        loginPage.clickSingInButton();
        loginPage.inputEmail();
        loginPage.inputPassword();
        Utils.scroll(driver, 0, 500);
        loginPage.clickLoginSubmitButton();
        Utils.waitInSeconds(2);
        Assert.assertTrue(loginPage.checkIfLoginIsCompleted(), "Error: login is not completed");
    }

    @Test(description = """
            Steps:
            Step1: Go to Magento Software URL
            Step2: Click sing in button
            Step3: Click submit button
            Step4: Scroll down
            Step5: Check if error message for empty emil field appears
            Step6: Check if error message for empty password field appears
            """)
    public void loginEmailAndPasswordAreEmptyTest() {
        loginPage.clickSingInButton();
        Utils.waitInSeconds(1);
        Utils.scroll(driver, 0, 500);
        loginPage.clickLoginSubmitButton();
        Assert.assertTrue(loginPage.checkIfEmailIsEmpty(), "Error: email field is not empty");
        Assert.assertTrue(loginPage.checkIfPasswordIsEmpty(), "Error: password field is not empty");
    }

    @Test(description = """
            Steps:
            Step1: Go to Magento Software URL
            Step2: Click sing in button
            Step3: Input password
            Step4: Scroll down
            Step5: Click submit button
            Step6: Check if error message for empty email field appears
            """)
    public void loginEmailEmptyTest() {
        loginPage.clickSingInButton();
        Utils.waitInSeconds(1);
        loginPage.inputPassword();
        Utils.scroll(driver, 0, 500);
        loginPage.clickLoginSubmitButton();
        Assert.assertTrue(loginPage.checkIfEmailIsEmpty(), "Error: email field is not empty");
    }

    @Test(description = """
            Steps:
            Step1: Go to Magento Software URL
            Step2: Click sing in button
            Step3: Input email
            Step4: Scroll down
            Step5: Click submit button
            Step6: Check if error message for empty password field appears
            """)
    public void loginPasswordEmptyTest() {
        loginPage.clickSingInButton();
        Utils.waitInSeconds(1);
        loginPage.inputEmail();
        Utils.scroll(driver, 0, 500);
        loginPage.clickLoginSubmitButton();
        Assert.assertTrue(loginPage.checkIfPasswordIsEmpty(), "Error: password field is not empty");
    }

    @Test(description = """
            Steps:
            Step1: Go to Magento Software URL
            Step2: Click sing in button
            Step3: Input email
            Step4: Input incorrect password
            Step5: Scroll down
            Step6: Click submit button
            Step7: Check if error message for incorrect password appears
            """)
    public void loginIncorrectPasswordTest() {
        loginPage.clickSingInButton();
        loginPage.inputEmail();
        loginPage.inputIncorrectPassword();
        Utils.scroll(driver, 0, 500);
        loginPage.clickLoginSubmitButton();
        Utils.waitInSeconds(2);
        Assert.assertTrue(loginPage.checkIfPasswordOrEmailIsCorrect(), "Error: password is incorrect");
    }

    @Test(description = """
            Steps:
            Step1: Go to Magento Software URL
            Step2: Click sing in button
            Step3: Input incorrect email
            Step4: Input password
            Step5: Scroll down
            Step6: Click submit button
            Step7: Check if error message for incorrect email appears
            """)
    public void loginIncorrectEmailTest() {
        loginPage.clickSingInButton();
        loginPage.inputIncorrectEmail();
        loginPage.inputPassword();
        Utils.scroll(driver, 0, 500);
        loginPage.clickLoginSubmitButton();
        Utils.waitInSeconds(2);
        Assert.assertTrue(loginPage.checkIfPasswordOrEmailIsCorrect(), "Error: password or email is incorrect");
    }
}
