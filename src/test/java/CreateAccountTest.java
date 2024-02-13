import org.testng.annotations.Test;
import pages.CreateAccountPage;

public class CreateAccountTest extends BaseTest {
    @Test
    public void createNewAccountTest() {
        homePage.clickCreateAccountButton();
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.inputAllFields();
        createAccountPage.clickCreateAccountButton();
    }
}
