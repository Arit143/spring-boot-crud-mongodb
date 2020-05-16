package com.aritra.crud.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Document(collection = "cars")
public class Car {
    @Id
    private String id;

    @Indexed(unique = true)
    @NotEmpty(message = "License plate cannot be empty")
    private String licensePlate;

    @NotNull
    private Integer seatCount;
    private boolean convertible;
    private Integer rating;
    private String engineType;

    @Valid
    private CarManufacturer carManufacturer;
}
