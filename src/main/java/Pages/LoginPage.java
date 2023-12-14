package Pages;

import cucumber.api.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {

    private WebDriver driver;
    public Select select;

    private By Email = By.id("Email");
    private By currencydrl = By.id("customerCurrency");
    private By Password = By.xpath("//input[@id='Password']");
    private By LoginBtn = By.xpath("//button[@type='submit' and contains(. , 'Log in')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public SearchPage LOGIN(String ActiveEmail, String ActivePassword) throws InterruptedException {
        driver.findElement(Email).sendKeys(ActiveEmail);
        Thread.sleep(500);
        driver.findElement(Password).sendKeys(ActivePassword);
        driver.findElement(LoginBtn).click();
        return new SearchPage(driver);
    }

    public void LoginUsingDataProvider(String ActiveEmail, String ActivePassword) throws InterruptedException {
        driver.findElement(Email).sendKeys(ActiveEmail);
        Thread.sleep(500);
        driver.findElement(Password).sendKeys(ActivePassword);
        driver.findElement(LoginBtn).click();
    }

    public void LoginUsingBDD(String ActiveEmail, String ActivePassword) throws InterruptedException {
        driver.findElement(Email).sendKeys(ActiveEmail);
        Thread.sleep(500);
        driver.findElement(Password).sendKeys(ActivePassword);
        driver.findElement(LoginBtn).click();
    }

    public SearchPage changeCurrency() throws InterruptedException {
        select = new Select(driver.findElement(currencydrl));
        select.selectByVisibleText("Euro");
        Thread.sleep(1000);
        return new SearchPage(driver);
    }
}
