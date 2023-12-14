package Tests;

import Base.TestBase;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserRegistrationTestWithDDTAndJSON extends TestBase {

    @Test(priority = 1, alwaysRun = true)
    public void UserRegistrationTest() throws InterruptedException, IOException, ParseException {

        data.JsonDataReader jsonReader = new data.JsonDataReader();
        jsonReader.JsonReader();

        userRegistrationPage = landingPage.openRegistrationPage();
        loginPage = userRegistrationPage.userRegistration(jsonReader.firstname, jsonReader.lastname, jsonReader.email, jsonReader.password);
        loginPage = landingPage.openLoginPage();
        loginPage.LoginUsingDataProvider(jsonReader.email, jsonReader.password);
        landingPage.userLogout();
    }

}
