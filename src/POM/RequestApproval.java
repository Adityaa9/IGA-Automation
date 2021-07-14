package POM;

import org.openqa.selenium.WebDriver;

import utility.Webelement;

public class RequestApproval extends Webelement {
	
	private WebDriver driver;
	
	private String xpath_searchRequestId="//input[@id='dtsearch_myDataTable123']";
	private String xpath_requestID="//table[@id='myDataTable123']/tbody/tr/td[1]/a";
	private String xpath_AcceptAccount="//i[@class='icon-ok']";
	private String xpath_enterComments="//textarea[@id='approverejectcomments']";
	private String xpath_submitBtn="//button[@id='subcom']";
	private String xpath_AcceptBtn="//div[@class='col-md-3']/button/i[@class='icon-ok']";
	private String xpath_AcceptAll="//a[@class=' buttonaccept btn btn green ']";
	private String xpath_confirmBtn="//a[@class='btn blue']";
	private String xpath_searchIcon="//button[@id='search_myDataTable123']";
	private String xpath_RejectAll="//a[@class=' buttonreject btn btn red ']";
	
	public RequestApproval(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean ClickSearchIcon() {
		return this.click(driver, this.xpath_searchIcon, "Click search icon", false);
	}
	
	public boolean EnterRequestID(String RequestID) {
		return this.setText(this.driver, this.xpath_searchRequestId, RequestID , "Search Request ID", false);
	}
	
	
	
	public boolean ClickRequestLink() {
		return this.click(driver, this.xpath_requestID, "Click request ID link", false);
	}
	
	public boolean ClickAcceptAllButton() {
		return this.click(driver, this.xpath_AcceptAll, "Click Accept All Button", false);
	}
	
	public boolean ClickConfirmButton() {
		return this.click(driver, this.xpath_confirmBtn, "Click confirm button", false);
	}
	
	public boolean ClickRejectAllButton() {
		return this.click(driver, this.xpath_RejectAll, "Click Reject All Button", false);
	}
	
	public boolean ClickAcceptAccount() {
		return this.click(driver, this.xpath_AcceptAccount, "Click Accept Account Button", false);
	}
	
	public boolean EnterComment(String comment) {
		return this.setText(this.driver, this.xpath_enterComments, comment , "Enter Comment", false);
	}
	
	public boolean ClickAcceptButton() {
		return this.click(driver, this.xpath_AcceptBtn, "Click Accept Button", false);
	}
	
	public boolean ClickSubmitButton() {
		return this.click(driver, this.xpath_submitBtn, "Click Submit Button", false);
	}

}
