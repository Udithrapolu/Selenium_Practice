package rahulshettypackage.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Insidepage extends Loginpage{
	
	
	public WebDriver driver;

	public Insidepage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "div h5 b" )
	List<WebElement> li ;	

	@FindBy(css = "div  button.btn.w-10.rounded")
	List<WebElement> movetocart ;
	
	@FindBy(css ="#products > div.container > div.row > div")
	List<WebElement> scroll ;
	

}
