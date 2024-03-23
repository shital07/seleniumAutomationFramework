package utility.configuration.reader;

import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;
import lombok.SneakyThrows;
import utility.configuration.JsonConfig;
import utility.configuration.PropertyConfig;

import java.io.File;

public class PropertyReader implements IConfigReader {


    @SneakyThrows
    public JsonConfig getConfig() {


        JsonConfig frameworkProperties =

                new JavaPropsMapper().readValue(new File(System.getProperty("user.dir") + "/src/main/resources/config/Test.properties"), JsonConfig.class);


        return frameworkProperties;
    }

    public  PropertyConfig getConfigOwner(){
        return org.aeonbits.owner.ConfigFactory.create(PropertyConfig.class);
    }
}
