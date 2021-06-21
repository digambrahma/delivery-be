package delivery.deliverybe.controller;

import delivery.deliverybe.model.Driver;
import delivery.deliverybe.service.DriverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/driver")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping
    public ResponseEntity<?> createDriver(@Valid @RequestBody Driver driver){
        return new ResponseEntity<>(driverService.save(driver), HttpStatus.OK);
    }

}
