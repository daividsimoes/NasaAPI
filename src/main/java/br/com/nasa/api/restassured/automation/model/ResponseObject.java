package br.com.nasa.api.restassured.automation.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ResponseObject implements Serializable {

    private int statusCode;
    private ResponseError responseError;
}
