package utility;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class WebDriverManager {
	
	public static int TYPE_CHROME = 1;
	public static int TYPE_IE = 2;
	
	public static WebDriver createDriver(int driverType, String driverPath) {
		switch(driverType) {
		case 1:
			return createChromDriver(driverPath);
		case 2:
			return createIEDriver(driverPath);
		default:
			throw new NumberFormatException("invalid Driver Type Provided. Use static variable as input type");
		}
	}
	
	private static WebDriver createChromDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		
		/*options.setExperimentalOption("credentials_enable_service", false);
		options.setExperimentalOption("profile.password_manager_enabled", false);*/
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(options);
		return driver;
	}
	
	private static WebDriver createChromDriver(String chromeDriverPath) {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		return WebDriverManager.createChromDriver();
	}
	
	private static WebDriver createIEDriver(String ieDriverPath) {
		System.setProperty("webdriver.ie.driver", ieDriverPath);
		InternetExplorerOptions capabilities = new InternetExplorerOptions();
		capabilities.ignoreZoomSettings();
		WebDriver driver = new InternetExplorerDriver(capabilities);
		return driver;
	}
}
