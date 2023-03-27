package bikashautomationframework.tests;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import bikashautomationframework.TestComponents.BaseTests;
import bikashautomationframework.pageObjects.ProductCartPage;
import bikashautomationframework.pageObjects.ProductCatalouge;

public class ValidateProductPrice extends BaseTests {

	String subtotalPrice = "$294500";
	String totalPrice = "$294500";

	public void validatePrice(HashMap<String, String> input) {
		ProductCatalouge productcatalouge = lanpObj.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productcatalouge.getProducts();
		productcatalouge.addProductToCart(input.get("product"));
		productcatalouge.addProductToCart(input.get("product1"));
		productcatalouge.addProductToCart(input.get("product2"));
		ProductCartPage productcartpage = productcatalouge.goToCartPage();
		Boolean matcher = productcartpage.ValidateCartProduct(input.get("product"));
		Assert.assertTrue(matcher);
		Boolean matcher1 = productcartpage.ValidateCartProduct(input.get("product1"));
		Assert.assertTrue(matcher1);
		Boolean matcher2 = productcartpage.ValidateCartProduct(input.get("product2"));
		Assert.assertTrue(matcher2);
		String subtotalprice = productcartpage.validateCartSubtotalPrice();
		Assert.assertEquals(subtotalprice, subtotalPrice);
		String totalprice = productcartpage.validateCartTotalPrice();
		Assert.assertEquals(subtotalprice, totalprice);
	}

}