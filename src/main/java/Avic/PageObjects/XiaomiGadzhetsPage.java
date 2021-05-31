package Avic.PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class XiaomiGadzhetsPage extends BasePage
{
    public XiaomiGadzhetsPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//a[@class=\"fancybox main-btn main-btn--orange main-btn--middle\"]")
    private List<WebElement> tellMeWhenProductWillExistButtons;   //Поменять название

    @FindBy(id="js_availableProductNotification")
    private WebElement productIsAbsendPopup;
    public WebElement getProductIsAbsendPopup()
    {
        return productIsAbsendPopup;
    }

    @FindBy(name="email")
    private WebElement emailInputField;

    @FindBy(id="select2-sort-gn-container")
    private WebElement sortingDropDownList;

    @FindBy(id="select2-sort-gn-result-2mb7-pricedesc")
    private WebElement DescSortingOrderMenuItemFromSortingDropDownList;

    @FindBy(xpath = "//div[@class='prod-cart__prise-new']")
    private List<WebElement> productsPriceList;

    @FindBy(xpath = "//input[@class=\"form-control form-control-min\"]")
    private WebElement minPriceOptionInputField;

    @FindBy(xpath = "class=\"form-control form-control-max\"")
    private WebElement maxPriceOptionInputField;

    public void ClickOnFirstTellMeWhenProductWillExistButton()
    {
        tellMeWhenProductWillExistButtons.get(0).click();
    }

    public void FillProductIsAbsendPopupEmailInputField(String email)
    {
        emailInputField.sendKeys(email, Keys.ENTER);
    }

    public void OpenSortingDropDownList()
    {
        sortingDropDownList.click();
    }

    public void ChooseDescSortOrder()
    {
        DescSortingOrderMenuItemFromSortingDropDownList.click();
    }

    public String chooseThePriceOfFirstProduct()
    {
           return productsPriceList.get(0).toString().substring(0, productsPriceList.get(0).toString().length()-4);
    }

    public void createOptionsFromTo(int start, int end)
    {
        minPriceOptionInputField.sendKeys(""+start);
        maxPriceOptionInputField.sendKeys(""+end, Keys.ENTER);
    }
}
