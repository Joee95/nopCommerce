package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage {

    private WebDriver driver;

    private By removeCheck = By.name("removefromcart");
    private By updateCartBtn = By.name("updatecart");

    private By quantityTxt = By.cssSelector("input.qty-input valid");
    public By totalLbl = By.xpath("//span[@class='product-subtotal']");
    private By checkoutBtn = By.id("checkout");
    private By agreeCheckbox = By.id("termsofservice");
    private By guestCheckoutBtn = By.cssSelector("input.button-1.checkout-as-guest-button");
    private By guestBtn = By.xpath("//button[@type='button' and contains (. , 'Checkout as Guest')]");

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void RemoveProductFromCart() {
        driver.navigate().to("http://demo.nopcommerce.com" + "/cart");
        Assert.assertTrue(driver.findElement(totalLbl).getText().contains("3,600"));
        driver.findElement(removeCheck).click();
        driver.findElement(updateCartBtn).click();
    }

    public void UpdateProductQuantityInCart(String quantity) {
        //clear quantity text box
        driver.findElement(quantityTxt).clear();
        driver.findElement(quantityTxt).sendKeys(quantity);
        driver.findElement(updateCartBtn).click();
    }

    public CheckoutPage openCheckoutPage() throws InterruptedException {
        driver.findElement(agreeCheckbox).click();
        driver.findElement(checkoutBtn).click();
        Thread.sleep(1000);
        driver.findElement(guestBtn).click();
        return new CheckoutPage(driver);
    }

    public void openCheckoutPageAsGuest() {
        driver.findElement(agreeCheckbox).click();
        driver.findElement(checkoutBtn).click();
        driver.findElement(guestCheckoutBtn).click();
    }

    public void MakeSurePriceAppeared() {
        driver.navigate().to("http://demo.nopcommerce.com" + "/cart");
        String Price = driver.findElement(totalLbl).getText();
        Assert.assertTrue(Price.contains("3,600"));
        System.out.println(Price);
    }
}
