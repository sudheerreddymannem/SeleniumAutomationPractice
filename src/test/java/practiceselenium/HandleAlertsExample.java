package practiceselenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlertsExample {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
		
		//Basic Alert
		driver.findElement(By.xpath("//button[contains(text(), 'Click for JS Alert')]")).click();
		driver.switchTo().alert().accept();
		
		String result=driver.findElement(By.id("result")).getText();
		System.out.println("The Result of clicked java Script Result is: "+ result);
		
		//confirmarion Alert
//		driver.findElement(By.cssSelector("button[onclick=\"jsConfirm()\"]")).click();
//		//driver.switchTo().alert().accept();
//		driver.switchTo().alert().dismiss();
//		
//		String resultofcnfrmAlrt=driver.findElement(By.id("result")).getText();
//		System.out.println("The Result of clicked java Script Result is: "+ resultofcnfrmAlrt);
		
		//Prompt Alert
		WebElement promptAlert= driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]"));
		promptAlert.click();
		Thread.sleep(3000);
		Alert textAlert=driver.switchTo().alert();
		textAlert.sendKeys("text Entered");
		//textAlert.accept();
		textAlert.dismiss();
		
		String resultofpromptAlrt=driver.findElement(By.id("result")).getText();
		System.out.println("The Result of clicked java Script Result is: "+ resultofpromptAlrt);
		
		
		//driver.switchTo().alert().dismiss();
		

	}

}
