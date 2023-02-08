package rahulshettypackage;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;  
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;


public class Testingwebs {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.out.println("hi");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.xpath("//input[@id=\"ctl00_mainContent_ddl_originStation1_CTXT\"]")).click();
		driver.findElement(By.xpath("//a[@text=\"Goa (GOI)\"][1]")).click();
		Thread.sleep(2000);
        driver.findElement(By.xpath("//div[ @id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();
        WebElement text = driver.findElement(By.xpath("//span[@class=\"ui-datepicker-month\"]"));
        System.out.println(text.getText());
         
        WebElement check = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[3]/td[5]/a"));
		if(check.isEnabled())
		{
			Assert.assertTrue(true);
			check.click();
			System.out.println("pass");
		}
		else {
			Assert.assertTrue(false);
			System.out.println("fail");
		}
		Thread.sleep(1000);
		System.out.println("hi2");
		driver.findElement(By.xpath("//*[@id=\"autosuggest\"]")).sendKeys("br");
		Thread.sleep(1000);
		@SuppressWarnings("unused")
		List<WebElement> list = driver.findElements(By.cssSelector("li.ui-menu-item"));
		
		
//		driver.findElement(By.xpath("//*[@id=\"autosuggest\"]")).sendKeys("br");
		Thread.sleep(2000);
		List<WebElement> ldrop = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
	
	    for(WebElement options : ldrop) {
		             System.out.println(options.getText());
		            if(options.getText().equals("Brazil")) {
		            	Thread.sleep(2000);
		                options.click();
		                
		            }
		        }
		
	
//		for (WebElement i : list) {
//////			
//////			String name = i.getText();
//////			System.out.println(name);
//			if(i.getText().equalsIgnoreCase("brazil"))
//			{
//				i.click();
//				//String text1 = name;
//				//driver.findElement(By.partialLinkText(name)).click();
//			}else{
//				System.out.println("failed");
//				break;
//			}
//			
//		}
		Thread.sleep(2000);
		driver.close();
		
		
	}

}
