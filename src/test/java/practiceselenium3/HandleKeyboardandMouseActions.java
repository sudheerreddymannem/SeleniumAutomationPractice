package practiceselenium3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class HandleKeyboardandMouseActions {

	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		Actions act =new Actions(driver);
		
		//Hover Over - Mouse Actions
		WebElement hoverOver=driver.findElement(By.xpath("//button[normalize-space()='Point Me']"));
		WebElement mobiles=driver.findElement(By.xpath("//a[normalize-space()='Mobiles']"));
		
		
		act.moveToElement(hoverOver).moveToElement(mobiles).build().perform();
		//mobiles.click();
		
		//Right Click - Context click
		
		//act.contextClick(mobiles).build().perform();
		
		//double click  --- Action Interface
		//WebElement CopyText=driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		
		//Action doubleclick= act.doubleClick(CopyText).build();
		//doubleclick.perform();
		
		//Drag and Drop
		
		WebElement SourceElement=driver.findElement(By.xpath("//p[normalize-space()='Drag me to my target']"));
		WebElement TargetElement = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		act.dragAndDrop(SourceElement, TargetElement).perform();
		
		String text =driver.findElement(By.xpath("//p[normalize-space()='Dropped!']")).getText();
		
		System.out.println("The Source Element is now :"+text);
		
		//keyboard Actions
		
		WebElement field1=driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement field2=driver.findElement(By.xpath("//input[@id='field2']"));
		field1.clear();
		
		field1.sendKeys("Testing Comments Added");
		
		//Ctrl+A
		act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).build().perform();
		
		//ctrl+c
		act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).build().perform();	
		
		//tab
		act.keyDown(Keys.TAB).keyUp(Keys.TAB);
		
		//ctrl+v
		act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).build().perform();

	}

}
