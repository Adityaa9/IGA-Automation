package utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import framework.ReportsLib;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class Webelement extends ReportsLib {
	

	public void waite(int waiteMinutes) {
		try {
			Thread.sleep(waiteMinutes*1000);
		} catch (InterruptedException e) {
			reportInfo(e.getMessage());
		}
	}
	
	public WebElement findElement(WebDriver webDriver, String xpath) {
		return webDriver.findElement(By.xpath(xpath));
	}
	
	public List<WebElement> findElements(WebDriver webDriver, String xpath) {
		return webDriver.findElements(By.xpath(xpath));
	}
	
	public String getAttribute(WebDriver webDriver, String xpath, String attrbute) {
		try{
			return this.findElement(webDriver, xpath).getAttribute(attrbute);
		}catch(Exception e) {
			return null;
		}
	}
	
	public String getText(WebDriver webDriver, String xpath) {
		try{
			return this.findElement(webDriver, xpath).getText();
		}catch(Exception e) {
			return null;
		}
	}

	public boolean setText(WebDriver webDriver, String xpath, String setValue, String elementName, boolean screenShotFlag) {
		try {
			this.findElement(webDriver, xpath).click();
			this.findElement(webDriver, xpath).sendKeys(setValue);
			reportPass("Provided Value ("+setValue+") in "+elementName, screenShotFlag, webDriver);
			return true;
		}catch(Exception e) {
			reportFailure("Unable to Provided Value ("+setValue+") in "+elementName+""
					+ "</br>"+e.getMessage(), true, webDriver);
			return false;
		}
	}

	public boolean click(WebDriver webDriver, String xpath, String elementName, boolean screenShotFlag) {
		try {
			this.findElement(webDriver, xpath).click();
			reportPass("Clicked on "+elementName, screenShotFlag, webDriver);
			return true;
		}catch(Exception e) {
			reportFailure("Unable to Clicked on "+elementName+" with error"
					+ "<br>"+e.getMessage(), true, webDriver);
			return false;
		}
	}
	
	public boolean waiteTillElementFound(WebDriver webDriver, String xpath) throws InterruptedException {
		boolean exitFlag = true;
		int maxWaiteTime = 30;
		int iterator = 0;
		while(exitFlag && (iterator<maxWaiteTime)) {
			try {
				this.findElement(webDriver, xpath);
				exitFlag = false;
			}catch(NoSuchElementException NSEE) {
				continue;
			}
			Thread.sleep(800);
			iterator++;
		}
		if(iterator >= maxWaiteTime) {
			throw new NoSuchElementException("Element with xpath: "+xpath+" not found");
		}else {
			return true;
		}
	}
	
	public boolean waiteTillElementFound(WebDriver webDriver, String xpath, double maxWaiteTimeInMilliSeconds) throws InterruptedException {
		boolean exitFlag = true;
		int maxWaiteTime = (int) (maxWaiteTimeInMilliSeconds/1000);
		int iterator = 0;
		while(exitFlag && (iterator<maxWaiteTime)) {
			try {
				this.findElement(webDriver, xpath);
				exitFlag = false;
				iterator++;
			}catch(NoSuchElementException NSEE) {
				Thread.sleep(1000);
				iterator++;
				continue;
			}
			
		}
		if(iterator >= maxWaiteTime) {
			return false;
			//throw new NoSuchElementException("Element with xpath: "+xpath+" not found");
		}else {
			return true;
		}
	}
	
	public boolean waiteTillElementFound(WebDriver webDriver, String xpath, double maxWaiteTimeInMilliSeconds, String elementName) throws InterruptedException {
		if(this.waiteTillElementFound(webDriver, xpath, maxWaiteTimeInMilliSeconds)) {
			reportPass(elementName+" is found in UI within "+(maxWaiteTimeInMilliSeconds/1000)+" seconds");
			return true;
		}else {
			reportFailure(elementName+" is not found in UI within "+(maxWaiteTimeInMilliSeconds/1000)+" seconds", true, webDriver);
			return false;
		}
	}
	
	public WebElement getElement(WebDriver webDriver, String xpath, int index) {
		return this.findElements(webDriver, xpath).get(index);
	}
	
	public boolean waiteTillElementFound(WebDriver webDriver, String[] xpath, double maxWaiteTimeInMilliSeconds) throws InterruptedException {
		boolean exitFlag = true;
		int maxWaiteTime = (int) (maxWaiteTimeInMilliSeconds/1000);
		int iterator = 0;
		while(exitFlag && (iterator<maxWaiteTime)) {
			for(int i=0; i<xpath.length; ++i) {
				try {
					this.findElement(webDriver, xpath[i]);
					exitFlag = false;
					break;
				}catch(NoSuchElementException NSEE) {
					continue;
				}
			}
			Thread.sleep(1000);
			iterator++;
		}
		if(iterator >= maxWaiteTime) {
			throw new NoSuchElementException("Element with xpath: "+xpath+" not found");
		}else {
			return true;
		}
	}
	
	public List<WebElement> finElements(WebDriver webDriver, String xpath) {
		return webDriver.findElements(By.xpath(xpath));
	}
	
	public String getAttribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}
	
}