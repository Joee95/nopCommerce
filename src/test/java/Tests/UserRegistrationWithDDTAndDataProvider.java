package Tests;

import Base.TestBase;
import LoadProperties.LoadPropertiesFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserRegistrationWithDDTAndDataProvider extends TestBase {

    private WebDriver driver;

    @DataProvider(name = "testData")
    public static Object[][] userData() {
        return new Object[][]{
                {"Moataz6666", "Nabil666", "testxxxx96666@gmail.com", "123456666"},
                {"Ahmed66666", "Ali66666", "testuser76366@gmail.com", "123456786"},
                {"Jo1111111111", "Kenawy1111111111", "ym1111111111@gmail.com", "Yousef1111111111"}
        };
    }

    @Test(priority = 1, dataProvider = "testData")
    public void UserRegistrationTest(String firstname, String lastname, String email, String password) throws InterruptedException {
        userRegistrationPage = landingPage.openRegistrationPage();
        loginPage = userRegistrationPage.userRegistration(firstname, lastname, email, password);
        loginPage = landingPage.openLoginPage();
        loginPage.LoginUsingDataProvider(email, password);
        landingPage.userLogout();
    }
}



