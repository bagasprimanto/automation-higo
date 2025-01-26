package higowebsite.abstractcomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import higowebsite.pageobjects.BlogHomePage;

public class AbstractComponent {
	
	private static WebDriver driver;
	
	//PageFactory
	@FindBy(css="header label[for='navigation-blog']")
	private WebElement headerBlogLink;
	
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public BlogHomePage goToBlog() {
		this.headerBlogLink.click();
		
		return new BlogHomePage(this.driver);
	}

}
