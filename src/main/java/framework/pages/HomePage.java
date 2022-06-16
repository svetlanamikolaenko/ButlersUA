package framework.pages;

import framework.helpers.JavaScriptHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage{

    @FindBy(xpath = "//a[@class='ico-login']")
    WebElement loginIcon;

    @FindBy(xpath = "//a[@class='ico-account']")
    WebElement accountIcon;

    @FindBy(xpath = "//h1")
    WebElement caption;

    public HomePage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, TIME_OUT);
        PageFactory.initElements(driver, this);
        javaScriptHelper = new JavaScriptHelper(driver);
    }

    public String getCation(){
        return caption.getText();
    }


    @Override
    public void openPage() {
        driver.get(BASE_PAGE + "/");
        waitUntilTextToBePresent(caption, caption.getText());
    }
}
