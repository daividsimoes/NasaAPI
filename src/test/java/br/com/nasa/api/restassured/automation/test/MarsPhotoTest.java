package br.com.nasa.api.restassured.automation.test;

import br.com.nasa.api.restassured.automation.model.nasa.PhotoResponse;
import br.com.nasa.api.restassured.automation.model.nasa.mars.MarsPhotoResponse;
import br.com.nasa.api.restassured.automation.service.MarsRoverPhotoService;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class MarsPhotoTest {

    private static MarsRoverPhotoService marsRoverPhotoService;

    @BeforeClass
    public static void init() {

        marsRoverPhotoService = new MarsRoverPhotoService();
    }

    // Retrieve the first 10 Mars photos made by "Curiosity" on 1000 Martian sol.
    @Test
    public void retrieveTenCuriosityMarsPhotosByMartianSol() {
        MarsPhotoResponse photos = marsRoverPhotoService.getMarsPhotoQueryMartianSol("1000", "DEMO_KEY");

        List<PhotoResponse> photoResponses = photos.getPhotos().subList(0, 10);
        assertEquals(10, photoResponses.size());

        photoResponses.forEach(photoResponse -> {
            assertNotNull(photoResponse);
            assertNotEquals(0, photoResponse.getId());
            assertNotEquals(0, photoResponse.getSol());
            assertNotNull(photoResponse.getImgSrc());
            assertNotEquals("", photoResponse.getImgSrc());
            assertNotNull(photoResponse.getEarthDate());
            assertNotEquals("", photoResponse.getEarthDate());

            assertNotNull(photoResponse.getCamera());
            assertNotEquals(0, photoResponse.getCamera().getId());
            assertNotEquals(0, photoResponse.getCamera().getRoverId());
            assertNotNull(photoResponse.getCamera().getName());
            assertNotEquals("", photoResponse.getCamera().getName());
            assertNotNull(photoResponse.getCamera().getFullName());
            assertNotEquals("", photoResponse.getCamera().getFullName());

            assertNotNull(photoResponse.getRover());
            assertNotEquals(0, photoResponse.getRover().getId());
            assertNotNull(photoResponse.getRover().getName());
            assertNotEquals("", photoResponse.getRover().getName());
            assertNotNull(photoResponse.getRover().getLandingDate());
            assertNotEquals("", photoResponse.getRover().getLandingDate());
            assertNotNull(photoResponse.getRover().getLaunchDate());
            assertNotEquals("", photoResponse.getRover().getLaunchDate());
            assertNotNull(photoResponse.getRover().getStatus());
            assertNotEquals("", photoResponse.getRover().getStatus());
        });
    }

    // Retrieve the first 10 Mars photos made by "Curiosity" on Earth date equal to 1000 Martian sol.
    @Test
    public void retrieveTenCuriosityMarsPhotosByEarthDateEqualMartianSol() {
        String earthDate = marsRoverPhotoService.getMarsPhotoQueryMartianSol("1000", "DEMO_KEY").getPhotos()
                .stream()
                .findFirst()
                .get()
                .getEarthDate();

        MarsPhotoResponse photos = marsRoverPhotoService.getMarsPhotoQueryEarthDate(earthDate, "DEMO_KEY");

        List<PhotoResponse> photoResponses = photos.getPhotos().subList(0, 10);
        assertEquals(10, photoResponses.size());

        photoResponses.forEach(photoResponse -> {
            assertNotNull(photoResponse);
            assertNotEquals(0, photoResponse.getId());
            assertNotEquals(0, photoResponse.getSol());
            assertNotNull(photoResponse.getImgSrc());
            assertNotEquals("", photoResponse.getImgSrc());
            assertNotNull(photoResponse.getEarthDate());
            assertNotEquals("", photoResponse.getEarthDate());

            assertNotNull(photoResponse.getCamera());
            assertNotEquals(0, photoResponse.getCamera().getId());
            assertNotEquals(0, photoResponse.getCamera().getRoverId());
            assertNotNull(photoResponse.getCamera().getName());
            assertNotEquals("", photoResponse.getCamera().getName());
            assertNotNull(photoResponse.getCamera().getFullName());
            assertNotEquals("", photoResponse.getCamera().getFullName());

            assertNotNull(photoResponse.getRover());
            assertNotEquals(0, photoResponse.getRover().getId());
            assertNotNull(photoResponse.getRover().getName());
            assertNotEquals("", photoResponse.getRover().getName());
            assertNotNull(photoResponse.getRover().getLandingDate());
            assertNotEquals("", photoResponse.getRover().getLandingDate());
            assertNotNull(photoResponse.getRover().getLaunchDate());
            assertNotEquals("", photoResponse.getRover().getLaunchDate());
            assertNotNull(photoResponse.getRover().getStatus());
            assertNotEquals("", photoResponse.getRover().getStatus());
        });
    }

    @Test
    public void compareTenCuriosityMarsPhotosByMartianSolAndEarthDateEqualMartianSol() {

        MarsPhotoResponse photosByMartianSol = marsRoverPhotoService.getMarsPhotoQueryMartianSol("1000", "DEMO_KEY");

        List<PhotoResponse> photosByMartianSolList = photosByMartianSol.getPhotos().subList(0, 10);
        assertEquals(10, photosByMartianSolList.size());

        String earthDate = photosByMartianSolList
                .stream()
                .findFirst()
                .get()
                .getEarthDate();

        MarsPhotoResponse photosByEarthDate = marsRoverPhotoService.getMarsPhotoQueryEarthDate(earthDate, "DEMO_KEY");

        List<PhotoResponse> photosByEarthDateList = photosByEarthDate.getPhotos().subList(0, 10);
        assertEquals(10, photosByEarthDateList.size());

        for (int i=0; i<10; i++) {

            assertEquals(photosByMartianSolList.get(i).getId(),
                    photosByEarthDateList.get(i).getId());

            assertEquals(photosByMartianSolList.get(i).getSol(),
                    photosByEarthDateList.get(i).getSol());

            assertEquals(photosByMartianSolList.get(i).getImgSrc(),
                    photosByEarthDateList.get(i).getImgSrc());

            assertEquals(photosByMartianSolList.get(i).getEarthDate(),
                    photosByEarthDateList.get(i).getEarthDate());

            assertEquals(photosByMartianSolList.get(i).getCamera().getId(),
                    photosByEarthDateList.get(i).getCamera().getId());

            assertEquals(photosByMartianSolList.get(i).getCamera().getRoverId(),
                    photosByEarthDateList.get(i).getCamera().getRoverId());

            assertEquals(photosByMartianSolList.get(i).getCamera().getName(),
                    photosByEarthDateList.get(i).getCamera().getName());

            assertEquals(photosByMartianSolList.get(i).getCamera().getFullName(),
                    photosByEarthDateList.get(i).getCamera().getFullName());

            assertEquals(photosByMartianSolList.get(i).getRover().getId(),
                    photosByEarthDateList.get(i).getRover().getId());

            assertEquals(photosByMartianSolList.get(i).getRover().getName(),
                    photosByEarthDateList.get(i).getRover().getName());

            assertEquals(photosByMartianSolList.get(i).getRover().getLandingDate(),
                    photosByEarthDateList.get(i).getRover().getLandingDate());

            assertEquals(photosByMartianSolList.get(i).getRover().getLaunchDate(),
                    photosByEarthDateList.get(i).getRover().getLaunchDate());

            assertEquals(photosByMartianSolList.get(i).getRover().getStatus(),
                    photosByEarthDateList.get(i).getRover().getStatus());
        }
    }

    // Validate that the amounts of pictures that each "Curiosity" camera took on 1000 Mars sol is not greater than 10 times the amount taken by other cameras on the same date.
    @Test
    public void validateAMountCuriosityPictureIsNotGreatThanTenTimesAmountOtherCamera() {

        MarsPhotoResponse fhaz = marsRoverPhotoService.getMarsPhotoQueryMartianSolAndCamera("1000", "FHAZ", "DEMO_KEY");
        MarsPhotoResponse rhaz = marsRoverPhotoService.getMarsPhotoQueryMartianSolAndCamera("1000", "RHAZ", "DEMO_KEY");
        MarsPhotoResponse mast = marsRoverPhotoService.getMarsPhotoQueryMartianSolAndCamera("1000", "MAST", "DEMO_KEY");
        MarsPhotoResponse chemcam = marsRoverPhotoService.getMarsPhotoQueryMartianSolAndCamera("1000", "CHEMCAM", "DEMO_KEY");
        MarsPhotoResponse mahli = marsRoverPhotoService.getMarsPhotoQueryMartianSolAndCamera("1000", "MAHLI", "DEMO_KEY");
        MarsPhotoResponse mardi = marsRoverPhotoService.getMarsPhotoQueryMartianSolAndCamera("1000", "MARDI", "DEMO_KEY");
        MarsPhotoResponse navcam = marsRoverPhotoService.getMarsPhotoQueryMartianSolAndCamera("1000", "NAVCAM", "DEMO_KEY");

        MarsPhotoResponse pancam = marsRoverPhotoService.getMarsPhotoQueryMartianSolAndCamera("1000", "PANCAM", "DEMO_KEY");
        MarsPhotoResponse minites = marsRoverPhotoService.getMarsPhotoQueryMartianSolAndCamera("1000", "MINITES", "DEMO_KEY");


        assertTrue(fhaz.getPhotos().size() <= (pancam.getPhotos().size() * 10));
        assertTrue(fhaz.getPhotos().size() <= (minites.getPhotos().size() * 10));

        assertTrue(rhaz.getPhotos().size() <= (pancam.getPhotos().size() * 10));
        assertTrue(rhaz.getPhotos().size() <= (minites.getPhotos().size() * 10));

        assertTrue(mast.getPhotos().size() <= (pancam.getPhotos().size() * 10));
        assertTrue(mast.getPhotos().size() <= (minites.getPhotos().size() * 10));

        assertTrue(chemcam.getPhotos().size() <= (pancam.getPhotos().size() * 10));
        assertTrue(chemcam.getPhotos().size() <= (minites.getPhotos().size() * 10));

        assertTrue(mahli.getPhotos().size() <= (pancam.getPhotos().size() * 10));
        assertTrue(mahli.getPhotos().size() <= (minites.getPhotos().size() * 10));

        assertTrue(mardi.getPhotos().size() <= (pancam.getPhotos().size() * 10));
        assertTrue(mardi.getPhotos().size() <= (minites.getPhotos().size() * 10));

        assertTrue(navcam.getPhotos().size() <= (pancam.getPhotos().size() * 10));
        assertTrue(navcam.getPhotos().size() <= (minites.getPhotos().size() * 10));
    }

    // Check invalid API KEY error
    @Test
    public void invalidApiKey() {

        MarsPhotoResponse photosByMartianSol = marsRoverPhotoService.getMarsPhotoQueryMartianSol("1000", "INVALID_KEY");

        assertEquals("API_KEY_INVALID", photosByMartianSol.getResponseError().getError().getCode());
        assertEquals("An invalid api_key was supplied. Get one at https://api.nasa.gov:443",
                photosByMartianSol.getResponseError().getError().getMessage());
    }
}
