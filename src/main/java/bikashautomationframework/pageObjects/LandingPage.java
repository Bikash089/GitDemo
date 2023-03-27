package bikashautomationframework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bikashautomationframework.abstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement userEmail = driver.findElement(By.id("userEmail"));

	@FindBy(id = "userEmail")
	WebElement userEmailEle;

	@FindBy(id = "userPassword")
	WebElement passwordEle;

	@FindBy(css = "#login")
	WebElement loginEle;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	

	public String getErrorMessage() {
		
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
	public ProductCatalouge loginApplication(String email, String password) {
		userEmailEle.sendKeys(email);
		passwordEle.sendKeys(password);
		loginEle.click();
		ProductCatalouge productcatalouge = new ProductCatalouge(driver);
		return productcatalouge;
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
}
