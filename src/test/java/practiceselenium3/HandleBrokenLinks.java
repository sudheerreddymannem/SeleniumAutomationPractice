package practiceselenium3;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrokenLinks {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// capture all the Links from the Website
		List<WebElement> noofLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total number of Links are :" + noofLinks.size());
		
		int noofBrokenLinks=0;

		for (WebElement allLinks : noofLinks) {
			String hrefAttribute = allLinks.getAttribute("href");

			if (hrefAttribute == null || hrefAttribute.isEmpty())
			{
				System.out.println("href tag does not contains any Link");
				continue; //skip it
			}
			try {
				URL myURL = new URL(hrefAttribute); // convert String to URL
				HttpURLConnection connection = (HttpURLConnection) myURL.openConnection(); // Connecting to server with
																							// HTTPConnection
				connection.connect();

				if (connection.getResponseCode() >= 400) {
					System.out.println("Broken Link : " + hrefAttribute);
					noofBrokenLinks++;
				} else {
					System.out.println("Not a Broken Link" + hrefAttribute);
				}
			} catch (Exception e) {

			}
			

		}
		System.out.println("No of BrokenLinks:"+noofBrokenLinks);
	}

}
