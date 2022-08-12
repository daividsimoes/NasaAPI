package br.com.nasa.api.restassured.automation.service;


import br.com.nasa.api.restassured.automation.model.nasa.mars.MarsPhotoResponse;

public class MarsRoverPhotoService extends AbstractService {

    private final String MARS_CURIOSITY_PHOTO_QUERY_MARTIAN_SOL = "/mars-photos/api/v1/rovers/curiosity/photos?sol={0}&api_key={1}";
    private final String MARS_CURIOSITY_PHOTO_QUERY_EARTH_DATE = "/mars-photos/api/v1/rovers/curiosity/photos?earth_date={0}&api_key={1}";

    private final String MARS_CURIOSITY_PHOTO_QUERY_MARTIAN_SOL_AND_CAMERA = "/mars-photos/api/v1/rovers/curiosity/photos?sol={0}&camera={1}&api_key={2}";
    public MarsPhotoResponse getMarsPhotoQueryMartianSol(String sol, String apiKey) {

        return requestUtil.get(MarsPhotoResponse.class, MARS_CURIOSITY_PHOTO_QUERY_MARTIAN_SOL, sol, apiKey);
    }

    public MarsPhotoResponse getMarsPhotoQueryEarthDate(String date, String apiKey) {

        return requestUtil.get(MarsPhotoResponse.class, MARS_CURIOSITY_PHOTO_QUERY_EARTH_DATE, date, apiKey);
    }

    public MarsPhotoResponse getMarsPhotoQueryMartianSolAndCamera(String sol, String camera, String apiKey) {

        return requestUtil.get(MarsPhotoResponse.class, MARS_CURIOSITY_PHOTO_QUERY_MARTIAN_SOL_AND_CAMERA, sol, camera, apiKey);
    }
}
