package com.thinkify.bookingride.BookingRideData;

import com.thinkify.bookingride.model.Driver;
import com.thinkify.bookingride.model.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingRideData {
    private static BookingRideData instance;
    private List<User>userDetails;
    Map<String,Boolean> busyDriver;

    private  List<Driver>driverDetails;
    private BookingRideData(){
        userDetails=new ArrayList<>();
        driverDetails=new ArrayList<>();
        busyDriver=new HashMap<>();
    }
    public void  addUserDetails(User user){
        userDetails.add(user);
    }
    public List<User> getAllUsers(){
        return userDetails;
    }
    public  void addDriverDetails(Driver driver){
        driverDetails.add(driver);
    }
    public List<Driver> getAllDrivers(){
        return driverDetails;
    }

    public  void setDriverBusy(String driverName){
        busyDriver.put(driverName,Boolean.TRUE);
    }
    public boolean isDriverBusy(String driverName){
        if(!busyDriver.containsKey(driverName))
            return false;
        return true;
    }
    public static BookingRideData getInstance()
    {
        if (instance == null)
        {
            synchronized (BookingRideData.class)
            {
                if(instance==null)
                {
                    instance = new BookingRideData();
                }
            }
        }
        return instance;
    }
}
