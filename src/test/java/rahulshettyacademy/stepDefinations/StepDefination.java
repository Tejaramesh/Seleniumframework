package rahulshettyacademy.stepDefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckOut;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.pageobjects.confirmPage;

public class StepDefination extends BaseTest {
	public LandingPage landingpage;
	public ProductCatalogue productcatalogue;
	confirmPage confirmpage;

	@Given("I landed on ecommerce page")
	public void I_landed_on_ecommercepage() throws IOException {
		landingpage = launchApplication();
	}

	@Given("^Loged in with username (.+) and password (.+)$")
	public void logged_in_username_and_password(String username, String password) {
		productcatalogue=landingPage.loginApplication(username, password);
	}

	@When("^I add product (.+) to cart$")
	public void add_product_cart(String productName) throws InterruptedException {
		List<WebElement> products = productcatalogue.getProductList();
		productcatalogue.addProductToCart(productName);
	}

	// And checkout <productName> and submit the order
	@When("^checkout (.+) and submit the order$")
	public void checkout_and_submit_order(String ProductName) {
		CartPage cartPage = productcatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(ProductName);
		Assert.assertTrue(match);
		CheckOut checkout = cartPage.goToCheckout();
		checkout.selectCountry("india");
		confirmpage = checkout.submitOrder();
	}

	// Then "THANKYOU FOR THE ORDER." message is displayed on Confirmationpage

	@Then("{string} message is displayed on Confirmationpage")
	public void Confirmationpage_isdisplayed(String actualMessage) {
		String confirmMessage = confirmpage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(actualMessage));
		driver.close();
	}

	@Then("{string} message is displayed")
	public void something_message_is_displayed(String errormessage) {
		Assert.assertEquals(errormessage, landingPage.getErrorMessage());
	}
}
