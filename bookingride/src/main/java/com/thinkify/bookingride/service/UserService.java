package com.thinkify.bookingride.service;

import com.thinkify.bookingride.BookingRideData.BookingRideData;
import com.thinkify.bookingride.Contracts.UserServiceable;
import com.thinkify.bookingride.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService implements UserServiceable {
    //private List<User> userDetails=new ArrayList<>();
    private BookingRideData bookingRideData;
    public UserService(){
        bookingRideData =BookingRideData.getInstance();
    }

    @Override
    public String addUser(User user){
        try {
            bookingRideData.addUserDetails(user);
            return "User Details are Added.";
        }
        catch (Exception ex){
            return "User details are not added due  to some internal error. Please try after some time";
        }
    }

    @Override
    public List<User> getAllUsers(){
        try {
            return bookingRideData.getAllUsers();
        }
        catch (Exception ex){
            List<User> obj=new ArrayList<>();
            return obj;
        }
    }
}
