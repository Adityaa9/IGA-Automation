package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Webelement;

public class Roles extends Webelement{	
	
	
	private WebDriver driver;
	
	private String xpath_actionBtn="//a[@class='btn btn-primary']";
	private String xpath_createRole="//a/i[@class='icon-edit']";
	private String xpath_rolename="//input[@id='role_name']";
	private String xpath_description="//input[@id='description']";
	private String xpath_roleTypeClick="//div[@id='s2id_roletype']";
	private String xpath_roleType="//div[@id='select2-drop']/div/input";
	private String xpath_requestableClick="//div[@id='s2id_autogen11']";
	private String xpath_requestable="//div[@id='select2-drop']/div/input";
	private String xpath_createBtn="//a[@class='btn green']";
	private String xpath_SearchRoleList="//input[@id='dtsearch_roleList']";
	private String xpath_roleList="//*[@id='roleList']/tbody/tr";
	private String xpath_roleNameLink="//a[text()='test5']";
	
	// Entitlement Tab
	private String xpath_EntitlementTab="//a[text()='Entitlements']";
	private String xpath_AddEntitlementBtn="//a[@class='btn btn-primary']";
	private String xpath_Entitlement_checkBox="//table[@id='myDataTableentvaltcode1']/tbody/tr[1]/td[1]";
	private String xpath_Save_btn="//button[@id='savebutton']";
	private String xpath_versionTab="//a[text()='Versions']";
	private String xpath_versionKeyEntitlement="//input[@name='versionkey' and @value='2']";
	private String xpath_SendForApproval="//a[@id='sendForApproval']";
	private String xpath_SendForApprovalConfirm="//a[@id='sendForApprovalConfirm']";
	
	//Role Owner Tab
	private String xpath_RoleOwnerTab="//a[text()='Role Owners']";
	private String xpath_ActionButton="//a[text()=' Actions ']";
	private String xpath_addRoleOwnerBtn="//a[@href='#adRoleowner']";
	private String xpath_enterRoleOwner="//input[@id='dtsearch_allusersofloggedmanager']";
	private String xpath_AddOwnerCheckBox="//input[@class='uniform']";
	private String xpath_SaveButton="//button[@id='savebutton']";
	private String xpath_versionKeyOwner="//input[@name='versionkey' and @value='1']";
	
	private String xpath_status="//div[@id='s2id_statusm']";
	
	//get request ID
	private String xpath_requestID="//body[1]/div[7]/div[1]/div[2]/div[2]/p[1]";
	
	//ARS Tab
	private String xpath_ARStab="//a[text()='ARS ']";
	
	
	
	
	public Roles(WebDriver driver) {
		this.driver = driver;
	}	
	
	public boolean ClickActionBtn() {
		return this.click(this.driver, this.xpath_actionBtn, "Click Action Button", false);
	}	

	public boolean ClickCreateRoles() {
		return this.click(this.driver, this.xpath_createRole, "Saviynt Login Button", false);
	}
	
	public boolean setRoleName(String userName) {
		return this.setText(this.driver, this.xpath_rolename, userName, "Enter Role Name", false);
	}
	
	public boolean description(String userName) {
		return this.setText(this.driver, this.xpath_description, userName, "Enter Description", false);
	}
	
	public boolean ClickRolesType() {
		return this.click(this.driver, this.xpath_roleTypeClick, "Click Role Type", false);
	}
	
	public boolean EnterRoleName(String userName) {
		return this.setText(this.driver, this.xpath_roleType, userName, "Enter Role Type", false);
	}
	
	public boolean ClickRequestableBtn() {
		return this.click(this.driver, this.xpath_requestableClick, "Click Requestable button", false);
	}
	
	public boolean EnterRequestable(String userName) {
		return this.setText(this.driver, this.xpath_requestable, userName, "Enter Requestable value", false);
	}
	
	public boolean ClickCreateBtn() {
		return this.click(this.driver, this.xpath_createBtn, "Click Create button", false);
	}
	
	public boolean ClickEntitlementTab() {
		return this.click(this.driver, this.xpath_EntitlementTab, "Click Entitlement Tab", false);
	}
	
	public boolean ClickAddEntitlementBtn() {
		return this.click(this.driver, this.xpath_AddEntitlementBtn, "Click Add Entitlement button", false);
	}
	
	public boolean selectEntitlement() {
		return this.click(this.driver, this.xpath_Entitlement_checkBox, "select entitlement", false);
	}
	
	public boolean ClickSaveBtn() {
		return this.click(this.driver, this.xpath_Save_btn, "Click Save button", false);
	}
	
	public boolean ClickVersionTab() {
		return this.click(this.driver, this.xpath_versionTab, "Click Version Tab", false);
	}
	
	public boolean ClickVersionKeyEntitlement() {
		return this.click(this.driver, this.xpath_versionKeyEntitlement, "Click Version Key", false);
	}
	
	public boolean ClickSendForApprovalBtn() {
		return this.click(this.driver, this.xpath_SendForApproval, "Click Send for Approval Button", false);
	}
	
	public boolean ClickSendForApprovalConfirmBtn() {
		return this.click(this.driver, this.xpath_SendForApprovalConfirm, "Click on Confirm Button", false);
	}
	
	public boolean ClickRoleOwnerTab() {
		return this.click(this.driver, this.xpath_RoleOwnerTab, "Click on Role Owner tab", false);
	}
	
	public boolean ClickActionButton() {
		return this.click(this.driver, this.xpath_ActionButton, "Click on Action Button", false);
	}
	
	public boolean ClickAddRoleOwnerButton() {
		return this.click(this.driver, this.xpath_addRoleOwnerBtn, "Click on Add role Owner Button", false);
	}
	
	public boolean EnterRoleOwner(String userName) {
		return this.setText(this.driver, this.xpath_enterRoleOwner, userName, "Select Role Owner", false);
	}
	
	public boolean ClickCheckBox() {
		return this.click(this.driver, this.xpath_AddOwnerCheckBox, "Click on check Box", false);
	}
	
	public boolean ClickSaveButton() {
		return this.click(this.driver, this.xpath_SaveButton, "Click on check Box", false);
	}
	
	public boolean ClickVersionKeyOwner() {
		return this.click(this.driver, this.xpath_versionKeyOwner, "Click on Radio Button", false);
	}
	
	public boolean ClickARS_Tab() {
		return this.click(this.driver, this.xpath_ARStab, "Click on ARS Tab", false);
	}
	
	public String getRequestID() {
		return this.getText(this.driver, this.xpath_requestID);
	}
	
	public boolean waitforElementVisiblity() throws InterruptedException {
		return this.waiteTillElementFound(this.driver, this.xpath_enterRoleOwner);
	}
	
	public boolean SearchRoleList(String roleName) {
		return this.setText(this.driver, this.xpath_SearchRoleList, roleName, "Enter Role Name", false);
	}
	
	public List<WebElement> GetList() {
		return this.findElements(this.driver, this.xpath_roleList);
	}
	
	public boolean ClickRoleLink() {
		return this.click(this.driver, this.xpath_roleNameLink, "Click on Role Link", false);
	}
	
	public String getStatus() {
		return this.getText(this.driver, this.xpath_status);
	}


}
