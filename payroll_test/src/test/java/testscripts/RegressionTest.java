package testscripts;

import org.testng.annotations.Test;

import pages.ApprovedTimesheetPage;
import pages.CreateTimesheetPage;
import pages.CreatedTimeSheet;
import pages.HomePage;
import pages.InitalCreateTimeSheetPage;
import pages.InvoicePage;
import pages.Login;
import pages.PayslipPage;
import pages.PendingTimesheetPage;
import pages.TimeSheetPage;
import pages.UpdateTimesheetPage;
import pages.ViewDetailsPage;
import utilities.ExcelUtility;
import utilities.PageUtility;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;


public class RegressionTest extends TestHelper{
	
	// @Test(dataProvider="testData")
	  public void verifyUserlogin(String sUserName, String sPassword)  {                                                                                             
			  
			  Login login= new Login(driver);
			  login.loggingIn(sUserName, sPassword);
			  HomePage homePage= new HomePage(driver);
			  Assert.assertEquals(homePage.getWelcomeText(), "Welcome to Payroll Application");
			  
		  }
		
	 
	// @DataProvider
	   public  Object[][] testData() throws IOException {
		 //String path= PageUtility.getExcelPath();
		 //System.out.println(path);
		 
		 ExcelUtility excelUtility= new ExcelUtility();
		 excelUtility.readExcel(excelUtility.getExcelPath(), excelUtility.getSheetName());
		 return excelUtility.logInData;
		 
	          }
	 
	
	// @Test
  public void verifyUserCanlogin()  {                                                                                             
	  
	  Login login= new Login(driver);
	  login.logIn("carol","1q2w3e4r");
	  HomePage homePage= new HomePage(driver);
	  Assert.assertEquals(homePage.getWelcomeText(), "Welcome to Payroll Application");
	  //homePage.logout();
	  
  }
  
   //@Test
  public void verifyUserNameWithRandomString()  {                                                                                             
	  
	  Login login= new Login(driver);
	  login.logIn("1q2w3e4r");
	  HomePage homePage= new HomePage(driver);
	  Assert.assertEquals(homePage.getWelcomeText(), "Welcome to Payroll Application");
	  //homePage.logout();
	  
  }
  
  @Test
  public void verifyUserCanLogOut()  {                                                                                           
	  
	  Login login= new Login(driver);
	  login.logIn("carol","1q2w3e4r");
	  HomePage homePage= new HomePage(driver);
	  homePage.logout();
	  Assert.assertEquals(homePage.getTextOfHeader(), "Login");
	  
	  
  }
  
  //@Test
  public void verifyTimeSheetPageIsLoading() {                                                   
	 
	  Login login= new Login(driver);
	  login.logIn("carol","1q2w3e4r");
	  HomePage homepage= new HomePage(driver);
	  homepage.clickOnTimesheet();
	  TimeSheetPage timesheetPage= new TimeSheetPage(driver);
	  Assert.assertEquals(timesheetPage.getTextOfHeaderTimeSheet(), "TIMESHEETS");
 
  }
 
  //@Test
  public void verifyPendingTimesheetIsLoaded() {   
	  
	  Login login= new Login(driver);
	  login.logIn("carol","1q2w3e4r");
      HomePage homePage= new HomePage(driver);
      homePage.clickOnTimesheet();	  
      TimeSheetPage timesheetPage= new TimeSheetPage(driver);	
      timesheetPage.pendingTimesheetClick();
      PendingTimesheetPage pendingTimesheetPage = new PendingTimesheetPage(driver);
	  Assert.assertEquals(pendingTimesheetPage.getNameOfDisplayedButton(), "Approve Timesheets");
	  
  }
  
