package practiceselenium3;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ReadDataFromExcel {

	public static void main(String[] args) throws IOException {
		
		//WebDriver driver = new ChromeDriver();
		
		//Excel Sheet - Workbook - sheet - row - cells
		
		//Read Data
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\test data\\AutomationPractice.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheetname=workbook.getSheet("Sheet1");
		//No of Rows and cells
		int noOfRows=sheetname.getLastRowNum();
		System.out.println("No of Rows are: "+noOfRows);  //6
		int noOfcells=sheetname.getRow(1).getLastCellNum();
		System.out.println("No of columns are: "+noOfcells); //4
		
		
		//Print data in the console - Nested loop
		
		for(int r=0;r<=noOfRows;r++)
		{
			XSSFRow rows=sheetname.getRow(r);
			for(int c=0;c<noOfcells;c++)
			{
				XSSFCell cell=rows.getCell(c);
				System.out.print(cell.toString()+"\t");
			}
			System.out.println();
		}
		workbook.close();
		file.close();

	}

}
