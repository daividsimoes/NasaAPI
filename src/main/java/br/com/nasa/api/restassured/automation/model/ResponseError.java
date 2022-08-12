package br.com.nasa.api.restassured.automation.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ResponseError  implements Serializable {

    private Error error;

    @Getter
    @Setter
    public static class Error implements Serializable {

        private String code;
        private String message;
    }
}