  //@Test
  public void verifyButtonsIsDisplayedOnPendingTimesheetPage() {  
	 
	     Login login= new Login(driver);
	     login.logIn("carol","1q2w3e4r");
	     HomePage homepage= new HomePage(driver);
	     homepage.clickOnTimesheet();	
	     PendingTimesheetPage pendingTimesheetPage = new PendingTimesheetPage(driver);
	     Assert.assertEquals(pendingTimesheetPage.isPendingTimeSheetButtonsDisplayed(), "Pending Timesheets");            
		 Assert.assertEquals(pendingTimesheetPage.isApprovedTimeSheetTimeSheetButtonsDisplayed(), "Approved Timesheets");
		 Assert.assertEquals(pendingTimesheetPage.isCreatTimeSheetButtonsDisplayed(), "Create Timesheet");     
			 
   }
  
  //@Test
  public void verifyHomeLinkIsPresentInPendingTimesheetpageToNavigateToDashBoard () {  
	 
	     Login login= new Login(driver);
	     login.logIn("carol","1q2w3e4r");
	     HomePage homepage= new HomePage(driver);
	     homepage.clickOnTimesheet();	
	     PendingTimesheetPage pendingTimesheetPage = new PendingTimesheetPage(driver);
	     pendingTimesheetPage.clickHomeLink();
	     Assert.assertEquals(pendingTimesheetPage.getTextOfHeaderInDashBoard(), "PAYROLL APPLICATION"); 
  }
 
    //@Test
   public void verifyTableHeadingInPendingTimesheetPage() {    
	   
	   Login login= new Login(driver);
	   login.logIn("carol","1q2w3e4r");	 
	   HomePage homePage= new HomePage(driver);
	   homePage.clickOnTimesheet();	
	   PendingTimesheetPage pendingTimesheetPage = new PendingTimesheetPage(driver);
	   Assert.assertEquals(pendingTimesheetPage.getTextOfTableHeadingTimesheetNumber(), "Timesheet Number");            
	   Assert.assertEquals(pendingTimesheetPage.getTextOfTableHeadingClient(), "Client");
	   Assert.assertEquals(pendingTimesheetPage.getTextOfTableHeadingWorker(), "Worker");
	   Assert.assertEquals(pendingTimesheetPage.getTextOfTableHeadingWeekEndDate(), "Week End Date");
	   Assert.assertEquals(pendingTimesheetPage.getTextOfTableHeadingApprovalStatus(), "Approval Status");
   }

   //@Test
   public void verifyIconIsDisplayedInPendingTimesheetTable() {   
	   
	   Login login= new Login(driver);
	   login.logIn("carol","1q2w3e4r");	 
	   HomePage homePage= new HomePage(driver);
	   homePage.clickOnTimesheet();	
	   PendingTimesheetPage pendingTimesheetPage = new PendingTimesheetPage(driver);
	   Assert.assertTrue(pendingTimesheetPage.isIconDisplayed());
	   
   }
   //@Test
   public void verifyViewDetailsPageIsLoasdingOnClickingViewIconInPendingTimesheetTable() {   
	  
	   Login login= new Login(driver);
	   login.logIn("carol","1q2w3e4r");	 
	   HomePage homePage= new HomePage(driver);
	   homePage.clickOnTimesheet();	
	   PendingTimesheetPage pendingTimesheetPage = new PendingTimesheetPage(driver);
	   pendingTimesheetPage.clickViewIcon();
	   ViewDetailsPage viewdetailsPage=new ViewDetailsPage(driver);
	   Assert.assertEquals(viewdetailsPage.getTextOfFieldTimeSheetNumber(), "Timesheet Number");
	   Assert.assertEquals(viewdetailsPage.getTextOfClientField(), "Client");
	   Assert.assertEquals(viewdetailsPage.getTextOfworkerField(), "Worker");
	   
   }
   //@Test
   public void verifyUpdateDetailsPageIsLoadingOnClickingUpdateIconInPendingTimesheetTable() {   
	   
	   Login login= new Login(driver);
	   login.logIn("carol","1q2w3e4r");	 
	   HomePage homePage= new HomePage(driver);
	   homePage.clickOnTimesheet();	
	   PendingTimesheetPage pendingTimesheetPage = new PendingTimesheetPage(driver);
	   pendingTimesheetPage.clickUpdateIcon(); 
	   UpdateTimesheetPage updateTimesheetPage= new UpdateTimesheetPage(driver);
	   Assert.assertEquals(updateTimesheetPage.getTextOfHeaderCreateTimeSheet(), "CREATE TIMESHEET");
	   Assert.assertEquals(updateTimesheetPage.getTextOfBranchField(), "Branch");
	   Assert.assertEquals(updateTimesheetPage.getTextOfDivisionField(), "Division");
	   
   }
   //@Test
   public void verifyTotalSummaryOfPendingSheetsIsDisplayed() {    
	   
	   Login login= new Login(driver);
	   login.logIn("carol","1q2w3e4r");	 
	   HomePage homePage= new HomePage(driver);
	   homePage.clickOnTimesheet();
	   PendingTimesheetPage pendingTimesheetPage = new PendingTimesheetPage(driver);
	   Assert.assertTrue(pendingTimesheetPage.isSummaryDisplayed());
	      
   }
   //@Test
   public void verifyPayslipAndInvoiceButtonIsDisplayedInPendingTimesheetPage() {   
	   
	   Login login= new Login(driver);
	   login.logIn("carol","1q2w3e4r");	 
	   HomePage homePage= new HomePage(driver);
	   homePage.clickOnTimesheet();
	   PendingTimesheetPage pendingTimesheetPage = new PendingTimesheetPage(driver);
	   Assert.assertTrue(pendingTimesheetPage.isPayslipInvoiceButtonDisplayed());	   
	      
   }
   
