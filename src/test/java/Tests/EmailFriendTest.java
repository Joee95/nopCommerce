package Tests;

import Base.TestBase;
import LoadProperties.LoadPropertiesFile;
import Pages.EmailPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class EmailFriendTest extends TestBase {

    private WebDriver driver;

    String firstname = LoadPropertiesFile.userdata.getProperty("firstname");
    String lastname = LoadPropertiesFile.userdata.getProperty("lastname");
    String email = LoadPropertiesFile.userdata.getProperty("email");
    String password = LoadPropertiesFile.userdata.getProperty("password");

    String ActiveEmail = LoadPropertiesFile.userdata.getProperty("ActiveEmail");

    String ActivePassword = LoadPropertiesFile.userdata.getProperty("ActivePassword");

    String searchTxt = LoadPropertiesFile.userdata.getProperty("searchTxt");
    String productName = LoadPropertiesFile.userdata.getProperty("productName");

    String Message = LoadPropertiesFile.userdata.getProperty("Message");


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
    public void UserCanEmailAFriend() throws InterruptedException {
        try {
            productDetailsPage = searchPage.ProductSearchUsingAutoSuggest(searchTxt);
            productDetailsPage.MakeSureProductNameAppeared(productName);
        } catch (Exception e) {
            System.out.println("Error occurred  " + e.getMessage());
        }
        emailPage = productDetailsPage.SendEmailToFriend();
        landingPage = emailPage.SendEmailToFriend(email, Message);
    }

    @Test(priority = 4)
    public void RegisteredUserCanLogout() {
        landingPage.userLogout();
    }

}
