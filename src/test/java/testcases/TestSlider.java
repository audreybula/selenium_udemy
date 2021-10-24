package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSlider {

	public static void main(String[] args) {
		

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://jqueryui.com/resources/demos/slider/default.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement mainSlider = driver.findElement(By.id("slider"));
		int width = mainSlider.getSize().width / 2;
		
		WebElement slider = driver.findElement(By.xpath("(//div[@id='slider'])[1]"));
		
		new Actions(driver).dragAndDropBy(slider, width, 0).perform();

	}

}