   //@Test
   public void verifyApproveTimeSheetButtonIsDisplayedInPendingTimesheetPage() {   
	   
	   Login login= new Login(driver);
	   login.logIn("carol","1q2w3e4r");	 
	   HomePage homePage= new HomePage(driver);
	   homePage.clickOnTimesheet();
	   PendingTimesheetPage pendingTimesheetPage = new PendingTimesheetPage(driver);
	   Assert.assertTrue(pendingTimesheetPage.isApproveTimeSheetButtonsDisplayed());	   
	      
   }
   
    // @Test
   public void verifyPayslipIsGenerated() {   
	   
	   Login login= new Login(driver);
	   login.logIn("carol","1q2w3e4r");	 
	   HomePage homePage= new HomePage(driver);
	   homePage.clickOnTimesheet();
	   PendingTimesheetPage pendingTimesheetPage = new PendingTimesheetPage(driver);
	   pendingTimesheetPage.checkBoxClick();
	   pendingTimesheetPage.playSlipButtonClick();
	   pendingTimesheetPage.alertHandling();// rename
	   pendingTimesheetPage.clickOnPayslipLink();
	   PayslipPage payslipPage= new PayslipPage(driver);
	   Assert.assertEquals(payslipPage.getTextOfWorkerNameInPayslip(), "Ramona Panait");
	   
   }

   // @Test
   public void verifyInvoiceIsGenerated() {  
	   
	   Login login= new Login(driver);
	   login.logIn("carol","1q2w3e4r");	 
	   HomePage homePage= new HomePage(driver);
	   homePage.clickOnTimesheet();
	   PendingTimesheetPage pendingTimesheetPage = new PendingTimesheetPage(driver);
	   pendingTimesheetPage.checkBoxClick();
	   pendingTimesheetPage.playSlipButtonClick();
	   pendingTimesheetPage.alertHandling();
	   pendingTimesheetPage.clickOnInvoiceLink();
	   InvoicePage invoicePage= new InvoicePage(driver);
	   Assert.assertEquals(invoicePage.getTextOfClientNameInInvoice(), "Middleton Grove");
  
   }
   
   //@Test
   public void verifyApprovedTimesheetPageIsLoaded() {    
	   
	   Login login= new Login(driver);
	   login.logIn("carol","1q2w3e4r");	 
	   HomePage homePage= new HomePage(driver);
	   homePage.clickOnTimesheet();
	   TimeSheetPage timesheetPage= new TimeSheetPage(driver);	
	   timesheetPage.clickOnAPpprovedTimesheetButton();
	   ApprovedTimesheetPage approvedTimesheetPage= new ApprovedTimesheetPage(driver);
	   Assert.assertEquals(approvedTimesheetPage.getTextOfTottalSummary(), "Showing 1-50 of 8,149 items.");
	   
   }
   
