package Avic.Tests;

import DataProvider.TestDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ProductPageTests extends BaseTest
{
    private final String expectedSuccessPopup = "//div[@id='modalAlert']//div[contains(text(),'Успешно!')]";
    private final String emailInputErrorLabel = "//div[@class=\"form-field input-field error\"]";

    @Test(priority = 1, dataProviderClass = TestDataProvider.class, dataProvider = "data-provider")
    public void AddToFavouriteWithoutRegistrationTest(String email, Boolean status) //поменять на сообщить о наличии
    {
        getHomePage().clickOnProductCatalogueButton();
        getHomePage().moveMousePointerToElement(getHomePage().getGadzhetsMenuItemIntoCatalogueMenu());
        getHomePage().waitForVisibilityOfElement(5, getHomePage().getQuadrocoptersMenuItem());
        getHomePage().moveMousePointerToElement(getHomePage().getQuadrocoptersMenuItem());
        getHomePage().waitForVisibilityOfElement(5, getHomePage().getXiaomiQuadrocoptersButtonIntoCatalogue());
        getHomePage().clickOnXiaomiQuadrocoptersButton();
        getXiaomiGadzhetsPage().ClickOnFirstTellMeWhenProductWillExistButton();
        getXiaomiGadzhetsPage().waitForVisibilityOfElement(5, getXiaomiGadzhetsPage().getProductIsAbsendPopup());
        getXiaomiGadzhetsPage().FillProductIsAbsendPopupEmailInputField(email);
        if (status) assertTrue(getDriver().findElement(By.xpath(expectedSuccessPopup)).isDisplayed());
        else assertTrue(getDriver().findElement(By.xpath(emailInputErrorLabel)).isDisplayed());
    }
}
