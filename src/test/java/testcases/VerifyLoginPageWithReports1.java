package testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.HomePage;
import pages.LoginPage;
import utility.Helper;
import factory.BrowseFactory;
import factory.DataProviderFactory;


public class VerifyLoginPageWithReports1 {
	private static final String path = null;
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	@BeforeMethod
	public void setUp(){
		report=new ExtentReports(".\\Reports\\LoginPageReport.html",true);
		logger=report.startTest("verify test login");
		
		System.setProperty("webdriver.gecko.driver","C:/geckodriver.exe");
		 driver=BrowseFactory.getBrowser("firefox");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		logger.log(LogStatus.INFO,"Application is open and running");
			
	}
	@Test
	public void testHomePage() throws IOException
	{
		
		HomePage home=PageFactory.initElements(driver,HomePage.class);
		logger.log(LogStatus.INFO,"Home Page is verified");
	String title=home.getApplicationTitle();
	Assert.assertTrue(title.contains("Demo Store"));
	logger.log(LogStatus.PASS,"Page got verified and it is loaded");
	home.clickOnSigninLink();
	logger.log(LogStatus.INFO,"Application gets sign in successfully");
	//System.out.println("My Application title is:"+title);
	LoginPage login=PageFactory.initElements(driver, LoginPage.class);
	login.loginApplication(DataProviderFactory.getExcel().getData(0, 0,0),DataProviderFactory.getExcel().getData(0, 0, 1));
	logger.log(LogStatus.INFO,"user name and pwd got verified successfully");
	login.verifySignOutLink();
	logger.log(LogStatus.INFO,logger.addScreenCapture(Helper.captureSreenshot(driver, "validation2")));
	logger.log(LogStatus.PASS,"Click on sign out link appeared");
	
	}
	@AfterMethod
	public void tearDown(ITestResult result){
		if(result.getStatus()==ITestResult.FAILURE){
	
			Helper.captureSreenshot(driver, result.getName());
			logger.log(LogStatus.FAIL,logger.addScreenCapture(path));
			
		}
		BrowseFactory.closeBrowser(driver);	
		report.endTest(logger);
		report.flush();
	}
}
