package rahulshettypackage;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortingUsingStream {
		
		@Test
		public void Sorting() throws InterruptedException
		{
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
			
			List<WebElement> ls= driver.findElements(By.cssSelector("tbody tr td:nth-child(1)"));
			
			List<String> list = ls.stream().map(s->s.getText()).collect(Collectors.toList());
			List<String> sortedlist = list.stream().sorted().collect(Collectors.toList());
			
//			sortedlist.forEach(s->System.out.println(s));
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/table/thead/tr/th[1]/span[1]")).click();
			
			Thread.sleep(5000);
			List<WebElement> ls2= driver.findElements(By.cssSelector("tbody tr td:nth-child(1)"));

			List<String> list2 = ls2.stream().map(s->s.getText()).collect(Collectors.toList());
			List<String> sortedlist2 = list.stream().sorted().collect(Collectors.toList());
			
			Assert.assertEquals(sortedlist, sortedlist2);
			
		}
		
		
		@Test
		public void CustomStream()
		{
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
			
			List<WebElement> ls= driver.findElements(By.cssSelector("tbody tr td:nth-child(1)"));
			
			List<String> list = ls.stream().filter(s->s.getText().contains("Rice")).map(s->getPricedetail(s)).collect(Collectors.toList());
			
			list.forEach(a->System.out.println(a));
			
			
			
			
		}
		public String getPricedetail(WebElement s)
		{
			WebElement pricevalue = s.findElement(By.xpath("tbody td:nth-child(2)"));
			
			String price = pricevalue.getText();
			
			return price;
		}
}
