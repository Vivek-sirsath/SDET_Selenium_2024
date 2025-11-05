package excelFileHandling;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingTheExcelFile {

	public static void main(String[] args) throws IOException {

		// Checking the class path at runtime if any error persist
//		System.out.println(System.getProperty("java.class.path")); // Optional 

		// Open the file in reading mode, Create an input stream and load the Excel file
		// 'user.dir' must be in lower case.
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\testData\\FileInputStream.xlsx");
//		FileInputStream file = new FileInputStream("C:\\Users\\Admin\\Desktop\\testData\\FIS_SDET2024.xlsx");
		
		// XSSFWorkbook will extract the workbook from the file.
		XSSFWorkbook workbook = new XSSFWorkbook(file); // IOException

		// XSSFSheet will extract the sheet from the workbook
		XSSFSheet sheet1 = workbook.getSheet("Sheet1");
//	    OR
//		XSSFSheet sheet1 = workbook.getSheetAt(0); // Extract the sheet by Sheet Number. We can specify sheet number also.

		int totalRows = sheet1.getLastRowNum(); // 5
		int totalColumns = sheet1.getRow(1).getLastCellNum(); // Instead of '1' we can take any row number.

		System.out.println("Number of rows: " + totalRows); // 5
		System.out.println("Number of colums: " + totalColumns); // 4
		
//		As per Excel, rowCount starts from '0'
//		As per Excel, cellCount starts from '1'
//		As per Java, rowCount starts from '0'
//		As per Java, cellCount starts from '0'

		for (int r = 0; r <= totalRows; r++) 
		{
			// Before reading the each cell we've to extract the particular row.
			XSSFRow currentRow = sheet1.getRow(r);
						
			for (int c = 0; c < totalColumns; c++) 
			{
				XSSFCell cell = currentRow.getCell(c);
				System.out.print(cell.toString() + "\t"); // tab-space // This will print row data in single line
			}
			
			System.out.println(); // This will go to the next line.
		}
		
		// Finally we've to close the workbook and file after using it.
		workbook.close();
		file.close();

	}

}
