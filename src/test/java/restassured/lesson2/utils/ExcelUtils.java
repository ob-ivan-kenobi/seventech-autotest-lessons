package restassured.lesson2.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtils {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ExcelUtils(String excelPath, String excelSheet){
        try {
            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(excelSheet);}
        catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }

        public static String getCellData(int row, int column) {


            DataFormatter formatter = new DataFormatter();

            Object value = formatter.formatCellValue(sheet.getRow(row).getCell(column));
            return value.toString();
        }


        public static void getRowCount() {
                int rowCount = sheet.getPhysicalNumberOfRows();
    }

}
