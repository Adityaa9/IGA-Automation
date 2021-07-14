package testscripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import POM.HomePage;
import POM.UserGroup;
import framework.TestRunner;

public class DummyScrip4 extends TestRunner {
	
	
	//New User Group Creation
	@Test(dataProvider = "test", description = "dummy Test script 4",enabled=false)
	public void userGroupCreation(@SuppressWarnings("rawtypes") Map mObj) throws InterruptedException {
		
	new Actions(driver);	
		
	reportInfo((String) mObj.get("Test Case Name"));
	
	String appUrl = envscop.env("ApplicationURL");
	String adminUser = envscop.env("AdminUsername");
	String adminPass = envscop.env("AdminPassword");
	String usersGroupName=(String) mObj.get("UserGroupName");
	String usersGroupDescription=(String) mObj.get("UserGroupDescription");	
	String usersGroupOwnerName=(String) mObj.get("UserGroupOwnerName");
	
	
	
	HomePage homePage = new HomePage(driver);

	
	driver.get(appUrl);
	
	homePage.saviyntLogin(adminUser, adminPass);
	homePage.verifyPageLoads();
	Thread.sleep(5000);
	homePage.clickAdminTab();
	homePage.ClickIdentityRepositoryTab();
	Thread.sleep(5000);
	
	UserGroup userGroup=new UserGroup(driver);
	Thread.sleep(5000);
	userGroup.ClickUserGroupTab();
	Thread.sleep(5000);
	userGroup.ClickActionButton();
	Thread.sleep(5000);
	userGroup.ClickCreateNewUserButton();
	Thread.sleep(5000);
	userGroup.setUserGroupName(usersGroupName);
	Thread.sleep(5000);
	userGroup.setUserGroupDescription(usersGroupDescription);
	Thread.sleep(5000);
	userGroup.ClickCreateButton();
	Thread.sleep(5000);
	userGroup.SerchUserGroupCreated(usersGroupName +Keys.ENTER);
	Thread.sleep(5000);
	userGroup.ClickUserLink();
	Thread.sleep(5000);
	userGroup.ClickUserGroupOwnerTab();
	Thread.sleep(5000);
	userGroup.ClickActionBtn();
	Thread.sleep(5000);
	userGroup.ClickAddUserGroupOwner();
	Thread.sleep(5000);
	userGroup.SearchBoxOwner(usersGroupOwnerName +Keys.ENTER);
	Thread.sleep(5000);
	userGroup.SelectOwnerCheckbox();
	Thread.sleep(5000);
	userGroup.ClickSaveButton();
	Thread.sleep(5000);
	userGroup.ClickUserGroupHistoryTab();
	Thread.sleep(5000);
	userGroup.EnterUserName(usersGroupName +Keys.ENTER);
	Thread.sleep(5000);
	List<WebElement> attributes=userGroup.findElements(driver, userGroup.xpath_ListElements);
	for(int i=0;i<attributes.size();i++) {
		System.out.println(attributes.get(i).getText());
	}
	}
	
