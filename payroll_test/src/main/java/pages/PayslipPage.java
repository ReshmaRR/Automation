package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class PayslipPage {
	
	 WebDriver driver;
		
		public PayslipPage(WebDriver driver)
	    {
	    	this.driver= driver;
	    	PageFactory.initElements(driver, this);
	    }
		
	    @FindBy(xpath="//div[@class='grid-view']/table/tbody/tr[8]/td[6]")
	    WebElement workerRemona;
	    
	    
	    public String getTextOfWorkerNameInPayslip() {
	    	PageUtility.isElementLoaded(driver, workerRemona, 3);
	    	return workerRemona.getText();
			
	    }

}
