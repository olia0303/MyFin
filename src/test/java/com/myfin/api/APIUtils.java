package com.myfin.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.apache.http.protocol.HTTP;
import utils.DateUtils;

import static io.restassured.RestAssured.given;
@Log4j2
public class APIUtils {
    public Response getRequest(String requestURL) {
        log.debug(String.format("GET request to: %s", requestURL));
        return given()
                    .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                    .param("ondate", DateUtils.getDate(+1, "yyyy-MM-dd"))
                    .when()
                    .get(requestURL)
                    .then()
                    .log().ifError()
                    .statusCode(200)
                    .contentType(ContentType.JSON).extract().response();
    }
}
