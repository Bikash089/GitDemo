package bikashautomationframework.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import bikashautomationframework.TestComponents.BaseTests;
import bikashautomationframework.pageObjects.CheckoutPage;
import bikashautomationframework.pageObjects.ConfirmationPage;
import bikashautomationframework.pageObjects.LandingPage;
import bikashautomationframework.pageObjects.ProductCartPage;
import bikashautomationframework.pageObjects.ProductCatalouge;

public class ErrorValidationsTest extends BaseTests {

	@Test(groups= {"ErrorHandling"},retryAnalyzer=bikashautomationframework.TestComponents.Retry.class)
	public void loginErrorValidation() throws IOException {

		

		// Product Catalouge Page Test
		lanpObj.loginApplication("bukashnsec@gmail.com", "MyLearning@198");
		Assert.assertEquals("Incorrect email or password.", lanpObj.getErrorMessage());

	}
	
	
	@Test
	public void productErrorValidation() throws IOException {


		String Productname = "ZARA COAT 3";
		String ExpectednMsg = "THANKYOU FOR THE ORDER.";

		// Product Catalouge Page Test
		ProductCatalouge productcatalouge = lanpObj.loginApplication("bukashnsec@gmail.com", "MyLearning@1989");

		List<WebElement> products = productcatalouge.getProducts();
		productcatalouge.addProductToCart(Productname);
		ProductCartPage productcart = productcatalouge.goToCartPage();

		// product cart page

		// productcart.clickOnCart();
		Boolean matchs = productcart.ValidateCartProduct("ZARA COAT 33");
		Assert.assertFalse(matchs);



	}

}
