package API;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import utils.PropertiesHelper;

public abstract class BaseAPI {

    protected RequestSpecification requestSpecification;

    @BeforeClass
    public void setup() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(PropertiesHelper.getProperty("url"))
                .build();
    }
}
