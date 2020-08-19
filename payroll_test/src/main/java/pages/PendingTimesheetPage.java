package pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GenericUtility;
import utilities.PageUtility;

public class PendingTimesheetPage {
WebDriver driver; 
	
	public PendingTimesheetPage(WebDriver driver) {
    	this.driver= driver;
    	PageFactory.initElements(driver, this);
    }
	
    
    @FindBy(xpath="//button[@type='submit']")
    WebElement approveTimesheetButton;
    @FindBy(xpath="//a[@href='/payrollapp/timesheet']")
    WebElement pendingTimeSheetButton ;
    @FindBy(xpath="//a[@href='/payrollapp/timesheet/approvedlist']")
    WebElement approvedTimeSheetButton;
    @FindBy(xpath="//a[@href='/payrollapp/timesheet/create']")
    WebElement creatTimeSheetButton;
    @FindBy(xpath="//a[@href='/payrollapp/timesheet/index?sort=timesheet_number']")
	WebElement tableHeadingTimesheetNumber; 
    @FindBy(xpath="//a[@href='/payrollapp/timesheet/index?sort=client_id']")
	WebElement tableHeadingClient; 
    @FindBy(xpath="//a[@href='/payrollapp/timesheet/index?sort=worker_id']")
	WebElement tableHeadingWorker; 
    @FindBy(xpath="//a[@href='/payrollapp/timesheet/index?sort=date']")
	WebElement tableHeadingWeekEndDate; 
    @FindBy(xpath="//*[@id='grid']/table/thead/tr/th[6]")
	WebElement tableHeadingApprovalStatus; 
    
	@FindBy(xpath="//*[@id='grid']/table/thead/tr/th")
	List<WebElement>c;
	@FindBy(tagName="th")
	List<WebElement>currentrow; 
	@FindBy(xpath="//*[@id=\'grid\']/table/thead/tr/th")
	List<WebElement>columns;
	@FindBy(xpath="//*[@id=\'grid\']/table/tbody/tr")
	List<WebElement>rows; 
	//@FindBy(xpath="td")
	//List<WebElement> currentrowI;
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement checkBoxIcon;
	@FindBy(xpath="//span[@class='glyphicon glyphicon-eye-open']")
	WebElement viewIcon;
	@FindBy(xpath="//span[@class='glyphicon glyphicon-pencil']")
    WebElement updateIcon;
	@FindBy(xpath="//span[@class='glyphicon glyphicon-check']")
	WebElement approveIcon;
	@FindBy(xpath="//div[@class='summary']")
	WebElement sheetNumbers;
	@FindBy(xpath="//button[@class='btn btn-warning btn-responsive playslip']")
	WebElement playslipButton;
	@FindBy(xpath="//button[@class='btn btn-warning btn-responsive invoice']")
	WebElement invoiceButton;
	@FindBy(xpath="//*[@id='grid']/table/tbody/tr[3]/td/input")
	WebElement checkBoxIconInTable;
	@FindBy(xpath="//a[@href='/payrollapp/payslip/index']")
	WebElement payslipLink;
	@FindBy(xpath="//a[@href='/payrollapp/invoice/index']")
	WebElement invoiceLink;
	@FindBy(xpath="//ul[@class='breadcrumb']/li/a")
	WebElement homeLink;
	@FindBy(xpath="//div[@class='col-sm-6 page-title']/h1")
	WebElement getTextOfHeaderPayroll;
	
	
   
    public String getNameOfDisplayedButton() {
    	
    	PageUtility.isElementLoaded(driver, approveTimesheetButton, 2);
    	return approveTimesheetButton.getText();
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
 
   public String getTextOfTableHeadingTimesheetNumber() {
	   
	   return tableHeadingTimesheetNumber.getText();
   }
   
  public String getTextOfTableHeadingClient() {
	   
	   return tableHeadingClient.getText();
   }
  
   public String getTextOfTableHeadingWorker() {
	   
	   return tableHeadingWorker.getText();
   }
  
   public String getTextOfTableHeadingWeekEndDate() {
	   
	   return tableHeadingWeekEndDate.getText();
   }
  
   public String getTextOfTableHeadingApprovalStatus() {
	   
	   return tableHeadingApprovalStatus.getText();
   }
   
   public boolean isIconDisplayed() {
	   
   	PageUtility.isElementLoaded(driver, checkBoxIcon, 2);
   	return(checkBoxIcon.isDisplayed() && viewIcon.isDisplayed() && updateIcon.isDisplayed() && approveIcon.isDisplayed());
   	
   }
   
   public void clickViewIcon() {
	   
		 PageUtility.isElementLoaded(driver, viewIcon, 2);
		 viewIcon.click();
	 }
   
   public void clickUpdateIcon() {
	   
		 PageUtility.isElementLoaded(driver, updateIcon, 3);
		 updateIcon.click();
		  
	 }
   
   public boolean isSummaryDisplayed() {
	   
		String sheets= sheetNumbers.getText();
		return sheetNumbers.isDisplayed(); 
	 }
   
   public  boolean isPayslipInvoiceButtonDisplayed() {
	   
		 PageUtility.isElementLoaded(driver, playslipButton, 2);
		return (playslipButton.isDisplayed() && invoiceButton.isDisplayed());

	}
   
   public  boolean isApproveTimeSheetButtonsDisplayed() {
   	
		return (approveTimesheetButton.isDisplayed());
   }
   
   public void checkBoxClick() {
   	
   	PageUtility.isElementLoaded(driver, checkBoxIconInTable, 3);
   	checkBoxIconInTable.click();
   	
   }
   
   public void playSlipButtonClick() {
   	
   	playslipButton.click();
   	
   }
   
   public void invoiceButtonClick() {
   	
   	invoiceButton.click();
   	
   }
   
   public void  alertHandling() {
   	
   Alert alert= driver.switchTo().alert();
   PageUtility.handleSleep(5000);
   alert.accept();
   PageUtility.handleSleep(17000); 
   alert.accept();
   
   }
   
   public void clickOnPayslipLink() {
   	
   	payslipLink.click();
   	
   }
   
   public void clickOnInvoiceLink() {
   	
	 invoiceLink.click();
   	
   }
   
   public void clickHomeLink() {
	   
		 PageUtility.isElementLoaded(driver, homeLink, 2);
		 homeLink.click();
		 
   }
   
   public String getTextOfHeaderInDashBoard() {
	   
		 PageUtility.isElementLoaded(driver, getTextOfHeaderPayroll, 2);
		 return getTextOfHeaderPayroll.getText();
		 
 }
}
