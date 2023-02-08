package rahulshettypackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handlingdates {

	public static void main(String[] args) throws InterruptedException {
		
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companion/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,900)");
        
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"form-field-travel_comp_date\"]")).click();
        
        //handling months
        
        while(!driver.findElement(By.xpath("//*[@class='cur-month']")).getText().contains("January"))
        {
        	System.out.println(driver.findElement(By.xpath("//*[@class='cur-month']")).getText());
        	Thread.sleep(5000);
        	driver.findElement(By.cssSelector("span.flatpickr-next-month")).click();
        }
        System.out.println("hi3");
        
        @SuppressWarnings("unused")
		List<WebElement> dates = driver.findElements(By.className("flatpickr-day"));
        int count = driver.findElements(By.className("flatpickr-day")).size();
        System.out.println(count);
        Thread.sleep(3000);
        for(int i=0;i<count;i++)
        {
        	System.out.println("hi2");
        	String text = driver.findElements(By.className("flatpickr-day")).get(i).getText();
        	
        	if(text.equalsIgnoreCase("24"))
        	{
        		System.out.println("hi");
        		driver.findElements(By.className("flatpickr-day")).get(i).click();
        		break;
        	}
        }
        

	}

}
