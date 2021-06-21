package delivery.deliverybe.controller;

import delivery.deliverybe.model.Driver;
import delivery.deliverybe.service.DriverService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
class DriverControllerTest {

    @Autowired
    DriverService driverService;

    @Autowired
    TestRestTemplate testRestTemplate;

    @BeforeEach
    public void cleanUp(){
        driverService.deleteAll();
    }

    private <T> ResponseEntity<T> createDriverPost(Driver driver, Class<T> response){
        String url = "/driver";
        return testRestTemplate.postForEntity(
                url,
                driver,
                response
        );
    }

    private Driver createDriver(){
        Driver driver = new Driver();
        driver.setFirstName("TestDriver");
        driver.setLastName("TestDriver");
        driver.setEmail("driver@gmail.com");
        driver.setCity("TestCity");
        driver.setPhone("7070204787");

        return driver;
    }

    @Test
    public void createDriver_emailEmpty_receiveBadRequest(){
        Driver driver = createDriver();
        driver.setEmail("");

        ResponseEntity<?> responseEntity = createDriverPost(driver, Object.class);
        System.out.println(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void createDriver_phoneEmpty_receiveBadRequest(){
        Driver driver = createDriver();
        driver.setPhone("");

        ResponseEntity<?> responseEntity = createDriverPost(driver, Object.class);
        System.out.println(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void createDriver_firstNameNotValid_receiveBadRequest(){
        Driver driver = createDriver();
        driver.setFirstName("");

        ResponseEntity<?> responseEntity = createDriverPost(driver, Object.class);
        System.out.println(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void createDriver_lastNameNotValid_receiveBadRequest(){
        Driver driver = createDriver();
        driver.setLastName("");

        ResponseEntity<?> responseEntity = createDriverPost(driver, Object.class);
        System.out.println(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void createDriver_emailNotValid_receiveBadRequest(){
        Driver driver = createDriver();
        driver.setEmail("@g.com");

        ResponseEntity<?> responseEntity = createDriverPost(driver, Object.class);
        System.out.println(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void createDriver_phoneNotValid_receiveBadRequest(){
        Driver driver = createDriver();
        driver.setPhone("1234");

        ResponseEntity<?> responseEntity = createDriverPost(driver, Object.class);
        System.out.println(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void createDriver_driverWithEmailAlreadyExist_receiveBadRequest(){
        Driver driver = createDriver();
        driverService.save(driver);

        ResponseEntity<?> responseEntity = createDriverPost(driver, Object.class);
        System.out.println(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void createDriver_driverWithEmailAndPhoneAlreadyExist_receiveBadRequest(){
        Driver driver = createDriver();
        driverService.save(driver);

        ResponseEntity<?> responseEntity = createDriverPost(driver, Object.class);
        System.out.println(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

}

















