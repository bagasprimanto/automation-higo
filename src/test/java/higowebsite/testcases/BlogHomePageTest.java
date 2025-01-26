package higowebsite.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import higowebsite.pageobjects.BlogHomePage;
import higowebsite.pageobjects.BlogNewsArticlePage;

public class BlogHomePageTest extends BaseTest{
	
	@Test
	public void openArticleAndComment() {
		String name = "Demetrius B4g4%s";
		String content = "Mantap banget artikelnya!";
		
		
		BlogHomePage blogHomePage = this.getHomePage().goToBlog();
		
		BlogNewsArticlePage newestArticlePage = blogHomePage.goToNewestArticle();
//		
//		newestArticlePage.sendComment(name, content);
//		String[] latestComment = newestArticlePage.getLatestCommentContent();
//		
//		Assert.assertTrue(latestComment[0].equals(name));
//		
//		Assert.assertTrue(latestComment[1].equals(content));
	}
}
