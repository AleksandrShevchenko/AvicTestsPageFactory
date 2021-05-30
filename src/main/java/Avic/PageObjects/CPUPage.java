package Avic.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CPUPage extends  ProductPage
{
    public CPUPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//label[@for=\"fltr-proizvoditel-intel\"]")
    private WebElement checkBoxIntelManufacturer;
    public WebElement getCheckBoxIntelManufacturer() {return checkBoxIntelManufacturer;}

    @FindBy(xpath = "//input[@id=\"fltr-kolichestvo-yader-2\"]//..//..//../p[contains(@class, 'filter')]")
    private WebElement coreAmountOptionsListButton;
    public WebElement getCoreAmountOptionsListButton() {return coreAmountOptionsListButton; }

    @FindBy(xpath = "//span[contains(@data-counter,'yader_6')]/../a[@class='filter-link']")
    private WebElement filterSixCoresAmount;
    public WebElement getFilterSixCoresAmount() {return filterSixCoresAmount;}

    @FindBy(xpath = "//input[@id=\"fltr-taktovaya-chastota-1-5-2-ggc\"]/..//..//../p[contains(@class, 'filter')]")
    private WebElement clockSpeedOpenOptionsListButton;
    public WebElement getClockSpeedOpenOptionsListButton() {return clockSpeedOpenOptionsListButton;}

    @FindBy(xpath = "//span[contains(@data-counter,'bolee-3-ggc')]/../a[@class=\"filter-link\"]")
    private WebElement clockSpeedOpenOptionsListButtonMoreThan3GHZCheckbox;
    public WebElement getClockSpeedOpenOptionsListButtonMoreThan3GHZCheckbox() {return clockSpeedOpenOptionsListButtonMoreThan3GHZCheckbox;}

    @FindBy(xpath = "//p[contains(text(), 'Семейство процессора')]/..//a[@class=\"filter-btn-more js-filter-more\"]")
    private WebElement showAllCPUFamiliesButton;

    @FindBy(xpath = "//p[contains(text(), 'Тип разъема')]/..//a[@class=\"filter-btn-more js-filter-more\"]")
    private WebElement showAllConnectorTypesButton;

    @FindBy(xpath = "//span[contains(@data-counter,'core-i5')]/../a[@class='filter-link']")
    private WebElement intelCoreI5Filter;
    public WebElement getIntelCoreI5Filter() {return intelCoreI5Filter;}

    @FindBy(xpath = "//span[contains(@data-counter,'socket-1151')]/../a[@class='filter-link']")
    private WebElement socket1151Button;
    public WebElement getSocket1151Button() {return socket1151Button;}

    public void clickOnSocket1151Button()
    {
        getSocket1151Button().click();
        waitForPageLoad(10);
    }
    public void clickOnShowAllTypesButton()
    {
        showAllConnectorTypesButton.click();
    }

    public void clickOnIntelCoreI5CheckBox()
    {
        intelCoreI5Filter.click();
        waitForPageLoad(10);
    }
    public void clickOnShowAllProcessorFamilies()
    {
        showAllCPUFamiliesButton.click();
    }
    public void clickOnTheIntelCheckBox()
    {
        checkBoxIntelManufacturer.click();
        waitForPageLoad(10);
    }

    public void clickOnTheCoreCountOpenOptionsListButton()
    {
        coreAmountOptionsListButton.click();
    }

    public void clickOnTheSixCoresAmountCheckbox()
    {
        filterSixCoresAmount.click();
        waitForPageLoad(10);
    }

    public void clickOnTheClockSpeedOpenOptionsListButton()
    {
        getClockSpeedOpenOptionsListButton().click();
    }

    public void clickOnTheClockSpeedMoreThan3GHZButton()
    {
        clockSpeedOpenOptionsListButtonMoreThan3GHZCheckbox.click();
        waitForPageLoad(10);
    }











}
