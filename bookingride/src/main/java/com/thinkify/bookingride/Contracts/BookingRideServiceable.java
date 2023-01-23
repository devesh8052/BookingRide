package com.thinkify.bookingride.Contracts;

import com.thinkify.bookingride.model.Driver;
import com.thinkify.bookingride.model.Location;

import java.util.List;

public interface BookingRideServiceable {
    public List<Driver> findRide(String userName, Location location) throws Exception;
    public String ChooseRide(String userName, String driverName) throws Exception;

    }
