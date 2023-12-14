package Pages;

import gherkin.lexer.Th;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;

    private By guestBtn = By.xpath("//button[@type='button' and contains (. , 'Checkout as Guest')]");
    private By fnTxt = By.id("BillingNewAddress_FirstName");
    private By lnTxt = By.id("BillingNewAddress_LastName");
    private By emailTxt = By.id("BillingNewAddress_Email");
    private By countryList = By.id("BillingNewAddress_CountryId");
    private By phoneTxt = By.id("BillingNewAddress_PhoneNumber");
    private By cityTxt = By.id("BillingNewAddress_City");
    private By addressTxt = By.id("BillingNewAddress_Address1");
    private By postCodeTxt = By.id("BillingNewAddress_ZipPostalCode");
    private By continueBtn = By.xpath("//*[@type='button' and contains (. , 'Continue')]");
    private By shippingMethodRdo = By.id("shippingoption_1");
    private By continueShippingBtn = By.xpath("//span[@id='shipping-method-please-wait']");
    private By continuePaymentBtn = By.xpath("//*[@id=\\'payment-method-buttons-container\\']/input");
    private By continueInfoBtn = By.xpath("//*[@id=\\'payment-info-buttons-container\\']/input");
    private By prodcutName = By.cssSelector("a.product-name");
    private By confirmBtn = By.cssSelector("input.button-1.confirm-order-next-step-button");
    private By ThankYoulbl = By.cssSelector("h1");
    private By successMessage = By.cssSelector("div.title");
    private By orderDetailsLink = By.linkText("Click here for order details.");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void RegisteredUserCheckoutProduct(String countryName, String address, String postcode, String phone, String city, String productName) throws InterruptedException {
        Select select = new Select(driver.findElement(countryList));
        select.selectByVisibleText(countryName);
        driver.findElement(cityTxt).sendKeys(city);
        driver.findElement(addressTxt).sendKeys(address);
        driver.findElement(postCodeTxt).sendKeys(postcode);
        driver.findElement(phoneTxt).sendKeys(phone);
        driver.findElement(continueBtn).click();
        driver.findElement(shippingMethodRdo).click();
        driver.findElement(continueShippingBtn).click();
        Thread.sleep(1000);
        driver.findElement(continuePaymentBtn).click();
        Thread.sleep(1000);
        driver.findElement(continueInfoBtn).click();
    }

    public void confirmOrder() throws InterruptedException {
        driver.findElement(confirmBtn).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(ThankYoulbl).isDisplayed());
    }

    public OrderDetailsPage viewOrderDetails() {
        driver.findElement(orderDetailsLink).click();
        return new OrderDetailsPage(driver);
    }

    public void CheckoutProduct(String firstName, String lastName, String countryName,
                                String email, String address, String postcode,
                                String phone, String city, String productName) throws InterruptedException {
        driver.findElement(fnTxt).sendKeys(firstName);
        driver.findElement(lnTxt).sendKeys(lastName);
        driver.findElement(emailTxt).sendKeys(email);
        Select select = new Select(driver.findElement(countryList));
        select.selectByVisibleText(countryName);
        driver.findElement(cityTxt).sendKeys(city);
        driver.findElement(addressTxt).sendKeys(address);
        driver.findElement(postCodeTxt).sendKeys(postcode);
        driver.findElement(phoneTxt).sendKeys(phone);
        driver.findElement(continueBtn).click();
        Thread.sleep(500);
        driver.findElement(shippingMethodRdo).click();
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(500));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(continueShippingBtn)));
        driver.findElement(continueShippingBtn).click();
        Thread.sleep(2000);
        driver.findElement(continuePaymentBtn).click();
        Thread.sleep(2000);
        driver.findElement(continueInfoBtn).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(prodcutName).isDisplayed());
        Assert.assertTrue(driver.findElement(prodcutName).getText().contains(productName));
    }


}