package framework.pages;

public class CustomerInfoPage extends BasePage {

    @Override
    public void openPage() {
        driver.get(BASE_PAGE + "/customer/info");
        waitUntilLoaded();
    }
}
