package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestIsElementPresent {
	
	public static WebDriver driver;
	
	public static boolean isElementPresent(String locator) {
		try{ 
			
			driver.findElement(By.xpath(locator));
			return true;
			
		} catch(Throwable t) {
			
			return false;
			
		}
	}

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.out.println(isElementPresent("//*[@id=\"js-link-box-en\"]/strong"));
		
	}

}
