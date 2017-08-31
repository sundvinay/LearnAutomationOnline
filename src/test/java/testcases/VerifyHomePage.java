package testcases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import factory.BrowseFactory;
import factory.DataProviderFactory;


public class VerifyHomePage {
	WebDriver driver;
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.gecko.driver","C:/geckodriver.exe");
		 driver=BrowseFactory.getBrowser("firefox");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
			
	}
	@Test
	public void testHomePage()
	{
		
		HomePage home=PageFactory.initElements(driver,HomePage.class);
	String title=home.getApplicationTitle();
	Assert.assertTrue(title.contains("Demo Store"));
	//System.out.println("My Application title is:"+title);
	
	}
	@AfterMethod
	public void tearDown(){
		
		BrowseFactory.closeBrowser(driver);		
	}
}
