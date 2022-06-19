package framework.pages;

import org.openqa.selenium.support.PageFactory;

public class CustomerInfoPage extends BasePage {

    public CustomerInfoPage() {
        PageFactory.initElements(driver, this);
    }

    @Override
    public void openPage() {
        driver.get(BASE_PAGE + "/customer/info");
        waitUntilLoaded();
    }
}
