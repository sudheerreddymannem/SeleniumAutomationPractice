package practiceselenium3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDateToExcelDynamically {

	public static void main(String[] args) throws IOException {
		FileOutputStream file = new FileOutputStream(
				System.getProperty("user.dir") + "\\test data\\Automationpractice3.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Data");
		
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter no of Rows:");
		int nofRows=sc.nextInt();
		
		System.out.println("Enter no of Cells:");
		int nofCells=sc.nextInt();
		
		for(int r=0;r<=nofRows;r++)
		{
			XSSFRow row=sheet.createRow(r);
			for(int c=0;c<nofCells;c++)
			{
				XSSFCell cells=row.createCell(c);
				cells.setCellValue(sc.next());
			}
		}

		

		workbook.write(file);
		workbook.close();
		file.close();


	}

}
