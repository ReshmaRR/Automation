package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class InvoicePage {
	
	 WebDriver driver;
		
		public InvoicePage(WebDriver driver)
	    {
	    	this.driver= driver;
	    	PageFactory.initElements(driver, this);
	    }
		
	    @FindBy(xpath="//div[@class='grid-view']/table/tbody/tr/td[2]")
	    WebElement clientMiddletonGrove;
	    
	    
	    public String getTextOfClientNameInInvoice() {
	    	PageUtility.isElementLoaded(driver, clientMiddletonGrove, 3);
	    	return clientMiddletonGrove.getText();
			
	    }

}
