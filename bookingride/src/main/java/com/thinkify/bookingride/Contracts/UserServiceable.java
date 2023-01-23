package com.thinkify.bookingride.Contracts;

import com.thinkify.bookingride.model.User;

import java.util.List;

public interface UserServiceable {
    public String addUser(User user);
    public List<User> getAllUsers();


    }
