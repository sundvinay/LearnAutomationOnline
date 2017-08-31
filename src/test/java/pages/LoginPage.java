package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver ldriver){
		
		this.driver=ldriver;
			
	}
	@FindBy(id="account_sign_in_form_email_id") WebElement username;
	
	@FindBy(id="account_sign_in_form_passwd_id") WebElement pass;
	@FindBy(xpath="//input[@value='Sign In' and @type='submit']") WebElement signUpButton;
	By signout=By.xpath("//div[@class='pre-header']//a[text()='Sign Out']");
	
	public void loginApplication(String user,String password){
	username.sendKeys(user);
	pass.sendKeys(password);
	signUpButton.click();
			
	}
	public void verifySignOutLink(){
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		WebElement ele=wait.until(ExpectedConditions.presenceOfElementLocated(signout));
		String text=ele.getText();
		Assert.assertEquals(text, "Sign Out","Sign Out Not Properly Verified!");
	
	}	
}
