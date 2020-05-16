package com.aritra.crud.repo;

import com.aritra.crud.entity.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends MongoRepository<Car, String>{
    Car findByLicensePlate(String licensePlate);
}
