package testcases;

import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBrowsers {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "/Users/admin/Desktop/capmation/selenium/drivers/geckodriver");
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
		
	}

}
