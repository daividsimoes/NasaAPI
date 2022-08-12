package br.com.nasa.api.restassured.automation.model.nasa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PhotoResponse implements Serializable {

    private int id;
    private int sol;
    private CameraResponse camera;
    private RoverResponse rover;

    @JsonProperty("earth_date")
    private String earthDate;

    @JsonProperty("img_src")
    private String imgSrc;
}
