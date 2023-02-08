package rahulshettypackage.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage extends Fileconnection{
//	Fileconnection fi =new Fileconnection();
	public WebDriver driver;

	
	public Loginpage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input#userEmail")
	WebElement user;
	
	@FindBy(css=("input#userPassword"))
	WebElement password;

	@FindBy(css=("input#login"))
	WebElement submit;
	
	
	public void pagelogininto(String name,String pass)
	{
		user.sendKeys(name);
		password.sendKeys(pass);
		submit.click();
		
	}
	
	
	
}



