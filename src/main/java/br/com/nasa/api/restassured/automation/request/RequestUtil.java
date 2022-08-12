package br.com.nasa.api.restassured.automation.request;

import br.com.nasa.api.restassured.automation.model.ResponseError;
import br.com.nasa.api.restassured.automation.model.ResponseObject;
import br.com.nasa.api.restassured.automation.util.JsonUtil;
import br.com.nasa.api.restassured.automation.util.UrlUtil;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.internal.http.Status;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import java.text.MessageFormat;

import static io.restassured.RestAssured.given;

@Slf4j
public class RequestUtil {

    private final HeaderUtil headerUtil;
    private String url;

    public RequestUtil() {

        headerUtil = new HeaderUtil();
    }

    public <T extends ResponseObject> T get(Headers headers, Class<T> clazz, String endpoint,
                                            Object... args) {

        url = UrlUtil.buildUrl(endpoint, args);

        log.info("REQUEST -> Executing GET on: {}", url);
        log.info("REQUEST -> Headers: {}", JsonUtil.convertToJson(headers.asList()));

        Response response = given()
                .contentType(ContentType.JSON)
                .headers(headers)
                .get(url);

        log.info("RESPONSE -> StatusCode: {}", response.getStatusCode());
        log.info("RESPONSE -> Time: {}", response.getTime());
        log.info("RESPONSE -> Body: {}", response.getBody().asString());

        return convertResponseToObject(response, clazz);
    }

    public <T extends ResponseObject> T get(Class<T> clazz, String endpoint, Object... args) {

        return get(headerUtil.getHeader(), clazz, endpoint, args);
    }

    private <T extends ResponseObject> T convertResponseToObject(Response response, Class<T> clazz) {

        T responseConverted = null;

        if (!response.getBody().asString().isEmpty()) {

            try {

                log.info("Converting response to class: {}", clazz);
                if (Status.SUCCESS.matches(response.statusCode())) {

                    responseConverted = response.getBody().as(clazz);
                } else {

                    responseConverted = clazz.newInstance();
                    responseConverted.setResponseError(response.getBody().as(ResponseError.class));
                }

            } catch (Exception e) {

                throw new RuntimeException(
                        MessageFormat.format("Failure to convert response -> {0}\nException Message -> {1}",
                                response.getBody().asString(), e.getMessage())
                );
            }
        }

        if(responseConverted != null)
            responseConverted.setStatusCode(response.getStatusCode());

        return responseConverted;
    }
}
