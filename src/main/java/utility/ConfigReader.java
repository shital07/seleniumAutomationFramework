package utility;

import com.learn.exceptions.InvalidPathForExcelException;
import com.learn.exceptions.PropertyFileUsageException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;


public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/main/resources/config/application.properties"))) {
            properties.load(bufferedReader);

        } catch (FileNotFoundException e) {
           throw new InvalidPathForExcelException("Property File you are trying to read is not found");
            //System.exit(0);
        } catch (IOException e) {
            throw new RuntimeException("IO operation you are trying to do is failing");
        }

    }

    private ConfigReader() {

    }


    public static String getValue(String key) {
        if (Objects.isNull(properties.getProperty(key)) || Objects.isNull(key)) {
            throw new PropertyFileUsageException("No property key in config file  :" + key);
        }
        return properties.getProperty(key).trim();
    }

}
