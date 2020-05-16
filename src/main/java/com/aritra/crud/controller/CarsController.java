package com.aritra.crud.controller;

import com.aritra.crud.controller.util.Message;
import com.aritra.crud.entity.Car;
import com.aritra.crud.repo.CarsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping(path = "/cars")
public class CarsController {
    private final CarsRepository carsRepository;

    public CarsController(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @GetMapping
    public List<Car> getCars() {
        return this.carsRepository.findAll();
    }

    @GetMapping(path = "/{licensePlate}")
    public Car getByLicensePlate(@PathVariable("licensePlate") String licensePlate) {
        return this.carsRepository.findByLicensePlate(licensePlate);
    }

    @PutMapping(produces = "application/json")
    public ResponseEntity<Message> insertCar(@Valid @RequestBody Car car) {
        log.info("Request received to insert {}", car);

        this.carsRepository.insert(car);
        return new ResponseEntity<>(Message.getInsertMessage(), HttpStatus.OK);
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<Message> updateCar(@Valid @RequestBody Car car) {
        log.info("Request received to update {}", car);

        Car documentToUpdate = this.carsRepository.findByLicensePlate(car.getLicensePlate());

        if (documentToUpdate == null) {
            return new ResponseEntity<>(new Message(HttpStatus.BAD_REQUEST,
                    "License plate provided in request is not valid"), HttpStatus.BAD_REQUEST);
        }

        // MongoDB finds for the ID to update else it will create a new document
        car.setId(documentToUpdate.getId());
        this.carsRepository.save(car);

        return new ResponseEntity<>(Message.getUpdateMessage(), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{licensePlate}", produces = "application/json")
    public ResponseEntity<Message> deleteCar(@PathVariable("licensePlate") String licensePlate) {
        Car toDelete = this.carsRepository.findByLicensePlate(licensePlate);
        this.carsRepository.delete(toDelete);

        return new ResponseEntity<>(Message.getDeleteMessage(), HttpStatus.OK);
    }
}
