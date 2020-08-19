package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class UpdateTimesheetPage {

WebDriver driver; 
	
	public UpdateTimesheetPage(WebDriver driver) {
    	this.driver= driver;
    	PageFactory.initElements(driver, this);
    }
	
	@FindBy(xpath="//div[@class='col-sm-6 page-title']/h1")
	WebElement upadeIcon;
	@FindBy(xpath="//div[@class='form-group field-timesheet-branch_id required']/label")
	WebElement branchField;
	@FindBy(xpath="//div[@class='form-group field-timesheet-division_id required']/label")
	WebElement divisionField;
	 
	 public String getTextOfHeaderCreateTimeSheet() {
		 PageUtility.isElementLoaded(driver, upadeIcon, 3);
		return upadeIcon.getText();
	 }
	 
	 public String getTextOfBranchField() {
		 PageUtility.isElementLoaded(driver, branchField, 3);
		return branchField.getText();
	 }
	 
	 public String getTextOfDivisionField() {
		
		return divisionField.getText();
	 }
	 
	 
}
