package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ComparePage {
    private WebDriver driver;

    private By clearListLink = By.cssSelector("a.clear-list");

    private By noDataLbl = By.cssSelector("div.no-data");
    private By compareTable = By.cssSelector("table.compare-products-table");
    private By allRows = By.tagName("tr");
    private By allCol = By.tagName("td");
    private By firstProductName = By.linkText("Asus N551JK-XO076H Laptop");
    private By secodProductName = By.linkText("Apple MacBook Pro 13-inch");

    public ComparePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clearCompareList() {
        driver.findElement(clearListLink).click();
        Assert.assertTrue(driver.findElement(noDataLbl).getText().contains("You have no items to compare."));
    }

    public void CompareProducts() {

        driver.navigate().to("http://demo.nopcommerce.com" + "/compareproducts");
        Assert.assertTrue(driver.findElement(firstProductName).getText().equals("Asus N551JK-XO076H Laptop"));
        Assert.assertTrue(driver.findElement(secodProductName).getText().equals("Apple MacBook Pro 13-inch"));

        // Get all Rows
        List<WebElement> rows = driver.findElements(allRows);

        // Get data from each Row
        for (WebElement row : rows) {
            System.out.println(row.getText() + "\t");
            // Get data from each column
            List<WebElement> cols = row.findElements(allCol);
            for (WebElement col : cols) {
                System.out.println(col.getText() + "\t");
            }
        }
    }
}
