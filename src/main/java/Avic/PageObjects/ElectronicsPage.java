package Avic.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElectronicsPage extends ProductPage
{
    public ElectronicsPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//ul[@class=\"brand-box__list\"]//a[contains(@href,'proczessoryi')]")
    private WebElement processorButton;

    public void clickOnProcessorButton()
    {
        processorButton.click();
    }


}