    //@Test
   public void verifyApprovedTimesheetButtonIsSelected() {    //rename by default
	   
	   Login login= new Login(driver);
	   login.logIn("carol","1q2w3e4r");	 
	   HomePage homePage= new HomePage(driver);
	   homePage.clickOnTimesheet();
	   TimeSheetPage timesheetPage= new TimeSheetPage(driver);	
	   timesheetPage.clickOnAPpprovedTimesheetButton();
	   ApprovedTimesheetPage approvedTimesheetPage= new ApprovedTimesheetPage(driver);
	   Assert.assertEquals(approvedTimesheetPage.getBackgroundColourOfApprovedTimesheet(), "rgba(255, 255, 255, 1)");
	   
   }
   //@Test
   public void verifyButtonsIsDisplayedOnApprovedTimesheetPage() {  
  	 
  	     Login login= new Login(driver);
  	     login.logIn("carol","1q2w3e4r");
  	     HomePage homepage= new HomePage(driver);
  	     homepage.clickOnTimesheet();	
  	     TimeSheetPage timesheetPage= new TimeSheetPage(driver);	
	     timesheetPage.clickOnAPpprovedTimesheetButton();
	     ApprovedTimesheetPage approvedTimesheetPage= new ApprovedTimesheetPage(driver);
  	     Assert.assertEquals(approvedTimesheetPage.isPendingTimeSheetButtonsDisplayed(), "Pending Timesheets");            
  		 Assert.assertEquals(approvedTimesheetPage.isApprovedTimeSheetTimeSheetButtonsDisplayed(), "Approved Timesheets");
  		 Assert.assertEquals(approvedTimesheetPage.isCreatTimeSheetButtonsDisplayed(), "Create Timesheet");     
  			 
    }
   
   
   //@Test
   public void verifyTableHeadingInApprovedTimesheetPage() {   
	   
	   Login login= new Login(driver);
	   login.logIn("carol","1q2w3e4r");	 
	   HomePage homePage= new HomePage(driver);
	   homePage.clickOnTimesheet();
	   TimeSheetPage timesheetPage= new TimeSheetPage(driver);	
	   timesheetPage.clickOnAPpprovedTimesheetButton();
	   ApprovedTimesheetPage approvedTimesheetPage= new ApprovedTimesheetPage(driver);
	   Assert.assertEquals(approvedTimesheetPage.getTextOfTableHeadingTimesheetNumber(), "Timesheet Number");
	   Assert.assertEquals(approvedTimesheetPage.getTextOfTableHeadingClient(), "Client");
	   Assert.assertEquals(approvedTimesheetPage.getTextOfTableHeadingWorker(), "Worker");
	   Assert.assertEquals(approvedTimesheetPage.getTextOfTableHeadingWeekEndDate(), "Week End Date");
	   Assert.assertEquals(approvedTimesheetPage.getTextOfTableHeadingApprovalStatus(), "Approval Status");
	   
   }
   
   // @Test 
   public void verifyApprovedTimesheetArePresentInApprovedTimesheetPage() {  
	   
	   Login login= new Login(driver);
	   login.logIn("carol","1q2w3e4r");	 
	   HomePage homePage= new HomePage(driver);
	   homePage.clickOnTimesheet();
	   TimeSheetPage timesheetPage= new TimeSheetPage(driver);	
	   timesheetPage.clickOnAPpprovedTimesheetButton();
	   ApprovedTimesheetPage approvedTimesheetPage= new ApprovedTimesheetPage(driver);
	   Assert.assertEquals(approvedTimesheetPage.getTextOfTableContentWorkerEduard(), "Eduard");
	   Assert.assertEquals(approvedTimesheetPage.getTextOfTableContentWorkerMichael(), "MICHAEL CHARLES");
	   
    }
   
