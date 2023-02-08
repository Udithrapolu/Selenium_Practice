package Testng;

import org.testng.annotations.Test;

public class Groups {

	@Test
	public void Submit()
	{
		System.out.println("click on submit button");
	}
	
	@Test(groups= {"data"})
	public void Pageloading()
	{
		System.out.println("page is loading");
	}
	
}
