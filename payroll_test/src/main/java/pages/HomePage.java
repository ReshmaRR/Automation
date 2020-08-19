package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class HomePage {
	
	static WebDriver driver;
	
	 public HomePage(WebDriver driver)
	    {
	    	this.driver= driver;
	    	PageFactory.initElements(driver, this);
	    }
	 
	
    @FindBy(xpath="//a[@href='#']")
    WebElement settings;
    @FindBy(xpath="//a[@class='logout-btn']")
    WebElement logOut;
    @FindBy(xpath="//div[@class='col-lg-12 col-sm-12']//following::p[1]")
	WebElement welcomePayroll;
    @FindBy(xpath="//*[@id='w1']/li[6]/a")
    WebElement timeSheetButton;
    @FindBy(xpath="//div[@class='col-sm-4 form-area inner']/h1")
    WebElement logInHeader;
    
    
    public String getWelcomeText() {
    	PageUtility.isElementLoaded(driver, welcomePayroll, 2);
    	return welcomePayroll.getText();
    }
    
    public void logout() {
    	
    	PageUtility.isElementLoaded(driver, settings, 2);
    	settings.click();
    	logOut.click();
    }
    
    public String getTextOfHeader() {
    	PageUtility.isElementLoaded(driver, logInHeader, 2);
    	return logInHeader.getText();
    }
    
    public void clickOnTimesheet()  {
    	PageUtility.isElementLoaded(driver, timeSheetButton, 3);
    	timeSheetButton.click();
  
    }
    
   
}
