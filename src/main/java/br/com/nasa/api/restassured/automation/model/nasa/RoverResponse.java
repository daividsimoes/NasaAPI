package br.com.nasa.api.restassured.automation.model.nasa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class RoverResponse implements Serializable {

    private int id;
    private String name;
    private String status;

    @JsonProperty("landing_date")
    private String landingDate;

    @JsonProperty("launch_date")
    private String launchDate;
}
