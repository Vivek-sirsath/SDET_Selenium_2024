package excelFileHandlingBySarthak;

public class ManageExcelFileUsing_Xls_Reader {

	public static void main(String[] args) {

		// Get user directory path
		// System.out.println(System.getProperty("user.dir"));
		// C:\Users\admin\git\SDET_Selenium_2024\SDET_Selenium_2024

		// Get path of excel file
		String path = System.getProperty("user.dir") + "\\testData\\DataXLSReader.xlsx";

		// Create object of Xls_Reader class and pass the path
		Xls_Reader xls = new Xls_Reader(path);

		// 1 - Count no of rows
		int noOfRows = xls.getRowCount();
		System.out.println(noOfRows);

		// 2 - Count no of columns
		int noOfColumns = xls.getColumnCount();
		System.out.println(noOfColumns);

		/*
		 * After executing getting error message in console: [ ERROR StatusLogger Log4j2
		 * could not find a logging implementation. Please add log4j-core to the
		 * classpath. Using SimpleLogger to log to the console... ]
		 * 
		 * Because, didn't added log4j2 and log4j2-core dependancies to the POM.xml
		 * 
		 * POI only uses it internally for warnings. Even without it, your code will run
		 * fine. But, recommended to add dependancies. Then, error will be gone.
		 * 
		 * 
		 * IMPORTANT: - Rows count from 0 and Column count from 0
		 * IMPORTANT: - 
		 * // As per Excel, rowCount starts from '0' 
		 * // As per Excel, cellCount starts from '1' 
		 * // As per Java, rowCount starts from '0' 
		 * // As per Java, cellCount starts from '0'
		 */

		// Read cell data using getCellData(int rowNum, int colNum)

		String email = xls.getCellData(2, 3);
		System.out.println(email); // kiran@yahoo.com
		
		String DOB = xls.getCellData(3, 4);
		System.out.println(DOB);

		String age = xls.getCellData("Salary", "Age", 2);
		System.out.println(age); // 37.0

		String name = xls.getCellData("Salary", "Name", 4);
		System.out.println(name); // Nilesh Mahajan

		// Writting the data to excel file using method setCellData()
		// setCellData(String sheetName, String colName, int rowNum, String data)
		xls.setCellData("Salary", "Name", 5, "Pankaj Chaudhari");

		// Read the written data
		String name5 = xls.getCellData("Salary", "Name", 5);
		System.out.println(name5); // Pankaj Chaudhari

		for (int r = 1; r < noOfRows; r++) {
			for (int c = 0; c < noOfColumns; c++) {
				String cellData = xls.getCellData(r, c);
				System.out.print(cellData + "\t"); // tab-space
			}
			System.out.println();
		}

	}

}
