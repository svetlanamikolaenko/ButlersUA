package framework.components;

import framework.helpers.WebDriverWaitHelper;
import framework.pages.AbstractPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {
    @FindBy(xpath = "//a[@class='ico-login']")
    WebElement loginIcon;

    @FindBy(xpath = "//a[@class='ico-account']")
    WebElement accountIcon;

    @FindBy(xpath = "//h1")
    WebElement caption;

    WebDriverWaitHelper waitHelper;
    public Header(WebDriver driver) {
        waitHelper = new WebDriverWaitHelper(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Verify that user is not logged in")
    public boolean isUserNotLogin(){
        return loginIcon.isDisplayed();
    }

    @Step("Verify that user is logged in")
    public boolean isUserLoggedIn(){
        return accountIcon.isDisplayed();
    }

    @Step("Navigate to Customer Info page via account icon in header")
    public void clickOnAccountButton(){
        accountIcon.click();
        waitHelper.waitElementUntilVisible(caption);
    }
}
