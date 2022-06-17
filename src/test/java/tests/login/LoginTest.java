package tests.login;
import framework.components.Header;
import framework.enums.Customers;
import framework.models.Customer;
import framework.pages.CustomerInfoPage;
import framework.pages.HomePage;
import framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.BaseTest;

public class LoginTest extends BaseTest{

    LoginPage loginPage;
    HomePage homePage;
    CustomerInfoPage customerInfoPage;
    Customer customer;

    @BeforeMethod
    void setup(){
        customer = Customers.TEST_USER.getCustomer();
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        homePage = new HomePage(driver);
        customerInfoPage = new CustomerInfoPage(driver);
    }

    @Test(description = "After login user returns to the Home Page", priority = 1)
    void loginTest(){
        loginPage.loginAs(customer);
        Assert.assertEquals(homePage.getCaption(), "Вітаємо в BUTLERS!");
        Assert.assertTrue(homePage.getHeader().isUserLoggedIn());
    }

    @Test(description = "Verify that user can navigate to personal cabinet after login", priority = 2)
    void navigateToCustomerInfoTest(){
        loginPage.getHeader().clickOnAccountButton();
        Assert.assertEquals(customerInfoPage.getCaption(), "Персональний кабінет - Інформація про клієнта");
    }
}
