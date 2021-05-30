package Avic.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{

    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath="//span[@class='sidebar-item']")
    private WebElement productCatalogueButton;

    @FindBy(xpath = "//li[@class=\"parent js_sidebar-item\"]/a[@href=\"https://avic.ua/gadzhetyi1\"]")
    private WebElement productCatalogueMenuItemGadzhets;
    public WebElement getGadgetsMenuItemIntoCatalogueMenu()
    {
        return productCatalogueMenuItemGadzhets;
    }

    @FindBy(xpath = "//a[@href=\"https://avic.ua/kvadrokopteryi\"][@class=\"sidebar-item\"]")
    private WebElement getProductCatalogueMenuItemGadgetsDrones;
    public WebElement getDronesMenuItem()
    {
        return getProductCatalogueMenuItemGadgetsDrones;
    }

    @FindBy(xpath = "//li[@class='single-hover-block']/a[@href='/kvadrokopteryi/proizvoditel--xiaomi']")
    private WebElement xiaomiDronesButtonIntoCatalogue;
    public WebElement getXiaomiDronesButtonIntoCatalogue() {return xiaomiDronesButtonIntoCatalogue;}

    @FindBy(xpath = "//li[@class=\"parent js_sidebar-item\"]/a[@href=\"https://avic.ua/elektronika\"]")
    private WebElement computersMenuItemIntoCatalogueMenu;
    public WebElement getComputersMenuItemIntoCatalogueMenu() { return computersMenuItemIntoCatalogueMenu; }


    public void clickOnProductCatalogueButton()
    {
        productCatalogueButton.click();
    }
    public void clickOnXiaomiDronesButton()
    {
        xiaomiDronesButtonIntoCatalogue.click();
    }
    public void clickOnDronesMenuItem()
    {
        getDronesMenuItem().click();
    }
    public void clickOnComputersMenuItem() {getComputersMenuItemIntoCatalogueMenu().click();}
}
