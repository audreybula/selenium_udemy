package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFindingElements {
	
	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("http://gmail.com");
		driver.manage().window().maximize();
		
//		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.withMessage("User defined Timed out after 30 seconds")
				.ignoring(NoSuchElementException.class);
		
//		WebElement username = driver.findElement(By.id("identifierId"));
//		username.sendKeys("tflrunningsheet@gmail.com");
//		WebElement nextBtn = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span"));
//		nextBtn.click();
		
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("tflrunningsheet@gmail.com");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"identifierId\"]"))).sendKeys("tflrunningsheet@gmail.com");
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/span")).click();
		
//		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/input")).sendKeys("password");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("password");
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button")).click();
	}

}
