package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowsers {
	
	// this is usually read from an excel sheet
	public static String browser = "chrome";
	public static WebDriver driver;
	
	public static void main(String[] args) {
		
//		System.setProperty("webdriver.gecko.driver", "/Users/admin/Desktop/capmation/selenium/drivers/geckodriver");
		
		if(browser.equals("chrome")) {
			// the webdriver manager automatically gets
			// the drivers. for chrome, safari,
			// change firefoxdriver to chromedriver / safaridriver
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} 
		
		driver.get("http://google.com");
		String title = driver.getTitle();
		System.out.println(title);
		driver.close(); // close the current browser
		//driver.quit(); // close current browser + all related browsers
		
	}

}
