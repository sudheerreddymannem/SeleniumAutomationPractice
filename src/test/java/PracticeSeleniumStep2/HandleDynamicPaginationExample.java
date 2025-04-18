package PracticeSeleniumStep2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleDynamicPaginationExample {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		//3 Steps
		//1-Total num of pages, 2)Click on each and Every page 3)read data 
		
		int total_Pages= driver.findElements(By.xpath("//ul[@class=\"pagination\"]//li")).size();
		System.out.println("Total Number of pages are: "+total_Pages);
		
		for(int r=1;r<=total_Pages;r++)
		{
			if(r>1)
			{
				driver.findElement(By.xpath("//ul[@class=\"pagination\"]//li/*[text()='"+r+"']")).click();
				
			}
			//driver.findElement(By.xpath("//table[@id=\"productTable\"]//tbody//tr["+r+"]/td[4]")).click();

					String Name=driver.findElement(By.xpath("//table[@id=\"productTable\"]//tbody//tr["+r+"]/td[2]")).getText();
					String Price=driver.findElement(By.xpath("//table[@id=\"productTable\"]//tbody//tr["+r+"]//td[3]")).getText();
					driver.findElement(By.xpath("//table[@id=\"productTable\"]//tbody//tr["+r+"]/td[4]")).click();
					System.out.println(Name+"\t"+Price+"\t");
		}
	}

}
