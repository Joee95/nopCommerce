package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {
    public WebDriver driver;

    private By fullNameTxt = By.id("FullName");

    private By emailTxt = By.id("Email");

    private By enquiryTxt = By.id("Enquiry");

    private By submitBtn = By.name("send-email");

    public By successMessage = By.cssSelector("div.result");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void ContactUs(String fullName, String email, String message) throws InterruptedException {
        driver.findElement(fullNameTxt).sendKeys(fullName);
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(enquiryTxt).sendKeys(message);
        driver.findElement(submitBtn).click();
        Thread.sleep(1500);
        Assert.assertTrue(driver.findElement(successMessage).getText()
                .contains("Your enquiry has been successfully sent to the store owner."));
    }
}
