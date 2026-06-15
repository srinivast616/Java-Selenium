package com.sample.pagefactory.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


    private static Properties properties;

    // Load the properties file
    static {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to get the application URL
    public static String getAppUrl() {
        return properties.getProperty("app.url");
    }

    // Method to get the browser type
    public static String getBrowser() {
        return properties.getProperty("browser");
    }

    // Method to get the environment (e.g., QA, Staging, Production)
    public static String getEnvironment() {
        return properties.getProperty("environment");
    }
}

