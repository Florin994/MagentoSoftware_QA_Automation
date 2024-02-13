package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FooterPage extends BasePage {
    @FindBy(xpath = "//a[contains(text(),'Contact us')]")
    WebElement contactUsButton;
    @FindBy(xpath = "(//h2[@class='elementor-heading-title elementor-size-default'])[1]")
    WebElement contactUsValidator;

    public FooterPage(WebDriver driver) {
        super(driver);
    }

    public void clickContactUsButton() {
        clickElement(contactUsButton);
    }

    public String contactUsValidator() {
        return contactUsValidator.getText();
    }
}
