package framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerInfoPage extends BasePage {

    @FindBy(id = "LastName")
    WebElement lastName;

    @FindBy(id = "save-info-button")
    WebElement saveInfoButton;

    @Override
    public void openPage() {
        driver.get(BASE_PAGE + "/customer/info");
        waitUntilLoaded();
    }

    @Step("Change the user surname")
    public void changeSurname(String name){
        lastName.click();
        lastName.clear();
        lastName.sendKeys(name);
    }

    @Step("Save changes in user personal cabinet")
    public void saveInfo(){
        saveInfoButton.click();
        jsHelper().allElementsLoaded();
    }

    @Step("Get last name")
    public String getLastName(){
        return lastName.getAttribute("value");
    }
}
