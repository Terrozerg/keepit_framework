package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * Reads value from string in xml format
 * into POJO class by name {@code clazz}
 */
public class XmlMapperHelper {

    private static final XmlMapper xmlMapper = new XmlMapper();

    public static <T> T getPOJOFromXml(String string, Class<T> clazz) {
        try {
            return xmlMapper.readValue(string, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
