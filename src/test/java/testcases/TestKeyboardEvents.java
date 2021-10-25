package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestKeyboardEvents {

	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("identifierId")).sendKeys("tflrunningsheet@gmail.com");
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div")).click();
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.chord(Keys.COMMAND, "A")).build().perform();
		action.sendKeys(Keys.chord(Keys.COMMAND+"C")).perform();
		
		driver.findElement(By.id("identifierId")).click();
		
		action.sendKeys(Keys.chord(Keys.COMMAND+"V")).perform();

	}

}
