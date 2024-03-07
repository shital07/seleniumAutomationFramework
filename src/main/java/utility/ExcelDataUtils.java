package utility;


import com.learn.exceptions.InvalidPathForExcelException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelDataUtils {

    @Test
    public static List<Map<String, String>> readExceldata(String sheet) {

        List<Map<String, String>> list = null;
        try (FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/excelsheetData.xlsx")) {

            XSSFWorkbook xssfWorkbook = null;

            xssfWorkbook = new XSSFWorkbook(fileInputStream);

            XSSFSheet xssfSheet = xssfWorkbook.getSheet(sheet);
            int rowcount = xssfSheet.getLastRowNum();
            int colcount = xssfSheet.getRow(0).getLastCellNum();

            list = new ArrayList<>();
            Map<String, String> mp = null;
            for (int i = 2; i <= rowcount; i++) {
                mp = new HashMap<>();
                for (int j = 0; j < colcount; j++) {
                    mp.put(xssfSheet.getRow(1).getCell(j).getStringCellValue(), xssfSheet.getRow(i).getCell(j).getStringCellValue());

                }

                list.add(mp);
            }


        } catch (FileNotFoundException e) {
            throw new InvalidPathForExcelException("Excel File you are trying to read is not found");
        } catch (IOException e) {
            throw new RuntimeException("IO operation you are trying to do is failing");
        }


        return list;
    }

}
