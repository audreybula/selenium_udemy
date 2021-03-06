package testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestTryIt {

	public static WebDriver driver;

	public static void captureScreenshot() throws IOException {

		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("/Users/admin/Desktop/dev/selenium/selenium_udemy/src/screenshot/" + fileName));

	}

	public static void main(String[] args) throws IOException {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.switchTo().frame("iframeResult");
//		driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();

//		((JavascriptExecutor) driver).executeScript("myFunction()");

		WebElement elem = driver.findElement(By.xpath("//input[@id='mySubmit']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("myFunction()");
		js.executeScript("arguments[0].style.border='3px solid red'", elem);

		driver.switchTo().defaultContent();

		List<WebElement> frames = driver.findElements(By.tagName("iframe"));

		System.out.println(frames.size());

		for (WebElement frame : frames) {
			System.out.println(frame.getAttribute("id"));
		}

		captureScreenshot();

	}

}
