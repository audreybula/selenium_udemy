package testcases;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowsers {
	
	public static void main(String[] args) {
		
//		System.setProperty("webdriver.gecko.driver", "/Users/admin/Desktop/capmation/selenium/drivers/geckodriver");
		
		// the webdriver manager automatically gets
		// the drivers. for chrome, safari,
		// change firefoxdriver to chromedriver / safaridriver
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
		
	}

}
