package rahulshettypackage;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Greenkart {
	
	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String[] item = {"Pista","Apple"};
		
		List<WebElement> products = driver.findElements(By.xpath("//*[@class='product-name']"));
		Thread.sleep(1000);
		for(int i=0;i<products.size();i++) {
			
		
			String[] name=products.get(i).getText().split(" ");
			String formattedName=name[0];
			@SuppressWarnings("rawtypes")
			List itemsNeededList = Arrays.asList(item);
			
			if(itemsNeededList.contains(formattedName))
			{
				System.out.println("pass");
			driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
			
			//div[@class='product-action']/button?
			}
			else
			{
				System.out.println("fail");
			}
		}
		
//		for(int i=1;i<products.size();i++)
//		{
//		WebElement boxes = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div["+i+"]"));
		
		Thread.sleep(5000);
		
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[1]/div[3]/button"));
		
		driver.close();
		
		
		
	}
	
	

}
