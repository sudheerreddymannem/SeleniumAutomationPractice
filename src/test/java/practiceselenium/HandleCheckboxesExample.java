package practiceselenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckboxesExample {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
		
		//select Specific
		//driver.findElement(By.xpath("(//input[@type='checkbox'])[8]")).click();
		
		//select all checkboxes
		
		List<WebElement> allcheckboxes=driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr/td/input"));
		System.out.println(allcheckboxes.toString());
//		for(WebElement checkallboxes:allcheckboxes )
//		{
//			checkallboxes.click();
//		}
		
		
		//check first 3
//		for(int i=0;i<=2;i++)
//		{
//			allcheckboxes.get(i).click();
//		}
		
		//check 2,3,4
		for(int i=1;i<=3;i++)
		{
			allcheckboxes.get(i).click();
		}
		

	}
	

}
