package Tests;

import Base.TestBase;
import LoadProperties.LoadPropertiesFile;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToWishListTest extends TestBase {

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
        searchPage = loginPage.LOGIN(ActiveEmail, ActivePassword);
    }

    @Test(priority = 3)
    public void UserCanAddProductToWishList() throws InterruptedException {
        try {
            productDetailsPage = searchPage.ProductSearchUsingAutoSuggest(searchTxt);
            productDetailsPage.MakeSureProductNameAppeared(productName);
        } catch (Exception e) {
            System.out.println("Error occurred  " + e.getMessage());
        }
        wishlistPage = productDetailsPage.AddProductToWishlist();
    }

    @Test(priority = 4)
    public void UserCanRemoveProductFromCart() {
        wishlistPage.removeProductFromWishlist(productName);
    }
}
