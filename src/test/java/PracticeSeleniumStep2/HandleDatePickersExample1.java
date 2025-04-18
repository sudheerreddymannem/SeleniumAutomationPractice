package PracticeSeleniumStep2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleDatePickersExample1 {

	public static void SelectFutureDate(WebDriver driver, String ExpectedMonth, String ExpecetdYear, String date) {

		while (true) {
			// select month and year

			String currentMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
			String CurrentYear = driver.findElement(By.className("ui-datepicker-year")).getText();

			if (currentMonth.equals(ExpectedMonth) && CurrentYear.equals(ExpecetdYear))

			{
				break;
			}
			// driver.findElement(By.cssSelector("a[title=\"Next\"]")).click();
			driver.findElement(By.cssSelector("a[title=\"Prev\"]")).click();

		}

		List<WebElement> allDates = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr/td/a"));

		for (WebElement dates : allDates) {
			if (dates.getText().equals("ExpectedDate"))
				;
			dates.click();
			break;
		}

	}

	public static void SelectPastDate(WebDriver driver, String ExpectedMonth, String ExpecetdYear, String date) {

		while (true) {
			// select month and year

			String currentMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
			String CurrentYear = driver.findElement(By.className("ui-datepicker-year")).getText();

			if (currentMonth.equals(ExpectedMonth) && CurrentYear.equals(ExpecetdYear))

			{
				break;
			}
			// driver.findElement(By.cssSelector("a[title=\"Next\"]")).click();
			driver.findElement(By.cssSelector("a[title=\"Prev\"]")).click();

		}

		List<WebElement> allDates = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr/td/a"));

		for (WebElement dates : allDates) {
			if (dates.getText().equals("ExpectedDate"))
				;
			dates.click();
			break;
		}
	}

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.switchTo().frame(0);

		driver.findElement(By.id("datepicker")).click();

		String ExpectedMonth = "July";
		String ExpecetdYear = "2023";
		String ExpectedDate = "25";

		// public String SelectMonthANdYear(String currentMonth,String CurrentYear ) {

		// select Dates
		SelectPastDate(driver, ExpectedMonth, ExpecetdYear, ExpectedDate);
	}
}
