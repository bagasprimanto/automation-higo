package higowebsite.testcases;

import org.testng.annotations.AfterMethod;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import higowebsite.pageobjects.HomePage;

public class BaseTest {

	protected WebDriver driver;
	private HomePage homePage;

	public WebDriver initializeDriver() throws IOException {
		// Properties class
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//resources//GlobalData.properties");
		prop.load(fis);
		
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
		//String browserName = prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			
			// Check headless browser
			ChromeOptions options = new ChromeOptions();
			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}
			
			// Chrome launch
			this.driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900)); // full screen
		}

		if (browserName.equalsIgnoreCase("firefox")) {
			// Firefox
			this.driver = new FirefoxDriver();

		}

		if (browserName.equalsIgnoreCase("edge")) {
			// Edge
			this.driver = new EdgeDriver();
		}

		// Set up implicit wait
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Maximize window
		this.driver.manage().window().maximize();

		return this.driver;
	}

	@BeforeMethod(alwaysRun = true)
	public HomePage launchApplication() throws IOException {

		this.driver = this.initializeDriver();

		this.homePage = new HomePage(this.driver);
		this.homePage.goTo();

		return this.homePage;
	}

	public WebDriver getWebDriver() {
		return this.driver;
	}

	public HomePage getHomePage() {
		return this.homePage;
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		this.driver.quit();
	}

}
