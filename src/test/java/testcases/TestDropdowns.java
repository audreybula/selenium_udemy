package testcases;

import java.time.Duration;
import java.util.List;

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
		
		List<WebElement> values = driver.findElements(By.tagName("option"));
		
		System.out.println(values.size());
		System.out.println(values.get(7).getText());
		
		for(int i = 0; i < values.size(); i++) {
			System.out.println(values.get(i).getText());
		}
		
		WebElement block = driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[9]/div[3]"));
//		block.findElements(By.tagName("a"));
		
		List<WebElement> links = block.findElements(By.tagName("a"));
		
		System.out.println(links.size());
		System.out.println(links.get(7).getText());
		
		for(int i = 0; i < links.size(); i++) {
			System.out.println(links.get(i).getText());
		}
		
		for(WebElement link: links) {
			link.getText();
		}
	}

}
