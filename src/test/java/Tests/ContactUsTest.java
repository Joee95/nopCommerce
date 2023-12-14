package Tests;

import Base.TestBase;
import LoadProperties.LoadPropertiesFile;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTest extends TestBase {
    private WebDriver driver;

    String firstname = LoadPropertiesFile.userdata.getProperty("firstname");
    String email = LoadPropertiesFile.userdata.getProperty("email");
    String Message = LoadPropertiesFile.userdata.getProperty("Message");


    @Test
    public void UserCanUseContactUs() throws InterruptedException {
        contactUsPage = landingPage.openContactUsPage();
        contactUsPage.ContactUs(firstname, email, Message);
    }
}
