package Avic.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForVisibilityOfElement(long timeToWait, WebElement webElement)
    {
        new WebDriverWait(driver,timeToWait)
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public void moveMousePointerToElement(WebElement webElement)
    {
        new Actions(driver).moveToElement(webElement).build().perform();
    }

}
