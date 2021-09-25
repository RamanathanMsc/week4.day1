package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {

	public static void main(String[] args) throws IOException {


		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://leafground.com/pages/frame.html");
		
		driver.switchTo().frame(0);
		
		WebElement we1=driver.findElement(By.id("Click"));
		
		
		
		File scr1= we1.getScreenshotAs(OutputType.FILE);	
		File dst=new File ("./snaps/ram.png");
		FileUtils.copyFile(scr1, dst);
		
		driver.switchTo().defaultContent();
		List<WebElement> findElements = driver.findElements(By.tagName("iframe"));
		
		System.out.println("count of frames: "+ findElements.size());
		
		

	}

}
