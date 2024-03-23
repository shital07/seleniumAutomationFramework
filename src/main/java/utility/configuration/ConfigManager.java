package utility.configuration;

import utility.configuration.reader.PropertyReader;

public class ConfigManager {


    static PropertyConfig getConfig() {
        return new PropertyReader().getConfigOwner();
    }
}
