package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class LandingPage {

    private WebDriver driver;
    public Select select;
    public JavascriptExecutor jse;
    private By registerLink = By.cssSelector("a.ico-register");
    private By loginLink = By.linkText("Log in");
    private By contactUsLink = By.linkText("Contact us");
    private By ComputerMenu = By.xpath("//a[contains (. , 'Computers') ]");

    private By NotebooksMenu = By.xpath("//a[contains (. , 'Notebooks ')]");
    private By logoutLink = By.cssSelector("a.ico-logout");
    private By ProductList = By.id("ui-id-1");
    private By searchTextBox = By.id("small-searchterms");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public UserRegistrationPage openRegistrationPage() {
        this.driver.findElement(registerLink).click();
        return new UserRegistrationPage(driver);
    }

    public LoginPage openLoginPage() {
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }

    public void userLogout() {
        driver.findElement(logoutLink).click();
    }

    public ContactUsPage openContactUsPage() {
//        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElement(contactUsLink).click();
        return new ContactUsPage(driver);
    }

    public SearchPage ProductSearchUsingAutoSuggest(String searchTxt) {
        List<WebElement> productlist = driver.findElements(ProductList);
        driver.findElement(searchTextBox).sendKeys(searchTxt);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productlist.get(0).click();
        return new SearchPage(driver);
    }

    public SearchPage ClickOnSearchTxtBox() {
        driver.findElement(searchTextBox).click();
        return new SearchPage(driver);
    }

    public void selectNotebooksMenu() {
        Actions actions = new Actions(driver);
        actions
                .moveToElement(driver.findElement(ComputerMenu))
                .moveToElement(driver.findElement(NotebooksMenu))
                .click()
                .build()
                .perform();
    }

}