	//New User Group Creation
		@Test(dataProvider = "test", description = "dummy Test script 4",enabled=false)
		public void userGroupCreationNonAdmin(@SuppressWarnings("rawtypes") Map mObj) throws InterruptedException {
			
		new Actions(driver);	
			
		reportInfo((String) mObj.get("Test Case Name"));
		
		String appUrl = envscop.env("ApplicationURL");
		String User = envscop.env("NonAdminUser");
		String Password = envscop.env("Password");
		String usersGroupName=(String) mObj.get("UserGroupName");
		String usersGroupDescription=(String) mObj.get("UserGroupDescription");	
		String usersGroupOwnerName=(String) mObj.get("UserGroupOwnerName");
		
		
		
		HomePage homePage = new HomePage(driver);

		
		driver.get(appUrl);
		
		homePage.saviyntLogin(User, Password);
		homePage.verifyPageLoads();
		Thread.sleep(5000);
		homePage.clickAdminTab();
		homePage.ClickIdentityRepositoryTab();
		Thread.sleep(5000);
		
		UserGroup userGroup=new UserGroup(driver);
		Thread.sleep(5000);
		userGroup.ClickUserGroupTab();
		Thread.sleep(5000);
		userGroup.ClickActionButton();
		Thread.sleep(5000);
		userGroup.ClickCreateNewUserButton();
		Thread.sleep(5000);
		userGroup.setUserGroupName(usersGroupName);
		Thread.sleep(5000);
		userGroup.setUserGroupDescription(usersGroupDescription);
		Thread.sleep(5000);
		userGroup.ClickCreateButton();
		Thread.sleep(5000);
		userGroup.SerchUserGroupCreated(usersGroupName +Keys.ENTER);
		Thread.sleep(5000);
		userGroup.ClickUserLink();
		Thread.sleep(5000);
		userGroup.ClickUserGroupOwnerTab();
		Thread.sleep(5000);
		userGroup.ClickActionBtn();
		Thread.sleep(5000);
		userGroup.ClickAddUserGroupOwner();
		Thread.sleep(5000);
		userGroup.SearchBoxOwner(usersGroupOwnerName +Keys.ENTER);
		Thread.sleep(5000);
		userGroup.SelectOwnerCheckbox();
		Thread.sleep(5000);
		userGroup.ClickSaveButton();
		Thread.sleep(5000);
		userGroup.ClickUserGroupHistoryTab();
		Thread.sleep(5000);
		userGroup.EnterUserName(usersGroupName +Keys.ENTER);
		Thread.sleep(5000);
		List<WebElement> attributes=userGroup.findElements(driver, userGroup.xpath_ListElements);
		for(int i=0;i<attributes.size();i++) {
			System.out.println(attributes.get(i).getText());
		}
		}
	
	
	//Add member to group
	@Test(dataProvider = "test", description = "dummy Test script 4",enabled=false)
	public void addUsertoUserGroup(@SuppressWarnings("rawtypes") Map mObj) throws InterruptedException {
		
	new Actions(driver);	
		
	reportInfo((String) mObj.get("Test Case Name"));
	
	String appUrl = envscop.env("ApplicationURL");
	String adminUser = envscop.env("AdminUsername");
	String adminPass = envscop.env("AdminPassword");
	
	String usersGroupName=(String) mObj.get("UserGroupName");
	String userName=(String) mObj.get("UserName");
	
	HomePage homePage = new HomePage(driver);

	
	driver.get(appUrl);
	
	homePage.saviyntLogin(adminUser, adminPass);
	homePage.verifyPageLoads();
	Thread.sleep(5000);
	homePage.clickAdminTab();
	homePage.ClickIdentityRepositoryTab();
	Thread.sleep(5000);
	
	UserGroup userGroup=new UserGroup(driver);
	Thread.sleep(5000);
	userGroup.ClickUserGroupTab();
	Thread.sleep(5000);
	userGroup.SerchUserGroupCreated(usersGroupName +Keys.ENTER);
	Thread.sleep(5000);
	userGroup.ClickUserLink();
	Thread.sleep(5000);
	userGroup.ClickUserTab();
	Thread.sleep(5000);
	userGroup.ClickActionBttn();
	Thread.sleep(5000);
	userGroup.ClickAddUserToGroup();
	Thread.sleep(5000);
	userGroup.SearchBoxUser(userName +Keys.ENTER);
	Thread.sleep(5000);
	userGroup.ClickAddUserCheckBox();
	Thread.sleep(5000);
	userGroup.ClickSaveBtn();	
	}
	
