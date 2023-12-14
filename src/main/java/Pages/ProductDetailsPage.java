package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductDetailsPage {

    public WebDriver driver;
    public By productNamebreadCrumb = By.cssSelector("strong.current-item");

    private By emailFriendBtn = By.xpath("//button[@type='button' and contains(. , 'Email a friend')]");

    private By searchTextBox = By.id("small-searchterms");
    private By ProductList = By.id("ui-id-1");

    public By productPricelbl = By.cssSelector("span.price-value-4");

    private By addToWishlistBtn = By.id("add-to-wishlist-button-4");


    private By addReviewLink = By.linkText("Add your review");

    private By addToCompareBtn = By.xpath("//button[@type='button' and contains ( . , 'Add to compare list')][1]");

    private By addToCartBtn = By.id("add-to-cart-button-4");

    public By totalLbl = By.xpath("//span[@class='product-subtotal']");

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public EmailPage SendEmailToFriend() {
        driver.findElement(emailFriendBtn).click();
        return new EmailPage(driver);
    }

    public ProductReviewPage openAddReviewPage() {
        driver.findElement(addReviewLink).click();
        return new ProductReviewPage(driver);
    }

    public Wishlistpage AddProductToWishlist() throws InterruptedException {
        driver.findElement(addToWishlistBtn).click();
        Thread.sleep(1000);
        return new Wishlistpage(driver);
    }

    public ComparePage AddProductToCompare() {
        driver.findElement(addToCompareBtn).click();
        return new ComparePage(driver);
    }

    public ShoppingCartPage AddToCart() throws InterruptedException {
        driver.findElement(addToCartBtn).click();
        Thread.sleep(2000);
        return new ShoppingCartPage(driver);
    }

    public ComparePage ProductSearchUsingAutoSuggest(String searchTxt_2) {
        List<WebElement> productlist = driver.findElements(ProductList);
        driver.findElement(searchTextBox).sendKeys(searchTxt_2);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productlist.get(0).click();
        return new ComparePage(driver);
    }

    public void MakeSureCurrencyChanged() {
        try {
            Assert.assertTrue(driver.findElement(productPricelbl).getText().contains("€"));
            System.out.println(driver.findElement(productPricelbl).getText());
        } catch (Exception e) {
            System.out.println("Error occurred  " + e.getMessage());
        }
    }

    public void MakeSureProductNameAppeared(String productName) {
        Assert.assertEquals(driver.findElement(productNamebreadCrumb).getText(), productName);
    }
}

