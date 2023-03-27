package bikashautomationframework.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import bikashautomationframework.TestComponents.BaseTests;
import bikashautomationframework.pageObjects.CheckoutPage;
import bikashautomationframework.pageObjects.ConfirmationPage;
import bikashautomationframework.pageObjects.LandingPage;
import bikashautomationframework.pageObjects.OrderPage;
import bikashautomationframework.pageObjects.ProductCartPage;
import bikashautomationframework.pageObjects.ProductCatalouge;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTests {

	String Productname = "ZARA COAT 3";

	@Test(dataProvider="getData",groups= {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException {

		String ExpectednMsg = "THANKYOU FOR THE ORDER.";
		ProductCatalouge productcatalouge = lanpObj.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productcatalouge.getProducts();
		productcatalouge.addProductToCart(input.get("product"));
		ProductCartPage productcart = productcatalouge.goToCartPage();
		Boolean matchs = productcart.ValidateCartProduct(input.get("product"));
		Assert.assertTrue(matchs);
		CheckoutPage checkoutpage = productcart.performCheckout();
		checkoutpage.selectCountry("india");
		ConfirmationPage confirmationpage = checkoutpage.submitDetails();
		String actualMsg = confirmationpage.Confirmation();
		Assert.assertEquals(actualMsg, ExpectednMsg);
	}
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest() throws IOException
	{

		ProductCatalouge productcatalouge = lanpObj.loginApplication("bukashnsec@gmail.com", "MyLearning@1989");
		OrderPage orderpage = productcatalouge.goToOrderPage();
		Assert.assertTrue(orderpage.verifyOrderDisplay(Productname));
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
//		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("email", "bukashnsec@gmail.com");
//		map.put("password", "MyLearning@1989");
//		map.put("product", "ZARA COAT 3");
//		
//		HashMap<String,String> map1 = new HashMap<String,String>();
//		map1.put("email", "anshika@gmail.com");
//		map1.put("password", "Iamking@000");
//		map1.put("product", "ADIDAS ORIGINAL");
		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\bikashautomationframework\\data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
		//return new Object[][] {{"bukashnsec@gmail.com","MyLearning@1989","ZARA COAT 3"},{"anshika@gmail.com","Iamking@000","ADIDAS ORIGINAL"}};
	}

}
