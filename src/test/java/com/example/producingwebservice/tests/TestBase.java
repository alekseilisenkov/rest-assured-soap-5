package com.example.producingwebservice.tests;

import io.restassured.RestAssured;
import io.restassured.internal.util.IOUtils;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.io.InputStream;

public class TestBase {

    InputStream is = getClass().getClassLoader().getResourceAsStream("getCountryRequest.xml");
    String request = new String(IOUtils.toByteArray(is));

    public TestBase() throws IOException {}

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = "http://localhost:8080/ws";
    }
}
