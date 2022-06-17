package framework.pages;

import com.github.javafaker.Faker;
import framework.components.Header;
import framework.config.TestConfig;
import framework.helpers.JavaScriptHelper;
import framework.helpers.WebDriverWaitHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected final String BASE_PAGE = TestConfig.CONFIG.baseUrl();
    protected Faker faker;
    protected JavaScriptHelper javaScriptHelper;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public Header getHeader(){
        return new Header(driver);
    }

    public WebDriverWaitHelper waitHelper(){
        return new WebDriverWaitHelper(driver);
    }

    public JavaScriptHelper jsHelper(){
        return new JavaScriptHelper(driver);
    }

    @FindBy(xpath = "//h1")
    WebElement caption;

    public String getCaption(){
        return caption.getText();
    }

    public WebElement findElementByXpath(String text){
        return driver.findElement(By.xpath(text));
    }

    public abstract void openPage();
}
