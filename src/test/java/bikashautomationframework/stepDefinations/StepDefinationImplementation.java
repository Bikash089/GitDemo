package bikashautomationframework.stepDefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import bikashautomationframework.TestComponents.BaseTests;
import bikashautomationframework.pageObjects.CheckoutPage;
import bikashautomationframework.pageObjects.ConfirmationPage;
import bikashautomationframework.pageObjects.LandingPage;
import bikashautomationframework.pageObjects.ProductCartPage;
import bikashautomationframework.pageObjects.ProductCatalouge;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinationImplementation extends BaseTests {

	public ConfirmationPage confirmationpage;
	public ProductCatalouge productcatalouge;
	public LandingPage landingpage;

	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException {

		landingpage = launchApplication();
	}

	@Given("^Logged in with eamil (.+) and password (.+)$")
	public void logged_in_username_and_password(String email, String password) {
		productcatalouge = lanpObj.loginApplication(email, password);
	}

	@When("^I add product (.)+ to cart$")
	public void i_add_product_to_cart(String Productname) {
		List<WebElement> products = productcatalouge.getProducts();
		productcatalouge.addProductToCart(Productname);
	}

	@When("^Checkout (.+) and submit the order$")
	public void checkout_submit_order(String Productname) {
		ProductCartPage productcart = productcatalouge.goToCartPage();
		Boolean matchs = productcart.ValidateCartProduct(Productname);
		Assert.assertTrue(matchs);
		CheckoutPage checkoutpage = productcart.performCheckout();
		checkoutpage.selectCountry("india");
		confirmationpage = checkoutpage.submitDetails();
	}

	@Then("{string} message is displayed on ConfirmationPage")
	public void message_displayed_confirmationPage(String string) {
		String actualMsg = confirmationpage.Confirmation();
		Assert.assertTrue(actualMsg.equalsIgnoreCase(string));
		driver.close();
	}
	

	@Then("^\"([^\"]*)\" message is dislayed")
	public void something_messge_is_displayed(String strArg1) throws Throwable {
		Assert.assertEquals(strArg1, lanpObj.getErrorMessage());
		driver.close();
	}

}