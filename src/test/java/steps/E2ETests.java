package steps;

import Base.TestBase;
import LoadProperties.LoadPropertiesFile;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class E2ETests extends TestBase {
    String firstname = LoadPropertiesFile.userdata.getProperty("firstname");
    String lastname = LoadPropertiesFile.userdata.getProperty("lastname");
    String email = LoadPropertiesFile.userdata.getProperty("email");
    String Phone = LoadPropertiesFile.userdata.getProperty("Phone");

    String Address = LoadPropertiesFile.userdata.getProperty("Address");

    String Country = LoadPropertiesFile.userdata.getProperty("Country");

    String searchTxt = LoadPropertiesFile.userdata.getProperty("searchTxt");
    String PostalCode = LoadPropertiesFile.userdata.getProperty("PostalCode");
    String productName = LoadPropertiesFile.userdata.getProperty("productName");

    @Given("user is in Home page.")
    public void User_is_in_Home_page() throws Throwable {
        Assert.assertTrue(driver.getCurrentUrl().contains("demo.nopcommerce.com"));
    }

    @When("User searchs for product.")
    public void User_searches_for_Product() {
        try {
            productDetailsPage = searchPage.ProductSearchUsingAutoSuggest(searchTxt);
            productDetailsPage.MakeSureProductNameAppeared(productName);
        } catch (Exception e) {
            System.out.println("Error occurred  " + e.getMessage());
        }
    }

    @When("Choose to buy item.")
    public void choose_to_buy_item() throws InterruptedException {
        shoppingCartPage = productDetailsPage.AddToCart();
        shoppingCartPage.MakeSurePriceAppeared();
    }

    @When("Moves to checkout cart page, enter personal details on checkout page and place the order.")
    public void moves_to_checkout_cart_and_enter_personal_details_on_checkout_page_and_place_the_order() throws InterruptedException {
        checkoutPage = shoppingCartPage.openCheckoutPage();
        checkoutPage.CheckoutProduct(firstname, lastname, Country, email, Address, PostalCode, Phone, Country, productName);
        checkoutPage.confirmOrder();
    }

    @Then("User can view the order and download the invoice.")
    public void User_can_view_the_order_and_download_the_invoice() throws InterruptedException {
        orderDetailsPage = checkoutPage.viewOrderDetails();
        Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
        orderDetailsPage.DownloadPDFInvoice();
        Thread.sleep(3000);
        orderDetailsPage.PrintOrderDetails();
    }
}
