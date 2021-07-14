package framework;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.io.File;
import java.util.Date;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class ReportsLib {

	private ExtentReports extent;
	public static String resfileName;
	public static ExtentTest test;
	public static ExtentReports rep;
	public static EnvScop envscop = new EnvScop();
	public static final String resultLoc = System.getProperty("user.dir")+"\\Results\\"+new Date().toString().replace(":", "_").replace(" ", "_");
	public static String currentScreenshotloc;
	
	public ExtentReports getInstance(String resultpath) {
		if (extent == null) {
			extent = new ExtentReports(resultpath, true, DisplayOrder.NEWEST_FIRST);
			extent.loadConfig(new File(System.getProperty("user.dir") + "\\ReportsConfig.xml"));

			Map<String, String> globalVal = envscop.global();
			extent.addSystemInfo("Enviorment",globalVal.get("Enviorment"));
			extent.addSystemInfo("Projectname",globalVal.get("projectname"));
		}
		return extent;
	}

	public void CreateExtentReport(String TestScenario) {
		currentScreenshotloc = resultLoc + "\\"+TestScenario+"\\screenshot";
		rep = this.getInstance(resultLoc+"\\"+TestScenario+"\\Result.html");
		test = rep.startTest(TestScenario);
		rep.flush();
	}
	
	public void CreateExtentReport(String path, String TestScenario) {
		rep = this.getInstance(path);
		test = rep.startTest(TestScenario);
		rep.flush();
	}

	public void SaveExtentReport() {
		rep.endTest(test);
		rep.flush();
	}

	public void reportPass(String msg) {
		if(msg != null) {
			test.log(LogStatus.PASS, msg);
			rep.flush();
			Reporter.log(msg, true);
		}
	}

	public void reportPass(String msg, boolean screenshot, WebDriver webDriver) {
		if(screenshot) {
			Date today = new Date();
			long randomName = today.getTime();
			String screenShotFile = null;
			try {
				screenShotFile = currentScreenshotloc+"/"+randomName+".png";
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
	    	try {
				FileUtils.copyFile(scrFile, new File(screenShotFile));
				String screnshotAbspath = "screenshot/"+randomName+".png";
				reportPass(msg+ "<br><a href=\""+screnshotAbspath+"\" target=\"_blank\" title=\"view screenshot\">View Screnshot</a>");
			} catch (Exception e) {
				reportFailure(msg+e.getMessage());
			}
		}else {
			reportPass(msg);
		}
	}
	
	public void reportFailure(String msg) {
		if(msg != null) {
			test.log(LogStatus.FAIL, msg);
			rep.flush();
			Reporter.log(msg, true);
		}
	}
	
	public void reportFailure(String msg, boolean screenshot, WebDriver webDriver) {
		if(screenshot) {
			Date today = new Date();
			long randomName = today.getTime();
			String screenShotFile = null;
			try {
				screenShotFile = currentScreenshotloc+"/"+randomName+".png";
			} catch (Exception e) {
				e.printStackTrace();
			}
			File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
	    	try {
				FileUtils.copyFile(scrFile, new File(screenShotFile));
				String screnshotAbspath = "screenshot/"+randomName+".png";
				reportFailure(msg+ "<br><a href=\""+screnshotAbspath+"\" target=\"_blank\" title=\"view screenshot\">View Screnshot</a>");
			} catch (Exception e) {
				reportFailure(msg+e.getMessage());
			}
		}else {
			reportFailure(msg);
		}
	}

	public void reportInfo(String msg) {
		if(msg != null) {
			test.log(LogStatus.INFO, msg);
			rep.flush();
			Reporter.log(msg, true);
		}
	}
	
	public void reportInfo(String msg, boolean screenshot, WebDriver webDriver) {
		if(screenshot) {
			Date today = new Date();
			long randomName = today.getTime();
			String screenShotFile = null;
			try {
				screenShotFile = currentScreenshotloc+"/"+randomName+".png";
			} catch (Exception e) {
				e.printStackTrace();
			}
			File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
	    	try {
				FileUtils.copyFile(scrFile, new File(screenShotFile));
				String screnshotAbspath = "screenshot/"+randomName+".png";
				reportInfo(msg+ "<br><a href=\""+screnshotAbspath+"\" target=\"_blank\" title=\"view screenshot\">View Screnshot</a>");
			} catch (Exception e) {
				reportFailure(msg+e.getMessage());
			}
		}else {
			reportInfo(msg);
		}
	}
	
	
}
