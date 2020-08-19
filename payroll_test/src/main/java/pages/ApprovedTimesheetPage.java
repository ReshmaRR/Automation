package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ApprovedTimesheetPage {
	
	WebDriver driver;
	
	public ApprovedTimesheetPage(WebDriver driver)
    {
    	this.driver= driver;
    	PageFactory.initElements(driver, this);
    }
	
	
	@FindBy(xpath="//div[@class='summary']")
    WebElement summary;
	@FindBy(xpath="//div[@class='grid-view']/table/thead/tr/th[1]")
    WebElement tableHeadingTimesheetNumber;
	@FindBy(xpath="//div[@class='grid-view']/table/thead/tr/th[2]")
    WebElement tableHeadingClient;
	@FindBy(xpath="//div[@class='grid-view']/table/thead/tr/th[3]")
    WebElement tableHeadingWorker;
	@FindBy(xpath="//div[@class='grid-view']/table/thead/tr/th[4]")
    WebElement tableHeadingWeekEndDate;
	@FindBy(xpath="//div[@class='grid-view']/table/thead/tr/th[5]")
    WebElement tableHeadingApprovalStatus;
	@FindBy(xpath="//div[@class='grid-view']/table/tbody/tr/td[3]")
    WebElement tableContentWorkerEduard;
	@FindBy(xpath="//div[@class='grid-view']/table/tbody/tr[8]/td[3]")
    WebElement tableContentWorkerMichael;
	@FindBy(xpath="//span[@class='glyphicon glyphicon-eye-open']")
    WebElement viewIcon;
	@FindBy(xpath="//ul[@class='pagination']")
    WebElement navigationButton;
	@FindBy(xpath="//a[@href='/payrollapp/timesheet']")
    WebElement pendingTimeSheetButton;
	@FindBy(xpath="//a[@href='/payrollapp/timesheet/approvedlist']")
    WebElement approvedTimeSheetButton;
	@FindBy(xpath="//a[@href='/payrollapp/timesheet/create']")
    WebElement creatTimeSheetButton;	
    
    
    public String getTextOfTottalSummary() {
    	PageUtility.isElementLoaded(driver, summary, 3);
    	return summary.getText();
		
    }
    
    public String getTextOfTableHeadingTimesheetNumber() {
    	PageUtility.isElementLoaded(driver, tableHeadingTimesheetNumber, 3);
    	return tableHeadingTimesheetNumber.getText();
		
    }
    
   public  String isPendingTimeSheetButtonsDisplayed() {
    	
		return pendingTimeSheetButton.getText();
    }
    
    public String isApprovedTimeSheetTimeSheetButtonsDisplayed() {
 	   
 	   return approvedTimeSheetButton.getText();
    }
    
    public String isCreatTimeSheetButtonsDisplayed() {
 	   
 	   return creatTimeSheetButton.getText();
    }
 
    
    public String getTextOfTableHeadingClient() {
    	
    	return tableHeadingClient.getText();
		
    }
    
    public String getTextOfTableHeadingWorker() {
    	
    	return tableHeadingWorker.getText();
		
    }
    
    public String getTextOfTableHeadingWeekEndDate() {
    	
    	PageUtility.waitForTextToBePresentInElement(driver, tableHeadingWeekEndDate, 5, "Week End Date");
    	return tableHeadingWeekEndDate.getText();
		
    }
    
    public String getTextOfTableHeadingApprovalStatus() {
    	
    	return tableHeadingApprovalStatus.getText();
		
    }
    
    public String getTextOfTableContentWorkerEduard() {

    	PageUtility.isElementLoaded(driver, tableContentWorkerEduard, 5);
    	return tableContentWorkerEduard.getText();
		
    }

    public String getTextOfTableContentWorkerMichael() {
	
	return tableContentWorkerMichael.getText();
	
}
    
    public boolean isViewIconDisplayed() {
    	
    	PageUtility.isElementLoaded(driver, viewIcon, 5);
    	return viewIcon.isDisplayed();
    	
    }
    
    
    public void scrollDownToBottom() { //utility
    	
    	JavascriptExecutor scroll=(JavascriptExecutor)driver;
    	scroll.executeScript("window.scrollBy(0,2000)");
    }
    
    public boolean isNavigationButtonDisplayed() {
    	
    	PageUtility.isElementLoaded(driver, navigationButton, 5);
    	return navigationButton.isDisplayed();
    	
    }
    
   public boolean isTotalSummaryDisplayed() {
    	
    	PageUtility.isElementLoaded(driver, summary, 5);
    	return summary.isDisplayed();
    	
    }
   
   public String getBackgroundColourOfApprovedTimesheet() { //change to utility
	   PageUtility.isElementLoaded(driver, navigationButton, 5);
	   String backGroundColourOfApprovedTimesheet= approvedTimeSheetButton.getCssValue("border-right-color").toString();
	   return backGroundColourOfApprovedTimesheet;
   }



}
