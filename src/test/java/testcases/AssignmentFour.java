package testcases;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentFour {

	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://google.com");
		Dimension dim;
		int width = driver.manage().window().getSize().width;
		
		int j = 0;
		for(int i = 0; i < width / 2; i++) {
			
			dim = new Dimension(i, j);
			driver.manage().window().setSize(dim);
			
		}

	}

}
