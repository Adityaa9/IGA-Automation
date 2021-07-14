package testscripts;

import java.util.Map;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.HomePage;
import POM.RequestApproval;
import POM.Roles;
import framework.TestRunner;

public class DummyScrip3 extends TestRunner {
	
	@Test(priority = 0,dataProvider = "test", description = "dummy Test script 3", enabled=false)
	public void roleCreationTest(@SuppressWarnings("rawtypes") Map mObj) throws InterruptedException {
		
	
		
	reportInfo((String) mObj.get("Test Case Name"));
	
	String appUrl = envscop.env("ApplicationURL");
	String adminUser = envscop.env("AdminUsername");
	String adminPass = envscop.env("AdminPassword");
	String admin2=envscop.env("AdminUser2"); 
	String roleName=(String) mObj.get("Value1");
	String description=(String) mObj.get("Value2");
	String roleType=(String) mObj.get("Value3");
	String requestable=(String) mObj.get("Value4");
	
	
	HomePage homePage = new HomePage(driver);
	
	driver.get(appUrl);
	
	homePage.saviyntLogin(adminUser, adminPass);
	homePage.verifyPageLoads();
	Thread.sleep(5000);
	homePage.clickAdminTab();
	homePage.clickSideBar();
	Thread.sleep(5000);
	homePage.ClickIdentityRepositoryTab();
	Thread.sleep(5000);
	homePage.ClickRolesOption();
	
	Roles roles=new Roles(driver);
	roles.ClickActionBtn();
	roles.ClickCreateRoles();
	
	roles.setRoleName(roleName);
	roles.description(description);
	roles.ClickRolesType();
	Thread.sleep(5000);
	roles.EnterRoleName(roleType +Keys.ENTER);
	Thread.sleep(5000);
	roles.ClickRequestableBtn();
	Thread.sleep(5000);
	roles.EnterRequestable(requestable +Keys.ENTER);
	Thread.sleep(5000);
	roles.ClickCreateBtn();
	
	roles.ClickEntitlementTab();
	Thread.sleep(5000);
	roles.ClickAddEntitlementBtn();
	Thread.sleep(5000);
	roles.selectEntitlement();
	Thread.sleep(5000);
	roles.ClickSaveBtn();
	Thread.sleep(5000);
	roles.ClickVersionTab();
	Thread.sleep(5000);
	roles.ClickVersionKeyEntitlement();
	Thread.sleep(5000);
	roles.ClickSendForApprovalBtn();
	Thread.sleep(5000);
	roles.ClickSendForApprovalConfirmBtn();
	Thread.sleep(5000);
	roles.ClickRoleOwnerTab();
	Thread.sleep(5000);
	roles.ClickActionButton();
	Thread.sleep(5000);
	roles.ClickAddRoleOwnerButton();
	Thread.sleep(5000);
	roles.EnterRoleOwner(admin2+ Keys.ENTER);
	Thread.sleep(5000);
	roles.ClickCheckBox();
	Thread.sleep(5000);
	roles.ClickSaveButton();
	Thread.sleep(5000);
	roles.ClickVersionTab();
	Thread.sleep(5000);
	roles.ClickVersionKeyOwner();
	Thread.sleep(5000);
	roles.ClickSendForApprovalBtn();
	Thread.sleep(5000);
	roles.ClickSendForApprovalConfirmBtn();
	Thread.sleep(5000);
	String status=roles.getStatus();
	Thread.sleep(5000);
	Assert.assertEquals(status, "Active");
	Thread.sleep(2000);
	}	
	