   //@Test
   public void verifyViewIconIsDisplayedInApprovedTimesheetTable() {    
	   
	   Login login= new Login(driver);
	   login.logIn("carol","1q2w3e4r");	 
	   HomePage homePage= new HomePage(driver);
	   homePage.clickOnTimesheet();	
	   TimeSheetPage timesheetPage= new TimeSheetPage(driver);	
	   timesheetPage.clickOnAPpprovedTimesheetButton();
	   ApprovedTimesheetPage approvedTimesheetPage= new ApprovedTimesheetPage(driver);
	   Assert.assertTrue(approvedTimesheetPage.isViewIconDisplayed());
	   
   }
   
   //@Test
   public void verifyTotalSummaryOfApprovedSheetsIsDisplayed() {    
	   
	   Login login= new Login(driver);
	   login.logIn("carol","1q2w3e4r");	 
	   HomePage homePage= new HomePage(driver);
	   homePage.clickOnTimesheet();
	   TimeSheetPage timesheetPage= new TimeSheetPage(driver);	
	   timesheetPage.clickOnAPpprovedTimesheetButton();
	   ApprovedTimesheetPage approvedTimesheetPage= new ApprovedTimesheetPage(driver);
	   Assert.assertTrue(approvedTimesheetPage.isTotalSummaryDisplayed());
   }
   
   // @Test
   public void verifyNavigationButtonIsDisplayedBelowApprovedTimesheetTable() {   
	   
	   Login login= new Login(driver);
	   login.logIn("carol","1q2w3e4r");	 
	   HomePage homePage= new HomePage(driver);
	   homePage.clickOnTimesheet();	
	   TimeSheetPage timesheetPage= new TimeSheetPage(driver);	
	   timesheetPage.clickOnAPpprovedTimesheetButton();
	   ApprovedTimesheetPage approvedTimesheetPage= new ApprovedTimesheetPage(driver);
	   approvedTimesheetPage.scrollDownToBottom();
	   Assert.assertTrue(approvedTimesheetPage.isNavigationButtonDisplayed());
	   
   }
   
   //@Test
   public void verifyInitalCreateTimesheetPageIsLoaded() {   
	   
	   Login login= new Login(driver);
	   login.logIn("carol","1q2w3e4r");	 
	   HomePage homePage= new HomePage(driver);
	   homePage.clickOnTimesheet();	
	   TimeSheetPage timesheetPage= new TimeSheetPage(driver);
	   timesheetPage.clickOnCreateTimesheetButton();
	   InitalCreateTimeSheetPage initalCreateTimeSheetPage= new InitalCreateTimeSheetPage(driver);
	   Assert.assertEquals(initalCreateTimeSheetPage.getTextOfHeaderTimesheetFile(), "Timesheet File");
   }
   
   //@Test
   public void verifyButtonIsPresentInInitalCreateTimesheetPage() {   
	   
	   Login login= new Login(driver);
	   login.logIn("carol","1q2w3e4r");	 
	   HomePage homePage= new HomePage(driver);
	   homePage.clickOnTimesheet();	
	   TimeSheetPage timesheetPage= new TimeSheetPage(driver);
	   timesheetPage.clickOnCreateTimesheetButton();
	   InitalCreateTimeSheetPage initalCreateTimeSheetPage= new InitalCreateTimeSheetPage(driver);
	   Assert.assertTrue(initalCreateTimeSheetPage.isBrowseButtonDisplayed());
	   Assert.assertTrue(initalCreateTimeSheetPage.isSaveButtonDisplayed());
   }
   
