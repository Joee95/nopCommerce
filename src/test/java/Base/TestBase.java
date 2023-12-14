package Base;

import Pages.*;
import Utilities.Helper;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.HashMap;

public class TestBase extends AbstractTestNGCucumberTests {

    public WebDriver driver;
    protected static ChromeOptions options;
    public static String downloadPath = System.getProperty("user.dir") + "\\Downloads\\EncryptedFile";
    protected LandingPage landingPage;
    protected UserRegistrationPage userRegistrationPage;
    protected SearchPage searchPage;
    protected ProductDetailsPage productDetailsPage;
    protected ProductReviewPage productReviewPage;
    protected LoginPage loginPage;
    protected CheckoutPage checkoutPage;
    protected ComparePage comparePage;
    protected ContactUsPage contactUsPage;
    protected EmailPage emailPage;
    protected MyAccountPage myAccountPage;
    protected OrderDetailsPage orderDetailsPage;
    protected ShoppingCartPage shoppingCartPage;
    protected Wishlistpage wishlistPage;


    public static ChromeOptions chromeOption() {
        options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default.content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);
        options.setExperimentalOption("prefs", chromePrefs);
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        return options;
    }

    @BeforeSuite
    // @Parameters({"browser"})
    public void SetUpEnvironment() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--force-device-scale-factor=1");
        driver = new ChromeDriver(options);
        driver.navigate().to("http://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        driver.manage().window().maximize();
        landingPage = new LandingPage(driver);
    }

    //take screenshot if the test case failed
    @AfterMethod
    public void screenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.print("Failure and taking screenshot");
            System.out.print(result.getName());
            Helper.takescreenshot(driver, result.getName());
        }

    }
}