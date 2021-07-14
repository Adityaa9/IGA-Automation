package POM;

import org.openqa.selenium.WebDriver;

import utility.Webelement;

public class HomePage extends Webelement{
	
	private WebDriver driver;
	
	//Login Screen
	private String xpath_userName = "//input[@id='username']";
	private String xpath_password = "//input[@type='password']";
	private String xpath_loginButton = "//button[@type='submit']";
	
	//Home page
	private String xpath_AdminTab="//a[text()='Admin ']";
	private String xpath_applicationNavigationButton="//a[@class='navbar-brand']";
	
	//Admin Tab
	private String xpath_irep_tab="//li[@id='irep']/a";
	private String xpath_sidebar="//div[@title='TOGGLE SIDEBAR']";
	private String xpath_roles_tab="//li[@id='role']/a";
	
	private String xpath_logOutImg="//i[@class='icon-angle-down']";
	private String xpath_logout="//i[@class='icon-key']";
	private String xpath_LoginAgainBtn="//button[@class='btn blue ']";
	private String xpath_RequestApproval="//p[text()='Approve, deny or redirect access requests from others']";
	
	// Request access for others
	private String xpath_RequestAccessforOthersTab="//p[text()='Create requests for new accounts, roles and access for other users']";
	private String xpath_SearchUser="//input[@id='dtsearch_myDataTable']";
	private String xpath_radioBtn="//input[@id='userkey_28']";
	private String xpath_NextBtn="//button[@id='arsUserNextButton']";
	private String xpath_AddToCart="//table//tbody//tr//td[text()='TestEndPoint']/following-sibling::td[@class='center']//div//a[@class='btn svicon']";
	private String xpath_checkoutBtn="(//a[@id='arsReqAcessCheckout'])[1]";
	private String xpath_AddRoleBtn="//table[@id='myDataTable6_ALL_5_2']//tbody//tr//td[@class='center']//a[@class]";
	private String xpath_nextBtn="//a[@id='nextBtn']";
	private String xpath_commentText="//textarea[@id='comments_global']";
	private String xpath_submitBtn="//a[@id='requestSubmit1']";
	private String xpath_requestID="(//table//tbody//tr//td)[2]";
	
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean clickAdminTab() {
		return this.click(driver, this.xpath_AdminTab, "Admin Tab", false);
	}
	
	public boolean clickSideBar() {
		return this.click(driver, this.xpath_sidebar, "Click Side Bar", false);
	}
	
//	public boolean clickCreateNewRoles() {
//		return this.click(driver, this.xpath_createRoles, "create roles button", false);
//	}

	
	public boolean verifyPageLoads(){
		try {
			return this.waiteTillElementFound(driver, xpath_applicationNavigationButton, 5000, "Saiynt Home Page Icon");
		} catch (InterruptedException e) {
			return false;
		}
	}
	
	public boolean setUserName(String userName) {
		return this.setText(this.driver, this.xpath_userName, userName, "Login User Name", false);
	}
	
	public boolean setPassword(String pasword) {
		return this.setText(this.driver, this.xpath_password, pasword,  "Login Password", true);
	}
	
	public boolean clickLogin() {
		return this.click(this.driver, this.xpath_loginButton, "Saviynt Login Button", false);
	}
	
	public boolean saviyntLogin(String userName, String pasword) {
		if(this.setUserName(userName)) {
			if(this.setPassword(pasword)) {
				return this.clickLogin();
			}else {
				return false;
			}
		}else {
			return false;
		}
		
	}
	
	public boolean ClickIdentityRepositoryTab() {
		return this.click(driver, this.xpath_irep_tab, "Identity Repository Tab", false);
	}
	
	public boolean ClickRolesOption() {
		return this.click(driver, this.xpath_roles_tab, "Roles Option", false);
	}
	
	public boolean ClickLogOutImg() {
		return this.click(driver, this.xpath_logOutImg, "Click Logout Image", false);
	}
	
	public boolean ClickLogOutOption() {
		return this.click(driver, this.xpath_logout, "Click Logout button", false);
	}
	
	public boolean ClickLoginAgainButton() {
		return this.click(driver, this.xpath_LoginAgainBtn, "Click Login Again button", false);
	}
	
	public boolean ClickRequestApprovalTab() {
		return this.click(driver, this.xpath_RequestApproval, "Click Logout button", false);
	}
	
	//Request Access for others
	
	public boolean ClickRequestForOthersTab() {
		return this.click(driver, this.xpath_RequestAccessforOthersTab, "Click Request for others", false);
	}
	
	public boolean searchUser(String userID) {
		return this.setText(this.driver, this.xpath_SearchUser, userID, "Enter User ID", false);
	}
	
	public boolean SelectUser() {
		return this.click(driver, this.xpath_radioBtn, "Click Radio button", false);
	}
	
	public boolean ClickNext() {
		return this.click(driver, this.xpath_NextBtn, "Click Next button", false);
	}
	
	public boolean SelectApplication() {
		return this.click(driver, this.xpath_AddToCart, "Click Add to Cart Button", false);
	}
	
	public boolean ClickCheckoutBtn() {
		return this.click(driver, this.xpath_checkoutBtn, "Click Checkout Button", false);
	}
	
	public boolean SelectRole() {
		return this.click(driver, this.xpath_AddRoleBtn, "Add Role", false);
	}
	
	public boolean ClickNextButton() {
		return this.click(driver, this.xpath_nextBtn, "Click Next button", false);
	}
	
	public boolean EnterComment(String comment) {
		return this.setText(this.driver, this.xpath_commentText, comment, "Enter User ID", false);
	}
	
	public boolean ClickSubmitButton() {
		return this.click(driver, this.xpath_submitBtn, "Click Submit button", false);
	}
	
	public String getRequestID() {
		return this.getText(this.driver, this.xpath_requestID);
	}

//	public boolean hamburgerMenu(String firstLevelMenu, String SecondLevelMenu) {
//		if(this.click(driver, xpath_hamburgerMenu, "Hamburger Menu Icon", false)) {
//			if(this.click(driver, String.format(xpath_hamburgerFirstLevelMenu, firstLevelMenu), firstLevelMenu+" Menu", true)) {
//				this.waite(3);
//				return this.click(driver, String.format(xpath_hamburgerSecondLevelMenu, firstLevelMenu, SecondLevelMenu), SecondLevelMenu+" Menu", true);
//			}else {
//				return false;
//			}
//		}else {
//			return false;
//		}
//	}
//
//	public boolean applicationNavigation(String appName) {
//		if(click(driver, xpath_applicationNavigationButton, "Application Navigation pop up", false)) {
//			return this.click(driver, String.format(xpath_applicationNavigationIcon, appName), appName+" Tile in Application Navigation", true);
//		}else {
//			return false;
//		}
//	}



}