   //@Test
   public void verifyCreateTimesheetPageIsLoaded() {   
	   
	   Login login= new Login(driver);
	   login.logIn("carol","1q2w3e4r");	 
	   HomePage homePage= new HomePage(driver);
	   homePage.clickOnTimesheet();	
	   TimeSheetPage timesheetPage= new TimeSheetPage(driver);
	   timesheetPage.clickOnCreateTimesheetButton();
	   InitalCreateTimeSheetPage initalCreateTimeSheetPage= new InitalCreateTimeSheetPage(driver);
	   initalCreateTimeSheetPage.skipButtonClick();
	   CreateTimesheetPage createTimesheetPage= new CreateTimesheetPage(driver);
	   Assert.assertEquals(createTimesheetPage.getTextOfHeaderCreateTimeSheet(), "CREATE TIMESHEET");
	   
   }
   
   //@Test
   public void verifyButtonsIsDisplayedOnCreateTimesheetPage() {  
  	 
  	   Login login= new Login(driver);
  	   login.logIn("carol","1q2w3e4r");
  	   HomePage homepage= new HomePage(driver);
  	   homepage.clickOnTimesheet();	
  	   TimeSheetPage timesheetPage= new TimeSheetPage(driver);
	   timesheetPage.clickOnCreateTimesheetButton();
	   InitalCreateTimeSheetPage initalCreateTimeSheetPage= new InitalCreateTimeSheetPage(driver);
	   initalCreateTimeSheetPage.skipButtonClick();
	   CreateTimesheetPage createTimesheetPage= new CreateTimesheetPage(driver);
  	   Assert.assertEquals(createTimesheetPage.isPendingTimeSheetButtonsDisplayed(), "Pending Timesheets");            
  	   Assert.assertEquals(createTimesheetPage.isApprovedTimeSheetTimeSheetButtonsDisplayed(), "Approved Timesheets");
  	   Assert.assertEquals(createTimesheetPage.isCreatTimeSheetButtonsDisplayed(), "Create Timesheet");     
  			 
    }
   
   //@Test
   public void verifyButtonsIsPresentInCreateTimesheetPage() {   
	   
	   Login login= new Login(driver);
	   login.logIn("carol","1q2w3e4r");	 
	   HomePage homePage= new HomePage(driver);
	   homePage.clickOnTimesheet();	
	   TimeSheetPage timesheetPage= new TimeSheetPage(driver);
	   timesheetPage.clickOnCreateTimesheetButton();
	   InitalCreateTimeSheetPage initalCreateTimeSheetPage= new InitalCreateTimeSheetPage(driver);
	   initalCreateTimeSheetPage.skipButtonClick();
	   CreateTimesheetPage createTimesheetPage= new CreateTimesheetPage(driver);
	   Assert.assertTrue(createTimesheetPage.isAddRatesButtonDisplayed());
	   Assert.assertTrue(createTimesheetPage.isAddExpensesButtonDisplayed());
	   Assert.assertTrue(createTimesheetPage.isAddDeductionButtonDisplayed());
	   Assert.assertTrue(createTimesheetPage.isSaveButtonDisplayed());
      
   }
   
    //@Test
   public void verifyIconsIsPresentInCreateTimesheetPage() {  
	   
	   Login login= new Login(driver);
	   login.logIn("carol","1q2w3e4r");	 
	   HomePage homePage= new HomePage(driver);
	   homePage.clickOnTimesheet();	
	   TimeSheetPage timesheetPage= new TimeSheetPage(driver);
	   timesheetPage.clickOnCreateTimesheetButton();
	   InitalCreateTimeSheetPage initalCreateTimeSheetPage= new InitalCreateTimeSheetPage(driver);
	   initalCreateTimeSheetPage.skipButtonClick();
	   CreateTimesheetPage createTimesheetPage= new CreateTimesheetPage(driver);
	   Assert.assertTrue(createTimesheetPage.isCloseIconDisplayed());
	   Assert.assertTrue(createTimesheetPage.isClearFieldIconDisplayed());
	   Assert.assertTrue(createTimesheetPage.isCalenderIconDisplayed());
   
	   
   }
   
