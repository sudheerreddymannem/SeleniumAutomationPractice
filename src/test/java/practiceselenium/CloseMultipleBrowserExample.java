package practiceselenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseMultipleBrowserExample {

	public static void main(String[] args) {
		WebDriver driver;

		driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(driver.getTitle());
		
		//Provide Some String and search for it
		WebElement inpttext =driver.findElement(By.id("Wikipedia1_wikipedia-search-input"));
		inpttext.sendKeys("selenium");
		driver.findElement(By.className("wikipedia-search-button")).click();
		
		//Count number of links
		
		List<WebElement> AllLinks=driver.findElements(By.xpath("//a[(text()='Selenium' or text()='Selenium in biology' or text()='Selenium (software)' or text()='Selenium disulfide' or text()='Selenium dioxide' or text()='More »')]"));
		System.out.println("Count of number of links is: "+ AllLinks.size());
		
		//Click on each link using for loop
		for(WebElement serachlinks:AllLinks) {
			System.out.println(serachlinks.getText());
			serachlinks.click();
			//System.out.println(driver.getTitle());
		}
		
		//get WindowID For Every browser
		Set<String> winIDs = driver.getWindowHandles();
		//List<String> AllWindowIDs = new ArrayList(winIDs);
		System.out.println(winIDs);
		
		
		//close Specific Browser
		for(String specificBrowser:winIDs )
		{
			String title= driver.switchTo().window(specificBrowser).getTitle();
			System.out.println(title);
			if(title.equals("Selenium - Wikipedia") || title.equals("Selenium dioxide - Wikipedia"))
			{
				driver.close();
			}
			
		}
		

	}

}
