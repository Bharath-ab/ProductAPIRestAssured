package com.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestUtils {
    private static Properties prop;
    static {
        loadPropFile();
    }

    public static void loadPropFile() {
        FileReader fileReader;
        prop = new Properties();
        try {
            File myFile = new File(System.getProperty("user.dir") + "/configs/dev.properties");
            fileReader = new FileReader(myFile);
            prop.load(fileReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBaseURL() {
        return prop.getProperty("BASE_URL");
    }

    public static String getOriginUrl() {
        return prop.getProperty("ORIGIN");
    }

    public static String getRefererUrl() {
        return prop.getProperty("REFERER");
    }
}
