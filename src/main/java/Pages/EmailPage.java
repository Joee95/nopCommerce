package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmailPage {

    public WebDriver driver;

    private By emailFriendTxt = By.id("FriendEmail");

    private By personalMessageTxt = By.id("PersonalMessage");

    private By sendEmailBtn = By.name("send-email");

    private By messageNotification = By.cssSelector("div.result");

    public EmailPage(WebDriver driver) {
        this.driver = driver;
    }

    public LandingPage SendEmailToFriend(String friendEmail, String personalMessage) {
        driver.findElement(emailFriendTxt).sendKeys(friendEmail);
        driver.findElement(personalMessageTxt).sendKeys(personalMessage);
        driver.findElement(sendEmailBtn).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(messageNotification)));
        Assert.assertTrue(driver.findElement(messageNotification).getText().contains("Your message has been sent."));
        return new LandingPage(driver);
    }
}
