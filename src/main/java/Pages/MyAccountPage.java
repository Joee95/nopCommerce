package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {

    public WebDriver driver;
    private By changePasswordLink = By.linkText("Change password");

    private By oldPasswordTxt = By.id("OldPassword");

    private By newPasswordTxt = By.id("NewPassword");

    private By confirmPasswordTxt = By.id("ConfirmNewPassword");

    private By ChangePasswordBtn = By.cssSelector("input.button-1.change-password-button");
    private By resultLbl = By.cssSelector("div.result");

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void ChangePassword(String oldpassword, String newpassword) {
        driver.findElement(oldPasswordTxt).sendKeys(oldpassword);
        driver.findElement(newPasswordTxt).sendKeys(newpassword);
        driver.findElement(confirmPasswordTxt).sendKeys(newpassword);
        driver.findElement(ChangePasswordBtn).click();
    }
}
