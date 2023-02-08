package Testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider {
  @Test(dataProvider="getData")
  public void f(String names,String names1) {
	  
	  System.out.println(names);
	  System.out.println(names1);
  }
  
  @DataProvider
  public  Object[][] getData()
  {
	  Object[][] data = new Object[2][2];
	  data[0][0] = "a";
	  data[0][1] = "b";
	  data[1][0] = "c";
	  data[1][1] = "d";
	  
	  return data;
	  
  }
}
