package higowebsite.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import higowebsite.abstractcomponents.AbstractComponent;

public class ContactUsPage extends AbstractComponent{
	
private WebDriver driver;
	
	// PageFactory
	@FindBy(css="input[name='fullName']")
	private WebElement fieldFullName;
	
	@FindBy(css="input[name='email']")
	private WebElement fieldEmail;
	
	@FindBy(css="input[name='phoneNumber']")
	private WebElement fieldPhone;
	
	@FindBy(css="input[name='companyName']")
	private WebElement fieldCompany;
	
	@FindBy(css="select[name='service']")
	private WebElement dropdownService;
	private Select fieldDropdownService = new Select(dropdownService);
	
	@FindBy(css="textarea[name='message']")
	private WebElement textAreaMessage;
	
	@FindBy(css="button[type='submit']")
	private WebElement btnSubmit;
	
	@FindBy(css="form>div.border-green-200")
	private WebElement successMessageForm;
	
	public ContactUsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void sendMessage() {
		this.fieldFullName.sendKeys("Marsha Silambuan");
		this.fieldEmail.sendKeys("test@gmail.com");
		this.fieldPhone.sendKeys("+62812312312345");
		this.fieldCompany.sendKeys("PT TEST");
		this.fieldDropdownService.selectByValue("Higospot");
		this.textAreaMessage.sendKeys("Website is very good");
		this.btnSubmit.click();
	}
	
	public String getSuccessMessage() {
		return this.successMessageForm.getText();
	}

}
