package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Webelement;

public class UserGroup extends Webelement{
	
	private WebDriver driver;
	
	private String xpath_UserGroupTab = "//li[@id='usrgrp']/a";
	private String xpath_ActionBtn="//div[@class='actions']/div";
	private String xpath_createNewUserBtn="//i[@class='icon-edit']";
	private String xpath_UserGroupName="//input[@id='user_groupname']";
	private String xpath_UserGroupDescription="//input[@id='user_groupdescription']";
	private String xpath_createBtn="//button[@onclick='checkAndSubmit()']";
	private String xpath_SearchBox="//input[@id='dtsearch_UsergroupList']";
	private String xpath_UserGroupLink="//table[@id='UsergroupList']/tbody/tr/td[1]/a";
	
	//Group Owner tab
	private String xpath_userGroupOwnerTab="//a[text()='User Group Owner']";
	private String xpath_ActionBTN="(//div[@class='actions'])[3]";
	private String xpath_AddUserGrpOwnerLink="//a[@href='#adUsergroupOwner']";
	private String xpath_SearchBoxOwner="//input[@id='dtsearch_alluserofloggedmanager']";
	private String xpath_selectOwnerCheckBox="//input[@name='ugowner']";
	private String xpath_SaveBtn="//button[@id='savebutton']";
	private String xpath_UserGroupHistoryTab="//li[@id='ugoowner']";
	private String xpath_serchBoxHistroyTab="//input[@id='dtsearch_myDataTablehistory']";
	public String xpath_ListElements="//table[@id='myDataTablehistory']/tbody/tr[1]/td";
	
	private String xpath_userGroupOwnerSearchBox="//input[@id='dtsearch_myDataTableowner']";
	private String xpath_selectUserGroupOwnerTabCheckBox="//input[@name='ownerkey']";
	private String xpath_RemoveOwnerButton="//a[@id='removebutton']";
	
	//User Tab
	private String xpath_userTab="//li[@id='userm']";
	private String xpath_ActionButton="(//a[@class='btn btn-primary'])[1]";
	private String xpath_AddUserToGroupLink="//a[@href='#addUser']";
	private String xpath_searchBoxUser="//input[@id='dtsearch_allusersofloggedmanager']";
	private String xpath_selectUserCheckBox="//input[@name='bpowner1']";
	private String xpath_SaveButton="//button[@id='submitbutton']";
	
	//Remove User 
	private String xpath_SearchUserBox="//input[@id='dtsearch_myDataTableUserGroups_users']";
	private String xpath_chooseUserCheckBox="//input[@name='euserkey']";
	private String xpath_RemoveUserFromGroup="//a[@class='btn red readonlyrolebutton' and @onclick='userlistform1()']";
	
	//Add Owner
	
	
	public UserGroup(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean ClickUserGroupTab() {
		return this.click(driver, this.xpath_UserGroupTab, "Click User group Tab", false);
	}
	
	public boolean ClickActionButton() {
		return this.click(driver, this.xpath_ActionBtn, "Click on Action Button", false);
	}
	
	public boolean ClickCreateNewUserButton() {
		return this.click(driver, this.xpath_createNewUserBtn, "Click on Create New user", false);
	}
	
	public boolean setUserGroupName(String userName) {
		return this.setText(this.driver, this.xpath_UserGroupName, userName, "Enter user group name", false);
	}
	
	public boolean setUserGroupDescription(String userName) {
		return this.setText(this.driver, this.xpath_UserGroupDescription, userName, "user grp description", false);
	}
	
	public boolean ClickCreateButton() {
		return this.click(driver, this.xpath_createBtn, "Click on Create button", false);
	}
	
	public boolean SerchUserGroupCreated(String userName) {
		return this.setText(this.driver, this.xpath_SearchBox, userName, "Search User Created", false);
	}
	
	public boolean ClickUserLink() {
		return this.click(driver, this.xpath_UserGroupLink, "Click on user group Link", false);
	}
	
	//Add owner
	
	public boolean ClickUserGroupOwnerTab() {
		return this.click(driver, this.xpath_userGroupOwnerTab, "Click on user group owner Tab", false);
	}
	
	public boolean ClickActionBtn() {
		return this.click(driver, this.xpath_ActionBTN, "Click on Action Button", false);
	}
	
	public boolean ClickAddUserGroupOwner() {
		return this.click(driver, this.xpath_AddUserGrpOwnerLink, "Click on Add User group owner", false);
	}
	
	public boolean SearchBoxOwner(String userName) {
		return this.setText(this.driver, this.xpath_SearchBoxOwner, userName, "Enter owner", false);
	}
	
	public boolean SelectOwnerCheckbox() {
		return this.click(driver, this.xpath_selectOwnerCheckBox, "Select Owner", false);
	}
	
	public boolean ClickSaveButton() {
		return this.click(driver, this.xpath_SaveBtn, "Click Save Button", false);
	}
	
	public boolean ClickUserGroupHistoryTab() {
		return this.click(driver, this.xpath_UserGroupHistoryTab, "Click User Group History Tab", false);
	}
	
	public boolean EnterUserName(String userName) {
		return this.setText(this.driver, this.xpath_serchBoxHistroyTab, userName, "Search for the user", false);
	}
	
	public List<WebElement> findElements(WebDriver webDriver, String xpath) {
		return webDriver.findElements(By.xpath(xpath));
	}
	
	//Add User Tab
	
	public boolean ClickUserTab() {
		return this.click(driver, this.xpath_userTab, "Click User Tab", false);
	}
	
	public boolean ClickActionBttn() {
		return this.click(driver, this.xpath_ActionButton, "Click Action Button", false);
	}
	
	public boolean ClickAddUserToGroup() {
		return this.click(driver, this.xpath_AddUserToGroupLink, "Click Add user to Group link", false);
	}
	
	public boolean SearchBoxUser(String userName) {
		return this.setText(this.driver, this.xpath_searchBoxUser, userName, "Enter user name", false);
	}
	
	public boolean ClickAddUserCheckBox() {
		return this.click(driver, this.xpath_selectUserCheckBox, "Select User", false);
	}
	
	public boolean ClickSaveBtn() {
		return this.click(driver, this.xpath_SaveButton, "Select User", false);
	}
	
	//Remove User 
	
	public boolean SearchUserBox(String userName) {
		return this.setText(this.driver, this.xpath_SearchUserBox, userName, "Enter user name", false);
	}
	
	public boolean ChooseUserCheckBox() {
		return this.click(driver, this.xpath_chooseUserCheckBox, "Click on check box", false);
	}
	
	public boolean ClickRemoveUserButton() {
		return this.click(driver, this.xpath_RemoveUserFromGroup, "Click on Remove User Button", false);
	}
	
	//Remove owner
	public boolean userGroupOwnerSearchBox(String userName) {
		return this.setText(this.driver, this.xpath_userGroupOwnerSearchBox, userName, "Enter owner name", false);
	}
	
	public boolean selectUserGroupOwnerTabCheckBox() {
		return this.click(driver, this.xpath_selectUserGroupOwnerTabCheckBox, "Click Check box", false);
	}
	
	public boolean ClickRemoveOwnerButton() {
		return this.click(driver, this.xpath_RemoveOwnerButton, "Click Remove Owner Button", false);
	}

}
