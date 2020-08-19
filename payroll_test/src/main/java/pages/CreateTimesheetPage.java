package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.GenericUtility;
import utilities.PageUtility;

public class CreateTimesheetPage {
	
	 WebDriver driver;
		
		public 	CreateTimesheetPage(WebDriver driver)
	    {
	    	this.driver= driver;
	    	PageFactory.initElements(driver, this);
	    }
	
	    @FindBy(xpath="//div[@class='col-sm-6 page-title']/h1")
	    WebElement headerCreateTimeSheet;
	    @FindBy(xpath="//button[@class='pull-right add-item btn btn-success btn-xs']")
	    WebElement addRateButton;
	    @FindBy(xpath="//button[@class='pull-right add-item1 btn btn-success btn-xs']")
	    WebElement addExpenseButton;
	    @FindBy(xpath="//button[@class='pull-right add-item2 btn btn-success btn-xs']")
	    WebElement addDeductionButton;
	    @FindBy(xpath="//div[@class='form-group']/button")
	    WebElement saveButton;
	    @FindBy(xpath="//i[@class='fa fa-close']")
	    WebElement closeIcon;
	    @FindBy(xpath="//i[@class='glyphicon glyphicon-remove']")
	    WebElement clearFieldIcon;
	    @FindBy(xpath="//i[@class='glyphicon glyphicon-calendar']")
	    WebElement calendarIcon;
	    @FindBy(xpath="//select[@id='timesheet-branch_id']/option[2]")
	    WebElement fieldBranch;
	    @FindBy(xpath="//span[@class='select2-selection__arrow']")
	    WebElement arrowOfClientField;
	    @FindBy(xpath="//input[@class='select2-search__field']")
	    WebElement ClientField;
	    @FindBy(xpath="//div[@class='form-group field-timesheet-worker_id required']//child::span[2]")
	    WebElement arrowOfWorkerField;
	    @FindBy(xpath="//input[@class='select2-search__field']")
	    WebElement WorkerField;
	    @FindBy(xpath="//input[@id='timesheet-date']")
	    WebElement weekEndDateField;
	    @FindBy(xpath="//select[@id='timesheet-division_id']/option[2]")
	    WebElement divisionField;
	    @FindBy(xpath="//select[@id='timesheet-category']")
	    WebElement categoryFieldDropDown;
	    @FindBy(xpath="//select[@id='timesheet-description']")
	    WebElement jobDescriptionFieldDropDown;
	    @FindBy(xpath="//input[@id='timesheet-timesheet_number']")
	    WebElement timesheetNumberField;
	    @FindBy(xpath="//input[@id='timesheet-direct_client']")
	    WebElement directClientCheckBox;
	    @FindBy(xpath="//select[@id='rate-0-type_id']")
	    WebElement ratesDescriptionField;
	    @FindBy(xpath="//input[@id='rate-0-units']")
	    WebElement ratesUnitsField;
	    @FindBy(xpath="//input[@id='rate-0-pay']")
	    WebElement ratesPayField;
	    @FindBy(xpath="//input[@id='rate-0-bill']")
	    WebElement ratesBillField;
	    @FindBy(xpath="//span[@class='file-caption-icon']")
	    WebElement uploadFile;
	    @FindBy(xpath="//div[@class='btn btn-primary btn-file']")
	    WebElement browseButton;
	    @FindBy(xpath="//button[@type='submit']")
	    WebElement uploadButton;
	    @FindBy(xpath="//div[@class='btn btn-primary btn-file']")
	    WebElement rowseButton;
	    @FindBy(xpath="//*[@id=\"dynamic-form\"]/div/div[1]/div[1]/div")
	    WebElement validationMessageOfBranch;
	    @FindBy(xpath="//*[@id=\"dynamic-form\"]/div/div[2]/div[1]/div")
	    WebElement validationMessageOfClient;
	    @FindBy(xpath="//*[@id=\"dynamic-form\"]/div/div[3]/div[1]/div")
	    WebElement validationMessageOfWorker;
	    @FindBy(xpath="//*[@id=\"dynamic-form\"]/div/div[2]/div[2]/div[2]")
	    WebElement validationMessageOfWeekEndDate;
	    @FindBy(xpath="//*[@id=\"dynamic-form\"]/div/div[1]/div[2]/div")
	    WebElement validationMessageOfDivision;
	    @FindBy(xpath="//*[@id=\"dynamic-form\"]/div/div[2]/div[3]/div")
	    WebElement validationMessageOfCategory;
	    @FindBy(xpath="//*[@id=\"dynamic-form\"]/div/div[1]/div[4]/div")
	    WebElement validationMessageOfTimeSheetNumber;
	    @FindBy(xpath="//*[@id=\"dynamic-form\"]/div/div[4]/div[1]/div/div[2]/div/div/div/div[1]/div/div")
	    WebElement validationMessageOfDescription;
	    @FindBy(xpath="//*[@id=\"dynamic-form\"]/div/div[4]/div[1]/div/div[2]/div/div/div/div[3]/div/div")
	    WebElement validationMessageOfUnit;
	    @FindBy(xpath="//*[@id=\"dynamic-form\"]/div/div[4]/div[1]/div/div[2]/div/div/div/div[4]/div/div")
	    WebElement validationMessageOfPay;
	    @FindBy(xpath="//*[@id=\"dynamic-form\"]/div/div[4]/div[1]/div/div[2]/div/div/div/div[5]/div/div")
	    WebElement validationMessageOfBill;
	    @FindBy(xpath="//a[@href='/payrollapp/timesheet']")
	    WebElement pendingTimeSheetButton;
		@FindBy(xpath="//a[@href='/payrollapp/timesheet/approvedlist']")
	    WebElement approvedTimeSheetButton;
		@FindBy(xpath="//a[@href='/payrollapp/timesheet/create']")
	    WebElement creatTimeSheetButton;
	 
	    
	    public String getTextOfHeaderCreateTimeSheet() {
	    	PageUtility.isElementLoaded(driver, headerCreateTimeSheet, 8);
	    	return headerCreateTimeSheet.getText();
	    	
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
	    
	    public boolean isAddRatesButtonDisplayed() {
	    	
	    	PageUtility.isElementLoaded(driver, addRateButton, 5);
	    	return addRateButton.isDisplayed();
	    	
	    }
	    
	    public boolean isAddExpensesButtonDisplayed() {
	    	
	    	return addExpenseButton.isDisplayed();
	    	
	    }
	    
	    public boolean isAddDeductionButtonDisplayed() {
	    	
	    	return addDeductionButton.isDisplayed();
	    	
	    }
	    
	    public boolean isSaveButtonDisplayed() {
	    	
	    	PageUtility.isElementLoaded(driver, saveButton, 5);
	    	return saveButton.isDisplayed();
	    	
	    }
	    
        public boolean isCloseIconDisplayed() {
	    	
	    	PageUtility.isElementLoaded(driver, closeIcon, 5);
	    	return closeIcon.isDisplayed();
	    	
	    }


        public boolean isClearFieldIconDisplayed() { 
	
	        return clearFieldIcon.isDisplayed();
	
        }
        
        public boolean isCalenderIconDisplayed() {
	    	
	    	PageUtility.isElementLoaded(driver, calendarIcon, 5);
	    	return calendarIcon.isDisplayed();
	    	
	    }
        
        public void enterBranchName() {
        	fieldBranch.click();

        }
        
        public void enterClientName(String clientName) {
        	arrowOfClientField.click();
        	PageUtility.isElementLoaded(driver, ClientField, 5);
        	ClientField.sendKeys(clientName);
        	PageUtility.toPressEnterInKeyBoard();

        }
        
        public void enterWorkerField(String workerName) {
        	arrowOfWorkerField.click();
        	PageUtility.isElementLoaded(driver, WorkerField, 5);
        	WorkerField.sendKeys(workerName);
        	PageUtility.toPressEnterInKeyBoard();
        }
        
        public void weekEndDateField() {
        	 	
        	weekEndDateField.sendKeys(GenericUtility.currentDate());
        	
        }
        
        public void divisionField() {
        	divisionField.click();
        	
        }
        
        public void categoryAndJobdropDownField() {
        	PageUtility.selectDropDown(categoryFieldDropDown, "Employee");  	
        	PageUtility.selectDropDown(jobDescriptionFieldDropDown, "Support Worker");
        	
        }
        
        public void timesheetNumberField(String timesheetNumber) {
        	
        	timesheetNumberField.sendKeys(timesheetNumber);
        	
        }
        
        public void directClientCheckBox() {
        	directClientCheckBox.click();
        	PageUtility.waitForElementToBeSelected(driver, directClientCheckBox, 7);
        	
        }
        
        public void ratesDropDownField() {
        	PageUtility.selectDropDown(ratesDescriptionField, "5");
        	
        }
        
        public void ratesField(String unitValue, String payValue, String billValue) {
        	JavascriptExecutor scroll=(JavascriptExecutor)driver;
        	scroll.executeScript("window.scrollBy(0,2000)");
        	PageUtility.isElementLoaded(driver, ratesUnitsField, 5);
        	ratesUnitsField.sendKeys(unitValue);
        	ratesPayField.sendKeys(payValue);
        	PageUtility.isElementLoaded(driver, ratesBillField, 5);
        	ratesBillField.sendKeys(billValue);
        	
        }
        
       public void clickSavEButton() {
        	
    	    PageUtility.waitForElementToBeClickable(driver, saveButton, 7);
        	saveButton.click();
        
        }
        		
        public void fieldEnter(String clientName, String workerName, String workEndDate, String timesheetNumber,String unitValue, String payValue, String billValue) {
        	PageUtility.isElementLoaded(driver, fieldBranch, 7);
        	fieldBranch.click();
        	arrowOfClientField.click();
        	PageUtility.isElementLoaded(driver, ClientField, 5);
        	ClientField.sendKeys(clientName);
        	PageUtility.toPressEnterInKeyBoard();
        	
        	arrowOfWorkerField.click();
        	PageUtility.isElementLoaded(driver, WorkerField, 5);
        	WorkerField.sendKeys(workerName);
        	PageUtility.toPressEnterInKeyBoard();
        	
        	weekEndDateField.sendKeys(workEndDate);
        	
        	divisionField.click();
        	
        	PageUtility.selectDropDown(categoryFieldDropDown, "Employee");  	
        	PageUtility.selectDropDown(jobDescriptionFieldDropDown, "Support Worker");
        	
        	timesheetNumberField.sendKeys(timesheetNumber);
        	
        	directClientCheckBox.click();
        	
        	PageUtility.selectDropDown(ratesDescriptionField, "5");
        	//PageUtility.scrollDownToBottom("window.scrollBy(0,1000)");
        	JavascriptExecutor scroll=(JavascriptExecutor)driver;
        	scroll.executeScript("window.scrollBy(0,2000)");
        	
        	PageUtility.isElementLoaded(driver, ratesUnitsField, 5);
        	ratesUnitsField.sendKeys(unitValue);
        	ratesPayField.sendKeys(payValue);
        	
        	PageUtility.isElementLoaded(driver, ratesBillField, 5);
        	ratesBillField.sendKeys(billValue);
        	saveButton.click();
        
        }
        
        public void uploadingFile() {
        	PageUtility.isElementLoaded(driver, browseButton, 7);
        	//uploadFile.sendKeys("/payroll_test/src/test/resources/resourceForTest/4.jpg");
        	browseButton.click();
        	uploadFile.sendKeys("\\C:\\Users\\USER\\Downloads\\TEST PLAN_CareDirect_Company.docx\\");
        	PageUtility.isElementLoaded(driver, uploadButton, 7);
        	uploadButton.click();
        
        }
        
        
        public void clickSaveButton() {
        	
        	JavascriptExecutor scroll=(JavascriptExecutor)driver;
        	scroll.executeScript("window.scrollBy(0,2500)");
        	PageUtility.isElementLoaded(driver, saveButton, 9);
        	saveButton.click();
        
        }
        
        public String getTextOfValidationMessageOfBranchField() {
	    	PageUtility.isElementLoaded(driver, validationMessageOfBranch, 8);
	    	return validationMessageOfBranch.getText();
	    	
	    }
        
        public String getTextOfValidationMessageOfClientField() {
	    	PageUtility.isElementLoaded(driver, validationMessageOfClient, 8);
	    	return validationMessageOfClient.getText();
	    	
	    }
        
        public String getTextOfValidationMessageOfWorkerField() {
	    	
	    	return validationMessageOfWorker.getText();
	    	
	    }
        
        public String getTextOfValidationMessageOfWeekEndDateField() {
	    	
	    	return validationMessageOfWeekEndDate.getText();
	    	
	    }
        
        public String getTextOfValidationMessageOfDivisionField() {
	    	
	    	return validationMessageOfDivision.getText();
	    	
	    }
        
        public String getTextOfValidationMessageOfCategoryField() {
	    	
	    	return validationMessageOfCategory.getText();
	    	
	    }
        
       public String getTextOfValidationMessageOfTimeSheetNumber() {
	    	
	    	return validationMessageOfTimeSheetNumber.getText();
	    	
	    }

       public String getTextOfValidationMessageOfDescriptionField() {
	
    	   return validationMessageOfDescription.getText();
	
       	}

       public String getTextOfValidationMessageOfUnitField() {
	
    	   return validationMessageOfUnit.getText();
	
       }

       public String getTextOfValidationMessageOfPayField() {
	
    	   return validationMessageOfPay.getText();
	
       }
       
       public String getTextOfValidationMessageOfBillField() {
    		
    	   return validationMessageOfBill.getText();
	
       }
  


}
