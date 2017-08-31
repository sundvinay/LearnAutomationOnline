package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver ldriver){
		
		this.driver=ldriver;
	}
	
	@FindBy(xpath="//a[text()='Sign In']") WebElement SignInlink;
    @FindBy(xpath="//a[text()='My Account']") WebElement myAccountLink;
    @FindBy(xpath="//a[text()='My cart']") WebElement myCartLink;
    @FindBy(xpath="//a[text()='Checkout']") WebElement checkOutLink;
    public void clickOnSigninLink()
    {
    	SignInlink.click();
    }
    public void clickOnMyAccountLink(){
    myAccountLink.click();
    }
    
    public void clickOnMyCartLink(){
        myCartLink.click();
        }
    
    public void CheckOutLink(){
        checkOutLink.click();
        }
    public String getApplicationTitle(){
    	
    	return driver.getTitle();
    } 
    
    
    
    
}
