package rahulshettypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class hiiii {

	public static void main(String[] arg)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement text = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/fieldset/legend"));
		System.out.println(text.getText());
		
		WebElement tag = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/fieldset/legend"));
		System.out.println(tag.getTagName());
		
		driver.quit();
	}
}
