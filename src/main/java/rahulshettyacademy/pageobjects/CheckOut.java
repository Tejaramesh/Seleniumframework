package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CheckOut extends AbstractComponent {
	WebDriver driver;

	public CheckOut(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By result = By.cssSelector(".ta-results");
	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement country;
	@FindBy(xpath = "//button[contains(@class,'ta-item')][2]")
	WebElement clickCountry;
	@FindBy(css = ".action__submit")
	WebElement submit;

	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(result);
		clickCountry.click();
	}

	public confirmPage submitOrder() {
		submit.click();
		confirmPage confirmpage = new confirmPage(driver);
		return confirmpage;
	}
}