	//Add Member to group
	@Test(dataProvider = "test", description = "dummy Test script 4",enabled=false)
	public void addUsertoUserGroupNonAdmin(@SuppressWarnings("rawtypes") Map mObj) throws InterruptedException {
		
	new Actions(driver);	
		
	reportInfo((String) mObj.get("Test Case Name"));
	
	String appUrl = envscop.env("ApplicationURL");
	String User = envscop.env("NonAdminUser");
	String Password = envscop.env("Password");
	
	String usersGroupName=(String) mObj.get("UserGroupName");
	String userName=(String) mObj.get("UserName");
	
	HomePage homePage = new HomePage(driver);

	
	driver.get(appUrl);
	
	homePage.saviyntLogin(User, Password);
	homePage.verifyPageLoads();
	Thread.sleep(5000);
	homePage.clickAdminTab();
	homePage.ClickIdentityRepositoryTab();
	Thread.sleep(5000);
	
	UserGroup userGroup=new UserGroup(driver);
	Thread.sleep(5000);
	userGroup.ClickUserGroupTab();
	Thread.sleep(5000);
	userGroup.SerchUserGroupCreated(usersGroupName +Keys.ENTER);
	Thread.sleep(5000);
	userGroup.ClickUserLink();
	Thread.sleep(5000);
	userGroup.ClickUserTab();
	Thread.sleep(5000);
	userGroup.ClickActionBttn();
	Thread.sleep(5000);
	userGroup.ClickAddUserToGroup();
	Thread.sleep(5000);
	userGroup.SearchBoxUser(userName +Keys.ENTER);
	Thread.sleep(5000);
	userGroup.ClickAddUserCheckBox();
	Thread.sleep(5000);
	userGroup.ClickSaveBtn();	
	}
	
