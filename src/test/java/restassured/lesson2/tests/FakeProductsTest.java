package restassured.lesson2.tests;

import restassured.lesson2.utils.ExcelUtils;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class FakeProductsTest {

    String projDir = System.getProperty("user.dir");

    @Test
    public void testGetProduct() {
        ExcelUtils excel = new ExcelUtils(projDir + "/src/test/java/restassured/lesson2/resources/testProducts.xlsx", "ProductsSheet");
        String name = excel.getCellData(1,0);

        given().
            log().all().
            body("{\n" +
                    "    \"name\": \"" + name + "\",\n" +
                    "    \"cost\": 15,\n" +
                    "    \"quantity\": 3\n" +
                    "}").
            header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6Im9iaXZhbmtlbm9iaUBnbWFpbC5jb20iLCJwYXNzd29yZCI6Iml2YW4iLCJpYXQiOjE1OTg5NTk3ODYsImV4cCI6MTU5ODk2MzM4Nn0.NhcGpOz2XexqzUHItkNcAN6gUDMEcG4QE-R0zbK9xIE").
        when().
            post("http://localhost:3000/products").
        then().
            log().all().
            statusCode(201);



    }
}
