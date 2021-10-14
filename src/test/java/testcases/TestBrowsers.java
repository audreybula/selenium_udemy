package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowsers {
	
	public static void main(String[] args) {
		
//		System.setProperty("webdriver.gecko.driver", "/Users/admin/Desktop/capmation/selenium/drivers/geckodriver");
		
		// the webdriver manager automatically gets
		// the drivers. for chrome, safari,
		// change firefoxdriver to chromedriver / safaridriver
		WebDriverManager.chromedriver().setup();
//		FirefoxDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");
		String title = driver.getTitle();
		System.out.println(title);
		driver.close(); // close the current browser
		//driver.quit(); // close current browser + all related browsers
		
	}

}
