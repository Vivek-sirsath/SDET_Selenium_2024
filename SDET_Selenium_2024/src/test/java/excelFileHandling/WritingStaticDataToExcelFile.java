package excelFileHandling;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingStaticDataToExcelFile {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		// Locate the excel file OR it'll automatically create the excel file
		FileOutputStream file = new FileOutputStream(
				System.getProperty("user.dir") + "\\testData\\WriteStaticData.xlsx"); // --> FileNotFoundException

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("Static Demo");

		XSSFRow row1 = sheet.createRow(0);
		row1.createCell(0).setCellValue("1");
		row1.createCell(1).setCellValue("Vivek Shirsath");
		row1.createCell(3).setCellValue("Dad");

		XSSFRow row2 = sheet.createRow(1);
		row2.createCell(0).setCellValue("2");
		row2.createCell(1).setCellValue("Deepika Shirsath");
		row2.createCell(3).setCellValue("Mom");

		XSSFRow row3 = sheet.createRow(2);
		row3.createCell(0).setCellValue("3");
		row3.createCell(1).setCellValue("Ishita Shirsath");
		row3.createCell(3).setCellValue("Daughter");

		workbook.write(file); // --> IOException
		workbook.close();
		file.close();
		
		System.out.println("Excel file is created...");

	}

}
