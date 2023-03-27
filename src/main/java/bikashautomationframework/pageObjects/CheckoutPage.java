package bikashautomationframework.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import bikashautomationframework.abstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[placeholder='Select Country']")
	private WebElement selectCountry;

	@FindBy(xpath = "//button[contains(@class,'ta-item')][2]")
	private WebElement selectCountryList;

	@FindBy(css = ".action__submit")
	private WebElement submit;

	By result = By.cssSelector(".ta-results");

	public void selectCountry(String country) {

		Actions act = new Actions(driver);
		act.sendKeys(selectCountry, country).build().perform();
		waitForElementToAppear(result);
		selectCountryList.click();
	}

	public ConfirmationPage submitDetails() {

		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		submit.click();
		return new ConfirmationPage(driver);
	}

}