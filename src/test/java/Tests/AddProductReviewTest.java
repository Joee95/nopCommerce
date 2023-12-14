package Tests;

import Base.TestBase;
import LoadProperties.LoadPropertiesFile;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductReviewTest extends TestBase {

    private WebDriver driver;

    String firstname = LoadPropertiesFile.userdata.getProperty("firstname");
    String lastname = LoadPropertiesFile.userdata.getProperty("lastname");
    String email = LoadPropertiesFile.userdata.getProperty("email");
    String password = LoadPropertiesFile.userdata.getProperty("password");

    String ActiveEmail = LoadPropertiesFile.userdata.getProperty("ActiveEmail");

    String ActivePassword = LoadPropertiesFile.userdata.getProperty("ActivePassword");

    String searchTxt = LoadPropertiesFile.userdata.getProperty("searchTxt");
    String productName = LoadPropertiesFile.userdata.getProperty("productName");
    String reviewTitle = LoadPropertiesFile.userdata.getProperty("reviewTitle");
    String reviewMessage = LoadPropertiesFile.userdata.getProperty("reviewMessage");


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
    public void UserCanSearchWithAutoSuggest() {
        try {
            productDetailsPage = searchPage.ProductSearchUsingAutoSuggest(searchTxt);
            productDetailsPage.MakeSureProductNameAppeared(productName);
        } catch (Exception e) {
            System.out.println("Error occurred  " + e.getMessage());
        }
    }

    @Test(priority = 4)
    public void RegisteredUserCanReviewProduct() throws InterruptedException {
        productReviewPage = productDetailsPage.openAddReviewPage();
        landingPage = productReviewPage.AddProductReview(reviewTitle, reviewMessage);
    }

    // 4- User Logout
    @Test(priority = 5)
    public void RegisteredUserCanLogout() {
        landingPage.userLogout();
    }

}
