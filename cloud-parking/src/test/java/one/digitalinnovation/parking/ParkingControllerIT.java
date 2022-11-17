package one.digitalinnovation.parking;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import io.restassured.RestAssured;
import one.digitalinnovation.parking.controller.dto.ParkingCreateDTO;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkingControllerIT {

    @LocalServerPort
    private int randomPort;

    @BeforeEach
    public void setUpTest(){
        RestAssured.port = randomPort;
    }
    
    @Test
    void whenFindAllThenCHeckResult(){
        RestAssured.given()
        .when()
        .get("/parking")
        .then()
        .statusCode(HttpStatus.OK.value());

    }

    @Test
    void whenCreateThenCheckIsCreated(){

        var createDTO = new ParkingCreateDTO();
        createDTO.setColor("AMARELO");
        createDTO.setLicense("AKT-5692");
        createDTO.setModel("VOYAGE");
        createDTO.setState("MG");


        RestAssured.given()
        .when()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(createDTO)
        .post("/parking")
        .then()
        .statusCode(HttpStatus.CREATED.value())
        .body("license", Matchers.equalTo("AKT-5692"));

    }

}
