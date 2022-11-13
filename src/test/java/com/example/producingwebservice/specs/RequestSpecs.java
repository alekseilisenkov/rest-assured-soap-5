package com.example.producingwebservice.specs;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.with;

public class RequestSpecs {

    public static RequestSpecification requestSpecification = with()
            .log().uri()
            .log().body()
            .header("Content-Type", "text/xml")
            .and();
}
