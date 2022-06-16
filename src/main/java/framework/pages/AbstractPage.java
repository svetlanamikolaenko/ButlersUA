package framework.pages;

import com.github.javafaker.Faker;
import framework.config.TestConfig;
import framework.helpers.JavaScriptHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final int TIME_OUT = 10;
    protected final String BASE_PAGE = TestConfig.CONFIG.baseUrl();
    protected Faker faker;
    protected JavaScriptHelper javaScriptHelper;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
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

    public WebElement findElementByXpath(String text){
        return driver.findElement(By.xpath(text));
    }

    public abstract void openPage();

}
