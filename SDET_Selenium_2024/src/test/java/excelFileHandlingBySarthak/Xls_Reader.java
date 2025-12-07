package excelFileHandlingBySarthak;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class Xls_Reader {

    public String path;
    public FileInputStream fis = null;
    public FileOutputStream fileOut = null;
    private XSSFWorkbook workbook = null;
    private XSSFSheet sheet = null;
    private XSSFRow row = null;
    private XSSFCell cell = null;

    public Xls_Reader(String path) {
        this.path = path;
        try {
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Returns row count
    public int getRowCount() {
        int count = 0;

        int firstRow = sheet.getFirstRowNum();
        int lastRow = sheet.getLastRowNum();

        for (int i = firstRow; i <= lastRow; i++) {
            Row row = sheet.getRow(i);

            if (row != null && !isRowEmpty(row)) {
                count++;
            }
        }

        return count;
    } 

    private boolean isRowEmpty(Row row) {
        if (row == null) return true;

        DataFormatter df = new DataFormatter();

        for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
            Cell cell = row.getCell(c);

            if (cell == null) continue;

            // Convert to String
            String value = df.formatCellValue(cell).trim();

            // Ignore fully empty OR formula returning ""
            if (!value.equals("")) {
                return false;
            }
        }
        return true;
    }

	// Returns data by column name
    public String getCellData(String sheetName, String colName, int rowNum) {
        try {
            if (rowNum <= 0) return "";

            int index = workbook.getSheetIndex(sheetName);
            if (index == -1) return "";

            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(0);

            int colNum = -1;
            for (int i = 0; i < row.getLastCellNum(); i++) {
                if (row.getCell(i).getStringCellValue().trim().equals(colName.trim())) {
                    colNum = i;
                    break;
                }
            }
            if (colNum == -1) return "";

            row = sheet.getRow(rowNum - 1);
            if (row == null) return "";

            cell = row.getCell(colNum);
            if (cell == null) return "";

            return getCellValueAsString(cell);

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    // Returns data by column number
    public String getCellData(String sheetName, int colNum, int rowNum) {
        try {
            if (rowNum <= 0) return "";

            int index = workbook.getSheetIndex(sheetName);
            if (index == -1) return "";

            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(rowNum - 1);
            if (row == null) return "";

            cell = row.getCell(colNum);
            if (cell == null) return "";

            return getCellValueAsString(cell);

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    // Convert cell to string
    private String getCellValueAsString(Cell cell) {
        CellType type = cell.getCellType();

        switch (type) {

            case STRING:
                return cell.getStringCellValue();

            case NUMERIC:
            case FORMULA:
                if (DateUtil.isCellDateFormatted(cell)) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(cell.getDateCellValue());
                    return cal.get(Calendar.DAY_OF_MONTH) + "/" +
                           (cal.get(Calendar.MONTH) + 1) + "/" +
                           (cal.get(Calendar.YEAR));
                }
                return String.valueOf(cell.getNumericCellValue());

            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());

            case BLANK:
            default:
                return "";
        }
    }

    // Set cell data
    public boolean setCellData(String sheetName, String colName, int rowNum, String data) {
        try {
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);

            if (rowNum <= 0) return false;

            int index = workbook.getSheetIndex(sheetName);
            if (index == -1) return false;

            sheet = workbook.getSheetAt(index);

            row = sheet.getRow(0);
            int colNum = -1;

            for (int i = 0; i < row.getLastCellNum(); i++) {
                if (row.getCell(i).getStringCellValue().trim().equals(colName.trim())) {
                    colNum = i;
                    break;
                }
            }

            if (colNum == -1) return false;

            sheet.autoSizeColumn(colNum);
            row = sheet.getRow(rowNum - 1);
            if (row == null) row = sheet.createRow(rowNum - 1);

            cell = row.getCell(colNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            cell.setCellValue(data);

            fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Add sheet
    public boolean addSheet(String sheetName) {
        try {
            workbook.createSheet(sheetName);
            fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Remove sheet
    public boolean removeSheet(String sheetName) {
        try {
            int index = workbook.getSheetIndex(sheetName);
            if (index == -1) return false;

            workbook.removeSheetAt(index);

            fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Add column
    public boolean addColumn(String sheetName, String colName) {
        try {
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);

            int index = workbook.getSheetIndex(sheetName);
            if (index == -1) return false;

            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(0);

            if (row == null)
                row = sheet.createRow(0);

            cell = row.createCell(row.getLastCellNum());
            cell.setCellValue(colName);

            fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Column count
    public int getColumnCount() {
        Row firstRow = sheet.getRow(sheet.getFirstRowNum());
        return firstRow.getLastCellNum();
    }

    public String getCellData(int rowNum, int colNum) {
        Row row = sheet.getRow(rowNum);
        if (row == null) return "";

        Cell cell = row.getCell(colNum);
        if (cell == null) return "";

        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }


    // Check sheet exists
    public boolean isSheetExist(String sheetName) {
        int index = workbook.getSheetIndex(sheetName);
        if (index == -1) return false;
        return true;
    }
}
