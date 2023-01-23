package com.thinkify.bookingride.controller;

import com.thinkify.bookingride.model.Driver;
import com.thinkify.bookingride.model.FindRideModel;
import com.thinkify.bookingride.model.Location;
import com.thinkify.bookingride.model.User;
import com.thinkify.bookingride.service.BookingRideService;
import com.thinkify.bookingride.service.DriverService;
import com.thinkify.bookingride.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BookRideController {
    @Autowired
    private UserService userService;
    @Autowired
    private DriverService driverService;
    @Autowired
    private BookingRideService bookingRideService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user){
         return userService.addUser(user);
    }
    @GetMapping("/getAllUsers")
    public List<User> addUser(){
        return userService.getAllUsers();
    }

    @PostMapping("/addDriver")
    public String addDriver(@RequestBody Driver driver){
       return  driverService.addDriver(driver);
    }

    @GetMapping("/getAllDrivers")
    public List<Driver> getAllDriver(){
        return driverService.getAllDrivers();
    }

    @GetMapping("/findRide")
    public List<Driver> findRide(@RequestBody FindRideModel findRideModel){
        return bookingRideService.findRide(findRideModel.getUserName(),findRideModel.getLocation());
    }
    @GetMapping("/chooseRide")
    public String chooseRide(@RequestParam String useName, @RequestParam String driverName){
     return bookingRideService.ChooseRide(useName,driverName);
    }
}
