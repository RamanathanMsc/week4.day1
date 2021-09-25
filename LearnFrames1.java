package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrames1 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		driver.switchTo().frame("frame1");
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("ram");
		
		driver.switchTo().frame("frame3");
		
		driver.findElement(By.id("a")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		
		WebElement w1=driver.findElement(By.id("animals"));
		
		Select s1=new Select(w1);
		s1.selectByIndex(2);
		
		driver.switchTo().defaultContent();

	}

}
