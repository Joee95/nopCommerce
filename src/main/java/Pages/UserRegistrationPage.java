package Pages;

import cucumber.api.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UserRegistrationPage {

    private WebDriver driver;

    private By genderRdoBtn = By.id("gender-male");
    private By fnTxtBox = By.id("FirstName");
    private By lnTxtBox = By.id("LastName");
    private By emailTxtBox = By.id("Email");
    private By passwordTxtBox = By.id("Password");

    private By confirmPasswordTxtBox = By.id("ConfirmPassword");

    private By registerBtn = By.id("register-button");

    public By successMessage = By.cssSelector("div.result");

    public By logoutLink = By.cssSelector("a.ico-logout");
    private By myAccountLink = By.linkText("My account");
    private By DateOfBirthDay = By.xpath("//select[@name='DateOfBirthDay']");
    private By DateOfBirthMonth = By.xpath("//select[@name='DateOfBirthMonth']");
    private By DateOfBirthYear = By.xpath("//select[@name='DateOfBirthYear']");

    public UserRegistrationPage(WebDriver driver) {
        this.driver = driver;

    }

    public LoginPage userRegistration(String firstName, String lastName, String email, String password) {
        driver.findElement(genderRdoBtn).click();
        driver.findElement(fnTxtBox).sendKeys(firstName);
        driver.findElement(lnTxtBox).sendKeys(lastName);
        Select SelectDay = new Select(driver.findElement(DateOfBirthDay));
        SelectDay.selectByValue("12");
        Select SelectMonth = new Select(driver.findElement(DateOfBirthMonth));
        SelectMonth.selectByValue("6");
        Select SelectYear = new Select(driver.findElement(DateOfBirthYear));
        SelectYear.selectByValue("1995");
        driver.findElement(emailTxtBox).sendKeys(email);
        driver.findElement(passwordTxtBox).sendKeys(password);
        driver.findElement(confirmPasswordTxtBox).sendKeys(password);
        driver.findElement(registerBtn).click();
        Assert.assertTrue(driver.findElement(successMessage).getText().contains("Your registration completed"));
        return new LoginPage(driver);
    }

    public void userLogout() {
        driver.findElement(logoutLink).click();
    }

    public void openMyAccountPage() {
        driver.findElement(myAccountLink).click();
    }

    public void DateOfBirth() {
        Select SelectDay = new Select(driver.findElement(DateOfBirthDay));
        SelectDay.selectByValue("12");
        Select SelectMonth = new Select(driver.findElement(DateOfBirthMonth));
        SelectMonth.selectByValue("6");
        Select SelectYear = new Select(driver.findElement(DateOfBirthYear));
        SelectYear.selectByValue("1995");
    }
}