	@Test(priority = 1,dataProvider = "test", description = "dummy Test script 3", enabled=false)
	public void RoleCreationTest1 (@SuppressWarnings("rawtypes") Map mObj) throws InterruptedException {
		
		
		
	reportInfo((String) mObj.get("Test Case Name"));
	
	String appUrl = envscop.env("ApplicationURL");
	String adminUser = envscop.env("AdminUsername");
	String adminPass = envscop.env("AdminPassword");
	String admin2=envscop.env("AdminUser2");
	String adminPass2=envscop.env("AdminPassword2");
	
	String roleName=(String) mObj.get("Value1");
	String description=(String) mObj.get("Value2");
	String roleType=(String) mObj.get("Value3");
	String requestable=(String) mObj.get("Value4");
	
	HomePage homePage = new HomePage(driver);
	
	driver.get(appUrl);
	
	homePage.saviyntLogin(adminUser, adminPass);
	homePage.verifyPageLoads();
	Thread.sleep(5000);
	homePage.clickAdminTab();
	homePage.clickSideBar();
	Thread.sleep(5000);
	homePage.ClickIdentityRepositoryTab();
	Thread.sleep(5000);
	homePage.ClickRolesOption();
	
	Roles roles=new Roles(driver);
	roles.ClickActionBtn();
	roles.ClickCreateRoles();
	
	roles.setRoleName(roleName);
	roles.description(description);
	roles.ClickRolesType();
	Thread.sleep(5000);
	roles.EnterRoleName(roleType +Keys.ENTER);
	Thread.sleep(5000);
	roles.ClickRequestableBtn();
	Thread.sleep(5000);
	roles.EnterRequestable(requestable +Keys.ENTER);
	Thread.sleep(5000);
	roles.ClickCreateBtn();
	Thread.sleep(5000);
	roles.ClickRoleOwnerTab();
	Thread.sleep(5000);
	roles.ClickActionButton();
	Thread.sleep(5000);
	roles.ClickAddRoleOwnerButton();
	Thread.sleep(5000);
	//roles.waitforElementVisiblity();
	driver.navigate().refresh();
	roles.ClickRoleOwnerTab();
	Thread.sleep(5000);
	roles.ClickActionButton();
	Thread.sleep(5000);
	roles.ClickAddRoleOwnerButton();
	Thread.sleep(5000);
	roles.EnterRoleOwner(admin2+ Keys.ENTER);
	Thread.sleep(5000);
	roles.ClickCheckBox();
	Thread.sleep(5000);
	roles.ClickSaveButton();
	Thread.sleep(5000);
	roles.ClickVersionTab();
	Thread.sleep(5000);
	roles.ClickVersionKeyOwner();
	Thread.sleep(5000);
	roles.ClickSendForApprovalBtn();
	Thread.sleep(5000);
	roles.ClickSendForApprovalConfirmBtn();
	Thread.sleep(5000);
	String requestID=roles.getRequestID();
	System.out.println(requestID);
	String[] stmt=requestID.split(" ");
	System.out.println(stmt[stmt.length-1]);
	Thread.sleep(3000);
	roles.ClickARS_Tab();
	Thread.sleep(3000);
	homePage.ClickLogOutImg();
	Thread.sleep(8000);
	homePage.ClickLogOutOption();
	Thread.sleep(3000);
	homePage.ClickLoginAgainButton();
	Thread.sleep(3000);
	homePage.saviyntLogin(admin2, adminPass2);
	Thread.sleep(3000);
	homePage.ClickRequestApprovalTab();
	Thread.sleep(3000);
	RequestApproval request=new RequestApproval(driver);	
	request.ClickSearchIcon();
	Thread.sleep(3000);
	request.EnterRequestID(stmt[stmt.length-1] +Keys.ENTER);
	Thread.sleep(3000);
	request.ClickRequestLink();
	Thread.sleep(3000);
	request.ClickAcceptAllButton();
	Thread.sleep(3000);
	request.ClickConfirmButton();
	Thread.sleep(3000);
	homePage.ClickLogOutImg();
	Thread.sleep(3000);
	homePage.ClickLogOutOption();
	Thread.sleep(3000);
	homePage.ClickLoginAgainButton();
	Thread.sleep(3000);
	
	homePage.saviyntLogin(adminUser, adminPass);
	homePage.verifyPageLoads();
	Thread.sleep(5000);
	homePage.clickAdminTab();
	Thread.sleep(5000);
	homePage.clickSideBar();
	Thread.sleep(5000);
	homePage.ClickIdentityRepositoryTab();
	Thread.sleep(5000);
	homePage.ClickRolesOption();
	Thread.sleep(5000);
	roles.SearchRoleList(roleName +Keys.ENTER);
	Thread.sleep(5000);
	roles.ClickRoleLink();	
	Thread.sleep(5000);
	
	
	roles.ClickEntitlementTab();
	Thread.sleep(5000);
	roles.ClickAddEntitlementBtn();
	Thread.sleep(5000);
	roles.selectEntitlement();
	Thread.sleep(5000);
	roles.ClickSaveBtn();
	Thread.sleep(5000);
	roles.ClickVersionTab();
	Thread.sleep(5000);
	roles.ClickVersionKeyEntitlement();
	Thread.sleep(5000);
	roles.ClickSendForApprovalBtn();
	Thread.sleep(5000);
	roles.ClickSendForApprovalConfirmBtn();
	Thread.sleep(3000);
	String requestIDEnt=roles.getRequestID();
	System.out.println(requestIDEnt);
	String[] stmt1=requestIDEnt.split(" ");
	System.out.println(stmt1[stmt1.length-1]);
	Thread.sleep(3000);
	roles.ClickARS_Tab();
	Thread.sleep(3000);
	homePage.ClickLogOutImg();
	Thread.sleep(8000);
	homePage.ClickLogOutOption();
	Thread.sleep(3000);
	homePage.ClickLoginAgainButton();
	Thread.sleep(3000);
	homePage.saviyntLogin(admin2, adminPass2);
	Thread.sleep(3000);	
	homePage.ClickRequestApprovalTab();
	Thread.sleep(3000);
	request.EnterRequestID(stmt1[stmt1.length-1] +Keys.ENTER);
	Thread.sleep(3000);
	
	request.ClickRequestLink();
	Thread.sleep(3000);
	request.ClickAcceptAllButton();
	Thread.sleep(3000);
	request.ClickConfirmButton();
	Thread.sleep(3000);
	
	}
	
	
	@Test(priority = 2,dataProvider = "test", description = "dummy Test script 3", enabled=true)
	public void ProvisionNewRole (@SuppressWarnings("rawtypes") Map mObj) throws InterruptedException {
		
		
		
	reportInfo((String) mObj.get("Test Case Name"));
	
	String appUrl = envscop.env("ApplicationURL");
	String adminUser = envscop.env("AdminUsername");
	String adminPass = envscop.env("AdminPassword");
	String admin2=envscop.env("AdminUser2");
	String adminPass2=envscop.env("AdminPassword2");
	
	String userID=(String) mObj.get("Value1");
	String comment=(String) mObj.get("Value2");

	
	HomePage homePage = new HomePage(driver);
	
	driver.get(appUrl);
	
	homePage.saviyntLogin(adminUser, adminPass);
	homePage.verifyPageLoads();
	Thread.sleep(5000);
	homePage.ClickRequestForOthersTab();
	Thread.sleep(5000);
	homePage.searchUser(userID+Keys.ENTER);
	Thread.sleep(5000);
	homePage.SelectUser();
	Thread.sleep(5000);
	homePage.ClickNext();
	Thread.sleep(5000);
	homePage.SelectApplication();
	Thread.sleep(5000);
	homePage.ClickCheckoutBtn();
	Thread.sleep(8000);
	homePage.SelectRole();
	Thread.sleep(5000);
	homePage.ClickNextButton();
	Thread.sleep(5000);
	homePage.EnterComment(comment);
	Thread.sleep(5000);
	homePage.ClickSubmitButton();
	Thread.sleep(5000);
	String requestID=homePage.getRequestID();
	Thread.sleep(5000);
	System.out.println(requestID);
	Thread.sleep(5000);
	homePage.ClickLogOutImg();
	Thread.sleep(5000);
	homePage.ClickLogOutOption();
	Thread.sleep(5000);
	homePage.ClickLoginAgainButton();
	Thread.sleep(5000);
	homePage.saviyntLogin(admin2, adminPass2);
	Thread.sleep(5000);
	homePage.ClickRequestApprovalTab();
	Thread.sleep(5000);
	RequestApproval request=new RequestApproval(driver);
	Thread.sleep(5000);
	request.ClickSearchIcon();
	Thread.sleep(5000);
	request.EnterRequestID(requestID +Keys.ENTER);
	Thread.sleep(5000);
	request.ClickRequestLink();
	Thread.sleep(5000);
	request.ClickAcceptAccount();
	Thread.sleep(5000);
	request.EnterComment(comment);
	Thread.sleep(5000);
	request.ClickSubmitButton();
	Thread.sleep(5000);
	request.ClickAcceptButton();
	Thread.sleep(5000);
	request.EnterComment(comment);
	Thread.sleep(5000);
	request.ClickSubmitButton();
	Thread.sleep(5000);
	request.ClickConfirmButton();
	Thread.sleep(5000);	
	
	}
	
	
	
	
	@Test(priority = 3,dataProvider = "test", description = "dummy Test script 3", enabled=false)
	public void RoleCreationTest2(@SuppressWarnings("rawtypes") Map mObj) throws InterruptedException {
		
		
		
	reportInfo((String) mObj.get("Test Case Name"));
	
	String appUrl = envscop.env("ApplicationURL");
	String adminUser = envscop.env("AdminUsername");
	String adminPass = envscop.env("AdminPassword");
	String admin2 = envscop.env("AdminUser2");
	String adminPass2 = envscop.env("AdminPassword2");
	String DelegateUser=envscop.env("NonAdminUser");
	String DelegatePassword=envscop.env("Password");
	
	String roleName=(String) mObj.get("Value1");
	String description=(String) mObj.get("Value2");
	String roleType=(String) mObj.get("Value3");
	String requestable=(String) mObj.get("Value4");
	
	HomePage homePage = new HomePage(driver);

	
	driver.get(appUrl);
	
	homePage.saviyntLogin(adminUser, adminPass);
	homePage.verifyPageLoads();
	Thread.sleep(5000);
	homePage.clickAdminTab();
	homePage.clickSideBar();
	Thread.sleep(5000);
	homePage.ClickIdentityRepositoryTab();
	Thread.sleep(5000);
	homePage.ClickRolesOption();
	
	Roles roles=new Roles(driver);
	roles.ClickActionBtn();
	roles.ClickCreateRoles();
	
	roles.setRoleName(roleName);
	roles.description(description);
	roles.ClickRolesType();
	Thread.sleep(5000);
	roles.EnterRoleName(roleType +Keys.ENTER);
	Thread.sleep(5000);
	roles.ClickRequestableBtn();
	Thread.sleep(5000);
	roles.EnterRequestable(requestable +Keys.ENTER);
	Thread.sleep(5000);
	roles.ClickCreateBtn();
	Thread.sleep(5000);
	roles.ClickRoleOwnerTab();
	Thread.sleep(5000);
	roles.ClickActionButton();
	Thread.sleep(5000);
	roles.ClickAddRoleOwnerButton();
	Thread.sleep(5000);
	//roles.waitforElementVisiblity();
	driver.navigate().refresh();
	roles.ClickRoleOwnerTab();
	Thread.sleep(5000);
	roles.ClickActionButton();
	Thread.sleep(5000);
	roles.ClickAddRoleOwnerButton();
	Thread.sleep(5000);
	roles.EnterRoleOwner(admin2+ Keys.ENTER);
	Thread.sleep(5000);
	roles.ClickCheckBox();
	Thread.sleep(5000);
	roles.ClickSaveButton();
	Thread.sleep(5000);
	roles.ClickVersionTab();
	Thread.sleep(5000);
	roles.ClickVersionKeyOwner();
	Thread.sleep(5000);
	roles.ClickSendForApprovalBtn();
	Thread.sleep(5000);
	roles.ClickSendForApprovalConfirmBtn();
	Thread.sleep(5000);
	String requestID=roles.getRequestID();
	System.out.println(requestID);
	String[] stmt=requestID.split(" ");
	System.out.println(stmt[stmt.length-1]);
	Thread.sleep(3000);
	roles.ClickARS_Tab();
	Thread.sleep(3000);
	homePage.ClickLogOutImg();
	Thread.sleep(8000);
	homePage.ClickLogOutOption();
	Thread.sleep(3000);
	homePage.ClickLoginAgainButton();
	Thread.sleep(3000);
	homePage.saviyntLogin(admin2, adminPass2);
	Thread.sleep(3000);
	homePage.ClickRequestApprovalTab();
	Thread.sleep(3000);
	RequestApproval request=new RequestApproval(driver);	
	request.ClickSearchIcon();
	Thread.sleep(3000);
	request.EnterRequestID(stmt[stmt.length-1] +Keys.ENTER);
	Thread.sleep(3000);
	request.ClickRequestLink();
	Thread.sleep(3000);
	request.ClickAcceptAllButton();
	Thread.sleep(3000);
	request.ClickConfirmButton();
	Thread.sleep(3000);
	homePage.ClickLogOutImg();
	Thread.sleep(3000);
	homePage.ClickLogOutOption();
	Thread.sleep(3000);
	homePage.ClickLoginAgainButton();
	Thread.sleep(3000);
	
	homePage.saviyntLogin(adminUser, adminPass);
	homePage.verifyPageLoads();
	Thread.sleep(5000);
	homePage.clickAdminTab();
	Thread.sleep(5000);
	homePage.clickSideBar();
	Thread.sleep(5000);
	homePage.ClickIdentityRepositoryTab();
	Thread.sleep(5000);
	homePage.ClickRolesOption();
	Thread.sleep(5000);
	roles.SearchRoleList(roleName +Keys.ENTER);
	Thread.sleep(5000);
	roles.ClickRoleLink();	
	Thread.sleep(5000);
	
	
	roles.ClickEntitlementTab();
	Thread.sleep(5000);
	roles.ClickAddEntitlementBtn();
	Thread.sleep(5000);
	roles.selectEntitlement();
	Thread.sleep(5000);
	roles.ClickSaveBtn();
	Thread.sleep(5000);
	roles.ClickVersionTab();
	Thread.sleep(5000);
	roles.ClickVersionKeyEntitlement();
	Thread.sleep(5000);
	roles.ClickSendForApprovalBtn();
	Thread.sleep(5000);
	roles.ClickSendForApprovalConfirmBtn();
	Thread.sleep(3000);
	String requestIDEnt=roles.getRequestID();
	System.out.println(requestIDEnt);
	String[] stmt1=requestIDEnt.split(" ");
	System.out.println(stmt1[stmt1.length-1]);
	Thread.sleep(3000);
	roles.ClickARS_Tab();
	Thread.sleep(3000);
	homePage.ClickLogOutImg();
	Thread.sleep(8000);
	homePage.ClickLogOutOption();
	Thread.sleep(3000);
	homePage.ClickLoginAgainButton();
	Thread.sleep(3000);
	homePage.saviyntLogin(DelegateUser, DelegatePassword);
	Thread.sleep(3000);	
	homePage.ClickRequestApprovalTab();
	Thread.sleep(3000);
	request.EnterRequestID(stmt1[stmt1.length-1] +Keys.ENTER);
	Thread.sleep(3000);
	
	request.ClickRequestLink();
	Thread.sleep(3000);
	request.ClickAcceptAllButton();
	Thread.sleep(3000);
	request.ClickConfirmButton();
	Thread.sleep(3000);	

	}
	
