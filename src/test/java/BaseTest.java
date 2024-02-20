import data.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import pages.HomePage;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeTest(description = """
            Steps:
            Step1: Go to Magento Software URL
            Step2: maximize window
            """)
    public void setUp() {
        driver = new FirefoxDriver();
        homePage = new HomePage(driver);
        driver.get(Constants.URL.getValue());
        driver.manage().window().maximize();
    }
}