   //@Test
   public void verifyUserIsAbleToCreateNewTimesheet() {   
	   
	   Login login= new Login(driver);
	   login.logIn("carol","1q2w3e4r");	 
	   HomePage homePage= new HomePage(driver);
	   homePage.clickOnTimesheet();	
	   TimeSheetPage timesheetPage= new TimeSheetPage(driver);
	   timesheetPage.clickOnCreateTimesheetButton();
	   InitalCreateTimeSheetPage initalCreateTimeSheetPage= new InitalCreateTimeSheetPage(driver);
	   initalCreateTimeSheetPage.skipButtonClick();
	   CreateTimesheetPage createTimesheetPage= new CreateTimesheetPage(driver);
	   //createTimesheetPage.fieldEnter("Mill","George","20-04-2020","234","10","10","10");
	   createTimesheetPage.enterBranchName();
	   createTimesheetPage.enterClientName("Mill");
	   createTimesheetPage.enterWorkerField("George");
	   createTimesheetPage.weekEndDateField();
	   createTimesheetPage.divisionField();
	   createTimesheetPage.categoryAndJobdropDownField();
	   createTimesheetPage.timesheetNumberField("234");
	   createTimesheetPage.directClientCheckBox();
	   createTimesheetPage.ratesDropDownField();
	   createTimesheetPage.ratesField("10","10","10");
	   createTimesheetPage.clickSavEButton();
	   CreatedTimeSheet createdTimeSheet= new CreatedTimeSheet(driver);
	   Assert.assertEquals(createdTimeSheet.getTextOfCreatedTimeSheetNumber(), "234");
	   Assert.assertEquals(createdTimeSheet.getTextOfCreatedClientName(), "Mill View");
	   Assert.assertEquals(createdTimeSheet.getTextOfCreatedWorkerName(), "George");
	   
   }
   
   //@Test
   public void verifyValidationMessageOfCreateTimesheetPage() {   
	   
	   Login login= new Login(driver);
	   login.logIn("carol","1q2w3e4r");	 
	   HomePage homePage= new HomePage(driver);
	   homePage.clickOnTimesheet();	
	   TimeSheetPage timesheetPage= new TimeSheetPage(driver);
	   timesheetPage.clickOnCreateTimesheetButton();
	   InitalCreateTimeSheetPage initalCreateTimeSheetPage= new InitalCreateTimeSheetPage(driver);
	   initalCreateTimeSheetPage.skipButtonClick();
	   //initalCreateTimeSheetPage.alertHandling();
	   CreateTimesheetPage createTimesheetPage= new CreateTimesheetPage(driver);
	   createTimesheetPage.clickSaveButton();
	   Assert.assertEquals(createTimesheetPage.getTextOfValidationMessageOfBranchField(),"Branch cannot be blank.");
	   Assert.assertEquals(createTimesheetPage.getTextOfValidationMessageOfClientField(),"Client cannot be blank.");
	   Assert.assertEquals(createTimesheetPage.getTextOfValidationMessageOfWorkerField(),"Worker cannot be blank.");
	   Assert.assertEquals(createTimesheetPage.getTextOfValidationMessageOfWeekEndDateField(),"Week End Date cannot be blank.");
	   Assert.assertEquals(createTimesheetPage.getTextOfValidationMessageOfDivisionField(),"Division cannot be blank.");
	   Assert.assertEquals(createTimesheetPage.getTextOfValidationMessageOfCategoryField(), "Category cannot be blank.");
	   Assert.assertEquals(createTimesheetPage.getTextOfValidationMessageOfTimeSheetNumber(),"Timesheet Number cannot be blank.");
	   Assert.assertEquals(createTimesheetPage.getTextOfValidationMessageOfDescriptionField(),"Description cannot be blank.");
	   Assert.assertEquals(createTimesheetPage.getTextOfValidationMessageOfUnitField(),"Units cannot be blank.");
	   Assert.assertEquals(createTimesheetPage.getTextOfValidationMessageOfPayField(),"Pay(£) cannot be blank.");
	   Assert.assertEquals(createTimesheetPage.getTextOfValidationMessageOfBillField(),"Bill(£) cannot be blank.");
	   
   }
   
  
   
 }
