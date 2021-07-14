package POM;

import org.openqa.selenium.WebDriver;

import utility.Webelement;

public class UsersPage extends Webelement {
	
	private WebDriver driver;

	private String xpath_pageHeader = "//h3[contains(text(),'Users')]";

	public UsersPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean verifyPageLoads(){
		try {
			return this.waiteTillElementFound(driver, xpath_pageHeader, 5000, "Users Page Header");
		} catch (InterruptedException e) {
			return false;
		}
	}
}
