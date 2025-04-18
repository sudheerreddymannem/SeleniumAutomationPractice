package PracticeSeleniumStep2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestionExample {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("Testing");
		
		List<WebElement> suggestionList =driver.findElements(By.xpath("//ul[@role=\"listbox\"]/li"));
		
		for(int i=0;i<suggestionList.size();i++)
		{
			
			//System.out.println(suggestionList.get(i).getText());
			if(suggestionList.get(i).getText().equals("testing types"))
			{
				suggestionList.get(i).click();
			}
			
			
		}
		
		

	}

}
