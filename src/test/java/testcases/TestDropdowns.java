package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDropdowns {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.findElement(By.name("country")).sendKeys("Fiji");
		WebElement dropdown = driver.findElement(By.id("searchLanguage"));
		Select select = new Select(dropdown);
		
//		select.selectByVisibleText("Eesti");
		select.selectByValue("hi");
	}

}
