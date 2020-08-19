package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import java.util.concurrent.TimeUnit;

public class PageUtility {
	static WebDriver driver;
	
	public static void handleSleep(int time) {
		
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static  WebElement isElementLoaded(WebDriver driver, WebElement elementToBeLoaded, int Time) {
		
		WebDriverWait wait= new WebDriverWait(driver, Time);
		WebElement Element = wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));
		return Element;
		
	}
	
   public static  WebElement waitForElementToBeClickable(WebDriver driver, WebElement elementToBeLoaded, int Time) {
		
		WebDriverWait wait= new WebDriverWait(driver, Time);
		WebElement Element = wait.until(ExpectedConditions.elementToBeClickable(elementToBeLoaded));
		return Element;
		
	}
   
   public static  Boolean waitForTextToBePresentInElement(WebDriver driver, WebElement elementToBeLoaded, int Time, String textToBeDisplayed) {
		
		WebDriverWait wait= new WebDriverWait(driver, Time);
		Boolean Element= wait.until(ExpectedConditions.textToBePresentInElement(elementToBeLoaded, textToBeDisplayed));
		return Element;
		
	}
   
   public static  Boolean waitForElementToBeSelected(WebDriver driver, WebElement elementToBeLoaded, int Time) {
		
 		WebDriverWait wait= new WebDriverWait(driver, Time);
 		Boolean Element= wait.until(ExpectedConditions.elementToBeSelected(elementToBeLoaded));
 		return Element;
 		
 	}

   public static  void isAlertLoaded(WebDriver driver, int Time) {
		
		WebDriverWait wait= new WebDriverWait(driver, Time);
	    wait.until((ExpectedConditions.alertIsPresent()));
		
	}

	 public static void alertHandling() {
		 
		 Alert ob= driver.switchTo().alert();
			ob.accept();
	 }
	 
    public static void toPressEnterInKeyBoard() {
		 
    	 Robot r;
		try {
			r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
		   	r.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	  
	 }
    
    public static void selectDropDown(WebElement elementToBeSelected, String valueToBeSelected) {
    	
    	Select dropDown=new Select(elementToBeSelected);
    	dropDown.selectByValue(valueToBeSelected); 
    	
    }
    
    public static void scrollDownToBottom(String diamentionToScroll) {
    	
    	JavascriptExecutor scroll=(JavascriptExecutor)driver;
    	scroll.executeScript(diamentionToScroll);
    }
    
	 
}    
	
			
			
	


