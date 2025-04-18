package practiceselenium4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelvsSequentialTest {
	
	WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser","url"})
	void setup(String br, String url)
	{
		switch(br)
		{
		case "chrome" :driver = new ChromeDriver();break;
		case "edge" :driver = new EdgeDriver();break;
		case "firefox" :driver = new FirefoxDriver();break;
		default:System.out.println("Invalid Browser");return;
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	void Login() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Thread.sleep(3000);
	}
	
	@AfterClass
	void Logout()
	{
		driver.close();
	}

}
