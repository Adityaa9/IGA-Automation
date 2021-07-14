package POM;

import org.openqa.selenium.WebDriver;

import utility.Webelement;

public class JobControlPage extends Webelement{
	
	private WebDriver driver;
	
	private String xpath_pageHeader = "//h3[contains(text(),'Job Control Panel')]";
	
	public JobControlPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean verifyPageLoads(){
		try {
			return this.waiteTillElementFound(driver, xpath_pageHeader, 5000, "Job COntrol Page Header");
		} catch (InterruptedException e) {
			return false;
		}
	}

}
