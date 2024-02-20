package pages;

import data.Constants;
import data.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//a[contains(text(),'Sign In')]")
    private WebElement signInButton;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement inputEmailField;
    @FindBy(xpath = "(//input[@id='pass'])[1]")
    private WebElement inputPasswordField;
    @FindBy(xpath = "(//button[@id='send2'])[1]")
    private WebElement loginSummitButton;
    @FindBy(css = ".logged-in")
    private WebElement loginValidatorField;
    @FindBy(xpath = "//div[@id='email-error']")
    private WebElement emailError;
    @FindBy(xpath = "//div[@id='pass-error']")
    private WebElement passwordError;
    @FindBy(xpath = "//div[@class='message-error error message']")
    private WebElement incorrectPasswordOrEmailError;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickSingInButton() {
        clickElement(signInButton);
    }

    public void inputEmail() {
        setText(inputEmailField, Constants.LOGIN_USER.getValue());
    }

    public void inputIncorrectEmail() {
        setText(inputEmailField, Constants.INCORRECT_LOGIN_USER.getValue());
    }

    public void inputPassword() {
        setText(inputPasswordField, Constants.PASSWORD.getValue());
    }

    public void inputIncorrectPassword() {
        setText(inputPasswordField, Constants.INCORRECT_PASSWORD.getValue());
    }

    public void clickLoginSubmitButton() {
        clickElement(loginSummitButton);
    }

    public boolean checkIfLoginIsCompleted() {
        String loginValidator = "Welcome";
        return loginValidatorField.getText().contains(loginValidator);
    }

    public boolean checkIfEmailIsEmpty() {
        String emailValidator = "This is a required field.";
        return emailError.getText().contains(emailValidator);
    }

    public boolean checkIfPasswordIsEmpty() {
        String passwordValidator = "This is a required field.";
        return emailError.getText().contains(passwordValidator);
    }

    public boolean checkIfPasswordOrEmailIsCorrect() {
        String errorText = "The account sign-in was incorrect or your account is disabled temporarily." +
                " Please wait and try again later.";
        return incorrectPasswordOrEmailError.getText().contains(errorText);
    }

    public String getIncorrectPasswordError() {
        return incorrectPasswordOrEmailError.getText();
    }

    public void completeLogin() {
        clickSingInButton();
        inputEmail();
        inputPassword();
        Utils.scroll(driver, 0, 500);
        clickLoginSubmitButton();
        Utils.waitInSeconds(2);
        checkIfLoginIsCompleted();
    }
}
