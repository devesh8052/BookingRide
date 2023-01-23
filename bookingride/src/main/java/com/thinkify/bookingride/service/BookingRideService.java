package com.thinkify.bookingride.service;

import com.thinkify.bookingride.BookingRideData.BookingRideData;
import com.thinkify.bookingride.Contracts.BookingRideServiceable;
import com.thinkify.bookingride.model.Driver;
import com.thinkify.bookingride.model.Location;
import com.thinkify.bookingride.model.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class BookingRideService implements BookingRideServiceable {
    private BookingRideData bookingRideData;

    public BookingRideService(){
        bookingRideData=BookingRideData.getInstance();

    }
    @Override
     public List<Driver> findRide(String userName, Location location){
        try{
            List<Driver> availableRides = new ArrayList<>();
            List<Driver> driverList = bookingRideData.getAllDrivers();
            for (Driver i : driverList) {
                int distance = Math.abs((i.getDriverLocation().getX() - location.getX())) + Math.abs(i.getDriverLocation().getY() - location.getY());
                if (distance <= 5) {
                    availableRides.add(i);
                }
            }
            return availableRides;
        }
        catch (Exception e)
        {
            List<Driver> obj=new ArrayList<>();
            return  obj;
        }
    }

     @Override
     public String ChooseRide(String userName, String driverName) {
        try {
            if(bookingRideData.isDriverBusy((driverName)))
                return "Chosen driver is busy";
            List<User> users = bookingRideData.getAllUsers();
            List<Driver> drivers = bookingRideData.getAllDrivers();
            Predicate<User> userPredicate = e -> e.getUserName() == userName;
            Predicate<Driver> driverPredicate = e -> e.getName() == driverName;
            boolean userExist = false, driverExist = false;
            for (User i : users) {
                if (i.getUserName().equals(userName))
                    userExist = true;
            }
            for (Driver i : drivers) {
                if (i.getName().equals(driverName))
                    driverExist = true;
            }
            if (userExist == true && driverExist == true) {
                bookingRideData.setDriverBusy(driverName);
                return "Ride is confirmed";
            }
            return "No rider is available";
        }
        catch (Exception e){
            return "An internal error occurred";
        }
     }
}
