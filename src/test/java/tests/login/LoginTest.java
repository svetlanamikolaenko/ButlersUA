package tests.login;
import framework.config.TestConfig;
import framework.models.Customer;
import framework.pages.HomePage;
import framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.BaseTest;

public class LoginTest extends BaseTest{

    LoginPage loginPage;
    HomePage homePage;
    Customer customer;

    @BeforeMethod
    void setup(){
        customer = Customer.newBuilder().withEmail(TestConfig.CONFIG.userEmail()).withPassword(TestConfig.CONFIG.userPassword()).build();
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        homePage = new HomePage(driver);
    }

    @Test
    void loginTest(){
        loginPage.loginAs(customer);
        Assert.assertEquals(homePage.getCation(), "Вітаємо в BUTLERS!");
    }
}
