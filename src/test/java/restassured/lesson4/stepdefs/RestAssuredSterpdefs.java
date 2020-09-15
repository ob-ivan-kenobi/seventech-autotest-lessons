package restassured.lesson4.stepdefs;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Assume;
import io.cucumber.java.ru.*;
import io.cucumber.datatable.DataTable;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.*;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.withArgs;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.*;


public class RestAssuredSterpdefs {

    private Response response;
    private ValidatableResponse validatableResponse;
    private RequestSpecification request = given().log().all();

    private String host = "http://localhost:3000";
    private String requestBody = "Body для данного запроса не передается";
    private Map<String, Object> sharedParams = new HashMap<>();

    @Дано("^входной параметр (.*) = (.*)$")
    public void paramRequestValue(String param, String paramValue) {
        param = param.trim();
        paramValue = paramValue.trim();
        request = request.
                queryParam(param, paramValue);
    }

    @Дано("^(.*)-запрос к методу (.*)$")
    public void requestToService(String httpMethod, String serviceMethod) {
        httpMethod = httpMethod.trim();
        serviceMethod = serviceMethod.trim();

        if (httpMethod.equals("POST")) {
            request = request.contentType(ContentType.JSON).body(requestBody);
        }



        sharedParams.put("httpMethod", httpMethod);
        sharedParams.put("serviceMethod", serviceMethod);
    }

    @Когда("^пользователь получил ответ от (.*)$")
    public void userReceivesAResponse(String serviceMethod) {
        String httpMethod = sharedParams.get("httpMethod").toString();
        serviceMethod = serviceMethod.trim();

        if (httpMethod.equals("GET")) {
            response = request.when().get(host + serviceMethod);
        } else if (httpMethod.equals("POST")) {
            response = request.when().post(host + serviceMethod);
        }  else {
            System.out.println("Ошибка: httpMethod не найден");
        }

        validatableResponse = response.then();
        requestBody = "Body для данного запроса не передается";
    }

    @Тогда("^код ответа (\\d+)$")
    public void verifyStatusCode(int statusCode) {
        validatableResponse = validatableResponse.log().all().statusCode(statusCode);
    }

}