	@Test(priority = 4,dataProvider = "test", description = "dummy Test script 3", enabled=false)
	public void RoleRequestRejection(@SuppressWarnings("rawtypes") Map mObj) throws InterruptedException {
		
		
		
	reportInfo((String) mObj.get("Test Case Name"));
	
	String appUrl = envscop.env("ApplicationURL");
	String adminUser = envscop.env("AdminUsername");
	String adminPass = envscop.env("AdminPassword");
	String admin2=envscop.env("AdminUser2");
	String adminPass2=envscop.env("AdminPassword2");
	
	String roleName=(String) mObj.get("Value1");
	String description=(String) mObj.get("Value2");
	String roleType=(String) mObj.get("Value3");
	String requestable=(String) mObj.get("Value4");
	
	HomePage homePage = new HomePage(driver);
//	JobControlPage jobControlPage = new JobControlPage(driver);
//	UsersPage userPage = new UsersPage(driver);
	
	driver.get(appUrl);
	
	homePage.saviyntLogin(adminUser, adminPass);
	homePage.verifyPageLoads();
	Thread.sleep(5000);
	homePage.clickAdminTab();
	homePage.clickSideBar();
	Thread.sleep(5000);
	homePage.ClickIdentityRepositoryTab();
	Thread.sleep(5000);
	homePage.ClickRolesOption();
	
	Roles roles=new Roles(driver);
	roles.ClickActionBtn();
	roles.ClickCreateRoles();
	
	roles.setRoleName(roleName);
	roles.description(description);
	roles.ClickRolesType();
	Thread.sleep(5000);
	roles.EnterRoleName(roleType +Keys.ENTER);
	Thread.sleep(5000);
	roles.ClickRequestableBtn();
	Thread.sleep(5000);
	roles.EnterRequestable(requestable +Keys.ENTER);
	Thread.sleep(5000);
	roles.ClickCreateBtn();
	Thread.sleep(5000);
	roles.ClickRoleOwnerTab();
	Thread.sleep(5000);
	roles.ClickActionButton();
	Thread.sleep(5000);
	roles.ClickAddRoleOwnerButton();
	Thread.sleep(5000);
	//roles.waitforElementVisiblity();
	driver.navigate().refresh();
	roles.ClickRoleOwnerTab();
	Thread.sleep(5000);
	roles.ClickActionButton();
	Thread.sleep(5000);
	roles.ClickAddRoleOwnerButton();
	Thread.sleep(5000);
	roles.EnterRoleOwner(admin2+ Keys.ENTER);
	Thread.sleep(5000);
	roles.ClickCheckBox();
	Thread.sleep(5000);
	roles.ClickSaveButton();
	Thread.sleep(5000);
	roles.ClickVersionTab();
	Thread.sleep(5000);
	roles.ClickVersionKeyOwner();
	Thread.sleep(5000);
	roles.ClickSendForApprovalBtn();
	Thread.sleep(5000);
	roles.ClickSendForApprovalConfirmBtn();
	Thread.sleep(5000);
	String requestID=roles.getRequestID();
	System.out.println(requestID);
	String[] stmt=requestID.split(" ");
	System.out.println(stmt[stmt.length-1]);
	Thread.sleep(3000);
	roles.ClickARS_Tab();
	Thread.sleep(3000);
	homePage.ClickLogOutImg();
	Thread.sleep(8000);
	homePage.ClickLogOutOption();
	Thread.sleep(3000);
	homePage.ClickLoginAgainButton();
	Thread.sleep(3000);
	homePage.saviyntLogin(admin2, adminPass2);
	Thread.sleep(3000);
	homePage.ClickRequestApprovalTab();
	Thread.sleep(3000);
	RequestApproval request=new RequestApproval(driver);	
	request.ClickSearchIcon();
	Thread.sleep(3000);
	request.EnterRequestID(stmt[stmt.length-1] +Keys.ENTER);
	Thread.sleep(3000);
	request.ClickRequestLink();
	Thread.sleep(3000);
	request.ClickAcceptAllButton();
	Thread.sleep(3000);
	request.ClickConfirmButton();
	Thread.sleep(3000);
	homePage.ClickLogOutImg();
	Thread.sleep(3000);
	homePage.ClickLogOutOption();
	Thread.sleep(3000);
	homePage.ClickLoginAgainButton();
	Thread.sleep(3000);
	
	homePage.saviyntLogin(adminUser, adminPass);
	homePage.verifyPageLoads();
	Thread.sleep(5000);
	homePage.clickAdminTab();
	Thread.sleep(5000);
	homePage.clickSideBar();
	Thread.sleep(5000);
	homePage.ClickIdentityRepositoryTab();
	Thread.sleep(5000);
	homePage.ClickRolesOption();
	Thread.sleep(5000);
	roles.SearchRoleList(roleName +Keys.ENTER);
	Thread.sleep(5000);
	roles.ClickRoleLink();	
	Thread.sleep(5000);
	
	
	roles.ClickEntitlementTab();
	Thread.sleep(5000);
	roles.ClickAddEntitlementBtn();
	Thread.sleep(5000);
	roles.selectEntitlement();
	Thread.sleep(5000);
	roles.ClickSaveBtn();
	Thread.sleep(5000);
	roles.ClickVersionTab();
	Thread.sleep(5000);
	roles.ClickVersionKeyEntitlement();
	Thread.sleep(5000);
	roles.ClickSendForApprovalBtn();
	Thread.sleep(5000);
	roles.ClickSendForApprovalConfirmBtn();
	Thread.sleep(3000);
	String requestIDEnt=roles.getRequestID();
	System.out.println(requestIDEnt);
	String[] stmt1=requestIDEnt.split(" ");
	System.out.println(stmt1[stmt1.length-1]);
	Thread.sleep(3000);
	roles.ClickARS_Tab();
	Thread.sleep(3000);
	homePage.ClickLogOutImg();
	Thread.sleep(8000);
	homePage.ClickLogOutOption();
	Thread.sleep(3000);
	homePage.ClickLoginAgainButton();
	Thread.sleep(3000);
	homePage.saviyntLogin(admin2, adminPass2);
	Thread.sleep(3000);	
	homePage.ClickRequestApprovalTab();
	Thread.sleep(3000);
	request.EnterRequestID(stmt1[stmt1.length-1] +Keys.ENTER);
	Thread.sleep(3000);
	
	request.ClickRequestLink();
	Thread.sleep(3000);
	request.ClickRejectAllButton();
	Thread.sleep(3000);
	request.ClickConfirmButton();
	Thread.sleep(3000);	
	}

}
