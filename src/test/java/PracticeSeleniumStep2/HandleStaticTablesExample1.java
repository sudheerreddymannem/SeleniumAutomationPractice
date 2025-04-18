package PracticeSeleniumStep2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleStaticTablesExample1 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		//total num of rows
		int totalRows=driver.findElements(By.xpath("//table[@name=\"BookTable\"]/tbody/tr")).size();
		System.out.println("Total num of Rows are :" +totalRows );
		
		//total num of col
		int numOfColmns= driver.findElements(By.xpath("//table[@name=\"BookTable\"]/tbody/tr/th")).size();
		System.out.println("Total Number of Columns are :" +numOfColmns);
		
		//Read Data From Specific Row or Column
		String BookName=driver.findElement(By.xpath("//table[@name=\"BookTable\"]/tbody/tr[5]/td[3]")).getText();
		System.out.println(BookName);
		
		//Read all the Data in the table
		for(int r=2;r<=totalRows;r++)
		{
			for(int c=1;c<=numOfColmns;c++)
			{
				String value=driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(value+" ");
			}
			System.out.println();
		}
		
		//Print Only Booknames With Author is mukesh
		
		for(int i=2;i<totalRows;i++)
		{
			String authorName=driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+i+"]//td[2]")).getText();
			
			
			if(authorName.equals("Mukesh"))
			{
				String BookName1=driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+i+"]/td[1]")).getText();
				System.out.println(BookName1);
			}
		}
		int total = 0;
		//total Price calculation
		for(int s=2;s<=totalRows;s++)
		{
			String Price=driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+s+"]//td[4]")).getText();
			total=total+Integer.parseInt(Price);
			
		}
		System.out.println("Total Price Value is :"+total);
	}

}
