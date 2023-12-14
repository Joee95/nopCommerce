package Tests;

import Base.TestBase;
import LoadProperties.LoadPropertiesFile;
import org.testng.annotations.Test;

public class UserRegistrationWithDDTAndPropertiesFile extends TestBase {

    String firstname = LoadPropertiesFile.userdata.getProperty("firstname");
    String lastname = LoadPropertiesFile.userdata.getProperty("lastname");
    String email = LoadPropertiesFile.userdata.getProperty("email");
    String password = LoadPropertiesFile.userdata.getProperty("password");

    @Test(priority = 1, alwaysRun = true)
    public void UserRegistrationTest() throws InterruptedException {
        userRegistrationPage = landingPage.openRegistrationPage();
        loginPage = userRegistrationPage.userRegistration(firstname, lastname, email, password);
        loginPage = landingPage.openLoginPage();
        loginPage.LoginUsingDataProvider(email, password);
        landingPage.userLogout();
    }
}
