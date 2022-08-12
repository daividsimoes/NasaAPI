package br.com.nasa.api.restassured.automation.util;

import java.text.MessageFormat;

public class UrlUtil {

    private static final String HOST = "https://api.nasa.gov";

    public static String buildUrl(String endpoint, Object... args) {

        return HOST.concat(MessageFormat.format(endpoint, args));
    }
}
