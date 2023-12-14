package Tests;

import Base.TestBase;
import LoadProperties.LoadPropertiesFile;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeCurrencyTest extends TestBase {

    private WebDriver driver;

    String firstname = LoadPropertiesFile.userdata.getProperty("firstname");
    String lastname = LoadPropertiesFile.userdata.getProperty("lastname");
    String email = LoadPropertiesFile.userdata.getProperty("email");
    String password = LoadPropertiesFile.userdata.getProperty("password");

    String ActiveEmail = LoadPropertiesFile.userdata.getProperty("ActiveEmail");

    String ActivePassword = LoadPropertiesFile.userdata.getProperty("ActivePassword");

    String searchTxt = LoadPropertiesFile.userdata.getProperty("searchTxt");
    String productName = LoadPropertiesFile.userdata.getProperty("productName");


    @Test(priority = 1)
    public void UserRegistrationTest() {
        userRegistrationPage = landingPage.openRegistrationPage();
        loginPage = userRegistrationPage.userRegistration(firstname, lastname, email, password);
    }

    @Test(priority = 2)
    public void UserCanLoginSuccessfully() throws InterruptedException {
        loginPage = landingPage.openLoginPage();
        loginPage.LOGIN(ActiveEmail, ActivePassword);
        searchPage = loginPage.changeCurrency();
    }

    @Test(priority = 3)
    public void UserCanSearchWithAutoSuggest() throws InterruptedException {
        try {
            productDetailsPage = searchPage.ProductSearchUsingAutoSuggest(searchTxt);
            Assert.assertEquals(driver.findElement(productDetailsPage.productNamebreadCrumb).getText(), productName);
        } catch (Exception e) {
            System.out.println("Error occurred  " + e.getMessage());
        }
        productDetailsPage.MakeSureCurrencyChanged();
    }
}
