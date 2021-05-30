package Avic.PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage
{
    public ProductPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//input[@class=\"form-control form-control-min\"]")
    private WebElement minPriceOptionInputField;

    @FindBy(xpath = "//input[@class=\"form-control form-control-max\"]")
    private WebElement maxPriceOptionInputField;
    @FindBy(xpath = "//a[@class=\"fancybox main-btn main-btn--orange main-btn--middle\"]")
    private List<WebElement> informWhenProductWillBeAvailableButtons;   //Поменять название

    @FindBy(id="js_availableProductNotification")
    private WebElement productIsAbsentPopup;
    public WebElement getProductIsAbsentPopup()
    {
        return productIsAbsentPopup;
    }

    @FindBy(name="email")
    private WebElement emailInputField;

    @FindBy(xpath = "//div[@class=\"form-group filter-group js_filter_parent open-filter-tooltip\"]//span[@class=\"filter-tooltip-inner\"]")
    private WebElement showProductsByChosenPriceButton;
    public WebElement getShowProductsByChosenPriceButton(){return showProductsByChosenPriceButton;}

    @FindBy(xpath = "//a[@class=\"prod-cart__buy\"]")
    private List<WebElement> buyButtonsList;

    @FindBy(xpath = "//div[@id=\"js_cart\"]")
    private WebElement cartPopup;
    public WebElement getCartPopup(){return cartPopup;}

    @FindBy(xpath = "//a[@class=\"main-btn  main-btn--green\"]")
    private WebElement cartPopupConfirmationButton;
    public WebElement getCartPopupConfirmationButton(){return cartPopupConfirmationButton;}

    @FindBy(xpath = "//label[@for=\"fltr-1\"]")
    private WebElement isAvailableCheckbox;

    public void clickOnIsAvailableCheckBox()
    {
        isAvailableCheckbox.click();
        waitForPageLoad(10);
    }
    public void ClickOnFirstInformWhenProductWillBeAvailableButton()
    {
        informWhenProductWillBeAvailableButtons.get(0).click();
    }

    public void FillProductIsAbsentPopupEmailInputField(String email)
    {
        emailInputField.sendKeys(email, Keys.ENTER);
    }

    public void FillMinPriceOption(int minValue)
    {
        minPriceOptionInputField.clear();
        minPriceOptionInputField.sendKeys(""+minValue, Keys.ENTER);
    }
    public void FillMaxPriceOption(int maxValue)
    {
        maxPriceOptionInputField.clear();
        maxPriceOptionInputField.sendKeys(""+maxValue, Keys.ENTER);
    }

    public void clickOnPriceOptionsConfirmationButton()
    {
        showProductsByChosenPriceButton.click();
        waitForPageLoad(10);
    }
}
