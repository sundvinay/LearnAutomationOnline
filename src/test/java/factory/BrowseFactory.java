package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import dataProvider.ConfigDataProvider;

public class BrowseFactory {
	static WebDriver driver;
	public static WebDriver getBrowser(String browserName){
		if(browserName.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
			
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			
			
			System.setProperty("webdriver.chrome.driver",DataProviderFactory.getConfig().getchromePath());
			driver=new ChromeDriver();
				
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	public static void closeBrowser(WebDriver ldriver){
		
		ldriver.quit();
		
	}
	

}
