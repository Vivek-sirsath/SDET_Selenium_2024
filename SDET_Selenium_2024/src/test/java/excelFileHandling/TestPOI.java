package excelFileHandling;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestPOI {
    public static void main(String[] args) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            System.out.println("Apache POI is working!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
