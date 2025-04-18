package practiceselenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class HandleframesExamp {

	public static void main(String[] args) {
		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(driver.getTitle());
		
		
		//Switch to Frame5
		WebElement frame5=driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
		driver.switchTo().frame(frame5);
		
		//send text in the element
		driver.findElement(By.xpath("//input[@name='mytext5']")).sendKeys("Text Enterred");
		
		//Click on the link
		
		driver.findElement(By.linkText("https://a9t9.com")).click();

	}

}
