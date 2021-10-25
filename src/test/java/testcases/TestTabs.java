package testcases;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestTabs {

	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://hdfcbank.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Set<String> winds = driver.getWindowHandles();
		Iterator<String> iterator = winds.iterator();
		
		String fwind = iterator.next();
		System.out.println(fwind);
		
		// 1st window
		driver.findElement(By.xpath("//button[@class='btn btn-primary login-btn hide-in-mobileApp ng-scope']")).click();
		
		// 2nd window
		
		winds = driver.getWindowHandles();
		iterator = winds.iterator();
		
		iterator.next();
		String swind = iterator.next();
		System.out.println(swind);
		
		driver.switchTo().window(swind);
		driver.findElement(By.xpath("//a[@class='btn-default register-url']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Locate us']")).click();
		
		// 3rd window
		
		winds = driver.getWindowHandles();
		iterator = winds.iterator();
		
		iterator.next();
		iterator.next();
		String twind = iterator.next();
		System.out.println(twind);
		
		driver.switchTo().window(twind);
		System.out.println(driver.getTitle().contains("HDFC Bank Locator"));
		
		driver.close();
		driver.switchTo().window(twind);
		driver.close();
		
		// driver.quit();

	}

}
