package framework.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitHelper {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final int TIME_OUT = 10;


    public WebDriverWaitHelper(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, TIME_OUT);
    }

    public void waitElementUntilVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilTextToBePresent(WebElement element, String text){
        wait.until(ExpectedConditions.textToBePresentInElement(element,text));
    }

    public void waitLocatorUntilVisible(String locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void waitLocatorUntilInvisible(String locator){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
    }

    public void waitElementUntilInvisible(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
