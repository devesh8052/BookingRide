package com.thinkify.bookingride.service;

import com.thinkify.bookingride.BookingRideData.BookingRideData;
import com.thinkify.bookingride.Contracts.DriverServiceable;
import com.thinkify.bookingride.model.Driver;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class DriverService implements DriverServiceable {
    ///private List<Driver> driverDetails=new ArrayList<>();
    private  BookingRideData bookingRideData;

    public DriverService(){
        bookingRideData =BookingRideData.getInstance();
    }

    @Override
    public String addDriver(Driver driver){
        try {
            bookingRideData.addDriverDetails(driver);
            return "Driver details are added";
        }
        catch (Exception ex) {
            return "Drivers details are not added because of internal error. Please try after some  time.";
        }
    }

    @Override
    public List<Driver> getAllDrivers(){
        try {
            return bookingRideData.getAllDrivers();
        }
        catch (Exception ex){
            List<Driver> obj=new ArrayList<>();
            return  obj;
        }
    }
}
