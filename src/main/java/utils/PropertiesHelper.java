package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * Reads properties files located in {@code path}
 * using specific property name {@code propertyName}
 * and return {@code String} representation
 */
public class PropertiesHelper {

    private static final String path = "src/main/resources/config/test.properties";

    public static String getProperty(String propertyName) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return properties.getProperty(propertyName);
    }
}
