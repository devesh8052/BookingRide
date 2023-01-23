package com.thinkify.bookingride.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver {
    private Integer age;
    private String name;
    private  String sex;
    private  String carDetails;
    private Location driverLocation;
}
