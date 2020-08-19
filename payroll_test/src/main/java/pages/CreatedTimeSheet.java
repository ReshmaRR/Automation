package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class CreatedTimeSheet {
	
	WebDriver driver;
	
	public 	CreatedTimeSheet(WebDriver driver)
    {
    	this.driver= driver;
    	PageFactory.initElements(driver, this);
    }
	
	@FindBy(xpath="//div[@class='col-lg-6 col-sm-6']/table/tbody/tr/td")
    WebElement timeSheetNumberNewSheet;
    @FindBy(xpath="//div[@class='col-lg-6 col-sm-6']/table/tbody/tr[2]/td")
    WebElement clientNameNewSheet;
    @FindBy(xpath="//div[@class='col-lg-6 col-sm-6']/table/tbody/tr[3]/td")
    WebElement workerNameNewSheet;
    
    
    public String getTextOfCreatedTimeSheetNumber() {
    	PageUtility.isElementLoaded(driver, timeSheetNumberNewSheet, 7);
    	return timeSheetNumberNewSheet.getText();
    }
    
    public  String getTextOfCreatedClientName() {
    	PageUtility.isElementLoaded(driver, clientNameNewSheet, 5);
    	return clientNameNewSheet.getText();
    
    }
    
    public  String getTextOfCreatedWorkerName() {
    	
    	return workerNameNewSheet.getText();
    }

}
