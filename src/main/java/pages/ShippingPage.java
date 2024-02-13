package pages;

import data.Constants;
import data.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ShippingPage extends BasePage {
    @FindBy(xpath = "//input[@name='company']")
    private WebElement companyField;
    @FindBy(xpath = "//input[@name='street[0]']")
    private WebElement streetField;
    @FindBy(xpath = "//input[@name='street[1]']")
    private WebElement streetNumberField;
    @FindBy(xpath = "//input[@name='street[2]']")
    private WebElement sectorField;
    @FindBy(xpath = "//input[@name='city']")
    private WebElement cityField;
    @FindBy(xpath = "//select[@name='region_id']")
    private WebElement regionField;
    @FindBy(xpath = "//input[@name='postcode']")
    private WebElement postalCodeField;
    @FindBy(xpath = "//select[@name='country_id']")
    private WebElement countryField;
    @FindBy(xpath = "//input[@name='telephone']")
    private WebElement phoneNumberField;
    @FindBy(xpath = "(//input[@class='radio'])[2]")
    private WebElement shippingMethodButton;
    @FindBy(xpath = "//button[@class='button action continue primary']")
    WebElement nextButton;

    public void clickNextButton() {
        clickElement(nextButton);
    }

    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    public void inputCompanyField() {
        setText(companyField, Constants.COMPANY.getValue());
    }

    public void inputStreetField() {
        setText(streetField, Constants.STR.getValue());
    }

    public void inputStreetNumberField() {
        setText(streetNumberField, Constants.STR_NUMBER.getValue());
    }

    public void inputSectorField() {
        setText(sectorField, Constants.SECTOR.getValue());
    }

    public void inputCityField() {
        setText(cityField, Constants.CITY.getValue());
    }

    public void inputRegionField() {
        Select selectState = new Select(regionField);
        selectState.selectByVisibleText("New York");
    }

    public void inputPostalCodeField() {
        setText(postalCodeField, Constants.ZIP_CODE.getValue());
    }

    public void inputCountryField() {
        Select selectCountry = new Select(countryField);
        selectCountry.selectByVisibleText("United States");
    }

    public void inputPhoneNumberField() {
        setText(phoneNumberField, Constants.PHONE_NUMBER.getValue());
    }

    public void clickShippingMethodButton() {
        clickElement(shippingMethodButton);
    }

    public void inputAllFields() {
        inputCompanyField();
        inputStreetField();
        inputStreetNumberField();
        inputSectorField();
        inputCityField();
        inputRegionField();
        inputPostalCodeField();
        inputCountryField();
        inputPhoneNumberField();
    }

    public void completeShipping() {
        CartPage cartPage = new CartPage(driver);
        cartPage.clickShowCartButton();
        Utils.waitInSeconds(1);
        cartPage.clickProceedToCheckoutButton();
        Utils.waitInSeconds(3);
        Utils.scroll(driver, 0, 500);
        inputAllFields();
        clickShippingMethodButton();
        Utils.scroll(driver, 0, 1000);
    }
}
