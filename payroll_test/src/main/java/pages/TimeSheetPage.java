package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;


public class TimeSheetPage {

	 WebDriver driver;
	
	public TimeSheetPage(WebDriver driver)
    {
    	this.driver= driver;
    	PageFactory.initElements(driver, this);
    }
	
    @FindBy(xpath="/html/body/header/div[3]/div/div/div[1]/h1")
    WebElement headerTimeSheet;
    @FindBy(xpath="//a[@href='/payrollapp/timesheet']")
    WebElement pendingTimeSheetButton;
    @FindBy(xpath="//a[@href='/payrollapp/timesheet/approvedlist']")
    WebElement approvedTimesheetButton;
    @FindBy(xpath="//a[@href='/payrollapp/timesheet/create']")
    WebElement createTimesheetButton;
   
    
    
    public String getTextOfHeaderTimeSheet() {
    	PageUtility.isElementLoaded(driver, headerTimeSheet, 3);
    	return headerTimeSheet.getText();
		
    }
    
    public void pendingTimesheetClick() {
    	pendingTimeSheetButton.click();
    	
    }
    
    public void clickOnAPpprovedTimesheetButton() {
    	PageUtility.isElementLoaded(driver, approvedTimesheetButton, 3);
    	approvedTimesheetButton.click();
		
    }
    
    public void clickOnCreateTimesheetButton() {
    	PageUtility.isElementLoaded(driver, createTimesheetButton, 3);
    	createTimesheetButton.click();
		
    }


    
}
