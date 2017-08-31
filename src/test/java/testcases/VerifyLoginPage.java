package testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import factory.BrowseFactory;
import factory.DataProviderFactory;


public class VerifyLoginPage {
	WebDriver driver;
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.gecko.driver","C:/geckodriver.exe");
		 driver=BrowseFactory.getBrowser("firefox");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
			
	}
	@Test
	public void testHomePage() throws IOException
	{
		
		HomePage home=PageFactory.initElements(driver,HomePage.class);
	String title=home.getApplicationTitle();
	Assert.assertTrue(title.contains("Demo Store"));
	home.clickOnSigninLink();
	//System.out.println("My Application title is:"+title);
	LoginPage login=PageFactory.initElements(driver, LoginPage.class);
	login.loginApplication(DataProviderFactory.getExcel().getData(0, 0,0),DataProviderFactory.getExcel().getData(0, 0, 1));
	login.verifySignOutLink();
	
	}
	@AfterMethod
	public void tearDown(){
		
		BrowseFactory.closeBrowser(driver);		
	}
}
