package Testng;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class Listeners implements ITestListener {
  @Override
  public void onTestStart(ITestResult result) {
	  
	  System.out.println("listener is started");
  }
  
  @Override
  public void onTestSuccess(ITestResult result) {
	  
	  System.out.println("listener is done");
  }
}
