package br.com.nasa.api.restassured.automation.model.nasa.mars;

import br.com.nasa.api.restassured.automation.model.ResponseObject;
import br.com.nasa.api.restassured.automation.model.nasa.PhotoResponse;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class MarsPhotoResponse extends ResponseObject implements Serializable {

    private List<PhotoResponse> photos;
}
