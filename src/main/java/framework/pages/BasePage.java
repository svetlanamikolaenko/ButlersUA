package framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage extends AbstractPage {
    @FindBy(xpath = "//a[@class='ico-login']")
    WebElement loginIcon;

    @FindBy(xpath = "//a[@class='ico-account']")
    WebElement accountIcon;

    @FindBy(xpath = "//h1")
    WebElement caption;

    public BasePage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Verify that user is logged in")
    public boolean isUserLoggedIn() {
        try {
            return accountIcon.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Navigate to Customer Info page via account icon in header")
    public void clickOnAccountButton() {
        if (isUserLoggedIn()) {
            accountIcon.click();
        }
    }

    @Step("Get page title")
    public String getCaption() {
        return caption.getText();
    }

    public WebElement findElementByXpath(String text) {
        return driver.findElement(By.xpath(text));
    }

    @Override
    protected void waitUntilLoaded() {
        waitHelper().waitElementUntilVisible(caption);
    }
}