	//Remove User from the group	
	@Test(dataProvider = "test", description = "dummy Test script 4",enabled=false)
	public void deleteUserFromUserGroup(@SuppressWarnings("rawtypes") Map mObj) throws InterruptedException {
		
	new Actions(driver);	
		
	reportInfo((String) mObj.get("Test Case Name"));
	
	String appUrl = envscop.env("ApplicationURL");
	String adminUser = envscop.env("AdminUsername");
	String adminPass = envscop.env("AdminPassword");
	
	String usersGroupName=(String) mObj.get("UserGroupName");
	String userName=(String) mObj.get("UserName");
	
	
	HomePage homePage = new HomePage(driver);

	
	driver.get(appUrl);
	
	homePage.saviyntLogin(adminUser, adminPass);
	homePage.verifyPageLoads();
	Thread.sleep(5000);
	homePage.clickAdminTab();
	homePage.ClickIdentityRepositoryTab();
	Thread.sleep(5000);
	
	UserGroup userGroup=new UserGroup(driver);
	Thread.sleep(5000);
	userGroup.ClickUserGroupTab();
	Thread.sleep(5000);
	userGroup.SerchUserGroupCreated(usersGroupName +Keys.ENTER);
	Thread.sleep(5000);
	userGroup.ClickUserLink();
	Thread.sleep(5000);
	userGroup.ClickUserTab();
	Thread.sleep(5000);
	userGroup.SearchUserBox(userName +Keys.ENTER);
	Thread.sleep(5000);
	userGroup.ChooseUserCheckBox();
	Thread.sleep(5000);
	userGroup.ClickRemoveUserButton();	
	}
	
	
	//Remove User from the group	
		@Test(dataProvider = "test", description = "dummy Test script 4",enabled=false)
		public void deleteUserFromUserGroupNonAdmin(@SuppressWarnings("rawtypes") Map mObj) throws InterruptedException {
			
		new Actions(driver);	
			
		reportInfo((String) mObj.get("Test Case Name"));
		
		String appUrl = envscop.env("ApplicationURL");
		String User = envscop.env("NonAdminUser");
		String Password = envscop.env("Password");
		
		String usersGroupName=(String) mObj.get("UserGroupName");
		String userName=(String) mObj.get("UserName");
		
		
		HomePage homePage = new HomePage(driver);

		
		driver.get(appUrl);
		
		homePage.saviyntLogin(User, Password);
		homePage.verifyPageLoads();
		Thread.sleep(5000);
		homePage.clickAdminTab();
		homePage.ClickIdentityRepositoryTab();
		Thread.sleep(5000);
		
		UserGroup userGroup=new UserGroup(driver);
		Thread.sleep(5000);
		userGroup.ClickUserGroupTab();
		Thread.sleep(5000);
		userGroup.SerchUserGroupCreated(usersGroupName +Keys.ENTER);
		Thread.sleep(5000);
		userGroup.ClickUserLink();
		Thread.sleep(5000);
		userGroup.ClickUserTab();
		Thread.sleep(5000);
		userGroup.SearchUserBox(userName +Keys.ENTER);
		Thread.sleep(5000);
		userGroup.ChooseUserCheckBox();
		Thread.sleep(5000);
		userGroup.ClickRemoveUserButton();	
		}
	
	
	//Add Owner to the Group
	@Test(dataProvider = "test", description = "dummy Test script 4",enabled=false)
	public void addOwnertoUserGroup(@SuppressWarnings("rawtypes") Map mObj) throws InterruptedException {
		
	new Actions(driver);	
		
	reportInfo((String) mObj.get("Test Case Name"));
	
	String appUrl = envscop.env("ApplicationURL");
	String adminUser = envscop.env("AdminUsername");
	String adminPass = envscop.env("AdminPassword");
	
	String usersGroup=(String) mObj.get("UserGroupName");
	String userGroupOwner=(String) mObj.get("UserGroupOwnerName");
	
	
	HomePage homePage = new HomePage(driver);

	
	driver.get(appUrl);
	
	homePage.saviyntLogin(adminUser, adminPass);
	homePage.verifyPageLoads();
	Thread.sleep(5000);
	homePage.clickAdminTab();
	homePage.ClickIdentityRepositoryTab();
	Thread.sleep(5000);
	
	UserGroup userGroup=new UserGroup(driver);
	Thread.sleep(5000);
	userGroup.ClickUserGroupTab();
	Thread.sleep(5000);
	userGroup.SerchUserGroupCreated(usersGroup +Keys.ENTER);
	Thread.sleep(5000);
	userGroup.ClickUserLink();
	Thread.sleep(5000);
	userGroup.ClickUserGroupOwnerTab();
	Thread.sleep(5000);
	userGroup.ClickActionBtn();
	Thread.sleep(5000);
	userGroup.ClickAddUserGroupOwner();
	Thread.sleep(5000);
	userGroup.SearchBoxOwner(userGroupOwner +Keys.ENTER);
	Thread.sleep(5000);
	userGroup.SelectOwnerCheckbox();
	Thread.sleep(5000);
	userGroup.ClickSaveButton();
	Thread.sleep(5000);	
	}
	
	
	//Add Owner to the Group
	@Test(dataProvider = "test", description = "dummy Test script 4",enabled=false)
	public void addOwnertoUserGroupNonAdmin(@SuppressWarnings("rawtypes") Map mObj) throws InterruptedException {
		
	new Actions(driver);	
		
	reportInfo((String) mObj.get("Test Case Name"));
	
	String appUrl = envscop.env("ApplicationURL");
	String User = envscop.env("NonAdminUser");
	String Password = envscop.env("Password");
	
	String usersGroup=(String) mObj.get("UserGroupName");
	String userGroupOwner=(String) mObj.get("UserGroupOwnerName");
	
	
	HomePage homePage = new HomePage(driver);

	
	driver.get(appUrl);
	
	homePage.saviyntLogin(User, Password);
	homePage.verifyPageLoads();
	Thread.sleep(5000);
	homePage.clickAdminTab();
	homePage.ClickIdentityRepositoryTab();
	Thread.sleep(5000);
	
	UserGroup userGroup=new UserGroup(driver);
	Thread.sleep(5000);
	userGroup.ClickUserGroupTab();
	Thread.sleep(5000);
	userGroup.SerchUserGroupCreated(usersGroup +Keys.ENTER);
	Thread.sleep(5000);
	userGroup.ClickUserLink();
	Thread.sleep(5000);
	userGroup.ClickUserGroupOwnerTab();
	Thread.sleep(5000);
	userGroup.ClickActionBtn();
	Thread.sleep(5000);
	userGroup.ClickAddUserGroupOwner();
	Thread.sleep(5000);
	userGroup.SearchBoxOwner(userGroupOwner +Keys.ENTER);
	Thread.sleep(5000);
	userGroup.SelectOwnerCheckbox();
	Thread.sleep(5000);
	userGroup.ClickSaveButton();
	Thread.sleep(5000);	
	}
	
	
	//Remove Owner to the Group
	@Test(dataProvider = "test", description = "dummy Test script 4",enabled=true)
	public void removeOwnertoUserGroup(@SuppressWarnings("rawtypes") Map mObj) throws InterruptedException {
		
		
		
	reportInfo((String) mObj.get("Test Case Name"));
	
	String appUrl = envscop.env("ApplicationURL");
	String adminUser = envscop.env("AdminUsername");
	String adminPass = envscop.env("AdminPassword");
	
	
	String usersGroup=(String) mObj.get("UserGroupName");
	String userGroupOwner=(String) mObj.get("UserGroupOwnerName");
	
	
	HomePage homePage = new HomePage(driver);

	
	driver.get(appUrl);
	
	homePage.saviyntLogin(adminUser, adminPass);
	homePage.verifyPageLoads();
	Thread.sleep(5000);
	homePage.clickAdminTab();
	homePage.ClickIdentityRepositoryTab();
	Thread.sleep(5000);
	
	UserGroup userGroup=new UserGroup(driver);
	Thread.sleep(5000);
	userGroup.ClickUserGroupTab();
	Thread.sleep(5000);
	userGroup.SerchUserGroupCreated(usersGroup +Keys.ENTER);
	Thread.sleep(5000);
	userGroup.ClickUserLink();
	Thread.sleep(5000);
	userGroup.ClickUserGroupOwnerTab();
	Thread.sleep(5000);
	userGroup.userGroupOwnerSearchBox(userGroupOwner +Keys.ENTER);
	Thread.sleep(5000);
	userGroup.selectUserGroupOwnerTabCheckBox();
	Thread.sleep(5000);
	userGroup.ClickRemoveOwnerButton();
	Thread.sleep(5000);
	}	
	
	
	//Remove Owner to the Group
	@Test(dataProvider = "test", description = "dummy Test script 4",enabled=true)
	public void removeOwnertoUserGroupNonAdmin(@SuppressWarnings("rawtypes") Map mObj) throws InterruptedException {
		
		
		
	reportInfo((String) mObj.get("Test Case Name"));
	
	String appUrl = envscop.env("ApplicationURL");
	String User = envscop.env("NonAdminUser");
	String Password = envscop.env("Password");
	
	
	String usersGroup=(String) mObj.get("UserGroupName");
	String userGroupOwner=(String) mObj.get("UserGroupOwnerName");
	
	
	HomePage homePage = new HomePage(driver);

	
	driver.get(appUrl);
	
	homePage.saviyntLogin(User, Password);
	homePage.verifyPageLoads();
	Thread.sleep(5000);
	homePage.clickAdminTab();
	homePage.ClickIdentityRepositoryTab();
	Thread.sleep(5000);
	
	UserGroup userGroup=new UserGroup(driver);
	Thread.sleep(5000);
	userGroup.ClickUserGroupTab();
	Thread.sleep(5000);
	userGroup.SerchUserGroupCreated(usersGroup +Keys.ENTER);
	Thread.sleep(5000);
	userGroup.ClickUserLink();
	Thread.sleep(5000);
	userGroup.ClickUserGroupOwnerTab();
	Thread.sleep(5000);
	userGroup.userGroupOwnerSearchBox(userGroupOwner +Keys.ENTER);
	Thread.sleep(5000);
	userGroup.selectUserGroupOwnerTabCheckBox();
	Thread.sleep(5000);
	userGroup.ClickRemoveOwnerButton();
	Thread.sleep(5000);
	}

}
