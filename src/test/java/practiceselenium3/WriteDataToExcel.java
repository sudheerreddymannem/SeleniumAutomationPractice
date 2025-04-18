package practiceselenium3;

import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Excel Sheet - Workbook - sheet - row - cells

public class WriteDataToExcel {

	public static void main(String[] args) throws IOException {
		FileOutputStream file = new FileOutputStream(
				System.getProperty("user.dir") + "\\test data\\Automationpractice2.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Data");

		XSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("automation");
		row.createCell(1).setCellValue("Testing");
		row.createCell(2).setCellValue("Selenium");
		row.createCell(3).setCellValue("Manual");

		XSSFRow row1 = sheet.createRow(1);
		row1.createCell(0).setCellValue("123");
		row1.createCell(1).setCellValue("456");
		row1.createCell(2).setCellValue("6673");
		row1.createCell(3).setCellValue("6773");

		workbook.write(file);
		workbook.close();
		file.close();

	}

}
