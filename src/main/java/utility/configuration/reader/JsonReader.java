package utility.configuration.reader;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import utility.configuration.JsonConfig;

import java.io.File;

public class JsonReader implements IConfigReader {

    @SneakyThrows
    @Override
    public JsonConfig getConfig() {

        JsonConfig frameworkProperties =
                new ObjectMapper().readValue(new File(System.getProperty("user.dir") + "/src/main/resources/config/application.json"), JsonConfig.class);

        return frameworkProperties;
    }
}
