package bikashautomationframework.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import bikashautomationframework.abstractComponents.AbstractComponent;

public class ProductCartPage extends AbstractComponent {

	WebDriver driver;

	public ProductCartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * @FindBy(css = "[routerlink*='cart']") WebElement cart;
	 */

	@FindBy(css = ".cartSection h3")
	private List<WebElement> cartProducts;

	@FindBy(css = ".totalRow button")
	WebElement checkout;
	
	@FindBy(css="li:nth-child(1) span:nth-child(2)")
	WebElement EleSubtotal;
	
	@FindBy(css="li:nth-child(2) span:nth-child(2)")
	WebElement EleTotal;

	/*
	 * public void clickOnCart() { cart.click(); }
	 */

	public List<WebElement> getCartProducts() {

		return cartProducts;
	}

	public boolean ValidateCartProduct(String Productname) {

		Boolean match = getCartProducts().stream().anyMatch(cartProduct -> cartProduct.getText().equals(Productname));
         return match;

	}
	
	public boolean ValidateCartProduct1(String Productname1) {

		Boolean match1 = getCartProducts().stream().anyMatch(cartProduct -> cartProduct.getText().equals(Productname1));
         return match1;

	}
	
	public boolean ValidateCartProduct2(String Productname2) {

		Boolean match2 = getCartProducts().stream().anyMatch(cartProduct -> cartProduct.getText().equals(Productname2));
         return match2;

	}
	
	public String validateCartSubtotalPrice() {
		String matchSubtotalPrice = EleSubtotal.getText();
		return matchSubtotalPrice;
	}
	
	public String validateCartTotalPrice() {
		String matchtotalPrice = EleTotal.getText();
		return matchtotalPrice;
	}

	public CheckoutPage performCheckout() {
		checkout.click();
		return new CheckoutPage(driver);
	}

}
