package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "(//a[contains(text(),'Create an Account')])[1]")
    WebElement createAccountButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickCreateAccountButton() {
        clickElement(createAccountButton);
    }
}
