package rahulshettypackage.PageObject;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Pageobjectmodel {

	public static void main(String[] args) throws InterruptedException
	{

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://rahulshettyacademy.com/client");

		Loginpage lp= new Loginpage(driver);
		
		//------------username and password
		lp.pagelogininto("rahulshetty@gmail.com", "Iamking@000");
//		driver.findElement(By.cssSelector("input#userEmail")).sendKeys("rahulshetty@gmail.com");
//		driver.findElement(By.cssSelector("input#userPassword")).sendKeys("Iamking@000");
//		driver.findElement(By.cssSelector("input#login")).click();

		//taking all items into list
		List<WebElement> li = driver.findElements(By.cssSelector("div h5 b"));		

		List<WebElement> movetocart = driver.findElements(By.cssSelector("div  button.btn.w-10.rounded"));
		
		List<WebElement> scroll = driver.findElements(By.cssSelector("#products > div.container > div.row > div"));
		
//		System.out.println(scroll.size());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		for (int i = 0; i <= li.size(); i++) {
			
			//checking name with neededitem
			boolean condition = li.get(i).getText().equalsIgnoreCase("QUIRKY");

//			WebElement  = scroll.get(i);

			if (condition == true) {

				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll.get(i));
				wait.until(ExpectedConditions.visibilityOf(scroll.get(i)));

//				scroll.sendKeys(Keys.DOWN);

//				ac.scrollToElement(scroll).perform();
////				System.out.println("hi");
//				WebElement list = li.stream()
//		                .filter(s -> s.findElement(By.cssSelector("div h5 b")).getText().equals("QWERTY")).findFirst()
//		                .orElse(null);
//


				Thread.sleep(1000);
				movetocart.get(i).click();

				

				wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("toast-container"))));

				Thread.sleep(2000);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
						driver.findElement(By.cssSelector("i.fa.fa-shopping-cart")));
				wait.until(
						ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("i.fa.fa-shopping-cart"))));
				Thread.sleep(2000);
				driver.findElement(By.cssSelector("i.fa.fa-shopping-cart")).click();
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
						driver.findElement(By.cssSelector("body > app-root > app-profile > div > div.subtotal.cf.ng-star-inserted > ul > li:nth-child(3) > button")));
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("body > app-root > app-profile > div > div.subtotal.cf.ng-star-inserted > ul > li:nth-child(3) > button"))));

				Thread.sleep(2000);
	
				driver.findElement(By.cssSelector("body > app-root > app-profile > div > div.subtotal.cf.ng-star-inserted > ul > li:nth-child(3) > button")).click();

				driver.findElement(By.xpath("/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[1]/div/input")).sendKeys("ind");
				Thread.sleep(2000);
				List<WebElement> countrylist = driver.findElements(By.cssSelector("[class*='ta-results list-group ng-star-inserted'] button"));
				Thread.sleep(2000);
				System.out.println(countrylist.size());
//		 for(int j=0;j<=countrylist.size();j++)
//				 {
//			        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",countrylist.get(i));
//
//	  				boolean countryname = countrylist.get(i).getText().equalsIgnoreCase("india");
//					System.out.println(countrylist.get(i).getText());
//					 if(countryname == true)
//					 {
//						 countrylist.get(i).click();
//					 }
//				 }

				for (WebElement oo : countrylist) {
					if (oo.getText().equalsIgnoreCase("india")) {

						oo.click();
						break;
					}

				}
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[2]/a")).click();
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("/html/body/app-root/app-thanksorder/app-sidebar/nav")));
				// list.findElement(By.cssSelector(".card-body button:last-of-type")).click();
				Thread.sleep(1000);
				Assert.assertEquals(" Thankyou for the order. ",driver.findElement(By.xpath("//*[@id=\"htmlData\"]/tbody/tr[4]/td/table/tbody/tr/td/table/tbody/tr[1]/td/h1")).getText());
				break;
			}

		}

		System.out.println("done");

		driver.close();

	}
}
