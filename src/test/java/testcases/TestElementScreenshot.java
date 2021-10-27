package testcases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestElementScreenshot {

	public static WebDriver driver;

	public static void captureScreenshot() throws IOException {

		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot,
				new File("/Users/admin/Desktop/dev/selenium/selenium_udemy/src/screenshot/" + fileName));

	}
	
	public static void captureElementScreenshot(WebElement ele) throws IOException {
		
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullImg = ImageIO.read(screenshot);

		Point point = ele.getLocation();

		int width = ele.getSize().getWidth();
		int height = ele.getSize().getHeight();
		
		System.out.println(width);
		System.out.println(height);
		
		BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), width, height);
		ImageIO.write(eleScreenshot, "jpg", screenshot);
		
		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		
		File screenshotLocation = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotLocation,
				new File("/Users/admin/Desktop/dev/selenium/selenium_udemy/src/screenshot/" + fileName));
		
	}

	public static void main(String[] args) throws IOException {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.way2automation.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement ele = driver.findElement(By.xpath("//img[@id='MzE5OjY4Mg==-1']"));

		captureElementScreenshot(ele);

	}

}