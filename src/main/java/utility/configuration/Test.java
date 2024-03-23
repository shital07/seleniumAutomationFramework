package utility.configuration;

import utility.configuration.reader.JsonReader;
import utility.configuration.reader.PropertyReader;

public class Test {

    public static void main(String[] args){

        System.out.println(new PropertyReader().getConfig().baseURL);
        System.out.println(new JsonReader().getConfig().baseURL);


        System.out.println(new PropertyReader().getConfigOwner().baseURL());

        System.out.println(ConfigService.getbaseURL());
        //PropertyReaderImpl propertyReader = ConfigFactory.create(PropertyReaderImpl.class);

       // System.out.println(new PropertyReader().getConfigP().baseURL());
       // System.out.println(ConfigFactory.create(PropertyReaderImpl.class).baseURL());
      //  System.out.println(propertyReader.baseURL());
    }
}
