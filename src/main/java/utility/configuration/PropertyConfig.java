package utility.configuration;

import org.aeonbits.owner.Config;

@Config.Sources(value="file:${user.dir}/src/main/resources/config/Test.properties")
public interface PropertyConfig extends Config , FrameworkConfig {

    String baseURL();

    String execution_mode();

}
