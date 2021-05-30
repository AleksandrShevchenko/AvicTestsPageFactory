package Avic.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

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
    public WebElement getGadzhetsMenuItemIntoCatalogueMenu()
    {
        return productCatalogueMenuItemGadzhets;
    }

    @FindBy(xpath = "//a[@href=\"https://avic.ua/kvadrokopteryi\"][@class=\"sidebar-item\"]")
    private WebElement getProductCatalogueMenuItemGadzhetsQuadrocopters;
    public WebElement getQuadrocoptersMenuItem()
    {
        return getProductCatalogueMenuItemGadzhetsQuadrocopters;
    }

    @FindBy(xpath = "//li[@class='single-hover-block']/a[@href='/kvadrokopteryi/proizvoditel--xiaomi']")
    private WebElement xiaomiQuadrocoptersButtonIntoCatalogue;
    public WebElement getXiaomiQuadrocoptersButtonIntoCatalogue() {return xiaomiQuadrocoptersButtonIntoCatalogue;}

    public void clickOnProductCatalogueButton()
    {
        productCatalogueButton.click();
    }
    public void clickOnXiaomiQuadrocoptersButton()
    {
        xiaomiQuadrocoptersButtonIntoCatalogue.click();
    }
    public void clickOnQuadrocopterMenuItem()
    {
        getQuadrocoptersMenuItem().click();
    }


}
