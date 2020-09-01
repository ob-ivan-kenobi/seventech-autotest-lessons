package restassured.lesson1;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import org.junit.Assert;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class FirstLessonTest {

    @Test
    public void test1_get() {

        when().
            get("https://reqres.in/api/users?page=2").
        then().
            log().all().
            statusCode(200).
            body("data.id[0]", equalTo(7)).
            body("data.first_name", hasItems("Lindsay", "Tobias"));
    }

    @Test
    public void test1_post() {

        String body = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        given().
            body(body).
            accept(ContentType.JSON).
        when().
            post("https://reqres.in/api/users?login=123&").
        then().
            statusCode(201).
            log().all();
    }

//    @Test
//    public void test1_xml() {
//        String body = "{\n" +
//                "    \"name\": \"morpheus\",\n" +
//                "    \"job\": \"leader\"\n" +
//                "}";
//
//        Response response = given().
//                body(body).
//                when().
//                post("https://reqres.in/api/users").
//                then().
//                statusCode(201).
//                log().all().
//                extract().response();
//
//
//        XmlPath xmlPath = new XmlPath(response.asString());
//        Assert.assertEquals("63452542", xmlPath.getString("Envelope.Body.checkSB1Response.ApplicationID"));
//    }
}
