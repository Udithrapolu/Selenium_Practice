package rahulshettypackage;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Dynamicwaiting {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
//		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		driver.get("https://the-internet.herokuapp.com/dynamic_loading");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/a[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"start\"]/button")).click();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		
		
		@SuppressWarnings("unused")
		WebElement foo = wait.until(new Function<WebDriver , WebElement>() {

			@Override
			public WebElement apply(WebDriver driver) {
				// TODO Auto-generated method stub
				if(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()) {
					
					return driver.findElement(By.cssSelector("[id='finish'] h4"));
				}
				else	
					return null;
			}
			
		});
//		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"finish\"]/h4")));
	    
		System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());
		
		
		
		driver.close();
		
		

	}

}
