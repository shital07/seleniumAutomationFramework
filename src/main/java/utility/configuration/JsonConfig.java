package utility.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JsonConfig implements FrameworkConfig {

    String baseURL;
    String execution_mode;
    

}
