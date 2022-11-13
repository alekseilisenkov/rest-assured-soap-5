package com.example.producingwebservice.tests;

import com.example.producingwebservice.helpers.EndPoints;
import com.example.producingwebservice.specs.RequestSpecs;
import com.example.producingwebservice.specs.ResponseSpecs;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SoapTest extends TestBase {

    public SoapTest() throws IOException {
    }

    @Test
    void getCountriesTest() {
        Response response = RequestSpecs.requestSpecification
                .body(request)
                .when()
                .post(EndPoints.GET_COUNTRY)
                .then()
                .spec(ResponseSpecs.response)
                .extract().response();

        Assertions.assertAll(
                () -> assertTrue(response.asString().contains("EUR")),
                () -> assertTrue(response.asString().contains("Madrid")),
                () -> assertTrue(response.asString().contains("46704314"))
        );
    }
}
