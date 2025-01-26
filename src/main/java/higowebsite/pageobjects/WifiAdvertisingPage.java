package higowebsite.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import higowebsite.abstractcomponents.AbstractComponent;

public class WifiAdvertisingPage extends AbstractComponent{
	
	private WebDriver driver;
	
	// PageFactory
	@FindBy(css="header>h6+a[href*='contact-us']")
	private WebElement contactUsButton;
	
	public WifiAdvertisingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public ContactUsPage goToContactUs() {
		this.contactUsButton.click();
		
		return new ContactUsPage(this.driver);
	}

}
