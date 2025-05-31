package excelFileHandling;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDynamicDataToExcelFileUsingScannerClass {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		FileOutputStream file = new FileOutputStream(
				System.getProperty("user.dir") + "\\testData\\WriteDynamicData.xlsx"); // --> FileNotFoundException

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("Dynamic Data");

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter no. of rows:");
		int noOfRows = sc.nextInt(); // Index from 0

		System.out.println("Enter no. of columns/cells:");
		int noOfCells = sc.nextInt(); // Index from 0

		for (int r = 0; r <= noOfRows; r++) {

			XSSFRow currentRow = sheet.createRow(r);

			for (int c = 0; c < noOfCells; c++) {

				XSSFCell currentCell = currentRow.createCell(c);
				currentCell.setCellValue(sc.next());

			}
		}
		
		workbook.write(file); // Attach workbook to the file // --> IOException
		workbook.close();
		file.close();
		
		System.out.println("File created...");
	}

}
