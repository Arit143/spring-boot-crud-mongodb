package com.aritra.crud.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CarManufacturer {
    @NotEmpty(message = "manufacturer name should not be empty")
    private String name;
}
