package utility;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataProviderUtils {

@DataProvider(parallel = true)
    public static Object[] getData(Method m) {

        String testcase = m.getName();
        List<Map<String, String>> list = ExcelDataUtils.readExceldata("Data");
        List<Map<String, String>> result = new ArrayList<>();


        for (int i = 0; i < list.size(); i++) {


            if (list.get(i).get("TestcaseName").equalsIgnoreCase(testcase) && list.get(i).get("Execute").equalsIgnoreCase("Yes")) {
                result.add(list.get(i));
            }


        }

        return result.toArray();


    }


}
