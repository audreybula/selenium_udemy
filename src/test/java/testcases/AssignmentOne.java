package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentOne {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://timesofindia.indiatimes.com/poll.cms");
		driver.manage().window().maximize();
		
		String captchaTxt = driver.findElement(By.xpath("//*[@id=\"mathq2\"]")).getText();
		
		String[] captchaSplit = captchaTxt.split(" ");
		
		int captchaSum = Integer.parseInt(captchaSplit[0]) + Integer.parseInt(captchaSplit[2]);
		
		driver.findElement(By.xpath("//*[@id=\"mathuserans2\"]")).sendKeys(Integer.toString(captchaSum));

	}

}
