package higowebsite.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import higowebsite.abstractcomponents.AbstractComponent;

public class BlogNewsArticlePage extends AbstractComponent {

	private WebDriver driver;

	// PageFactory
	@FindBy(xpath = "//h2[text()='Artikel Terbaru']/following-sibling::div/div[@class='@container/list']")
	private WebElement newestArticle;

	@FindBy(css = "input[placeholder='Tulis Nama Kamu']")
	private WebElement fieldCommentNameField;

	@FindBy(css = "textarea[name='comment']")
	private WebElement fieldCommentContentField;

	@FindBy(xpath = "//button[text()='Kirim']")
	private WebElement submitButton;
	
	@FindBy(css="section.gap-4 div.gap-4.divide-y div")
	private List<WebElement> commentsDivs;

	public BlogNewsArticlePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void sendComment(String name, String content) {
		this.fieldCommentNameField.sendKeys(name);
		this.fieldCommentContentField.sendKeys(content);
		this.submitButton.click();
	}
	
	public String[] getLatestCommentContent() {
		String name = commentsDivs.get(0).findElement(By.cssSelector("b")).getText();
		String content = commentsDivs.get(0).findElement(By.cssSelector("p")).getText();
		
		String[] commentContent = {name, content};
		
		return commentContent;
	}
}
