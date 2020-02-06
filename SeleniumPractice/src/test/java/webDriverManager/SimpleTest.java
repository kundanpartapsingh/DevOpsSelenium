package webDriverManager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SimpleTest{
	
	WebDriver driver;
	String baseURL = "https://mvnrepository.com/";
	String expectedTitle = "Maven Repository: Search/Browse/Explore";
	
	
	
	@BeforeTest
	void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(baseURL);
	}

	@Test (priority=1)
	void verifyTitle() {
		
		Assert.assertEquals(driver.getTitle(), expectedTitle,"Title mismatched");
		

	}
	
	@Test (priority=2)
	void isLogoPresent() {
		
		
		boolean logoPresent = driver.findElement(By.xpath("//*[@id=\"logo\"]/a/ximg")).isDisplayed();
		
		
			Assert.assertTrue(logoPresent);
		
	}
	
	@AfterClass
	void closeBrowser() {
		driver.close();
	}

}
