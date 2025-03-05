package utils;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;

/**
 * Validates given xml file content
 * with given xsd schema located in {@code path}
 */
public class XmlSchemaValidator {

    private static final String path = "src/test/java/testData/response/schema/";

    public static Validator getSchemaValidator(String xsdPath) {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Source schemaFile;
        Schema schema;

        try (FileInputStream fileInputStream = new FileInputStream(path + xsdPath)){
            schemaFile = new StreamSource(fileInputStream);
            schema = factory.newSchema(schemaFile);
        } catch (IOException | SAXException e) {
            throw new RuntimeException(e);
        }

        return schema.newValidator();
    }

    public static void validateXml(String xsdSchemaFileName, String xmlFileContent) {
        try {
            getSchemaValidator(xsdSchemaFileName).validate(new StreamSource(new StringReader(xmlFileContent)));
        } catch (SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
