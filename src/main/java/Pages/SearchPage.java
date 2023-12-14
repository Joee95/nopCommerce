package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {
    public WebDriver driver;
    private By searchTextBox = By.id("small-searchterms");

    private By searchBtn = By.cssSelector("input.button-1.search-box-button");

    private By ProductList = By.id("ui-id-1");

    private By productTitle = By.linkText("Apple MacBook Pro 13-inch");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void ProductSearch(String productName) {
        driver.findElement(searchTextBox).sendKeys(productName);
        driver.findElement(searchBtn).click();
    }

    public void OpenProductDetailsPage() {
        driver.findElement(productTitle).click();
    }

    public ProductDetailsPage ProductSearchUsingAutoSuggest(String searchTxt) {
        List<WebElement> productlist = driver.findElements(ProductList);
        driver.findElement(searchTextBox).sendKeys(searchTxt);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productlist.get(0).click();
        return new ProductDetailsPage(driver);
    }


}
