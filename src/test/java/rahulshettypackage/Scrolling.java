package rahulshettypackage;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scrolling {

	
	public static void main(String[] args) throws InterruptedException
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(3000);
		js.executeScript("document.querySelector('div.tableFixHead').scrollTop");
		
		
		List<WebElement> list =driver.findElements(By.cssSelector("div.tableFixHead table tbody td:nth-child(4)"));
		
		int total =Integer.parseInt(driver.findElement(By.cssSelector("div.totalAmount")).getText().split(":")[1].trim());
		int sum =0;
		
		for(int i=0;i<list.size();i++)
		{
			sum = sum + Integer.parseInt(driver.findElements(By.cssSelector("div.tableFixHead table tbody td:nth-child(4)")).get(i).getText());
		}
		System.out.println(sum);
	
		Assert.assertEquals(total, sum);
		
	}
}
