package testscripts;

import java.util.Map;

import org.testng.annotations.Test;

import POM.HomePage;
import POM.JobControlPage;
import POM.UsersPage;
import framework.TestRunner;

public class DummyScrip2 extends TestRunner {
	
	@Test(priority = 0, dataProvider = "test", description = "dummy Test script 2")
	public void OnBoardUserTest(@SuppressWarnings("rawtypes") Map mObj) {
		reportInfo((String) mObj.get("Test Case Name"));

		String appUrl = envscop.env("ApplicationURL");
		String adminUser = envscop.env("AdminUsername");
		String adminPass = envscop.env("AdminPassword");
		
		
		HomePage homePage = new HomePage(driver);
		JobControlPage jobControlPage = new JobControlPage(driver);
		UsersPage userPage = new UsersPage(driver);
		
		driver.get(appUrl);
		
		homePage.saviyntLogin(adminUser, adminPass);
		homePage.verifyPageLoads();
	//	homePage.applicationNavigation("Admin");
		jobControlPage.verifyPageLoads();
	//	homePage.hamburgerMenu("Identity Repository", "Users");
		userPage.verifyPageLoads();
		
		
	}
	
}
