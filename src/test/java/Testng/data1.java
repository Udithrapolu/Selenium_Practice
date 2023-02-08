package Testng;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class data1 {

	@Test
	public void Open() {
		// TODO Auto-generated method stub

		
		System.out.println("open the app");
	}
	
	@Test
	public void Login()
	{
		System.out.println("click on login");
	}
	
	@Parameters({"user"})
	@Test
	public void User(String user)
	{
		System.out.println("Enter the Username " + user);
	}

	@Parameters({"pass"})
	@Test
	public void Pass(String pass)
	{
		System.out.println("Enter the password " +   pass);
	}
	
	@Test
	public void close()
	{
		System.out.println("click no close");
	}
}
