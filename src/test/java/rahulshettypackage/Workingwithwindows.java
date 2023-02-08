package rahulshettypackage;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Workingwithwindows {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
//		WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(5));
//		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='blinkingText']")));
		String sys = 	driver.findElement(By.className("blinkingText")).getText();
		System.out.println(sys);
		
//		Thread.sleep(10000);
//		Actions a = new Actions(driver);
//		a.moveToElement(driver.findElement(By.xpath("//*[@class='blinkingText']"))).keyDown(Keys.CONTROL).click().build().perform();
		
//		Actions a= new Actions(driver);
//		a.moveToElement(driver.findElement(By.className("blinkingText"))).click().build().perform();
//		
	
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String>it = windows.iterator();
		String parentid = it.next();
		String childid = it.next();
		driver.switchTo().window(childid);
		
		
//		Selector a  = (Selector) driver.findElement(By.cssSelector(".im-para.red [href]"));
//		System.out.println(a.select());
//		
//		Actions link = new Actions(driver);
//		link.moveToElement(driver.findElement(By.cssSelector(".im-para.red [href]"))).keyDown(Keys.CONTROL+"c").build().perform();
		
//		String link = driver.findElement(By.cssSelector(".im-para.red [href]")).getText();
//		
//		System.out.println(link);
		
//		driver.switchTo().window(parentid);
		
//		driver.findElement(By.cssSelector(".form-group [name]")).sendKeys(link);
		
//		link.moveToElement(driver.findElement(By.cssSelector(".form-group [name]"))).click().keyDown(Keys.CONTROL + "v").build().perform();;
		
		

	}

}
