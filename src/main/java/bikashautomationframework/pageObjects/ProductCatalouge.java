package bikashautomationframework.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bikashautomationframework.abstractComponents.AbstractComponent;

public class ProductCatalouge extends AbstractComponent {

	WebDriver driver;

	public ProductCatalouge(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	//driver.findElement(By.cssSelector(".ng-animating"))

	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");

	public List<WebElement> getProducts() {

		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String Productname) {
		
		WebElement selectedProduct = getProducts().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(Productname)).findFirst()
				.orElse(null);
		
		return selectedProduct;
	}
	
	public void addProductToCart(String Productname) {
		
		WebElement selectedProduct = getProductByName(Productname);
		selectedProduct.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);

	}

}
