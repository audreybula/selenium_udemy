package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMouseOver {
	
	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.way2automation.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement resourcesLink = driver.findElement(By.xpath("//li[@id='menu-item-25091']//span[@class='menu-text'][normalize-space()='Resources']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(resourcesLink).perform();
		driver.findElement(By.linkText("Practice Site 1")).click();
		
	}

}
