import org.testng.annotations.Test;
import pages.CreateAccountPage;

public class CreateAccountTest extends BaseTest {
    @Test(description = """
            Steps:
            Step1: Go to Magento Software URL
            Step2: Click create account button
            Step3: Input all fields required
            Step4: Click submit create account button
            """)
    public void createNewAccountTest() {
        homePage.clickCreateAccountButton();
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.inputAllFields();
        createAccountPage.clickCreateAccountButton();
    }
}
