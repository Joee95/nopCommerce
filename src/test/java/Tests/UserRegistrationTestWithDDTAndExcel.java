package Tests;

import Base.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserRegistrationTestWithDDTAndExcel extends TestBase {

    @DataProvider(name = "ExcelData")
    public Object[][] userRegisterData() throws IOException {
        // get data from Excel Reader class
        data.ExcelReader ER = new data.ExcelReader();
        return ER.getExcelData();
    }

    @Test(priority = 1, alwaysRun = true, dataProvider = "ExcelData")
    public void UserRegistrationTest(String firstname, String lastname, String email, String password) throws InterruptedException {
        userRegistrationPage = landingPage.openRegistrationPage();
        loginPage = userRegistrationPage.userRegistration(firstname, lastname, email, password);
        loginPage = landingPage.openLoginPage();
        loginPage.LoginUsingDataProvider(email, password);
        landingPage.userLogout();
    }
}
