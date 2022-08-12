package br.com.nasa.api.restassured.automation.model.nasa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CameraResponse implements Serializable {

    private int id;
    private int sol;
    private String name;

    @JsonProperty("rover_id")
    private int roverId;

    @JsonProperty("full_name")
    private String fullName;
}
