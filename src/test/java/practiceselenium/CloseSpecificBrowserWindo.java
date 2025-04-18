package practiceselenium;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseSpecificBrowserWindo {

	public static void main(String[] args) {
WebDriver driver;
		
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.partialLinkText("OrangeHRM")).click();
		
		//System.out.println(driver.getTitle());
		
		Set<String> WindowID= driver.getWindowHandles();
		
		//loop
		for(String winid:WindowID)
		{
			String title=driver.switchTo().window(winid).getTitle();
			System.out.println(title);
			
			if(title.equals("OrangeHRM"))
			{
				driver.close();
			}
		}

	}

}
