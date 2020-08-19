package clear;

import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Download {
	public WebDriver driver;
  @Test
  public void f() {
	  WebElement downloadButton = driver.findElement(By.id("messenger-download"));
	  downloadButton.click();
	  String sourceLocation = downloadButton.getAttribute("href");
	  String wget_command = "cmd /c C:\\Wget\\wget.exe -P D: --no-check-certificate " + sourceLocation;
	  
	/*  try {
	        Process exec = Runtime.getRuntime().exec(wget_command);
	        int exitVal = exec.waitFor();
	        System.out.println("Exit value: " + exitVal);
	        }
	  catch (InterruptedException | IOException ex) {
	        System.out.println(ex.toString());
	        }*/
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "F:\\maven\\chromedriver_win32\\chromedriver.exe");
	   driver=new ChromeDriver();
	    driver.get("http://demo.guru99.com/test/yahoo.html");

  }

 // @AfterTest
 // public void afterTest() {
 // }

}
