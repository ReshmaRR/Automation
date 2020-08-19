package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ViewDetailsPage {

static WebDriver driver; 
	
	public ViewDetailsPage(WebDriver driver) {
    	this.driver= driver;
    	PageFactory.initElements(driver, this);
    }
	
	
	@FindBy(xpath="//div[@class='col-lg-6 col-sm-6']/table/tbody/tr/th")
	WebElement timesheetNumberField;
	@FindBy(xpath="//div[@class='col-lg-6 col-sm-6']/table/tbody/tr[2]/th")
	WebElement clientField;
	@FindBy(xpath="//div[@class='col-lg-6 col-sm-6']/table/tbody/tr[3]/th")
	WebElement workerField;
	 
	
	 
	 public String getTextOfFieldTimeSheetNumber() {
		 
		 PageUtility.isElementLoaded(driver, timesheetNumberField, 3);
		return timesheetNumberField.getText();
	 }
	 
	 public String getTextOfClientField() {
		 
		return clientField.getText();
	 }
	 
	 public String getTextOfworkerField() {
		 
		 PageUtility.isElementLoaded(driver, workerField, 3);
		return workerField.getText();
	 }

}
