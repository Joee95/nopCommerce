package Tests;

import Base.TestBase;
import LoadProperties.LoadPropertiesFile;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GuestCheckoutProductFromCartTest extends TestBase {
    private WebDriver driver;

    String firstname = LoadPropertiesFile.userdata.getProperty("firstname");
    String lastname = LoadPropertiesFile.userdata.getProperty("lastname");
    String email = LoadPropertiesFile.userdata.getProperty("email");
    String Phone = LoadPropertiesFile.userdata.getProperty("Phone");

    String Address = LoadPropertiesFile.userdata.getProperty("Address");

    String Country = LoadPropertiesFile.userdata.getProperty("Country");

    String searchTxt = LoadPropertiesFile.userdata.getProperty("searchTxt");
    String PostalCode = LoadPropertiesFile.userdata.getProperty("PostalCode");
    String productName = LoadPropertiesFile.userdata.getProperty("productName");

    @Test(priority = 1)
    public void UserCanSearchForProductsWithAutoSuggest() {
        searchPage = landingPage.ClickOnSearchTxtBox();
        try {
            productDetailsPage = searchPage.ProductSearchUsingAutoSuggest(searchTxt);
            productDetailsPage.MakeSureProductNameAppeared(productName);
        } catch (Exception e) {
            System.out.println("Error occurred  " + e.getMessage());
        }
    }

    @Test(priority = 4)
    public void UserCanAddProductToShoppingCart() throws InterruptedException {
        shoppingCartPage = productDetailsPage.AddToCart();
        shoppingCartPage.MakeSurePriceAppeared();
        checkoutPage = shoppingCartPage.openCheckoutPage();
    }

    @Test(priority = 5)
    public void UserCanCheckoutProduct() throws InterruptedException {
        checkoutPage.CheckoutProduct(firstname, lastname, Country, email, Address, PostalCode, Phone, Country, productName);
        checkoutPage.confirmOrder();
    }

}
