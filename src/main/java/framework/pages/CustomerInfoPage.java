package framework.pages;

import framework.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerInfoPage extends AbstractPage{

    public CustomerInfoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void openPage() {
        driver.get(BASE_PAGE + "/customer/info");
    }
}
