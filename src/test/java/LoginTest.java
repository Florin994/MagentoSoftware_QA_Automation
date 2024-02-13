import data.Utils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @BeforeTest
    @Override
    public void setUp() {
        super.setUp();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void logInTest() {
        loginPage.clickSingInButton();
        loginPage.inputEmail();
        loginPage.inputPassword();
        Utils.scroll(driver, 0, 500);
        loginPage.clickLoginSummitButton();
        Utils.waitInSeconds(2);
        loginPage.checkIfLoginIsCompleted();
    }

    @Test
    public void loginEmailAndPasswordAreEmptyTest() {
        loginPage.clickSingInButton();
        Utils.waitInSeconds(1);
        Utils.scroll(driver, 0, 500);
        loginPage.clickLoginSummitButton();
        loginPage.checkIfEmailIsEmpty();
        loginPage.checkIfPasswordIsEmpty();
    }

    @Test
    public void loginEmailEmptyTest() {
        loginPage.clickSingInButton();
        Utils.waitInSeconds(1);
        loginPage.inputPassword();
        Utils.scroll(driver, 0, 500);
        loginPage.clickLoginSummitButton();
        loginPage.checkIfEmailIsEmpty();
    }

    @Test
    public void loginPasswordEmptyTest() {
        loginPage.clickSingInButton();
        Utils.waitInSeconds(1);
        loginPage.inputEmail();
        Utils.scroll(driver, 0, 500);
        loginPage.clickLoginSummitButton();
        loginPage.checkIfPasswordIsEmpty();
    }

    @Test
    public void loginIncorrectPasswordTest() {
        loginPage.clickSingInButton();
        loginPage.inputEmail();
        loginPage.inputIncorrectPassword();
        Utils.scroll(driver, 0, 500);
        loginPage.clickLoginSummitButton();
        Utils.waitInSeconds(2);
        loginPage.checkIfPasswordOrEmailIsCorrect();
    }

    @Test
    public void loginIncorrectEmailTest() {
        loginPage.clickSingInButton();
        loginPage.inputIncorrectEmail();
        loginPage.inputPassword();
        Utils.scroll(driver, 0, 500);
        loginPage.clickLoginSummitButton();
        Utils.waitInSeconds(2);
        loginPage.checkIfPasswordOrEmailIsCorrect();
    }
}
