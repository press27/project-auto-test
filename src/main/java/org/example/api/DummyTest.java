package org.example.api;

import io.restassured.RestAssured;
import org.example.api.dto.CreateRequestBody;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.with;


public class DummyTest extends BaseApiTest{

//    @Test
//    public void getAllListTest(){
//        RestAssured.get("https://dummy.restapiexample.com/api/v1/employees").then()
//                .assertThat().statusCode(200);
//    }

    @Test
    public void createTest(){
        CreateRequestBody createRequestBody = CreateRequestBody.builder().name("Test").salary("2000").age("20").build();
        with().body(createRequestBody).when().post("https://dummy.restapiexample.com/api/v1/create")
                .then().assertThat().statusCode(200).log().body();

//        String body = "\t{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}";
//        with().body(body).when().post("https://dummy.restapiexample.com/api/v1/create")
//                .then().assertThat().statusCode(200).log().body();
    }

}
