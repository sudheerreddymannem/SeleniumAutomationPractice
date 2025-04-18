package practiceselenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleSwitchingBrows {

	public static void main(String[] args) {
		WebDriver driver;
		
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.partialLinkText("OrangeHRM")).click();
		
		System.out.println(driver.getTitle());
		
		Set<String> WindowID= driver.getWindowHandles();
		
		//Approach 1 - When we have 2 to 3 browsers
		
		//Convert to List to get the Individual IDs
		
//		List<String> BrowserWindowID = new ArrayList(WindowID);
//		String ParentID= BrowserWindowID.get(0);
//		String ChildID= BrowserWindowID.get(1);
//		
//		//Switch to Child Window
//		driver.switchTo().window(ChildID);
//		System.out.println(driver.getTitle());
		
		//Approach 2 - When we have Multiple browsers - Using Loops
		

	}

}
