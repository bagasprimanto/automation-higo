package higowebsite.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import higowebsite.abstractcomponents.AbstractComponent;

public class HomePage extends AbstractComponent{

	private WebDriver driver;
	
	// PageFactory
	@FindBy(css="img[alt='WiFi Advertising']")
	private WebElement imageWifiAdvertising;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WifiAdvertisingPage goToWifiAdvertising() {
		this.imageWifiAdvertising.click();
		
		return new WifiAdvertisingPage(this.driver);
	}
	
	public void goTo() {
		this.driver.get("https://higo.id/");
	}
	
	
	
}
