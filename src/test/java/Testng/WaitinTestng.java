package Testng;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WaitinTestng {
	
  @Test(timeOut=10000)
  public void f() {
	  
	  System.out.println("Page is loaded");
  }
  
  @BeforeTest
  public void  wait_time()
  {
	  System.out.println("page is still loading");
  }
  
	  
  @AfterTest
  public void close()
  {
	  System.out.println("window close");
	  
  }
}
