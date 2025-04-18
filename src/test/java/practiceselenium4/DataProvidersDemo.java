package practiceselenium4;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidersDemo {
	
	WebDriver driver;
	
	@BeforeClass
	void method1()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("This is method1");
	}
	
	@Test(dataProvider="sr")
	void method2(String username,String pass) throws InterruptedException
	{
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pass);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		String expected_Title= driver.getTitle();
		
		if (expected_Title.equals("OrangeHRM")) {
		    System.out.println("Login successful");
		    //Thread.sleep(3000);
		    //driver.navigate().back();
		    Thread.sleep(3000);
		    driver.navigate().back();
		    driver.findElement(By.xpath("//input[@placeholder='Username']")).click();
		    driver.findElement(By.xpath("//input[@placeholder='Username']")).clear();
		    driver.findElement(By.xpath("//input[@placeholder='Password']")).click();
			driver.findElement(By.xpath("//input[@placeholder='Password']")).clear();
			
		    Assert.assertTrue(true);
		    
		} else {
		    Assert.fail("Login failed!");
		}
	}
	
	
	@AfterClass
	void method4()
	{
		driver.close();
	}
	
	@DataProvider(name="sr")
	Object[][] loginTest()
	{
		Object data[][] = {
				
				{"Test","password"},
				{"Admin","admin123"},
				{"Test1","pass"}
			
		};
		return data;	
		
		
	}


}
