package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static FileInputStream fi;  //  For reading mode
	public static FileOutputStream fo;  // For writting mode
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static XSSFCellStyle style;

	public static int getRowCount(String xlfile, String xlsheet) throws FileNotFoundException, IOException {
		fi = new FileInputStream(xlfile); // xlfile = path of excel file
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet); // xlsheet = sheet name
		int rowCount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowCount;
	}

	public static int getCellCount(String xlfile, String xlsheet, int rowNum)
			throws FileNotFoundException, IOException {
		fi = new FileInputStream(xlfile); // --> FileNotFoundException
		wb = new XSSFWorkbook(fi); // --> IOException
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellCount;
	}

	public static String getCellData(String xlfile, String xlsheet, int rowNum, int colNum /* cellNo */)
			throws FileNotFoundException, IOException {

		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rowNum);
		cell = row.getCell(colNum);

		String data;

		try {
			// 1st Way to read cell data
//		    data = cell.toString();

			// 2nd way to read cell data
			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell); // DataNotFoundException
			// Returns the formatted value of cell as a String regardless of Excel cell
			// dataType
		} catch (Exception e) {
			data = ""; // Return Empty
		}

		wb.close();
		fi.close();
		return data;
	}

	public static void setCellData(String xlfile, String xlsheet, int rowNum, int colNum, String data)
			throws FileNotFoundException, IOException {

		// Reading the data
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rowNum);

		// Writing the data
		cell = row.createCell(colNum);
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}

	public static void fillGreenColor(String xlfile, String xlsheet, int rowNum, int colNum)
			throws FileNotFoundException, IOException {

		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rowNum);
		cell = row.getCell(colNum);

		style = wb.createCellStyle();

		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}

	public static void fillRedColor(String xlfile, String xlsheet, int rowNum, int colNum)
			throws FileNotFoundException, IOException {

		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rowNum);
		cell = row.getCell(colNum);

		style = wb.createCellStyle();

		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}

}
