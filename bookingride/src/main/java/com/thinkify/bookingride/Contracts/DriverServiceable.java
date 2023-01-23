package com.thinkify.bookingride.Contracts;

import com.thinkify.bookingride.model.Driver;

import java.util.List;

public interface DriverServiceable {
    public String addDriver(Driver driver);
    public List<Driver> getAllDrivers();

    }
