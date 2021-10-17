package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFindingElements {
	
	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("http://gmail.com");
//		WebElement username = driver.findElement(By.id("identifierId"));
//		username.sendKeys("tflrunningsheet@gmail.com");
//		WebElement nextBtn = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span"));
//		nextBtn.click();
		
		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("tflrunningsheet@gmail.com");
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/span")).click();
	}

}
