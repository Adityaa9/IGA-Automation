package POM;

import org.openqa.selenium.WebDriver;

import utility.Webelement;

public class SelectOwner extends Webelement {
	
	private WebDriver driver;
	
	private String xpath_Add_owner_Btn ="//a[@class='btn btn-primary']";
	private String xpath_searchBox="//input[@id='dtsearch_allusersofloggedmanager']";
	private String xpath_checkBox="//input[@name='bpowner']";
	private String xpath_saveBtn="//button[@id='savebutton']";
	
	public SelectOwner(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean AddOwnerClick() {
		return this.click(this.driver, this.xpath_Add_owner_Btn, "Add Owner Button", false);
	}
	
	public boolean searchBox(String userName) {
		return this.setText(this.driver, this.xpath_searchBox, userName, "Search Owner", false);
	}
	
	public boolean CheckBoxClick() {
		return this.click(this.driver, this.xpath_checkBox, "Select owner", false);
	}
	
	public boolean saveBtnClick() {
		return this.click(this.driver, this.xpath_saveBtn, "Click Save Button", false);
	}

}
