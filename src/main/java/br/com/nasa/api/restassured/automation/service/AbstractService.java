package br.com.nasa.api.restassured.automation.service;

import br.com.nasa.api.restassured.automation.request.RequestUtil;

public class AbstractService {

    protected RequestUtil requestUtil;

    public AbstractService(){

        requestUtil = new RequestUtil();
    }
}
