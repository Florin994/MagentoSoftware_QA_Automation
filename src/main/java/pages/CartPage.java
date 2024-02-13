package pages;

import data.Constants;
import data.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    @FindBy(xpath = "//a[@class='action showcart']")
    private WebElement showCartButton;
    @FindBy(xpath = "//a[@class='action delete']")
    private WebElement emptyCartButton;
    @FindBy(xpath = "//button[@class='action-primary action-accept']")
    private WebElement confirmEmptyCartButton;
    @FindBy(xpath = "//div[@id='minicart-content-wrapper']")
    private WebElement emptyCartField;
    @FindBy(xpath = "//a[@id='ui-id-5']")
    private WebElement menCategoryButton;
    @FindBy(xpath = "//a[contains(text(),'Tops')]")
    private WebElement topsSubCategoryButton;
    @FindBy(xpath = "(//li[@class='item product product-item'])[1]")
    private WebElement wantedItem;
    @FindBy(xpath = "//div[@id='option-label-size-143-item-170']")
    private WebElement selectedSizeButton;
    @FindBy(xpath = "//div[@id='option-label-color-93-item-50']")
    private WebElement colorButton;
    @FindBy(xpath = "//input[@id='qty']")
    private WebElement qtyField;
    @FindBy(xpath = "//button[@id='product-addtocart-button']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//button[@id='top-cart-btn-checkout']")
    private WebElement proceedToCheckoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickShowCartButton() {
        clickElement(showCartButton);
    }

    public void clickEmptyCartButton() {
        clickElement(emptyCartButton);
    }

    public void clickConfirmEmptyCartButton() {
        clickElement(confirmEmptyCartButton);
    }

    public boolean checkIfCartIsEmpty() {
        String emptyCartFieldValidator = "You have no items in your shopping cart.";
        return emptyCartField.getText().contains(emptyCartFieldValidator);
    }

    public void clickMenCategoryButton() {
        clickElement(menCategoryButton);
    }

    public void clickTopsSubCategoryButton() {
        clickElement(topsSubCategoryButton);
    }

    public void clickWantedItem() {
        clickElement(wantedItem);
    }

    public void clickSelectedSizeButton() {
        clickElement(selectedSizeButton);
    }

    public void clickColorButton() {
        clickElement(colorButton);
    }

    public void clearQtyField() {
        clearField(qtyField);
    }

    public void setQtyField() {
        setText(qtyField, Constants.QTY.getValue());
    }

    public void clickAddToCartButton() {
        clickElement(addToCartButton);
    }

    public void clickProceedToCheckoutButton() {
        clickElement(proceedToCheckoutButton);
    }

    public void completeCart() {
        clickMenCategoryButton();
        clickTopsSubCategoryButton();
        Utils.scroll(driver, 0, 500);
        clickWantedItem();
        Utils.scroll(driver, 0, 500);
        clickSelectedSizeButton();
        clickColorButton();
        clearQtyField();
        setQtyField();
        Utils.scroll(driver, 0, 300);
        clickAddToCartButton();
        Utils.scroll(driver, 0, -800);
    }
}
