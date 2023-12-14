package steps;


import Base.TestBase;
import LoadProperties.LoadPropertiesFile;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class UserRegistration extends TestBase {

    String firstname = LoadPropertiesFile.userdata.getProperty("firstname");
    String lastname = LoadPropertiesFile.userdata.getProperty("lastname");
    String email = LoadPropertiesFile.userdata.getProperty("email");
    String password = LoadPropertiesFile.userdata.getProperty("password");

    @Given("Given The user is in Home page.")
    public void User_is_in_Home_page() throws Throwable {
        userRegistrationPage = landingPage.openRegistrationPage();
    }

    @When("When User clicks on register link.")
    public void User_Clicks_on_register_link() {
        Assert.assertTrue(driver.getCurrentUrl().contains("register"));
    }

    @When("User entered \"<firstname>\" , \"<lastname>\" , \"<email>\" , \"<password>\"")
    public void User_Registration_Credentials() {
        loginPage = userRegistrationPage.userRegistration(firstname, lastname, email, password);
    }

    @Then("User has registered successfully.")
    public void the_registration_page_displayed_successfully() throws InterruptedException {
        loginPage = landingPage.openLoginPage();
        loginPage.LoginUsingBDD(email, password);
    }
}
