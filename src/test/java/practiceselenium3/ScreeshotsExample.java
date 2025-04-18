package practiceselenium3;



import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreeshotsExample {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.opencart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//full Page Screenshot
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetFiles=new File(System.getProperty("user.dir")+"\\screenshots\\DemoPage.png");;
		sourcefile.renameTo(targetFiles);
		
		//logo ss
		WebElement logo=driver.findElement(By.xpath("//img[@title='OpenCart - Open Source Shopping Cart Solution']"));
		File Source=logo.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"\\screenshots\\logopage.png");
		Source.renameTo(target);



	}

}
