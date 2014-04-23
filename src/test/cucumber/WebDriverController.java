

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverController {

	private static final int WAIT_TIME = 30;
	private static final String BASE_URL = "";
	private WebDriver webDriver;
//	JavascriptExecutor javascriptExecutor;
	
	private static WebDriverController instance;

	private WebDriverController() {
		webDriver = new ChromeDriver();
		
//    JavascriptExecutor javascriptExecutor = (JavascriptExecutor)webDriver;
//    javascriptExecutor.executeScript("document.getElementsByName('body')[0].setAttribute('type', 'text');");
	}
	
	public static WebDriverController getInstance(){
		if(instance == null){
			instance = new WebDriverController();
		}
		return instance;
	}
	
	public void navigateTo(String url) {
		webDriver.navigate().to(BASE_URL + url);
	}
	
	public void stopDriver() {
		if (webDriver != null) {
			webDriver.quit();
		}
	}
	
	public void click(String location){
		Actions mybuilder = waitForElementToBeClickable(location);
		mybuilder.moveToElement(webDriver.findElement(By.xpath(location))).perform();
		webDriver.findElement(By.xpath(location)).click();
	}
	
  public void click(String location, int xOffset, int yOffset){
    Actions mybuilder = waitForElementToBeClickable(location);
    mybuilder.moveToElement(webDriver.findElement(By.xpath(location)), xOffset, yOffset).click().build().perform();
//    webDriver.findElement(By.xpath(location)).click();
  }

  public Actions waitForElementToBeClickable(String location) {
    WebDriverWait mywait = new WebDriverWait(webDriver, WAIT_TIME);
    Actions mybuilder = new Actions(webDriver);
    
    mywait.until(ExpectedConditions.elementToBeClickable(By.xpath(location)));
    return mybuilder;
  }
	
	public WebElement getElement(String location){
	  WebElement webElement =  null;
	  
	  try{
	    webElement = webDriver.findElement(By.xpath(location));
	  }
    catch(NoSuchElementException e){
    }
	  
	  return webElement;
	}
	
	public String getTextNoWait(String location) {
	  String text = "";
	  
	  WebElement webElement = getElement(location);
	  try{
  	  if(webElement != null){
  	    text = webElement.getText();
  	  }
	  }
	  catch(StaleElementReferenceException e){
    }
	  return text;
	}
	
	public String getText(String location, int waitTime) {
	   WebDriverWait mywait = new WebDriverWait(webDriver, waitTime);
	    
	    mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(location)));
	    String text = webDriver.findElement(By.xpath(location)).getText();
	    return text;
	}
	
	public String getText(String location) {
	  return getText(location, WAIT_TIME);
	}
	
	public String getInputTextValue(String location) {

		WebDriverWait mywait = new WebDriverWait(webDriver, WAIT_TIME);
		
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(location)));
		
		return webDriver.findElement(By.xpath(location)).getAttribute("value");

	}
	
	public void setText(String location, String text) {
		
		Actions mybuilder = waitForElementToBeClickable(location);
		mybuilder.moveToElement(webDriver.findElement(By.xpath(location))).perform();
		webDriver.findElement(By.xpath(location)).clear();
		webDriver.findElement(By.xpath(location)).sendKeys(text);
		
	}
	
  public void selectOption(String location, String selectionvalue) {
    
    Actions mybuilder = waitForElementToBeClickable(location);
    mybuilder.moveToElement(webDriver.findElement(By.xpath(location))).perform();
    WebElement dropDownListBox = webDriver.findElement(By.xpath(location)); 
    Select clickThis = new Select(dropDownListBox); 
    clickThis.selectByVisibleText(selectionvalue);
  }
  
  public void check(String location) {
    
    Actions mybuilder = waitForElementToBeClickable(location);
    mybuilder.moveToElement(webDriver.findElement(By.xpath(location))).perform();
    WebElement checkbox = webDriver.findElement(By.xpath(location)); 
    if(!checkbox.isSelected()){
      checkbox.click();
    }
  }

  
  public Object getOptionValue(String location) {
    
    Actions mybuilder = waitForElementToBeClickable(location);
    mybuilder.moveToElement(webDriver.findElement(By.xpath(location))).perform();
    WebElement dropDownListBox = webDriver.findElement(By.xpath(location)); 
    
    return dropDownListBox.getAttribute("value");
  }
  
  public String findTextByXpath(String xpath) {
    return getTextNoWait(xpath);
  }
  
//  public void waitForPageToLoad(){
//    webDriver.
//  }
}
