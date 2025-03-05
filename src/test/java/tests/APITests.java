package tests;

import API.BaseAPI;
import API.objects.User;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertiesHelper;
import utils.XmlMapperHelper;
import utils.XmlSchemaValidator;

public class APITests extends BaseAPI {

    private static final String getUser = "/users/";

    @Test
    @Description("Login using username and password")
    public void login() {
        RestAssured.given()
                .spec(requestSpecification)
                .contentType("application/xml")
                .auth().basic(PropertiesHelper.getProperty("username"), PropertiesHelper.getProperty("password"))
                .when()
                //TODO add to test data
                .get(getUser + "hbnbdm-sw0tha-0j8g61")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    @Description("Login using username and password and validate response contents")
    public void getUserData() {
        Response response = RestAssured.given()
                .spec(requestSpecification)
                .contentType("application/xml")
                .auth().basic(PropertiesHelper.getProperty("username"), PropertiesHelper.getProperty("password"))
                .when()
                //TODO add to test data
                .get(getUser + "hbnbdm-sw0tha-0j8g61")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

        String responseBodyString = response.getBody().asPrettyString();

        //TODO to test data
        XmlSchemaValidator.validateXml("login.xsd", responseBodyString);
        User pojoFromXml = XmlMapperHelper.getPOJOFromXml(responseBodyString, User.class);

        //TODO to test data
        Assert.assertTrue(pojoFromXml.isEnabled());
        Assert.assertEquals(pojoFromXml.getProduct(), "7dwqnq-5cvrcm-1z3ehj");
        Assert.assertEquals(pojoFromXml.getParent(), "80ltks-yhfls5-24zyf2");
        Assert.assertTrue(pojoFromXml.isSubscribed());
        //TODO validate dates separately in POJO/utils DateHelper
    }
}
