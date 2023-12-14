package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Wishlistpage {
    public WebDriver driver;
    private By productCell = By.cssSelector("td.product");

    private By wishlistHeader = By.cssSelector("h1");

    private By updateWishlistBtn = By.name("updatecart");

    private By removefromCartCheck = By.xpath("//input[@name='removefromcart']");

    public By EmptyCartLbl = By.cssSelector("div.no-data");

    public Wishlistpage(WebDriver driver) {
        this.driver = driver;
    }

    public void removeProductFromWishlist(String productName) {
        driver.navigate().to("http://demo.nopcommerce.com" + "/wishlist");
        Assert.assertTrue(driver.findElement(wishlistHeader).isDisplayed());
        Assert.assertTrue(driver.findElement(productCell).getText().contains(productName));
        System.out.println(driver.findElement(wishlistHeader).getText());
        driver.findElement(removefromCartCheck).click();
        Assert.assertTrue(driver.findElement(EmptyCartLbl).getText().contains("The wishlist is empty!"));
    }
}
