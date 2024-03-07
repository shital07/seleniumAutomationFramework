package com.learn.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class learning {

  //  @Test(dataProvider = "getExceldata")
    public void test(Map<String, String> mp) {
        System.out.println(mp.get("username"));
    }

    @DataProvider
    public Object[][] getData() {


        return new Object[][]{{"shital"}, {"malviya"}, {"ranu"}};

    }

    @DataProvider
    public Object[] getExceldata() throws IOException, FileNotFoundException {

        FileInputStream fileInputStream = new FileInputStream("");
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
        int rowcount = xssfSheet.getLastRowNum();
        int colcount = xssfSheet.getRow(0).getLastCellNum();

        Object[] a = new Object[rowcount];
        Map<String, String> mp;
        for (int i = 1; i <= rowcount; i++) {
            mp = new HashMap<>();
            for (int j = 0; j < colcount; j++) {
                mp.put(xssfSheet.getRow(0).getCell(j).getStringCellValue(), xssfSheet.getRow(i).getCell(j).getStringCellValue());

            }
            a[i - 1] = mp;
        }


        return a;
    }
 //   @Test(dataProvider = "readJsonFile")
    public void printJson(Map<String,Object> mp){

        for(Map.Entry<String,Object> e:mp.entrySet()){

            System.out.println(e.getKey() + " " + e.getValue());
        }
    }

    @DataProvider
    public Object[] readJsonFile() throws IOException {

     HashMap<String,Object> mp=   new ObjectMapper()
                .readValue(new File(System.getProperty("user.dir")+ "/src/test/resources/json/json1.json"), new TypeReference<HashMap<String,Object>>() {});

    return new Object[]{mp};

    }


}
