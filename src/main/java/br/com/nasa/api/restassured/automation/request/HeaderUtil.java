package br.com.nasa.api.restassured.automation.request;

import io.restassured.http.Header;
import io.restassured.http.Headers;

public class HeaderUtil {

    public Headers getHeader(Header... header) {

        return new Headers(header);
    }
}
