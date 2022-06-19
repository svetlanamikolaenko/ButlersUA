package tests.login;

import framework.enums.Customers;
import framework.models.Customer;
import framework.pages.CustomerInfoPage;
import framework.pages.HomePage;
import framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.BaseTest;

public class LoginTest extends BaseTest{

    LoginPage loginPage;
    HomePage homePage;
    CustomerInfoPage customerInfoPage;
    Customer customer;
    String message = "Actual page caption is: %s";

    @BeforeMethod
    void setup() {
        customer = Customers.TEST_USER.getCustomer();
        loginPage = new LoginPage();
        loginPage.openPage();
        homePage = new HomePage();
        customerInfoPage = new CustomerInfoPage();
    }

    @Test(description = "After login user returns to the Home Page", priority = 1)
    void loginTest() {
        loginPage.loginAs(customer);
        softAssert.assertEquals(homePage.getCaption(), "Вітаємо в BUTLERS!", String.format(message, homePage.getCaption()));
        softAssert.assertTrue(homePage.isUserLoggedIn(), "User is NOT logged in");
        softAssert.assertAll();
    }

    @Test(description = "Verify that user can navigate to personal cabinet after login", priority = 2)
    void navigateToCustomerInfoTest() {
        loginPage.clickOnAccountButton();
        Assert.assertEquals(customerInfoPage.getCaption(), "Персональний кабінет - Інформація про клієнта", String.format(message, customerInfoPage.getCaption()));
    }
}
