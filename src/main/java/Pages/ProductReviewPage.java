package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductReviewPage {
    public WebDriver driver;

    private By reviewTitleTxt = By.id("AddProductReview_Title");

    private By reviewText = By.id("AddProductReview_ReviewText");

    private By rating4RdoBtn = By.id("addproductrating_4");

    private By submitReviewBtn = By.name("add-review");
    public By reviewNotification = By.cssSelector("div.result");

    public ProductReviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public LandingPage AddProductReview(String reviewTitle, String reviewMessage) throws InterruptedException {
        driver.findElement(reviewTitleTxt).sendKeys(reviewTitle);
        driver.findElement(reviewText).sendKeys(reviewMessage);
        driver.findElement(rating4RdoBtn).click();
        driver.findElement(submitReviewBtn).click();
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(reviewNotification).getText()
                .contains("Product review is successfully added."));
        return new LandingPage(driver);
    }


}
