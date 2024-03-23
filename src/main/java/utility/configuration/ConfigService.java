package utility.configuration;

import static utility.configuration.ConfigManager.getConfig;

public class ConfigService {

    public static String getbaseURL() {

        return getConfig().baseURL();
    }

    public static String execution_mode() {
        return getConfig().execution_mode();
    }


}
