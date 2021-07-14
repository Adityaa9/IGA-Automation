package framework;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import utility.ArrayManager;
import utility.WebDriverManager;

public class TestRunner extends ReportsLib {

	public WebDriver driver;
	/*private int browser;
	private String browserPath;
	
	void setbrowser() {
		switch (envscop.env("Browser").trim().toLowerCase()) {
		case "chrome":
			this.browser =  WebDriverManager.TYPE_CHROME;
			this.browserPath = envscop.global("ChromeDriver");
		case "ie":
			this.browser = WebDriverManager.TYPE_IE;
			this.browserPath = envscop.global("IEDriver");
		default:
			reportFailure("Invalid browser name found in input/config..xlsx file  for selected enviorment.");
		}
	}*/
	
	@BeforeMethod
	public void LoadTestSetup(ITestResult itResult) throws InterruptedException {
		driver = WebDriverManager.createDriver(WebDriverManager.TYPE_CHROME, envscop.global("ChromeDriver"));
		String displayVal = itResult.getMethod().getDescription();
		CreateExtentReport(displayVal);
	}

	@AfterMethod
	public void cleanup() {
		driver.close();
		SaveExtentReport();
	}

	@DataProvider(name = "test")
	public Object[][] getData() throws Exception {
		TestConfig testConfig = new TestConfig();
		Object[][] testDataBucket = testConfig.getTestData(this.getClass().getName());
		testDataBucket = ArrayManager.rowReverse(testDataBucket);
		return testDataBucket;
	}
}
