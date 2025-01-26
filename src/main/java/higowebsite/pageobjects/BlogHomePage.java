package higowebsite.pageobjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import higowebsite.abstractcomponents.AbstractComponent;

public class BlogHomePage extends AbstractComponent {
	
	private WebDriver driver;
	
	//PageFactory
	@FindBy(xpath="//h2[text()='Artikel Terbaru']/following-sibling::div/div[@class='@container/list']")
	private WebElement newestArticle;	
	
	public BlogHomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public BlogNewsArticlePage goToNewestArticle() {
		this.newestArticle.click();
		
		Set<String> windows = this.driver.getWindowHandles();
		
		Iterator<String> iter = windows.iterator();
		
		String homeWindow = iter.next();
		String blogWindow = iter.next();
		
		this.driver.switchTo().window(blogWindow);
		
		this.goToNewestArticle();
		
		BlogNewsArticlePage article = new BlogNewsArticlePage(this.driver);
		
		article.sendComment(homeWindow, blogWindow);
		
		return article;
	}
}
