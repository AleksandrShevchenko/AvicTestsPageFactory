package Avic.Tests;

import DataProvider.TestDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class ProductPageTests extends BaseTest
{
    private final String EXPECTED_SUCCESS_POPUP = "//div[@id='modalAlert']//div[contains(text(),'Успешно!')]";
    private final String EMAIL_INPUT_ERROR_LABEL = "//div[@class=\"form-field input-field error\"]";
    private final String EXPECTED_URL = "https://avic.ua/proczessoryi/available--on_proizvoditel--intel_semejstvo-processora--intel-core-i5_tip-razema--socket-1151_kolichestvo-yader--6_taktovaya-chastota--bolee-3-ggc";

    @Test(priority = 1, dataProviderClass = TestDataProvider.class, dataProvider = "checkTheEmailValidationOnTheInformWhenProductWillBeAvailableFormData")
    public void checkTheEmailValidationOnTheInformWhenProductWillBeAvailableForm(String email, Boolean expected)
    {
        getHomePage().clickOnProductCatalogueButton();
        getHomePage().moveMousePointerToElement(getHomePage().getGadgetsMenuItemIntoCatalogueMenu());
        getHomePage().waitForVisibilityOfElement(5, getHomePage().getDronesMenuItem());
        getHomePage().moveMousePointerToElement(getHomePage().getDronesMenuItem());
        getHomePage().waitForVisibilityOfElement(5, getHomePage().getXiaomiDronesButtonIntoCatalogue());
        getHomePage().clickOnXiaomiDronesButton();
        getXiaomiGadgetsPage().ClickOnFirstInformWhenProductWillBeAvailableButton();
        getXiaomiGadgetsPage().waitForVisibilityOfElement(5, getXiaomiGadgetsPage().getProductIsAbsentPopup());
        getXiaomiGadgetsPage().FillProductIsAbsentPopupEmailInputField(email);
        if (expected) assertTrue(getDriver().findElement(By.xpath(EXPECTED_SUCCESS_POPUP)).isDisplayed());
        else assertTrue(getDriver().findElement(By.xpath(EMAIL_INPUT_ERROR_LABEL)).isDisplayed());
    }

    @Test(priority = 2)
    public void checkIfURLChangesWhileFilterProductCheckBoxIsUsed()
    {
        getHomePage().clickOnProductCatalogueButton();
        getHomePage().moveMousePointerToElement(getHomePage().getGadgetsMenuItemIntoCatalogueMenu());
        getHomePage().clickOnComputersMenuItem();
        getElectronicsPage().clickOnProcessorButton();
        getElectronicsPage().waitForPageLoad(10);
        getCPUPage().clickOnTheIntelCheckBox();
        getCPUPage().clickOnIsAvailableCheckBox();
        getCPUPage().clickOnShowAllProcessorFamilies();
        getCPUPage().clickOnIntelCoreI5CheckBox();
        getCPUPage().clickOnShowAllTypesButton();
        getCPUPage().clickOnSocket1151Button();
        getCPUPage().clickOnTheCoreCountOpenOptionsListButton();
        getCPUPage().waitForVisibilityOfElement(10, getCPUPage().getFilterSixCoresAmount());
        getCPUPage().clickOnTheSixCoresAmountCheckbox();
        getCPUPage().clickOnTheClockSpeedOpenOptionsListButton();
        getCPUPage().waitForVisibilityOfElement(10, getCPUPage().getClockSpeedOpenOptionsListButtonMoreThan3GHZCheckbox());
        getCPUPage().clickOnTheClockSpeedMoreThan3GHZButton();
        assertEquals(getDriver().getCurrentUrl(), EXPECTED_URL);
    }

    @Test(priority = 3, dataProviderClass = TestDataProvider.class, dataProvider = "checkIfFilterProductsPriceSliderWorkCorrectlyData")
    public void checkIfFilterProductsPriceSliderWorkCorrectly(int min, int max)
    {
        getHomePage().clickOnProductCatalogueButton();
        getHomePage().moveMousePointerToElement(getHomePage().getGadgetsMenuItemIntoCatalogueMenu());
        getHomePage().waitForVisibilityOfElement(5, getHomePage().getDronesMenuItem());
        getHomePage().clickOnDronesMenuItem();
        getElectronicsPage().waitForPageLoad(10);

        getXiaomiGadgetsPage().FillMinPriceOption(min);
        getXiaomiGadgetsPage().waitForVisibilityOfElement(10, getXiaomiGadgetsPage().getShowProductsByChosenPriceButton());
        getXiaomiGadgetsPage().clickOnPriceOptionsConfirmationButton();

        getXiaomiGadgetsPage().FillMaxPriceOption(max);
        getXiaomiGadgetsPage().waitForVisibilityOfElement(10, getXiaomiGadgetsPage().getShowProductsByChosenPriceButton());
        getXiaomiGadgetsPage().clickOnPriceOptionsConfirmationButton();

        List<WebElement> webElementList = getDriver().findElements(By.xpath("//div[@class=\"prod-cart__prise-new\"]"));
        for (WebElement webElement:webElementList)
        {
            assertTrue((Integer.parseInt((webElement.getText().substring(0, webElement.getText().length()-4)))>min)
                    &&(Integer.parseInt((webElement.getText().substring(0, webElement.getText().length()-4)))<max));
        }
    }
}
