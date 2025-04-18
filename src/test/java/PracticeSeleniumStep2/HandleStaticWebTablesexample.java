package PracticeSeleniumStep2;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleStaticWebTablesexample {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://blazedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		//Choose departure City
		WebElement depCity=driver.findElement(By.name("fromPort"));
		Select departureCity = new Select(depCity);
		departureCity.selectByValue("Boston");
		//Print all Options
		List<WebElement>allOptions= departureCity.getOptions();
		
		for(int i=0;i<allOptions.size();i++)
		{
			System.out.println(allOptions.get(i).getText());
		}
		
		//select destination city
		WebElement desticity=driver.findElement(By.name("toPort"));
		Select destinationCity = new Select(desticity);
		destinationCity.selectByVisibleText("Berlin");
		
		driver.findElement(By.cssSelector("input[value=\"Find Flights\"]")).click();
		
		//Finding the Lowest Price in the table and Click on Choose Flight
		//step-1: print price
		for(int i=1;i<6;i++)
		{
			String Price=driver.findElement(By.xpath("//table[@class=\"table\"]//tbody//tr["+i+"]/td[6]")).getText();
			Integer.parseInt(Price);
		}
		int[] Price;
		
	}

}
