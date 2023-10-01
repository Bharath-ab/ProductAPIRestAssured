package productapi.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestUtils {
    private static Properties prop;
    static{
        loadConfigFile();
    }
    public static void loadConfigFile(){
        try{
            File myFile = new File(System.getProperty("user.dir")+"/configs/productApi.properties");
            FileReader fileReader = new FileReader(myFile);
            prop = new Properties();
            prop.load(fileReader);
        }catch (IOException e){
            e.printStackTrace();

        }
    }

    public static String getBaseURL(){
        return prop.getProperty("BASE_URL");
    }
}
