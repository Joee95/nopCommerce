package Tests;

import Base.TestBase;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserRegistrationTestWithDDTAndCSV extends TestBase {

    @Test(priority = 1, alwaysRun = true)
    public void UserRegistrationTest() throws InterruptedException, IOException, CsvValidationException {

        // get path of CSV file
        String CSV_file = System.getProperty("user.dir") + "/src/main/java/Data/UserData.csv";
        CSVReader reader = new CSVReader(new FileReader(CSV_file));
        String[] csvCell;

        // while loop will be executed till last value in CSV file .
        while ((csvCell = reader.readNext()) != null) {
            String firstname = csvCell[0];
            String lastname = csvCell[1];
            String email = csvCell[2];
            String password = csvCell[3];

            userRegistrationPage = landingPage.openRegistrationPage();
            loginPage = userRegistrationPage.userRegistration(firstname, lastname, email, password);
            loginPage = landingPage.openLoginPage();
            loginPage.LoginUsingDataProvider(email, password);
            landingPage.userLogout();
        }
    }
}
