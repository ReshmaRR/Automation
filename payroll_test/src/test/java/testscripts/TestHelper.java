package testscripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class TestHelper {
	WebDriver driver;
 
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver","F:\\maven\\chromedriver_win32 (1)\\chromedriver.exe"); 
	  driver=new ChromeDriver();
	  driver.get("http://www.qabible.in/payrollapp/site/login");
  }
  
 
  @AfterMethod
	  public void afterMethod(ITestResult r) throws IOException {
		  if(ITestResult.FAILURE==r.getStatus()) {
			  File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  FileUtils.copyFile(f, new File("C:\\Users\\USER\\Desktop\\Screenshot\\ "+r.getName()+".Jpeg"));
		  }
		  driver.close();
  }

}
