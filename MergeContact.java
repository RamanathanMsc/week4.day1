package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://leaftaps.com/opentaps/control/login");

		// USER NAME
		WebElement username = driver.findElement(By.id("username"));

		username.sendKeys("demosalesmanager");
//password
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys("crmsfa");
//login
		WebElement Login = driver.findElement(By.className("decorativeSubmit"));

		Login.click();
		
		WebElement linktext = driver.findElement(By.linkText("CRM/SFA"));
		linktext.click();

		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.linkText("Merge Contacts")).click();
		
		driver.findElement(By.xpath("//*[@alt='Lookup'][1]")).click();
		
		Set<String> WINset = driver.getWindowHandles();
		
		List<String> L1=new ArrayList<String>(WINset);
		
		driver.switchTo().window(L1.get(1));
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId'][1]/a")).click();
		
		driver.switchTo().window(L1.get(0));
		
		driver.findElement(By.xpath("(//*[@alt='Lookup'][1])[2]")).click();
		
Set<String> WINset1 = driver.getWindowHandles();
		
		List<String> L2=new ArrayList<String>(WINset1);
		
		driver.switchTo().window(L2.get(1));
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'][1]/a)[2]")).click();
		
		driver.switchTo().window(L2.get(0));
		driver.findElement(By.linkText("Merge")).click();
		
		Alert alert=driver.switchTo().alert();
		
		alert.accept();
		
		String title = driver.getTitle();
		
		System.out.println(title);
		
		
	}

}
