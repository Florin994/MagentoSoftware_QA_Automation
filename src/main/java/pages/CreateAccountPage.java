package pages;

import data.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage {

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastNameField;
    @FindBy(xpath = "//input[@id='email_address']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@id='password-confirmation']")
    private WebElement confirmPasswordField;
    @FindBy(xpath = "//button[@class='action submit primary']")
    private WebElement createAccountButton;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public void inputFirstName() {
        setText(firstNameField, Constants.FIRST_NAME.getValue());
    }

    public void inputLastName() {
        setText(lastNameField, Constants.LAST_NAME.getValue());
    }

    public void inputEmail() {
        setText(emailField, Constants.RANDOM_EMAIL.getValue());
    }

    public void inputPassword() {
        setText(passwordField, Constants.PASSWORD.getValue());
    }

    public void inputConfirmPassword() {
        setText(confirmPasswordField, Constants.PASSWORD.getValue());
    }

    public void clickCreateAccountButton() {
        clickElement(createAccountButton);
    }

    public void inputAllFields() {
        inputFirstName();
        inputLastName();
        inputEmail();
        inputPassword();
        inputConfirmPassword();
    }
}
