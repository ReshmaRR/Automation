package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class InitalCreateTimeSheetPage {
	
	 WebDriver driver;
		
		public 	InitalCreateTimeSheetPage(WebDriver driver)
	    {
	    	this.driver= driver;
	    	PageFactory.initElements(driver, this);
	    }
		
	    @FindBy(xpath="//button[@class='btn btn-success']")
	    WebElement skipButton;
	    @FindBy(xpath="//label[@class='control-label']")
	    WebElement getHeaderTextTimesheetFile;
	    @FindBy(xpath="//div[@class='btn btn-primary btn-file']")
	    WebElement browseButton;
	    
	   
	    
	    public String getTextOfHeaderTimesheetFile() {
	    	
	    	PageUtility.isElementLoaded(driver, skipButton, 5);
	    	return getHeaderTextTimesheetFile.getText();
			
	    }
	    
	    public boolean isSaveButtonDisplayed() {
	    	
	    	PageUtility.isElementLoaded(driver, skipButton, 5);
	    	return skipButton.isDisplayed();
			
	    }
	    
	    public boolean isBrowseButtonDisplayed() {
	    	
	    	return browseButton.isDisplayed();
			
	    }
	    
	    public void skipButtonClick() {
	    	
	    	PageUtility.isElementLoaded(driver, skipButton, 5);
	    	skipButton.click();
	    	Alert alert= driver.switchTo().alert();
	    	//PageUtility.handleSleep(7000);
	    	PageUtility.isAlertLoaded(driver, 8);
	    	alert.accept();
	    	PageUtility.handleSleep(3000);
			
	    }
	    


}
